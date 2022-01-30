package com.jumpwatch.cuprum.common.utils;

import net.minecraftforge.common.ForgeConfigSpec;

public class CuprumConfigCommon {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final General GENERAL = new General(BUILDER);




    public static class General {
        public  final ForgeConfigSpec.ConfigValue<Integer> EnderDurability;
        public  final ForgeConfigSpec.ConfigValue<Integer> EnderCooldown;
        public  final ForgeConfigSpec.ConfigValue<Double> EnderDamage;
        General(ForgeConfigSpec.Builder builder) {
            builder.push("Configuration for Cuprum");
            EnderDurability = builder
                    .comment("(NOT USED) The Durability of the Stable Ender Pearl. Default value is 3.")
                    .translation("cuprum.enderdurability.config")
                    .defineInRange("Ender Durability", 3, 0, Integer.MAX_VALUE);
            EnderCooldown = builder
                    .comment("The Cooldown before Stable Ender Pearl can be used again (In ticks). Default value is 4.")
                    .translation("cuprum.endercooldown.config")
                    .defineInRange("Ender Cooldown", 160, 0, Integer.MAX_VALUE);
            EnderDamage = builder
                    .comment("The damage the player takes when landing. Default value is 0.5.")
                    .translation("cuprum.enderdamage.config")
                    .defineInRange("Ender Damage", 0.5, 0.0, 20.0);
            builder.pop();
        }


    }
    public static final ForgeConfigSpec SPEC = BUILDER.build();
}
