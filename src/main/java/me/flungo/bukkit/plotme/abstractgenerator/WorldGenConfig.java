/*
 * Copyright (C) 2013 Fabrizio Lungo <fab@lungo.co.uk> - All Rights Reserved
 *
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 * Created by Fabrizio Lungo <fab@lungo.co.uk>, November 2013
 */
package me.flungo.bukkit.plotme.abstractgenerator;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.bukkit.Color;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

/**
 *
 * @author Fabrizio Lungo <fab@lungo.co.uk>
 */
public class WorldGenConfig implements ConfigurationSection {

    private static HashMap<String, Object> DEFAULTS = new HashMap<String, Object>();

    private final ConfigurationSection world;
    private final HashMap<String, Object> defaults;

    public WorldGenConfig(ConfigurationSection world) {
        this(world, new HashMap<String, Object>());
    }

    public WorldGenConfig(ConfigurationSection world, HashMap<String, Object> defaults) {
        this.world = world;
        this.defaults = DEFAULTS;
        this.defaults.putAll(defaults);
        for (Map.Entry<String, Object> def : this.defaults.entrySet()) {
            if (!world.contains(def.getKey())) {
                world.set(def.getKey(), def.getValue());
            }
        }
    }

    public static int defaultSize() {
        return DEFAULTS.size();
    }

    public static boolean isDefaultEmpty() {
        return DEFAULTS.isEmpty();
    }

    public static Object getDefault(String key) {
        return DEFAULTS.get(key);
    }

    public static boolean defaultContainsKey(String key) {
        return DEFAULTS.containsKey(key);
    }

    public static Object putDefault(String key, Object value) {
        if (value instanceof BlockRepresentation) {
            value = ((BlockRepresentation) value).getBlockIdValue();
        }
        return DEFAULTS.put(key, value);
    }

    public static void putAllDefaults(Map<? extends String, ? extends Object> m) {
        DEFAULTS.putAll(m);
    }

    public static Object removeDefault(String key) {
        return DEFAULTS.remove(key);
    }

    public static void clearDefaults() {
        DEFAULTS.clear();
    }

    public static boolean containsDefaultValue(Object value) {
        return DEFAULTS.containsValue(value);
    }

    public static HashMap<String, Object> cloneDefaults() {
        return (HashMap<String, Object>) DEFAULTS.clone();
    }

    public static Set<String> defaultKeySet() {
        return DEFAULTS.keySet();
    }

    public static Collection<Object> defaultValues() {
        return DEFAULTS.values();
    }

    public static Set<Map.Entry<String, Object>> defaultEntrySet() {
        return DEFAULTS.entrySet();
    }

    public BlockRepresentation getBlockRepresentation(String string) {
        return new BlockRepresentation(getString(string));
    }

    public boolean isBlockRepresentation(String string) {
        try {
            getBlockRepresentation(string);
        } catch (NumberFormatException ex) {
            return false;
        }
        return true;
    }

    @Override
    public Set<String> getKeys(boolean bln) {
        return world.getKeys(bln);
    }

    @Override
    public Map<String, Object> getValues(boolean bln) {
        return world.getValues(bln);
    }

    @Override
    public boolean contains(String string) {
        return world.contains(string);
    }

    @Override
    public boolean isSet(String string) {
        return world.isSet(string);
    }

    @Override
    public String getCurrentPath() {
        return world.getCurrentPath();
    }

    @Override
    public String getName() {
        return world.getName();
    }

    @Override
    public Configuration getRoot() {
        return world.getRoot();
    }

    @Override
    public ConfigurationSection getParent() {
        return world.getParent();
    }

    @Override
    public Object get(String string) {
        return world.get(string);
    }

    @Override
    public Object get(String string, Object o) {
        return world.get(string, o);
    }

    @Override
    public void set(String string, Object o) {
        world.set(string, o);
    }

    @Override
    public ConfigurationSection createSection(String string) {
        return world.createSection(string);
    }

    @Override
    public ConfigurationSection createSection(String string, Map<?, ?> map) {
        return world.createSection(string, map);
    }

    @Override
    public String getString(String string) {
        return world.getString(string);
    }

    @Override
    public String getString(String string, String string1) {
        return world.getString(string, string1);
    }

    @Override
    public boolean isString(String string) {
        return world.isString(string);
    }

    @Override
    public int getInt(String string) {
        return world.getInt(string);
    }

    @Override
    public int getInt(String string, int i) {
        return world.getInt(string, i);
    }

    @Override
    public boolean isInt(String string) {
        return world.isInt(string);
    }

    @Override
    public boolean getBoolean(String string) {
        return world.getBoolean(string);
    }

    @Override
    public boolean getBoolean(String string, boolean bln) {
        return world.getBoolean(string, bln);
    }

    @Override
    public boolean isBoolean(String string) {
        return world.isBoolean(string);
    }

    @Override
    public double getDouble(String string) {
        return world.getDouble(string);
    }

    @Override
    public double getDouble(String string, double d) {
        return world.getDouble(string, d);
    }

    @Override
    public boolean isDouble(String string) {
        return world.isDouble(string);
    }

    @Override
    public long getLong(String string) {
        return world.getLong(string);
    }

    @Override
    public long getLong(String string, long l) {
        return world.getLong(string, l);
    }

    @Override
    public boolean isLong(String string) {
        return world.isLong(string);
    }

    @Override
    public List<?> getList(String string) {
        return world.getList(string);
    }

    @Override
    public List<?> getList(String string, List<?> list) {
        return world.getList(string, list);
    }

    @Override
    public boolean isList(String string) {
        return world.isList(string);
    }

    @Override
    public List<String> getStringList(String string) {
        return world.getStringList(string);
    }

    @Override
    public List<Integer> getIntegerList(String string) {
        return world.getIntegerList(string);
    }

    @Override
    public List<Boolean> getBooleanList(String string) {
        return world.getBooleanList(string);
    }

    @Override
    public List<Double> getDoubleList(String string) {
        return world.getDoubleList(string);
    }

    @Override
    public List<Float> getFloatList(String string) {
        return world.getFloatList(string);
    }

    @Override
    public List<Long> getLongList(String string) {
        return world.getLongList(string);
    }

    @Override
    public List<Byte> getByteList(String string) {
        return world.getByteList(string);
    }

    @Override
    public List<Character> getCharacterList(String string) {
        return world.getCharacterList(string);
    }

    @Override
    public List<Short> getShortList(String string) {
        return world.getShortList(string);
    }

    @Override
    public List<Map<?, ?>> getMapList(String string) {
        return world.getMapList(string);
    }

    @Override
    public Vector getVector(String string) {
        return world.getVector(string);
    }

    @Override
    public Vector getVector(String string, Vector vector) {
        return world.getVector(string, vector);
    }

    @Override
    public boolean isVector(String string) {
        return world.isVector(string);
    }

    @Override
    public OfflinePlayer getOfflinePlayer(String string) {
        return world.getOfflinePlayer(string);
    }

    @Override
    public OfflinePlayer getOfflinePlayer(String string, OfflinePlayer op) {
        return world.getOfflinePlayer(string, op);
    }

    @Override
    public boolean isOfflinePlayer(String string) {
        return world.isOfflinePlayer(string);
    }

    @Override
    public ItemStack getItemStack(String string) {
        return world.getItemStack(string);
    }

    @Override
    public ItemStack getItemStack(String string, ItemStack is) {
        return world.getItemStack(string, is);
    }

    @Override
    public boolean isItemStack(String string) {
        return world.isItemStack(string);
    }

    @Override
    public Color getColor(String string) {
        return world.getColor(string);
    }

    @Override
    public Color getColor(String string, Color color) {
        return world.getColor(string, color);
    }

    @Override
    public boolean isColor(String string) {
        return world.isColor(string);
    }

    @Override
    public ConfigurationSection getConfigurationSection(String string) {
        return world.getConfigurationSection(string);
    }

    @Override
    public boolean isConfigurationSection(String string) {
        return world.isConfigurationSection(string);
    }

    @Override
    public ConfigurationSection getDefaultSection() {
        return world.getDefaultSection();
    }

    @Override
    public void addDefault(String string, Object o) {
        world.addDefault(string, o);
    }

}
