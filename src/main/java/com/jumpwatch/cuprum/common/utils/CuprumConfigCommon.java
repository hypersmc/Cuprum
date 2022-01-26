package com.jumpwatch.cuprum.common.utils;

import net.minecraftforge.common.ForgeConfigSpec;

public class CuprumConfigCommon {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Integer> EnderDurability;
    public static final ForgeConfigSpec.ConfigValue<Integer> EnderCooldown;
    public static final ForgeConfigSpec.ConfigValue<Double> EnderDamage;

    static {
        BUILDER.push("Configuration for Cuprum");
        EnderDurability = BUILDER.comment("The Durability of the Stable Ender Pearl. Default value is 3.").define("Ender Durability", 3);
        EnderCooldown = BUILDER.comment("The Cooldown before Stable Ender Pearl can be used again. Default value is 4.").define("Ender Cooldown", 4);
        EnderDamage = BUILDER.comment("The damage the player takes when landing. Default value is 0.5.").define("Ender Damage", 0.5);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
