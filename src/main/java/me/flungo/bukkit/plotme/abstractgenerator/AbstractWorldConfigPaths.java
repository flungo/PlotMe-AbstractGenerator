/*
 * Copyright (C) 2013 Fabrizio Lungo <fab@lungo.co.uk> - All Rights Reserved
 *
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 * Created by Fabrizio Lungo <fab@lungo.co.uk>, November 2013
 */
package me.flungo.bukkit.plotme.abstractgenerator;

/**
 *
 * @author Fabrizio Lungo <fab@lungo.co.uk>
 */
public enum AbstractWorldConfigPaths {

    PLOT_SIZE("PlotSize"),
    X_TRANSLATION("XTranslation"),
    Z_TRANSLATION("ZTranslation"),
    BASE_BLOCK("BottomBlock"),
    GROUND_LEVEL("GroundHeight");

    private final String path;

    private AbstractWorldConfigPaths(String path) {
        this.path = path;
    }

    public String path() {
        return path;
    }

    @Override
    public String toString() {
        return path();
    }

}
