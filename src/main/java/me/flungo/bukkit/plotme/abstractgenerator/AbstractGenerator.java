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
import static me.flungo.bukkit.plotme.abstractgenerator.AbstractWorldConfigPaths.BASE_BLOCK;
import static me.flungo.bukkit.plotme.abstractgenerator.AbstractWorldConfigPaths.GROUND_LEVEL;
import static me.flungo.bukkit.plotme.abstractgenerator.AbstractWorldConfigPaths.PLOT_SIZE;
import static me.flungo.bukkit.plotme.abstractgenerator.AbstractWorldConfigPaths.X_TRANSLATION;
import static me.flungo.bukkit.plotme.abstractgenerator.AbstractWorldConfigPaths.Z_TRANSLATION;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author Fabrizio Lungo <fab@lungo.co.uk>
 */
public abstract class AbstractGenerator extends JavaPlugin {

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
        File plotMeFolder = new File(pluginsFolder, "PlotMe");
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
        configCA = new ConfigAccessor(this, "config.yml");

        // Set defaults for WorldGenConfig
        WorldGenConfig.putDefault(PLOT_SIZE.toString(), 32);

        WorldGenConfig.putDefault(X_TRANSLATION.toString(), 0);
        WorldGenConfig.putDefault(Z_TRANSLATION.toString(), 0);

        WorldGenConfig.putDefault(BASE_BLOCK.toString(), "7");

        WorldGenConfig.putDefault(GROUND_LEVEL.toString(), 64);

        // Set the config accessor for the main caption-english.yml
        captionsCA = new ConfigAccessor(this, "caption-english.yml");
        // Save default config into file.
        captionsCA.saveConfig();
    }

    public WorldGenConfig getWorldGenConfig(String world) {
        return getWorldGenConfig(world, new HashMap<String, Object>());
    }

    public WorldGenConfig getWorldGenConfig(String world, HashMap<String, Object> defaults) {
        ConfigurationSection worldsConfigurationSection;
        if (getConfig().contains("worlds")) {
            worldsConfigurationSection = getConfig().getConfigurationSection("worlds");
        } else {
            worldsConfigurationSection = getConfig().createSection("worlds");
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
