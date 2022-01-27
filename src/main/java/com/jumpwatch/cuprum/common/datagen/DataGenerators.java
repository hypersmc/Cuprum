package com.jumpwatch.cuprum.common.datagen;

import com.jumpwatch.cuprum.client.model.ItemModels;
import com.jumpwatch.cuprum.common.Cuprum;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = Cuprum.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event){
        DataGenerator generator = event.getGenerator();
        if (event.includeServer()){

        }
        if (event.includeClient())
            generator.addProvider(new ItemModels(generator, event.getExistingFileHelper()));

    }
}
