package com.jumpwatch.cuprum.common.items;

import com.jumpwatch.cuprum.common.registry.FinalRegistry;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Chargedprism extends Item {
    public Chargedprism() {
        super(new Properties().stacksTo(1).tab(FinalRegistry.CUPRUM));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        if (Screen.hasShiftDown()){
            pTooltipComponents.add(new TranslatableComponent("tooltip.cuprum.chargedprismunstable_shift"));
        }else{
            pTooltipComponents.add(new TranslatableComponent("tooltip.cuprum.chargedprismunstable"));
        }

        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
