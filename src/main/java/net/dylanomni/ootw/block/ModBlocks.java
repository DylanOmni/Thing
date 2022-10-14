package net.dylanomni.ootw.block;

import net.dylanomni.ootw.OotW;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.OreBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.PickaxeItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.Registry;

public class ModBlocks {
    public static final Block PLATINUM_ORE  = registerBlock("platinum_ore", new OreBlock(FabricBlockSettings.of(Material.STONE).strength(3f).requiresTool(), UniformIntProvider.create(3, 7)), ItemGroup.DECORATIONS);

    private static Block registerBlock(String name, Block block, ItemGroup tab){
        registerBlockItem(name, block, tab);
        return Registry.register(Registry.BLOCK, new Identifier(OotW.MOD_ID, name),block);
    }

    private static Item registerBlockItem (String name, Block block, ItemGroup tab) {
        return Registry.register(Registry.ITEM, new Identifier(OotW.MOD_ID, name), new BlockItem(block, new FabricItemSettings().group(tab)));
    }

    public static void registerModBlocks() {
        OotW.LOGGER.debug("Registering Mod Blocks for " + OotW.MOD_ID);
    }
}
