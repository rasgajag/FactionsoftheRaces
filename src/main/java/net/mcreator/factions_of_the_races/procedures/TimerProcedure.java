package net.mcreator.factions_of_the_races.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.ScoreCriteria;
import net.minecraft.scoreboard.Score;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.factions_of_the_races.FactionsOfTheRacesModElements;
import net.mcreator.factions_of_the_races.FactionsOfTheRacesMod;

import java.util.Map;
import java.util.Collection;

@FactionsOfTheRacesModElements.ModElement.Tag
public class TimerProcedure extends FactionsOfTheRacesModElements.ModElement {
	public TimerProcedure(FactionsOfTheRacesModElements instance) {
		super(instance, 22);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FactionsOfTheRacesMod.LOGGER.warn("Failed to load dependency entity for procedure Timer!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.LUCK, (int) 100, (int) 1, (false), (false)));
		for (int index0 = 0; index0 < (int) (100000); index0++) {
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
			}.getScore("timer")) != (new Object() {
				int check(Entity _entity) {
					if (_entity instanceof LivingEntity) {
						Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
						for (EffectInstance effect : effects) {
							if (effect.getPotion() == Effects.LUCK)
								return effect.getDuration();
						}
					}
					return 0;
				}
			}.check(entity)))) {
				{
					Entity _ent = entity;
					if (_ent instanceof PlayerEntity) {
						Scoreboard _sc = ((PlayerEntity) _ent).getWorldScoreboard();
						ScoreObjective _so = _sc.getObjective("timer");
						if (_so == null) {
							_so = _sc.addObjective("timer", ScoreCriteria.DUMMY, new StringTextComponent("timer"), ScoreCriteria.RenderType.INTEGER);
						}
						Score _scr = _sc.getOrCreateScore(((PlayerEntity) _ent).getScoreboardName(), _so);
						_scr.setScorePoints((int) (new Object() {
							int check(Entity _entity) {
								if (_entity instanceof LivingEntity) {
									Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
									for (EffectInstance effect : effects) {
										if (effect.getPotion() == Effects.LUCK)
											return effect.getDuration();
									}
								}
								return 0;
							}
						}.check(entity)));
					}
				}
			}
		}
	}
}
