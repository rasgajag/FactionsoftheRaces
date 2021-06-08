package net.mcreator.factions_of_the_races.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.factions_of_the_races.FactionsOfTheRacesModVariables;
import net.mcreator.factions_of_the_races.FactionsOfTheRacesModElements;
import net.mcreator.factions_of_the_races.FactionsOfTheRacesMod;

import java.util.Map;
import java.util.HashMap;

@FactionsOfTheRacesModElements.ModElement.Tag
public class DrawfpowersProcedure extends FactionsOfTheRacesModElements.ModElement {
	public DrawfpowersProcedure(FactionsOfTheRacesModElements instance) {
		super(instance, 36);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FactionsOfTheRacesMod.LOGGER.warn("Failed to load dependency entity for procedure Drawfpowers!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((2 == ((entity.getCapability(FactionsOfTheRacesModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new FactionsOfTheRacesModVariables.PlayerVariables())).Factionnumber))) {
			{
				Entity _ent = entity;
				if (!_ent.world.isRemote && _ent.world.getServer() != null) {
					_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
							"attribute @s forge:reach_distance base set 4");
				}
			}
			{
				Entity _ent = entity;
				if (!_ent.world.isRemote && _ent.world.getServer() != null) {
					_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
							"attribute @s minecraft:generic.movement_speed base set 0.08");
				}
			}
			{
				Entity _ent = entity;
				if (!_ent.world.isRemote && _ent.world.getServer() != null) {
					_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
							"attribute @s minecraft:generic.max_health base set 30");
				}
			}
			{
				Entity _ent = entity;
				if (!_ent.world.isRemote && _ent.world.getServer() != null) {
					_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
							"attribute @s minecraft:generic.armor base set 4");
				}
			}
			if ((new ItemStack(Items.WOODEN_PICKAXE, (int) (1))
					.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem())) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.HASTE, (int) 10, (int) 3));
			}
			if ((new ItemStack(Items.STONE_PICKAXE, (int) (1))
					.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem())) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.HASTE, (int) 10, (int) 3));
			}
			if ((new ItemStack(Items.IRON_PICKAXE, (int) (1))
					.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem())) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.HASTE, (int) 10, (int) 3));
			}
			if ((new ItemStack(Items.GOLDEN_PICKAXE, (int) (1))
					.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem())) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.HASTE, (int) 10, (int) 3));
			}
			if ((new ItemStack(Items.DIAMOND_PICKAXE, (int) (1))
					.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem())) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.HASTE, (int) 10, (int) 3));
			}
			if ((new ItemStack(Items.NETHERITE_PICKAXE, (int) (1))
					.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem())) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.HASTE, (int) 10, (int) 3));
			}
		}
	}

	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			Entity entity = event.player;
			World world = entity.world;
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}
}
