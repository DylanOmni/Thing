package net.dylanomni.ootw;

import net.dylanomni.ootw.block.ModBlocks;
import net.dylanomni.ootw.entity.projectile.OmniBeamEntity;
import net.dylanomni.ootw.item.ModItems;
import net.dylanomni.ootw.world.feature.ModConfiguredFeatures;
import net.dylanomni.ootw.world.gen.ModOreGeneration;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.example.registry.EntityRegistry;


import static software.bernie.geckolib3.GeckoLib.ModID;


public class OotW implements ModInitializer {
	public static final String MOD_ID = "ootw";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final EntityType<OmniBeamEntity> OmniBeamEntityType = Registry.register(
			Registry.ENTITY_TYPE,
			new Identifier(ModID, "legendary_sword"),
			FabricEntityTypeBuilder.<OmniBeamEntity>create(SpawnGroup.MISC, OmniBeamEntity::new)
					.dimensions(EntityDimensions.fixed(0.25F, 0.25F)) // dimensions in Minecraft units of the projectile
					.trackRangeBlocks(4).trackedUpdateRate(10) // necessary for all thrown projectiles (as it prevents it from breaking, lol)
					.build() // VERY IMPORTANT DONT DELETE FOR THE LOVE OF GOD PSLSSSSSS
	);


	@Override
	public void onInitialize() {
		ModConfiguredFeatures.registerConfiguredFeatures();


		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModOreGeneration.generateOres();




	}
	public static Identifier id(String name) {
		return new Identifier("ootw", name);
	}

}

