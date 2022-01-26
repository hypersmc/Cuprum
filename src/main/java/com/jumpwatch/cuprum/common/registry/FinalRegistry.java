package com.jumpwatch.cuprum.common.registry;


import com.jumpwatch.cuprum.common.Cuprum;
import com.jumpwatch.cuprum.common.items.StableEnderP;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FinalRegistry {
    private static final Logger LOGGER = LogManager.getLogger();
    public static final DeferredRegister<Item> ITEMS = create(ForgeRegistries.ITEMS);
    public static void register(){
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ITEMS.register(modEventBus);
        LOGGER.info("Finished registering!");
    }

    public static final RegistryObject<Item> Stable_Ender_Pearl = ITEMS.register("stableenderpearl", () -> new StableEnderP());




    private static <T extends IForgeRegistryEntry<T>> DeferredRegister<T> create(IForgeRegistry<T> registry) {
        return DeferredRegister.create(registry, Cuprum.MOD_ID);
    }

}
