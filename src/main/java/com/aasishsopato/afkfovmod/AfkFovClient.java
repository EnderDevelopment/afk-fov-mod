package com.aasishsopato.afkfovmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public
class AfkFovClient implements ClientModInitializer {
    private static final KeyBinding TOGGLE_KEY = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.afkfovmod.toggle", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_F6, "category.afkfovmod"));
    private final AfkManager afkManager = new AfkManager();
    private final FovManager fovManager = new FovManager();

    @Override
    public void onInitializeClient() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.player != null) {
                afkManager.update(client.player);
                fovManager.update(client.player, afkManager.isAfk());
            }
        });
    }
}
