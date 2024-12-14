package com.mingamerking.heraclesbuttonforge;

import com.mingamerking.heraclesbuttonforge.gui.QuestButton;
import earth.terrarium.heracles.client.HeraclesClient;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "heraclesbuttonforge", bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ScreenEventHandler {

    @SubscribeEvent
    public static void onScreenOpen(ScreenEvent.Opening event) {
        System.out.println("Screen Opened");
        Screen screen = event.getNewScreen();
        if (screen instanceof InventoryScreen inventoryScreen) {
            addQuestButton(inventoryScreen);
        }
    }

    private static void addQuestButton(InventoryScreen inventoryScreen) {
        // Create a new QuestButton and add it to the screen's widgets
        int x = inventoryScreen.getGuiLeft() + 100; // Adjust as necessary
        int y = inventoryScreen.getGuiTop() + 100; // Adjust as necessary
        QuestButton questButton = new QuestButton(x, y, button -> {
            // Define what happens when the button is pressed
            HeraclesClient.openQuestScreen();
        }, inventoryScreen);

        // Add the button to the screen's renderables and children
        inventoryScreen.renderables.add(questButton);
        System.out.println("Button added to inventory");
    }
}