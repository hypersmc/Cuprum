package com.jumpwatch.cuprum.common;

import com.jumpwatch.cuprum.common.network.CuprumNetwork;
import com.jumpwatch.cuprum.common.registry.FinalRegistry;
import com.jumpwatch.cuprum.common.utils.CuprumConfigCommon;
import net.minecraftforge.common.MinecraftForge;
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
        FinalRegistry.register();
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonsetups);
        MinecraftForge.EVENT_BUS.register(this);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, CuprumConfigCommon.SPEC, "cuprum-common.toml");
    }

    public void commonsetups(FMLCommonSetupEvent event) {
        CuprumNetwork.init();
    }
}