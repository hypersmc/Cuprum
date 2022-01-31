package com.jumpwatch.cuprum.common.items;

import com.jumpwatch.cuprum.common.registry.FinalRegistry;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class Chargedprism extends Item {
    public Chargedprism() {
        super(new Properties().stacksTo(1).tab(FinalRegistry.CUPRUM));
    }


}
