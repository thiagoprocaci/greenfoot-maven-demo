package com.greenfoot.demo.world;

import com.greenfoot.demo.actor.*;
import greenfoot.*;  // imports Actor, World, Greenfoot, GreenfootImage

/**
 * A world where wombats live.
 * 
 * @author Michael Kölling
 * @version 2.0
 */
public class WombatWorld extends World
{
    /**
     * Create a new world with 10x10 cells and
     * with a cell size of 60x60 pixels.
     */
    public WombatWorld() 
    {
        super(10, 10, 60);        
        setBackground("cell.jpg");
        setPaintOrder(Wombat.class, Leaf.class);  // draw wombat on top of leaf
        populate();
    }

    /**
     * Populate the world with a fixed scenario of wombats and leaves.
     */    
    public void populate()
    {
        for(int i = 0; i < 8; i++) {
            addObject(new Wombat(), Greenfoot.getRandomNumber(getWidth() - 2) + 3, Greenfoot.getRandomNumber(getHeight() - 2) + 3);
        }
        randomLeaves(20);
        addObject(new House(), Greenfoot.getRandomNumber(getWidth() - 2) + 3, Greenfoot.getRandomNumber(getHeight() - 2) + 3);
        addObject(new Bricklayer(), Greenfoot.getRandomNumber(getWidth() - 2) + 3, Greenfoot.getRandomNumber(getHeight() - 2) + 3);

        for(int i = 0; i < 3; i++) {
            addObject(new Crab(), Greenfoot.getRandomNumber(getWidth() - 2) + 3, Greenfoot.getRandomNumber(getHeight() - 2) + 3);
        }
    }
    
    /**
     * Place a number of leaves into the world at random places.
     * The number of leaves can be specified.
     */
    public void randomLeaves(int howMany)
    {
        for (int i=0; i<howMany; i++) {
            Leaf leaf = new Leaf();
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight());
            addObject(leaf, x, y);
        }
    }

}