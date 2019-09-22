package com.greenfoot.demo.world;

import com.greenfoot.demo.actor.Platform;
import com.greenfoot.demo.actor.Pole;
import com.greenfoot.demo.actor.Warrior;
import greenfoot.World;

public class GameWorld extends World {

    public GameWorld()
    {
        super(810, 600, 1, false);
        setBackground("paperpg.png");
        addWarrior();
        addPlatform(1, 100, 585);
        addPoles(-10, 20, 15);
        addPoles(-10, 20, 2955);
    }

    private void addWarrior() {
        addObject(new Warrior(), 65, -100);
    }

    /**
     * Add platforms starting at start and ending at end
     */

    public void addPlatform(int start, int end, int y)
    {
        for(int i = start; i < end; i++)
        {
            addObject(new Platform(), i*30-15, y);
        }
    }

    public void addPoles(int start, int end, int x)
    {
        for(int i = start; i < end; i++)
        {
            addObject(new Pole(), x, i*30-15);
        }
    }


}
