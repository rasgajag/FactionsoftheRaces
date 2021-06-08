package net.mcreator.factions_of_the_races.world;

import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import net.minecraft.world.GameRules;

import net.mcreator.factions_of_the_races.FactionsOfTheRacesModElements;

import java.lang.reflect.Method;

@FactionsOfTheRacesModElements.ModElement.Tag
public class PowerkeyGameRule extends FactionsOfTheRacesModElements.ModElement {
	public static final GameRules.RuleKey<GameRules.BooleanValue> gamerule = GameRules.register("powerkey", GameRules.Category.PLAYER, create(true));
	public PowerkeyGameRule(FactionsOfTheRacesModElements instance) {
		super(instance, 35);
	}

	public static GameRules.RuleType<GameRules.BooleanValue> create(boolean defaultValue) {
		try {
			Method createGameruleMethod = ObfuscationReflectionHelper.findMethod(GameRules.BooleanValue.class, "func_223568_b", boolean.class);
			createGameruleMethod.setAccessible(true);
			return (GameRules.RuleType<GameRules.BooleanValue>) createGameruleMethod.invoke(null, defaultValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
