package net.dylanomni.ootw.item;

import net.dylanomni.ootw.OotW;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static software.bernie.example.registry.RegistryUtils.registerItem;
import static software.bernie.geckolib3.GeckoLib.ModID;

public class ModItems {

    public static final Item PLATINUM_SWORD = registerItem("platinum_sword",
            new SwordItem(ToolMaterials.NETHERITE, 3, -2.4f,
                    new FabricItemSettings().group(ItemGroup.COMBAT).maxCount(1)));
    public static final Item PLATINUM = registerItem("platinum",
            new Item(new FabricItemSettings().group(ItemGroup.MISC)));
    public static final Item LEGENDARY_SWORD = registerItem("legendary_sword",
            new LegendarySword(ToolMaterials.NETHERITE, 4, -2.4f,
                    new FabricItemSettings().group(ItemGroup.COMBAT).maxCount(1)));



        private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(OotW.MOD_ID,  name), item);
    }

    public static void registerModItems() {
        OotW.LOGGER.debug("Registering Mod Items for " + OotW.MOD_ID);
    }
}
