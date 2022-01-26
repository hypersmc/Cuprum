package com.jumpwatch.cuprum.common.items;

import com.jumpwatch.cuprum.common.Cuprum;
import com.jumpwatch.cuprum.common.utils.CuprumConfigCommon;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrownEnderpearl;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

public class StableEnderP extends Item {
    public StableEnderP() {
        super(new Properties().stacksTo(1).defaultDurability(CuprumConfigCommon.EnderDurability.get()).setNoRepair().tab(CreativeModeTab.TAB_MISC));

    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack stack = pPlayer.getMainHandItem();
        ThrownEnderpearl entity = new ThrownEnderpearl(pLevel, pPlayer);
        entity.setOwner(pPlayer);
        entity.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0.0F, 1.5F, 1.0F);
        pLevel.addFreshEntity(entity);

        int dmgVal = stack.getDamageValue() - 1;
        stack.setDamageValue(dmgVal);

        return super.use(pLevel, pPlayer, pUsedHand);
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        if (enchantment.isCompatibleWith(Enchantments.MENDING)) return true;
        if (enchantment.isCompatibleWith(Enchantments.UNBREAKING)) return true;
        return false;
    }
}
