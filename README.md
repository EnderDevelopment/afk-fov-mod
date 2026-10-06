# AFK FOV Mod

Adjust FOV when you're AFK in Minecraft

## Features

- Automatically detects AFK status after configurable timeout
- Adjusts FOV to a customizable value when AFK
- Configurable timeout and FOV settings

## Requirements

- Minecraft 1.21.4
- Fabric Loader 0.14.0 or later
- Fabric API

## Installation

1. Download the mod JAR file from the [releases page](https://github.com/EnderDevelopment/afk-fov-mod/releases)
2. Place the JAR file in your Minecraft mods folder
3. Launch Minecraft with Fabric

## Usage

The mod will automatically adjust your FOV when you're inactive. You can configure the timeout and FOV values in the configuration file.

## Configuration

The mod creates a configuration file at `config/afkfovmod.json` with the following options:

```json
{
  "enabled": true,
  "timeout": 10,
  "afkFov": 30.0
}
```

- `enabled`: Whether the mod is enabled
- `timeout`: The number of seconds of inactivity before the mod considers you AFK
- `afkFov`: The FOV value to set when you're AFK

---

## Generated with EnderDevelopment

This mod was generated in minutes with [EnderDevelopment](https://enderdevelopment.com) — the AI platform that turns your ideas into working Minecraft plugins, Discord bots and FiveM scripts.

**Want your own?** [Generate this project on EnderDevelopment](https://dash.enderdevelopment.com?utm_source=github&utm_medium=readme&utm_campaign=afk-fov-mod&utm_content=bottom) — describe it in one sentence and get the full source code.