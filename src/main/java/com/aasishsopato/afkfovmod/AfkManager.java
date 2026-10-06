package com.aasishsopato.afkfovmod;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.util.InputUtil;

public
class AfkManager {
    private long lastActivityTime = System.currentTimeMillis();
    private boolean isAfk = false;

    public void update(ClientPlayerEntity player) {
        MinecraftClient client = MinecraftClient.getInstance();
        GameOptions options = client.options;

        if (options.forwardKey.isPressed() || options.backKey.isPressed() || options.leftKey.isPressed() || options.rightKey.isPressed() || options.jumpKey.isPressed() || options.sneakKey.isPressed() || options.sprintKey.isPressed() || InputUtil.isKeyPressed(client.getWindow().getHandle(), GLFW.GLFW_MOUSE_BUTTON_LEFT) || InputUtil.isKeyPressed(client.getWindow().getHandle(), GLFW.GLFW_MOUSE_BUTTON_RIGHT)) {
            lastActivityTime = System.currentTimeMillis();
            isAfk = false;
        } else if (System.currentTimeMillis() - lastActivityTime > AfkFovConfig.getTimeout() * 1000L) {
            isAfk = true;
        }
    }

    public boolean isAfk() {
        return isAfk;
    }
}
