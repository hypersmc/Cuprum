package com.jumpwatch.cuprum.common.registry;

import com.jumpwatch.cuprum.common.Cuprum;
import com.jumpwatch.cuprum.common.blocks.Hepatizonblock;
import com.jumpwatch.cuprum.common.entities.testEntity;
import com.jumpwatch.cuprum.common.items.Chargedprism;
import com.jumpwatch.cuprum.common.items.Hepatizoningot;
import com.jumpwatch.cuprum.common.items.StableEnderP;
import com.jumpwatch.cuprum.common.utils.ThrownStableEnderpearl;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FinalRegistry {
    private static final Logger LOGGER = LogManager.getLogger();
    public static final DeferredRegister<Item> ITEMS = create(ForgeRegistries.ITEMS);
    public static final DeferredRegister<EntityType<?>> ENTITIES = create(ForgeRegistries.ENTITIES);
    public static final DeferredRegister<Block> BLOCKS = create(ForgeRegistries.BLOCKS);
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES  = create(ForgeRegistries.BLOCK_ENTITIES);
    public static void register(){
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ITEMS.register(modEventBus);
        ENTITIES.register(modEventBus);
        BLOCKS.register(modEventBus);
        BLOCK_ENTITIES.register(modEventBus);
        LOGGER.info("Finished registering!");
    }



    public static final CreativeModeTab CUPRUM = new CreativeModeTab("Cuprum") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Hepatizon_ingot.get());
        }
    };
    public static <B extends Block> RegistryObject<Item> fromBlock(RegistryObject<B> block) {
        return ITEMS.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(CUPRUM)));
    }






    //Blocks
    public static final RegistryObject<Block> Hepatizon_block = BLOCKS.register("hepatizonblock", () -> new Hepatizonblock());

    //Items
    public static final RegistryObject<Item> Stable_Ender_Pearl = ITEMS.register("stableenderpearl", () -> new StableEnderP());
    public static final RegistryObject<Item> Hepatizon_ingot = ITEMS.register("hepatizoningot", () -> new Hepatizoningot());
    public static final RegistryObject<Item> Hepatizon_block_item = fromBlock(Hepatizon_block);
    public static final RegistryObject<Item> Charged_prism = ITEMS.register("chargedprisunstable", () -> new Chargedprism());

    //BlockEntities


    //Entities
    public static final RegistryObject<EntityType<ThrownStableEnderpearl>> THROWN_STABLE_ENDERPEARL_ENTITY_TYPE = ENTITIES.register("thrownstableentitytype", () -> EntityType.Builder.<ThrownStableEnderpearl>of(ThrownStableEnderpearl::new,
            MobCategory.MISC)
            .sized(0.25F, 0.25F)
            .clientTrackingRange(4)
            .updateInterval(10)
            .build("thrownstableentitytype"));
    public static ModelLayerLocation THROWN_STABLE_ENDERPEARL_MODEL = new ModelLayerLocation(new ResourceLocation(Cuprum.MOD_ID, "textures/stableenderpearl_texture"), "stableenderpearl_texture");
    private static <T extends IForgeRegistryEntry<T>> DeferredRegister<T> create(IForgeRegistry<T> registry) {
        return DeferredRegister.create(registry, Cuprum.MOD_ID);
    }



    //mobs and or animals

    public static final RegistryObject<EntityType<testEntity>> TEST_ENTITY = ENTITIES.register("test", () -> EntityType.Builder.of(testEntity::new, MobCategory.CREATURE)
            .sized(0.6F, 1.95F)
            .clientTrackingRange(8)
            .setShouldReceiveVelocityUpdates(false)
            .build("test"));
    public static final RegistryObject<Item> test_egg = ITEMS.register("test", () -> new ForgeSpawnEggItem(TEST_ENTITY, 0xff0000, 0x00ff00, new Item.Properties().tab(CUPRUM)));


}
