/*
 * Copyright (C) 2013 Fabrizio Lungo <fab@lungo.co.uk> - All Rights Reserved
 *
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 * Created by Fabrizio Lungo <fab@lungo.co.uk>, November 2013
 */
package me.flungo.bukkit.plotme.abstractgenerator;

import com.worldcretornica.plotme_core.api.v0_14b.IPlotMe_GeneratorManager;
import java.util.HashSet;
import java.util.Set;
import org.bukkit.Material;

/**
 *
 * @author Fabrizio Lungo <fab@lungo.co.uk>
 */
public abstract class AbstractGenManager implements IPlotMe_GeneratorManager {

    // List of blocks that should be placed last in world generation
    protected static final Set<Integer> blockPlacedLast = new HashSet<Integer>();

    static {
        blockPlacedLast.add(Material.SAPLING.getId());
        blockPlacedLast.add(Material.BED.getId());
        blockPlacedLast.add(Material.POWERED_RAIL.getId());
        blockPlacedLast.add(Material.DETECTOR_RAIL.getId());
        blockPlacedLast.add(Material.LONG_GRASS.getId());
        blockPlacedLast.add(Material.DEAD_BUSH.getId());
        blockPlacedLast.add(Material.PISTON_EXTENSION.getId());
        blockPlacedLast.add(Material.YELLOW_FLOWER.getId());
        blockPlacedLast.add(Material.RED_ROSE.getId());
        blockPlacedLast.add(Material.BROWN_MUSHROOM.getId());
        blockPlacedLast.add(Material.RED_MUSHROOM.getId());
        blockPlacedLast.add(Material.TORCH.getId());
        blockPlacedLast.add(Material.FIRE.getId());
        blockPlacedLast.add(Material.REDSTONE_WIRE.getId());
        blockPlacedLast.add(Material.CROPS.getId());
        blockPlacedLast.add(Material.LADDER.getId());
        blockPlacedLast.add(Material.RAILS.getId());
        blockPlacedLast.add(Material.LEVER.getId());
        blockPlacedLast.add(Material.STONE_PLATE.getId());
        blockPlacedLast.add(Material.WOOD_PLATE.getId());
        blockPlacedLast.add(Material.REDSTONE_TORCH_OFF.getId());
        blockPlacedLast.add(Material.REDSTONE_TORCH_ON.getId());
        blockPlacedLast.add(Material.STONE_BUTTON.getId());
        blockPlacedLast.add(Material.SNOW.getId());
        blockPlacedLast.add(Material.PORTAL.getId());
        blockPlacedLast.add(Material.DIODE_BLOCK_OFF.getId());
        blockPlacedLast.add(Material.DIODE_BLOCK_ON.getId());
        blockPlacedLast.add(Material.TRAP_DOOR.getId());
        blockPlacedLast.add(Material.VINE.getId());
        blockPlacedLast.add(Material.WATER_LILY.getId());
        blockPlacedLast.add(Material.NETHER_WARTS.getId());
        blockPlacedLast.add(Material.PISTON_BASE.getId());
        blockPlacedLast.add(Material.PISTON_STICKY_BASE.getId());
        blockPlacedLast.add(Material.PISTON_EXTENSION.getId());
        blockPlacedLast.add(Material.PISTON_MOVING_PIECE.getId());
        blockPlacedLast.add(Material.COCOA.getId());
        blockPlacedLast.add(Material.TRIPWIRE_HOOK.getId());
        blockPlacedLast.add(Material.TRIPWIRE.getId());
        blockPlacedLast.add(Material.FLOWER_POT.getId());
        blockPlacedLast.add(Material.CARROT.getId());
        blockPlacedLast.add(Material.POTATO.getId());
        blockPlacedLast.add(Material.WOOD_BUTTON.getId());
        blockPlacedLast.add(Material.SKULL.getId());
        blockPlacedLast.add(Material.GOLD_PLATE.getId());
        blockPlacedLast.add(Material.IRON_PLATE.getId());
        blockPlacedLast.add(Material.REDSTONE_COMPARATOR_OFF.getId());
        blockPlacedLast.add(Material.REDSTONE_COMPARATOR_ON.getId());
        blockPlacedLast.add(Material.ACTIVATOR_RAIL.getId());
    }

    @Override
    public int getIdX(String id) {
        return Integer.parseInt(id.substring(0, id.indexOf(";")));
    }

    @Override
    public int getIdZ(String id) {
        return Integer.parseInt(id.substring(id.indexOf(";") + 1));
    }
}
