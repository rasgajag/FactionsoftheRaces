package net.mcreator.factions_of_the_races.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.entity.Entity;

import net.mcreator.factions_of_the_races.FactionsOfTheRacesModVariables;
import net.mcreator.factions_of_the_races.FactionsOfTheRacesModElements;
import net.mcreator.factions_of_the_races.FactionsOfTheRacesMod;

import java.util.Map;
import java.util.HashMap;

@FactionsOfTheRacesModElements.ModElement.Tag
public class EndwarCommandExecutedProcedure extends FactionsOfTheRacesModElements.ModElement {
	public EndwarCommandExecutedProcedure(FactionsOfTheRacesModElements instance) {
		super(instance, 54);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FactionsOfTheRacesMod.LOGGER.warn("Failed to load dependency entity for procedure EndwarCommandExecuted!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				FactionsOfTheRacesMod.LOGGER.warn("Failed to load dependency world for procedure EndwarCommandExecuted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		{
			Map<String, Object> $_dependencies = new HashMap<>();
			$_dependencies.put("entity", entity);
			TeamclearProcedure.executeProcedure($_dependencies);
		}
		FactionsOfTheRacesModVariables.WorldVariables.get(world).War = (boolean) (false);
		FactionsOfTheRacesModVariables.WorldVariables.get(world).syncData(world);
	}
}
