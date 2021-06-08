package net.mcreator.factions_of_the_races.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.Score;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.factions_of_the_races.FactionsOfTheRacesModVariables;
import net.mcreator.factions_of_the_races.FactionsOfTheRacesModElements;
import net.mcreator.factions_of_the_races.FactionsOfTheRacesMod;

import java.util.Map;
import java.util.HashMap;

@FactionsOfTheRacesModElements.ModElement.Tag
public class FactionAbilityKey1OnKeyPressedProcedure extends FactionsOfTheRacesModElements.ModElement {
	public FactionAbilityKey1OnKeyPressedProcedure(FactionsOfTheRacesModElements instance) {
		super(instance, 15);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FactionsOfTheRacesMod.LOGGER.warn("Failed to load dependency entity for procedure FactionAbilityKey1OnKeyPressed!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				FactionsOfTheRacesMod.LOGGER.warn("Failed to load dependency x for procedure FactionAbilityKey1OnKeyPressed!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				FactionsOfTheRacesMod.LOGGER.warn("Failed to load dependency y for procedure FactionAbilityKey1OnKeyPressed!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				FactionsOfTheRacesMod.LOGGER.warn("Failed to load dependency z for procedure FactionAbilityKey1OnKeyPressed!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				FactionsOfTheRacesMod.LOGGER.warn("Failed to load dependency world for procedure FactionAbilityKey1OnKeyPressed!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((new Object() {
			public int getScore(String score) {
				if (entity instanceof PlayerEntity) {
					Scoreboard _sc = ((PlayerEntity) entity).getWorldScoreboard();
					ScoreObjective _so = _sc.getObjective(score);
					if (_so != null) {
						Score _scr = _sc.getOrCreateScore(((PlayerEntity) entity).getScoreboardName(), _so);
						return _scr.getScorePoints();
					}
				}
				return 0;
			}
		}.getScore("timer")) == 0)) {
			if ((((entity.getCapability(FactionsOfTheRacesModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new FactionsOfTheRacesModVariables.PlayerVariables())).Factionnumber) == 1)) {
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					$_dependencies.put("x", x);
					$_dependencies.put("y", y);
					$_dependencies.put("z", z);
					$_dependencies.put("world", world);
					ElfpowerkeypressedProcedure.executeProcedure($_dependencies);
				}
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					TimerpotionluckstartProcedure.executeProcedure($_dependencies);
				}
			}
			if ((((entity.getCapability(FactionsOfTheRacesModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new FactionsOfTheRacesModVariables.PlayerVariables())).Factionnumber) == 2)) {
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					DrawnFactionpower1pressedProcedure.executeProcedure($_dependencies);
				}
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					TimerpotionluckstartProcedure.executeProcedure($_dependencies);
				}
			}
			if ((((entity.getCapability(FactionsOfTheRacesModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new FactionsOfTheRacesModVariables.PlayerVariables())).Factionnumber) == 3)) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You're a human you have no power, you DumDum"), (false));
				}
			}
			if ((((entity.getCapability(FactionsOfTheRacesModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new FactionsOfTheRacesModVariables.PlayerVariables())).Factionnumber) == 4)) {
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					CentarPowerKEy1pressedProcedure.executeProcedure($_dependencies);
				}
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					TimerpotionluckstartProcedure.executeProcedure($_dependencies);
				}
			}
			if ((((entity.getCapability(FactionsOfTheRacesModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new FactionsOfTheRacesModVariables.PlayerVariables())).Factionnumber) == 5)) {
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					NetherbornFActionPowerKey1PressedProcedure.executeProcedure($_dependencies);
				}
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					TimerpotionluckstartProcedure.executeProcedure($_dependencies);
				}
			}
			if ((((entity.getCapability(FactionsOfTheRacesModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new FactionsOfTheRacesModVariables.PlayerVariables())).Factionnumber) == 6)) {
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					ChickenPowerKey1PressedProcedure.executeProcedure($_dependencies);
				}
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					TimerpotionluckstartProcedure.executeProcedure($_dependencies);
				}
			}
		}
	}
}
