package com.jumpwatch.cuprum.client.render;

import com.jumpwatch.cuprum.client.model.testModel;
import com.jumpwatch.cuprum.common.Cuprum;
import com.jumpwatch.cuprum.common.entities.testEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.SlimeRenderer;
import net.minecraft.resources.ResourceLocation;

public class testRenderer extends HumanoidMobRenderer<testEntity, testModel> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(Cuprum.MOD_ID, "textures/entity/test.png");

    public testRenderer(EntityRendererProvider.Context context) {
        super(context, new testModel(context.bakeLayer(testModel.test_layer)), 1f);
    }

    @Override
    public ResourceLocation getTextureLocation(testEntity pEntity) {
        return null;
    }
}
