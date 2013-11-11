/*
 * Copyright (C) 2013 Fabrizio Lungo <fab@lungo.co.uk> - All Rights Reserved
 *
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 * Created by Fabrizio Lungo <fab@lungo.co.uk>, November 2013
 */
package me.flungo.bukkit.plotme.abstractgenerator;

import java.io.File;
import java.util.HashMap;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author Fabrizio Lungo <fab@lungo.co.uk>
 */
public abstract class AbstractGenerator extends JavaPlugin {

    public static final String CORE_PLUGIN_NAME = "PlotMe";
    public static final String DEFAULT_CONFIG_NAME = "config.yml";
    public static final String DEFAULT_CAPTIONS_FILE = "caption-english.yml";
    public static final String WORLDS_CONFIG_SECTION = "worlds";

    private File configFolder;

    private ConfigAccessor configCA;
    protected ConfigAccessor captionsCA;

    @Override
    public final void onEnable() {
        setupConfigFolder();
        setupConfig();
        initialize();
    }

    public abstract void initialize();

    @Override
    public final void onDisable() {
        configFolder = null;
        configCA = null;
        captionsCA = null;
        takedown();
    }

    public abstract void takedown();

    private void setupConfigFolder() {
        File pluginsFolder = getDataFolder().getParentFile();
        File plotMeFolder = new File(pluginsFolder, CORE_PLUGIN_NAME);
        this.configFolder = new File(plotMeFolder, getName());
        this.configFolder.mkdirs();
    }

    public File getConfigFolder() {
        return configFolder;
    }

    @Override
    public void reloadConfig() {
        configCA.reloadConfig(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public FileConfiguration getConfig() {
        return configCA.getConfig();
    }

    @Override
    public void saveConfig() {
        configCA.saveConfig(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveDefaultConfig() {
        configCA.saveDefaultConfig(); //To change body of generated methods, choose Tools | Templates.
    }

    private void setupConfig() {
        // Set the config accessor for the main config.yml
        configCA = new ConfigAccessor(this, DEFAULT_CONFIG_NAME);

        // Set defaults for WorldGenConfig
        for (AbstractWorldConfigPaths configPath : AbstractWorldConfigPaths.values()) {
            WorldGenConfig.putDefault(configPath.path, configPath.def);
        }

        // Set the config accessor for the main caption-english.yml
        captionsCA = new ConfigAccessor(this, DEFAULT_CAPTIONS_FILE);
        // Save default config into file.
        captionsCA.saveConfig();
    }

    public WorldGenConfig getWorldGenConfig(String world) {
        return getWorldGenConfig(world, new HashMap<String, Object>());
    }

    public WorldGenConfig getWorldGenConfig(String world, HashMap<String, Object> defaults) {
        ConfigurationSection worldsConfigurationSection;
        if (getConfig().contains(WORLDS_CONFIG_SECTION)) {
            worldsConfigurationSection = getConfig().getConfigurationSection(WORLDS_CONFIG_SECTION);
        } else {
            worldsConfigurationSection = getConfig().createSection(WORLDS_CONFIG_SECTION);
        }
        ConfigurationSection worldConfigurationSection;
        if (worldsConfigurationSection.contains(world)) {
            worldConfigurationSection = worldsConfigurationSection.getConfigurationSection(world);
        } else {
            worldConfigurationSection = worldsConfigurationSection.createSection(world);
        }
        return new WorldGenConfig(worldConfigurationSection, defaults);
    }
}
