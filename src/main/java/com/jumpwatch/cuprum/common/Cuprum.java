package com.jumpwatch.cuprum.common;

import com.jumpwatch.cuprum.client.Clientsetup;
import com.jumpwatch.cuprum.common.network.CuprumNetwork;
import com.jumpwatch.cuprum.common.registry.Attribute;
import com.jumpwatch.cuprum.common.registry.FinalRegistry;
import com.jumpwatch.cuprum.common.utils.CuprumConfigCommon;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Cuprum.MOD_ID)
public class Cuprum
{
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "cuprum";
    public Cuprum() {
        LOGGER.info("Started registering!");
        Attribute.setup();
        IEventBus modbus = FMLJavaModLoadingContext.get().getModEventBus();
        FinalRegistry.register();
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonsetups);
        MinecraftForge.EVENT_BUS.register(this);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, CuprumConfigCommon.SPEC);
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> modbus.addListener(Clientsetup::init));

    }

    public void commonsetups(FMLCommonSetupEvent event) {
        CuprumNetwork.init();

    }

}
