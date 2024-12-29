package com.mingamerking.heraclesbuttonforge.gui;

import com.mingamerking.heraclesbuttonforge.HeraclesButtonForge;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractButton;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

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
        HeraclesButtonForge.log("Button constructed");
    }

    @Override
    public void onPress() {
        onPress.accept(this);
    }

    @Override
    public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        HeraclesButtonForge.log("Rendering");
        guiGraphics.blit(QUEST_BUTTON, getX(), getY(), 0, 14, WIDTH, HEIGHT, 32, 32);
    }

    @Override
    protected void updateWidgetNarration(NarrationElementOutput pNarrationElementOutput) {

    }

    @Override
    public void render(GuiGraphics pose, int x, int y, float t) {
        super.render(pose, x, y, t);
        HeraclesButtonForge.log("QButton render is being called");
    }
}
