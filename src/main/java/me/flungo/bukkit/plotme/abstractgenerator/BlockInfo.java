package me.flungo.bukkit.plotme.abstractgenerator;

import org.bukkit.Location;

public class BlockInfo {

    public final BlockRepresentation block;
    public final Location loc;

    public BlockInfo(BlockRepresentation block, Location loc) {
        this.block = block;
        this.loc = loc;
    }

}
