package com.greenfoot.demo.world;

import com.greenfoot.demo.actor.*;
import greenfoot.World;

public class GameWorld extends World {

    public GameWorld() {
        super(810, 600, 1, false);
        setBackground("paperpg.png");
        addWarrior();
        addPlatform(1, 100, 585);
        addPoles(-10, 20, 15);
        addPoles(-10, 20, 2955);
        addTreeAndBush();
    }

    private void addTreeAndBush() {

    }

    private void addWarrior() {

    }


    public void addPlatform(int start, int end, int y) {

    }

    public void addPoles(int start, int end, int x) {

    }


}
