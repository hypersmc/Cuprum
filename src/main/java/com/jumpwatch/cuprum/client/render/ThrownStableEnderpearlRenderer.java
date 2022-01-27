package com.jumpwatch.cuprum.client.render;

import com.jumpwatch.cuprum.client.model.ThrownStableEnderpearlModel;
import com.jumpwatch.cuprum.common.Cuprum;
import com.jumpwatch.cuprum.common.registry.FinalRegistry;
import com.jumpwatch.cuprum.common.utils.ThrownStableEnderpearl;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.item.ItemStack;

public class ThrownStableEnderpearlRenderer extends ThrownItemRenderer<ThrownStableEnderpearl> implements ItemSupplier {
    public static final ResourceLocation ThrownStableEnderpearl_Texture = new ResourceLocation(Cuprum.MOD_ID, "textures/stableenderpearl_texture.png");

    public ThrownStableEnderpearlRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ItemStack getItem() {
        return FinalRegistry.Stable_Ender_Pearl.get().getDefaultInstance();
    }
}
