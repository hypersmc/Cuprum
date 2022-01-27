package com.jumpwatch.cuprum.common.registry;

import com.jumpwatch.cuprum.common.Cuprum;
import com.jumpwatch.cuprum.common.items.StableEnderP;

import com.jumpwatch.cuprum.common.utils.ThrownStableEnderpearl;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FinalRegistry {
    private static final Logger LOGGER = LogManager.getLogger();
    public static final DeferredRegister<Item> ITEMS = create(ForgeRegistries.ITEMS);
    public static final DeferredRegister<EntityType<?>> ENTITIES = create(ForgeRegistries.ENTITIES);
    public static void register(){
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ITEMS.register(modEventBus);
        ENTITIES.register(modEventBus);
        LOGGER.info("Finished registering!");
    }

    public static final RegistryObject<Item> Stable_Ender_Pearl = ITEMS.register("stableenderpearl", () -> new StableEnderP());


    public static final RegistryObject<EntityType<ThrownStableEnderpearl>> THROWN_STABLE_ENDERPEARL_ENTITY_TYPE = ENTITIES.register("thrownstableentitytype", () -> EntityType.Builder.<ThrownStableEnderpearl>of(ThrownStableEnderpearl::new,
            MobCategory.MISC)
            .sized(0.25F, 0.25F)
            .clientTrackingRange(4)
            .updateInterval(10)
            .build("thrownstableentitytype"));
    public static ModelLayerLocation THROWN_STABLE_ENDERPEARL_MODEL = new ModelLayerLocation(new ResourceLocation(Cuprum.MOD_ID, "textures/stableenderpearl_texture"), "stableenderpearl_texture");
    // EntityType.Builder.<ThrownStableEnderpearl>of(ThrownStableEnderpearl::new, MobCategory.MISC).sized(0.25F, 0.25F).clientTrackingRange(4).updateInterval(10)
    private static <T extends IForgeRegistryEntry<T>> DeferredRegister<T> create(IForgeRegistry<T> registry) {
        return DeferredRegister.create(registry, Cuprum.MOD_ID);
    }

}
