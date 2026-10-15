package com.nova.autobuilder;

import com.nova.autobuilder.gui.BuilderScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class NovaAutoBuilderClient implements ClientModInitializer {
    private static KeyBinding openGuiKey;

    @Override
    public void onInitializeClient() {
        // Daftar kekunci pintas 'N' untuk membuka menu GUI Nova Auto Builder
        openGuiKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.nova-auto-builder.open",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_N,
                "category.nova-auto-builder.main"
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (openGuiKey.wasPressed()) {
                if (client.player != null) {
                    client.setScreen(new BuilderScreen());
                }
            }
        });
    }
}
