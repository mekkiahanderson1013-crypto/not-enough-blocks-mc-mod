package net.mekkiah.testmod.item;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.mekkiah.testmod.TestMod;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;

public class ModItems {

    private static Item registerItem(String name) {
        // make sure item id is lower case
        name = name.toLowerCase();

        // setup item id, key
        Identifier id = Identifier.fromNamespaceAndPath(TestMod.MOD_ID, name);
        ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, id);

        // create new item
        Item item = new Item(new Item.Properties().setId(key));

        return Registry.register(BuiltInRegistries.ITEM, key, item);
    }

    //public static final Item EXAMPLE_ITEM = registerItem("example_item");

    public static void registerModItems() {
        TestMod.LOGGER.info("Registering Mod Items for " + TestMod.MOD_ID);

       /* CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS)
                .register((creativeModeTab) -> {creativeModeTab.accept(ModItems.EXAMPLE_ITEM);});

        */
    }
}