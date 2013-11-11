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

/**
 *
 * @author Fabrizio Lungo <fab@lungo.co.uk>
 */
public abstract class AbstractGenManager implements IPlotMe_GeneratorManager {

    @Override
    public int getIdX(String id) {
        return Integer.parseInt(id.substring(0, id.indexOf(";")));
    }

    @Override
    public int getIdZ(String id) {
        return Integer.parseInt(id.substring(id.indexOf(";") + 1));
    }
}
