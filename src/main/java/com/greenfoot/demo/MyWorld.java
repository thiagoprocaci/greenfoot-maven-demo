package com.greenfoot.demo;

import greenfoot.*;

/**
 * Autumn. A world with some leaves.
 * 
 * @author Michael Kölling
 * @version 1.0
 */
public class MyWorld extends World
{
    /**
     * Create the world and objects in it.
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        setUp();
    }
    
    /**
     * Create the initial objects in the world.
     */
    private void setUp()
    {
        int i = 0;
        while (i<18) {
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight());
            addObject( new Leaf(), x, y );
            i++;
        }
        
        addObject(new Block(), 300, 200);
        addApple();
        addPear();
    }

    private void addApple() {
        for(int i = 0 ; i < 12 ; i++) {
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight());
            addObject( new Apple(), x, y );
        }
    }

    private void addPear() {
        for(int i = 0 ; i < 8 ; i++) {
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight());
            addObject( new Pear(), x, y );
        }
    }
}
