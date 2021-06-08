
package net.mcreator.factions_of_the_races.gui.overlay;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.Minecraft;

import net.mcreator.factions_of_the_races.procedures.ZerosecProcedure;
import net.mcreator.factions_of_the_races.procedures.TwoSecProcedure;
import net.mcreator.factions_of_the_races.procedures.ThreeSecProcedure;
import net.mcreator.factions_of_the_races.procedures.SixSecProcedure;
import net.mcreator.factions_of_the_races.procedures.OnesecProcedure;
import net.mcreator.factions_of_the_races.procedures.FourSecProcedure;
import net.mcreator.factions_of_the_races.procedures.FiveSecProcedure;
import net.mcreator.factions_of_the_races.FactionsOfTheRacesModElements;

import com.google.common.collect.ImmutableMap;

@FactionsOfTheRacesModElements.ModElement.Tag
public class TimeRemainingOverlay extends FactionsOfTheRacesModElements.ModElement {
	public TimeRemainingOverlay(FactionsOfTheRacesModElements instance) {
		super(instance, 23);
	}

	@Override
	public void initElements() {
		MinecraftForge.EVENT_BUS.register(this);
	}

	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public void eventHandler(RenderGameOverlayEvent event) {
		if (!event.isCancelable() && event.getType() == RenderGameOverlayEvent.ElementType.HELMET) {
			int posX = (event.getWindow().getScaledWidth()) / 2;
			int posY = (event.getWindow().getScaledHeight()) / 2;
			PlayerEntity entity = Minecraft.getInstance().player;
			World world = entity.world;
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			if (true) {
				Minecraft.getInstance().fontRenderer.drawString(event.getMatrixStack(), "Power Cooldown", posX + 130, posY + 93, -1);
				if (SixSecProcedure.executeProcedure(ImmutableMap.of("entity", entity)))
					Minecraft.getInstance().fontRenderer.drawString(event.getMatrixStack(), "6 Sec", posX + 172, posY + 101, -1);
				if (FiveSecProcedure.executeProcedure(ImmutableMap.of("entity", entity)))
					Minecraft.getInstance().fontRenderer.drawString(event.getMatrixStack(), "5 Sec", posX + 172, posY + 101, -1);
				if (FourSecProcedure.executeProcedure(ImmutableMap.of("entity", entity)))
					Minecraft.getInstance().fontRenderer.drawString(event.getMatrixStack(), "4 Sec", posX + 172, posY + 101, -1);
				if (ThreeSecProcedure.executeProcedure(ImmutableMap.of("entity", entity)))
					Minecraft.getInstance().fontRenderer.drawString(event.getMatrixStack(), "3 Sec", posX + 172, posY + 101, -1);
				if (TwoSecProcedure.executeProcedure(ImmutableMap.of("entity", entity)))
					Minecraft.getInstance().fontRenderer.drawString(event.getMatrixStack(), "2 Sec", posX + 172, posY + 101, -1);
				if (OnesecProcedure.executeProcedure(ImmutableMap.of("entity", entity)))
					Minecraft.getInstance().fontRenderer.drawString(event.getMatrixStack(), "1 Sec", posX + 172, posY + 101, -1);
				if (ZerosecProcedure.executeProcedure(ImmutableMap.of("entity", entity)))
					Minecraft.getInstance().fontRenderer.drawString(event.getMatrixStack(), "0 Sec", posX + 172, posY + 101, -1);
			}
		}
	}
}
