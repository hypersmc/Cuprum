package com.jumpwatch.cuprum.common.registry;

import com.jumpwatch.cuprum.common.Cuprum;
import com.jumpwatch.cuprum.common.entities.testEntity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Cuprum.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)

public class Attribute {

    public static void setup() {
        IEventBus bus = MinecraftForge.EVENT_BUS;
    }
    @SubscribeEvent
    public static void onAttributeCreate(EntityAttributeCreationEvent event) {
        event.put(FinalRegistry.TEST_ENTITY.get(), testEntity.prepareAttributes().build());
    }
}
