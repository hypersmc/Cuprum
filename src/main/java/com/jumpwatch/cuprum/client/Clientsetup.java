package com.jumpwatch.cuprum.client;

import com.jumpwatch.cuprum.client.model.ThrownStableEnderpearlModel;
import com.jumpwatch.cuprum.client.render.ThrownStableEnderpearlRenderer;
import com.jumpwatch.cuprum.common.Cuprum;
import com.jumpwatch.cuprum.common.registry.FinalRegistry;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod.EventBusSubscriber(modid = Cuprum.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Clientsetup {
    private static final Logger LOGGER = LogManager.getLogger();
    public static void init(FMLClientSetupEvent event){

    }

    @SubscribeEvent
    public static void onRegisterRenderer(EntityRenderersEvent.RegisterRenderers event){
        LOGGER.info("registering renderes!");
        event.registerEntityRenderer(FinalRegistry.THROWN_STABLE_ENDERPEARL_ENTITY_TYPE.get(), ThrownStableEnderpearlRenderer::new);
    }
    @SubscribeEvent
    public static void onRegisterLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        LOGGER.info("registering models!");

        event.registerLayerDefinition(FinalRegistry.THROWN_STABLE_ENDERPEARL_MODEL, ThrownStableEnderpearlModel::createLayer);
    }
}
