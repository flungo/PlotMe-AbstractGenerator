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
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author Fabrizio Lungo <fab@lungo.co.uk>
 */
public abstract class AbstractGenerator extends JavaPlugin {

    public static final String CORE_PLUGIN_NAME = "PlotMe";
    public static final String CORE_CONFIG_NAME = "core-config.yml";
    public static final String CORE_LANG_PATH = "Language";
    public static final String CORE_DEFAULT_LANG = "english";
    public static final String CORE_CAPTIONS_PATTERN = "caption-%s.yml";
    public static final String DEFAULT_CONFIG_NAME = "config.yml";
    public static final String DEFAULT_LANG = "english";
    public static final String DEFAULT_CAPTIONS_FILE = "caption-english.yml";
    public static final String WORLDS_CONFIG_SECTION = "worlds";

    private File coreFolder;
    private File configFolder;

    private File coreConfigFile;

    private FileConfiguration coreConfig;
    private HashMap<String, FileConfiguration> coreCaptions;
    private ConfigAccessor configCA;
    protected ConfigAccessor captionsCA;

    @Override
    public final void onEnable() {
        setupConfigFolders();
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

    private void setupConfigFolders() {
        File pluginsFolder = getDataFolder().getParentFile();
        coreFolder = new File(pluginsFolder, CORE_PLUGIN_NAME);
        coreConfigFile = new File(coreFolder, CORE_CONFIG_NAME);
        configFolder = new File(coreFolder, getName());
        configFolder.mkdirs();
    }

    public File getCoreFolder() {
        return coreFolder;
    }

    public void reloadCoreConfig() {
        coreConfig = YamlConfiguration.loadConfiguration(coreConfigFile);
    }

    public FileConfiguration getCoreConfig() {
        if (coreConfig == null) {
            reloadCoreConfig();
        }
        return coreConfig;
    }

    public void saveCoreConfig() {
        if (coreConfig == null || coreConfigFile == null) {
            return;
        }
        try {
            getConfig().save(coreConfigFile);
        } catch (IOException ex) {
            getLogger().log(Level.SEVERE, "Could not save config to " + coreConfigFile, ex);
        }
    }

    private File getCoreCaptionsFile(String lang) {
        return new File(coreFolder, String.format(CORE_CAPTIONS_PATTERN, lang));
    }

    public void reloadCoreCaptions() {
        reloadCoreCaptions(getCoreConfig().getString(CORE_LANG_PATH, CORE_DEFAULT_LANG));
    }

    public void reloadCoreCaptions(String lang) {
        coreCaptions.put(lang, YamlConfiguration.loadConfiguration(getCoreCaptionsFile(lang)));
    }

    public FileConfiguration getCoreCaptions() {
        return getCoreCaptions(getCoreConfig().getString(CORE_LANG_PATH, CORE_DEFAULT_LANG));
    }

    public FileConfiguration getCoreCaptions(String lang) {
        if (!coreCaptions.containsKey(lang)) {
            reloadCoreConfig();
        }
        return coreCaptions.get(lang);
    }

    public void saveCoreCaptions() {
        saveCoreCaptions(getCoreConfig().getString(CORE_LANG_PATH, CORE_DEFAULT_LANG));
    }

    public void saveCoreCaptions(String lang) {
        if (!coreCaptions.containsKey(lang)) {
            return;
        }
        try {
            coreCaptions.get(lang).save(getCoreCaptionsFile(lang));
        } catch (IOException ex) {
            getLogger().log(Level.SEVERE, "Could not save config to " + coreConfigFile, ex);
        }
    }

    public File getConfigFolder() {
        return configFolder;
    }

    @Override
    public void reloadConfig() {
        configCA.reloadConfig();
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
        for (AbstractWorldConfigPath configPath : AbstractWorldConfigPath.values()) {
            WorldGenConfig.putDefault(configPath);
        }

        // Set the config accessor for the main caption-english.yml
        captionsCA = new ConfigAccessor(this, DEFAULT_CAPTIONS_FILE);
        // Save default config into file.
        captionsCA.saveConfig();
    }

    protected WorldGenConfig getWorldGenConfig(String world) {
        return getWorldGenConfig(world, new HashMap<String, Object>());
    }

    protected WorldGenConfig getWorldGenConfig(String world, HashMap<String, Object> defaults) {
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

    public abstract AbstractGenManager getGeneratorManager();
}
