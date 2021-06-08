
package net.mcreator.factions_of_the_races.gui;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import net.mcreator.factions_of_the_races.FactionsOfTheRacesMod;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class FirstjoinGuiPageTWoGuiWindow extends ContainerScreen<FirstjoinGuiPageTWoGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	public FirstjoinGuiPageTWoGuiWindow(FirstjoinGuiPageTWoGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 500;
		this.ySize = 300;
	}

	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.color4f(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("factions_of_the_races:textures/5456d36c6106729.png"));
		this.blit(ms, this.guiLeft + 33, this.guiTop + -16, 0, 0, 440, 350, 440, 350);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeScreen();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void tick() {
		super.tick();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
		this.font.drawString(ms, "Powers:", 150, 101, -12829636);
		this.font.drawString(ms, "You're Boring", 141, 110, -12829636);
		this.font.drawString(ms, "Powers:", 321, 101, -12829636);
		this.font.drawString(ms, "HalfBody", 312, 137, -12829636);
		this.font.drawString(ms, "Start Bow", 312, 110, -12829636);
		this.font.drawString(ms, "Thinskin", 312, 128, -12829636);
		this.font.drawString(ms, "Horse Speed", 312, 119, -12829636);
		this.font.drawString(ms, "Heat Scared", 312, 146, -12829636);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardListener.enableRepeatEvents(false);
	}

	@Override
	public void init(Minecraft minecraft, int width, int height) {
		super.init(minecraft, width, height);
		minecraft.keyboardListener.enableRepeatEvents(true);
		this.addButton(new Button(this.guiLeft + 339, this.guiTop + 236, 70, 20, new StringTextComponent("Next Page"), e -> {
			if (true) {
				FactionsOfTheRacesMod.PACKET_HANDLER.sendToServer(new FirstjoinGuiPageTWoGui.ButtonPressedMessage(0, x, y, z));
				FirstjoinGuiPageTWoGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 141, this.guiTop + 74, 50, 20, new StringTextComponent("Human"), e -> {
			if (true) {
				FactionsOfTheRacesMod.PACKET_HANDLER.sendToServer(new FirstjoinGuiPageTWoGui.ButtonPressedMessage(1, x, y, z));
				FirstjoinGuiPageTWoGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 312, this.guiTop + 74, 60, 20, new StringTextComponent("Centar"), e -> {
			if (true) {
				FactionsOfTheRacesMod.PACKET_HANDLER.sendToServer(new FirstjoinGuiPageTWoGui.ButtonPressedMessage(2, x, y, z));
				FirstjoinGuiPageTWoGui.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 96, this.guiTop + 236, 65, 20, new StringTextComponent("LastPage"), e -> {
			if (true) {
				FactionsOfTheRacesMod.PACKET_HANDLER.sendToServer(new FirstjoinGuiPageTWoGui.ButtonPressedMessage(3, x, y, z));
				FirstjoinGuiPageTWoGui.handleButtonAction(entity, 3, x, y, z);
			}
		}));
	}
}
