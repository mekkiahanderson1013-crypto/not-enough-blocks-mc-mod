package net.mekkiah.testmod.blocks;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.mekkiah.testmod.TestMod;
import net.mekkiah.testmod.item.ModItems;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class ModBlocks {

    public static final Block CUT_EMERALD = registerBlock(
            "cut_emerald",
            BlockBehaviour.Properties.ofFullCopy(Blocks.EMERALD_BLOCK)
    );

    public static final Block CUT_IRON = registerBlock(
            "cut_iron",
            BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)
    );
    public static final Block CUT_IRON_STAIRS = registerStairBlock(
            "cut_iron_stairs",
            BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK),
            Blocks.STONE.defaultBlockState()
    );
    public static final Block CUT_IRON_SLAB = registerSlabBlock(
            "cut_iron_slab",
            BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK),
            Blocks.STONE.defaultBlockState()
    );

    private static Block registerBlock(
            String name,
            BlockBehaviour.Properties properties
    ) {
        Identifier id = Identifier.fromNamespaceAndPath(TestMod.MOD_ID, name);
        ResourceKey<Block> blockKey = ResourceKey.create(Registries.BLOCK, id);

        Block block = new Block(properties.setId(blockKey));

        Registry.register(BuiltInRegistries.BLOCK, blockKey, block);
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, id);

        BlockItem blockItem = new BlockItem(block, new Item.Properties().setId(itemKey).useBlockDescriptionPrefix());
        Registry.register(BuiltInRegistries.ITEM, itemKey, blockItem);

        return block;
    }

    private static StairBlock registerStairBlock(
            String name,
            BlockBehaviour.Properties properties,
            BlockState blockState
    ) {
        Identifier id = Identifier.fromNamespaceAndPath(TestMod.MOD_ID, name);
        ResourceKey<Block> blockKey = ResourceKey.create(Registries.BLOCK, id);

        StairBlock block = new StairBlock(blockState, properties.setId(blockKey));

        Registry.register(BuiltInRegistries.BLOCK, blockKey, block);
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, id);

        BlockItem blockItem = new BlockItem(block, new Item.Properties().setId(itemKey).useBlockDescriptionPrefix());
        Registry.register(BuiltInRegistries.ITEM, itemKey, blockItem);

        return block;
    }

    private static SlabBlock registerSlabBlock(
            String name,
            BlockBehaviour.Properties properties,
            BlockState blockState
    ) {
        Identifier id = Identifier.fromNamespaceAndPath(TestMod.MOD_ID, name);
        ResourceKey<Block> blockKey = ResourceKey.create(Registries.BLOCK, id);

        SlabBlock block = new SlabBlock(properties.setId(blockKey));

        Registry.register(BuiltInRegistries.BLOCK, blockKey, block);
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, id);

        BlockItem blockItem = new BlockItem(block, new Item.Properties().setId(itemKey).useBlockDescriptionPrefix());
        Registry.register(BuiltInRegistries.ITEM, itemKey, blockItem);

        return block;
    }


    public static void registerModBlocks() {
        TestMod.LOGGER.info("Registering Mod Items for " + TestMod.MOD_ID);

        CreativeModeTabEvents.modifyOutputEvent(
                CreativeModeTabs.BUILDING_BLOCKS
        ).register(entries -> {

            entries.insertAfter(
                    Blocks.EMERALD_BLOCK,
                    ModBlocks.CUT_EMERALD
            );
            entries.insertAfter(
                    Blocks.IRON_BLOCK,
                    ModBlocks.CUT_IRON
            );
            entries.insertAfter(
                    ModBlocks.CUT_IRON,
                    ModBlocks.CUT_IRON_STAIRS
            );
            entries.insertAfter(
                    ModBlocks.CUT_IRON_STAIRS,
                    ModBlocks.CUT_IRON_SLAB
            );
        });
    }

}