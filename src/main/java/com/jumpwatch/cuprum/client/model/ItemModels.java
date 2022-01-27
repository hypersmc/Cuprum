package com.jumpwatch.cuprum.client.model;

import com.jumpwatch.cuprum.common.Cuprum;
import com.jumpwatch.cuprum.common.registry.FinalRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ItemModels extends ItemModelProvider {
    private static final Logger LOGGER = LogManager.getLogger();
    public ItemModels(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, Cuprum.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        LOGGER.info("Started registering eggs!");
        withExistingParent(FinalRegistry.test_egg.get().getRegistryName().getPath(), mcLoc("item/template_spawn_egg"));
    }
}
