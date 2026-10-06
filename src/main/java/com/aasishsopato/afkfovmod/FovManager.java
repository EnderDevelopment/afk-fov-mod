package com.aasishsopato.afkfovmod;

import net.minecraft.client.network.ClientPlayerEntity;

public
class FovManager {
    private float originalFov = 70.0f;

    public void update(ClientPlayerEntity player, boolean isAfk) {
        if (isAfk) {
            if (player.getFovMultiplier() != AfkFovConfig.getAfkFov()) {
                originalFov = player.getFovMultiplier();
                player.setFovMultiplier(AfkFovConfig.getAfkFov());
            }
        } else {
            if (player.getFovMultiplier() != originalFov) {
                player.setFovMultiplier(originalFov);
            }
        }
    }
}
