package net.mcreator.factions_of_the_races.procedures;

import net.minecraftforge.fml.server.ServerLifecycleHooks;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.Util;
import net.minecraft.server.MinecraftServer;
import net.minecraft.entity.Entity;

import net.mcreator.factions_of_the_races.FactionsOfTheRacesModVariables;
import net.mcreator.factions_of_the_races.FactionsOfTheRacesModElements;
import net.mcreator.factions_of_the_races.FactionsOfTheRacesMod;

import java.util.Map;
import java.util.HashMap;

@FactionsOfTheRacesModElements.ModElement.Tag
public class StartWorldWarCommandExecutedProcedure extends FactionsOfTheRacesModElements.ModElement {
	public StartWorldWarCommandExecutedProcedure(FactionsOfTheRacesModElements instance) {
		super(instance, 42);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FactionsOfTheRacesMod.LOGGER.warn("Failed to load dependency entity for procedure StartWorldWarCommandExecuted!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				FactionsOfTheRacesMod.LOGGER.warn("Failed to load dependency world for procedure StartWorldWarCommandExecuted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		if (!world.isRemote()) {
			MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
			if (mcserv != null)
				mcserv.getPlayerList().func_232641_a_(
						new StringTextComponent("A world war has been called good luck have fun! do /warteam to choose a team!"), ChatType.SYSTEM,
						Util.DUMMY_UUID);
		}
		FactionsOfTheRacesModVariables.WorldVariables.get(world).War = (boolean) (true);
		FactionsOfTheRacesModVariables.WorldVariables.get(world).syncData(world);
		{
			Map<String, Object> $_dependencies = new HashMap<>();
			$_dependencies.put("entity", entity);
			TeamcreateProcedure.executeProcedure($_dependencies);
		}
	}
}
