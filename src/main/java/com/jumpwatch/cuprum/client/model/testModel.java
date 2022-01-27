package com.jumpwatch.cuprum.client.model;

import com.jumpwatch.cuprum.common.Cuprum;
import com.jumpwatch.cuprum.common.entities.testEntity;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.resources.ResourceLocation;

public class testModel extends HumanoidModel<testEntity> {
    public static final String BODY = "body";
    public static ModelLayerLocation test_layer = new ModelLayerLocation(new ResourceLocation(Cuprum.MOD_ID, "test"), BODY);
    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = createMesh(CubeDeformation.NONE, 0.6f);
        return LayerDefinition.create(meshdefinition, 64, 32);
    }
    public testModel(ModelPart pRoot) {
        super(pRoot);
    }
}
