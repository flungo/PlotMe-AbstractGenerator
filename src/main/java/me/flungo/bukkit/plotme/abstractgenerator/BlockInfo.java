package me.flungo.bukkit.plotme.abstractgenerator;

import org.bukkit.Location;
import org.bukkit.block.Block;

public class BlockInfo {

    public final BlockRepresentation block;
    public final Location loc;

    public BlockInfo(BlockRepresentation block, Location loc) {
        this.block = block;
        this.loc = loc;
    }

    public BlockInfo(Block block) {
        this(new BlockRepresentation(block), block.getLocation());
    }

}
