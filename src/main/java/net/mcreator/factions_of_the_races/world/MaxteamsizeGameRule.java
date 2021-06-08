package net.mcreator.factions_of_the_races.world;

import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import net.minecraft.world.GameRules;

import net.mcreator.factions_of_the_races.FactionsOfTheRacesModElements;

import java.lang.reflect.Method;

@FactionsOfTheRacesModElements.ModElement.Tag
public class MaxteamsizeGameRule extends FactionsOfTheRacesModElements.ModElement {
	public static final GameRules.RuleKey<GameRules.IntegerValue> gamerule = GameRules.register("maxteamsize", GameRules.Category.PLAYER, create(2));
	public MaxteamsizeGameRule(FactionsOfTheRacesModElements instance) {
		super(instance, 50);
	}

	public static GameRules.RuleType<GameRules.IntegerValue> create(int defaultValue) {
		try {
			Method createGameruleMethod = ObfuscationReflectionHelper.findMethod(GameRules.IntegerValue.class, "func_223559_b", int.class);
			createGameruleMethod.setAccessible(true);
			return (GameRules.RuleType<GameRules.IntegerValue>) createGameruleMethod.invoke(null, defaultValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
