/*
 * Copyright (C) 2013 Fabrizio Lungo <fab@lungo.co.uk> - All Rights Reserved
 *
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 * Created by Fabrizio Lungo <fab@lungo.co.uk>, November 2013
 */
package me.flungo.bukkit.plotme.abstractgenerator;

import com.worldcretornica.plotme_core.api.v0_14b.IPlotMe_ChunkGenerator;
import java.util.Random;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.generator.ChunkGenerator;

/**
 *
 * @author Fabrizio Lungo <fab@lungo.co.uk>
 */
public abstract class AbstractChunkGenerator extends ChunkGenerator implements IPlotMe_ChunkGenerator {

    private final WorldGenConfig wgc;
    private final AbstractGenerator plugin;

    public AbstractChunkGenerator(AbstractGenerator instance, WorldGenConfig wgc) {
        plugin = instance;
        this.wgc = wgc;
    }

    @Override
    public Location getFixedSpawnLocation(World world, Random random) {
        return new Location(world, wgc.getInt("XTranslation"), wgc.getInt("RoadHeight") + 2, wgc.getInt("ZTranslation"));
    }

}
