package com.jumpwatch.cuprum.common.blocks;

import com.jumpwatch.cuprum.common.registry.FinalRegistry;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;

public class Hepatizonblock extends Block {
    public Hepatizonblock() {
        super(Properties.of(Material.METAL).requiresCorrectToolForDrops().sound(SoundType.METAL).noOcclusion());
    }
}
