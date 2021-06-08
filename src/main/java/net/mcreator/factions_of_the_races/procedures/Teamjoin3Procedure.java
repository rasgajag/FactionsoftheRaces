package net.mcreator.factions_of_the_races.procedures;

import net.minecraft.world.IWorld;

import net.mcreator.factions_of_the_races.world.MaxteamsizeGameRule;
import net.mcreator.factions_of_the_races.FactionsOfTheRacesModVariables;
import net.mcreator.factions_of_the_races.FactionsOfTheRacesModElements;
import net.mcreator.factions_of_the_races.FactionsOfTheRacesMod;

import java.util.Map;

@FactionsOfTheRacesModElements.ModElement.Tag
public class Teamjoin3Procedure extends FactionsOfTheRacesModElements.ModElement {
	public Teamjoin3Procedure(FactionsOfTheRacesModElements instance) {
		super(instance, 48);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				FactionsOfTheRacesMod.LOGGER.warn("Failed to load dependency world for procedure Teamjoin3!");
			return false;
		}
		IWorld world = (IWorld) dependencies.get("world");
		if (((world.getWorldInfo().getGameRulesInstance()
				.getInt(MaxteamsizeGameRule.gamerule)) > (FactionsOfTheRacesModVariables.MapVariables.get(world).Team3))) {
			return (true);
		}
		return (false);
	}
}
