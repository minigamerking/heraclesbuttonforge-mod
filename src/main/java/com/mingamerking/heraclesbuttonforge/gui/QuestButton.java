package com.mingamerking.heraclesbuttonforge.gui;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractButton;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.InventoryMenu;

import java.util.function.Consumer;

public class QuestButton extends AbstractButton {

    private static final ResourceLocation QUEST_BUTTON = new ResourceLocation("heracles", "textures/item/quest_book.png");
    public static final int WIDTH = 18;
    public static final int HEIGHT = 14;
    private InventoryScreen screen;
    private Consumer<QuestButton> onPress;

    public QuestButton(int x, int y, Consumer<QuestButton> onPress, InventoryScreen screen) {
        super(x, y, WIDTH, HEIGHT, Component.empty());
        this.onPress = onPress;
        this.screen = screen;
        System.out.println("Button constructed");
    }

    @Override
    public void onPress() {
        onPress.accept(this);
    }

    @Override
    public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        System.out.println("Rendering");
        guiGraphics.blit(QUEST_BUTTON, getX(), getY(), 0, 14, WIDTH, HEIGHT, 32, 32);
    }

    @Override
    protected void updateWidgetNarration(NarrationElementOutput pNarrationElementOutput) {

    }
}
