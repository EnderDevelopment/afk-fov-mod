package com.aasishsopato.afkfovmod;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public
class AfkFovConfig {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final File CONFIG_FILE = new File("config/afkfovmod.json");

    private static boolean enabled = true;
    private static int timeout = 10;
    private static float afkFov = 30.0f;

    public static void load() {
        if (!CONFIG_FILE.exists()) {
            save();
            return;
        }

        try (FileReader reader = new FileReader(CONFIG_FILE)) {
            AfkFovConfig config = GSON.fromJson(reader, AfkFovConfig.class);
            enabled = config.enabled;
            timeout = config.timeout;
            afkFov = config.afkFov;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void save() {
        try (FileWriter writer = new FileWriter(CONFIG_FILE)) {
            GSON.toJson(new AfkFovConfig(), writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean isEnabled() {
        return enabled;
    }

    public static int getTimeout() {
        return timeout;
    }

    public static float getAfkFov() {
        return afkFov;
    }

    private static
    class AfkFovConfig {
        private boolean enabled = true;
        private int timeout = 10;
        private float afkFov = 30.0f;
    }
}
