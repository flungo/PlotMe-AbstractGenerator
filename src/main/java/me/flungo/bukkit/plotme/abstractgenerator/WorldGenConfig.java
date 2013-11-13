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
public final class WorldGenConfig implements ConfigurationSection {

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

    public static Object getDefault(WorldConfigPath wcp) {
        return getDefault(wcp.path());
    }

    public static boolean defaultContainsKey(String key) {
        return DEFAULTS.containsKey(key);
    }

    public static boolean defaultContainsKey(WorldConfigPath wcp) {
        return defaultContainsKey(wcp.path());
    }

    public static Object putDefault(String key, Object value) {
        return DEFAULTS.put(key, value);
    }

    public static Object putDefault(WorldConfigPath wcp, Object value) {
        return putDefault(wcp.path(), value);
    }

    public static Object putDefault(WorldConfigPath wcp) {
        return putDefault(wcp.path(), wcp.def());
    }

    public static void putAllDefaults(Map<? extends String, ? extends Object> m) {
        DEFAULTS.putAll(m);
    }

    public static Object removeDefault(String key) {
        return DEFAULTS.remove(key);
    }

    public static Object removeDefault(WorldConfigPath wcp) {
        return DEFAULTS.remove(wcp.path());
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

    public BlockRepresentation getBlockRepresentation(WorldConfigPath wcp) {
        return getBlockRepresentation(wcp.path());
    }

    public boolean isBlockRepresentation(String string) {
        try {
            getBlockRepresentation(string);
        } catch (NumberFormatException ex) {
            return false;
        }
        return true;
    }

    public boolean isBlockRepresentation(WorldConfigPath wcp) {
        return isBlockRepresentation(wcp.path());
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

    public boolean contains(WorldConfigPath wcp) {
        return contains(wcp.path());
    }

    @Override
    public boolean isSet(String string) {
        return world.isSet(string);
    }

    public boolean isSet(WorldConfigPath wcp) {
        return isSet(wcp.path());
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

    public Object get(WorldConfigPath wcp) {
        return get(wcp.path());
    }

    @Override
    public Object get(String string, Object o) {
        return world.get(string, o);
    }

    public Object get(WorldConfigPath wcp, Object o) {
        return get(wcp.path(), o);
    }

    @Override
    public void set(String string, Object o) {
        if (o instanceof BlockRepresentation) {
            o = ((BlockRepresentation) o).getBlockIdValue();
        }
        world.set(string, o);
    }

    public void set(WorldConfigPath wcp, Object o) {
        set(wcp.path(), o);
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

    public String getString(WorldConfigPath wcp) {
        return getString(wcp.path());
    }

    @Override
    public String getString(String string, String string1) {
        return world.getString(string, string1);
    }

    public String getString(WorldConfigPath wcp, String string1) {
        return getString(wcp.path(), string1);
    }

    @Override
    public boolean isString(String string) {
        return world.isString(string);
    }

    public boolean isString(WorldConfigPath wcp) {
        return isString(wcp.path());
    }

    @Override
    public int getInt(String string) {
        return world.getInt(string);
    }

    public int getInt(WorldConfigPath wcp) {
        return getInt(wcp.path());
    }

    @Override
    public int getInt(String string, int i) {
        return world.getInt(string, i);
    }

    public int getInt(WorldConfigPath wcp, int i) {
        return getInt(wcp.path(), i);
    }

    @Override
    public boolean isInt(String string) {
        return world.isInt(string);
    }

    public boolean isInt(WorldConfigPath wcp) {
        return isInt(wcp.path());
    }

    @Override
    public boolean getBoolean(String string) {
        return world.getBoolean(string);
    }

    public boolean getBoolean(WorldConfigPath wcp) {
        return getBoolean(wcp.path());
    }

    @Override
    public boolean getBoolean(String string, boolean bln) {
        return world.getBoolean(string, bln);
    }

    public boolean getBoolean(WorldConfigPath wcp, boolean bln) {
        return getBoolean(wcp.path(), bln);
    }

    @Override
    public boolean isBoolean(String string) {
        return world.isBoolean(string);
    }

    public boolean isBoolean(WorldConfigPath wcp) {
        return isBoolean(wcp.path());
    }

    @Override
    public double getDouble(String string) {
        return world.getDouble(string);
    }

    public double getDouble(WorldConfigPath wcp) {
        return getDouble(wcp.path());
    }

    @Override
    public double getDouble(String string, double d) {
        return world.getDouble(string, d);
    }

    public double getDouble(WorldConfigPath wcp, double d) {
        return getDouble(wcp.path(), d);
    }

    @Override
    public boolean isDouble(String string) {
        return world.isDouble(string);
    }

    public boolean isDouble(WorldConfigPath wcp) {
        return isDouble(wcp.path());
    }

    @Override
    public long getLong(String string) {
        return world.getLong(string);
    }

    public long getLong(WorldConfigPath wcp) {
        return getLong(wcp.path());
    }

    @Override
    public long getLong(String string, long l) {
        return world.getLong(string, l);
    }

    public long getLong(WorldConfigPath wcp, long l) {
        return getLong(wcp.path(), l);
    }

    @Override
    public boolean isLong(String string) {
        return world.isLong(string);
    }

    public boolean isLong(WorldConfigPath wcp) {
        return isLong(wcp.path());
    }

    @Override
    public List<?> getList(String string) {
        return world.getList(string);
    }

    public List<?> getList(WorldConfigPath wcp) {
        return getList(wcp.path());
    }

    @Override
    public List<?> getList(String string, List<?> list) {
        return world.getList(string, list);
    }

    public List<?> getList(WorldConfigPath wcp, List<?> list) {
        return getList(wcp.path(), list);
    }

    @Override
    public boolean isList(String string) {
        return world.isList(string);
    }

    public boolean isList(WorldConfigPath wcp) {
        return isList(wcp.path());
    }

    @Override
    public List<String> getStringList(String string) {
        return world.getStringList(string);
    }

    public List<String> getStringList(WorldConfigPath wcp) {
        return getStringList(wcp.path());
    }

    @Override
    public List<Integer> getIntegerList(String string) {
        return world.getIntegerList(string);
    }

    public List<Integer> getIntegerList(WorldConfigPath wcp) {
        return getIntegerList(wcp.path());
    }

    @Override
    public List<Boolean> getBooleanList(String string) {
        return world.getBooleanList(string);
    }

    public List<Boolean> getBooleanList(WorldConfigPath wcp) {
        return getBooleanList(wcp.path());
    }

    @Override
    public List<Double> getDoubleList(String string) {
        return world.getDoubleList(string);
    }

    public List<Double> getDoubleList(WorldConfigPath wcp) {
        return getDoubleList(wcp.path());
    }

    @Override
    public List<Float> getFloatList(String string) {
        return world.getFloatList(string);
    }

    public List<Float> getFloatList(WorldConfigPath wcp) {
        return getFloatList(wcp.path());
    }

    @Override
    public List<Long> getLongList(String string) {
        return world.getLongList(string);
    }

    public List<Long> getLongList(WorldConfigPath wcp) {
        return getLongList(wcp.path());
    }

    @Override
    public List<Byte> getByteList(String string) {
        return world.getByteList(string);
    }

    public List<Byte> getByteList(WorldConfigPath wcp) {
        return getByteList(wcp.path());
    }

    @Override
    public List<Character> getCharacterList(String string) {
        return world.getCharacterList(string);
    }

    public List<Character> getCharacterList(WorldConfigPath wcp) {
        return getCharacterList(wcp.path());
    }

    @Override
    public List<Short> getShortList(String string) {
        return world.getShortList(string);
    }

    public List<Short> getShortList(WorldConfigPath wcp) {
        return getShortList(wcp.path());
    }

    @Override
    public List<Map<?, ?>> getMapList(String string) {
        return world.getMapList(string);
    }

    public List<Map<?, ?>> getMapList(WorldConfigPath wcp) {
        return getMapList(wcp.path());
    }

    @Override
    public Vector getVector(String string) {
        return world.getVector(string);
    }

    public Vector getVector(WorldConfigPath wcp) {
        return getVector(wcp.path());
    }

    @Override
    public Vector getVector(String string, Vector vector) {
        return world.getVector(string, vector);
    }

    public Vector getVector(WorldConfigPath wcp, Vector vector) {
        return getVector(wcp.path(), vector);
    }

    @Override
    public boolean isVector(String string) {
        return world.isVector(string);
    }

    public boolean isVector(WorldConfigPath wcp) {
        return isVector(wcp.path());
    }

    @Override
    public OfflinePlayer getOfflinePlayer(String string) {
        return world.getOfflinePlayer(string);
    }

    public OfflinePlayer getOfflinePlayer(WorldConfigPath wcp) {
        return getOfflinePlayer(wcp.path());
    }

    @Override
    public OfflinePlayer getOfflinePlayer(String string, OfflinePlayer op) {
        return world.getOfflinePlayer(string, op);
    }

    public OfflinePlayer getOfflinePlayer(WorldConfigPath wcp, OfflinePlayer op) {
        return getOfflinePlayer(wcp.path(), op);
    }

    @Override
    public boolean isOfflinePlayer(String string) {
        return world.isOfflinePlayer(string);
    }

    public boolean isOfflinePlayer(WorldConfigPath wcp) {
        return isOfflinePlayer(wcp.path());
    }

    @Override
    public ItemStack getItemStack(String string) {
        return world.getItemStack(string);
    }

    public ItemStack getItemStack(WorldConfigPath wcp) {
        return getItemStack(wcp.path());
    }

    @Override
    public ItemStack getItemStack(String string, ItemStack is) {
        return world.getItemStack(string, is);
    }

    public ItemStack getItemStack(WorldConfigPath wcp, ItemStack is) {
        return getItemStack(wcp.path(), is);
    }

    @Override
    public boolean isItemStack(String string) {
        return world.isItemStack(string);
    }

    public boolean isItemStack(WorldConfigPath wcp) {
        return isItemStack(wcp.path());
    }

    @Override
    public Color getColor(String string) {
        return world.getColor(string);
    }

    public Color getColor(WorldConfigPath wcp) {
        return getColor(wcp.path());
    }

    @Override
    public Color getColor(String string, Color color) {
        return world.getColor(string, color);
    }

    public Color getColor(WorldConfigPath wcp, Color color) {
        return getColor(wcp.path(), color);
    }

    @Override
    public boolean isColor(String string) {
        return world.isColor(string);
    }

    public boolean isColor(WorldConfigPath wcp) {
        return isColor(wcp.path());
    }

    @Override
    public ConfigurationSection getConfigurationSection(String string) {
        return world.getConfigurationSection(string);
    }

    public ConfigurationSection getConfigurationSection(WorldConfigPath wcp) {
        return getConfigurationSection(wcp.path());
    }

    @Override
    public boolean isConfigurationSection(String string) {
        return world.isConfigurationSection(string);
    }

    public boolean isConfigurationSection(WorldConfigPath wcp) {
        return isConfigurationSection(wcp.path());
    }

    @Override
    public ConfigurationSection getDefaultSection() {
        return world.getDefaultSection();
    }

    @Override
    public void addDefault(String string, Object o) {
        world.addDefault(string, o);
    }

    public void addDefault(WorldConfigPath wcp, Object o) {
        addDefault(wcp.path(), o);
    }

}
