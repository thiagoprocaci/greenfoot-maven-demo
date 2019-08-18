package com.greenfoot.demo;

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Bacteria fload along in the bloodstream. They are bad. Best to destroy
 * them if you can.
 * 
 * @author Michael Kölling
 * @version 0.1
 */
public class Bacteria extends Actor
{
    
   private int speed;
    
   
   /**
     * Constructor. Nothing to do so far.
     */
    public Bacteria()
    {
        speed = Greenfoot.getRandomNumber(3) + 1;
    }

    /**
     * Float along the bloodstream, slowly rotating.
     */
    public void act() 
    {
        setLocation(getX() - speed, getY());
        turn(1);
        
        if (getX() == 0) 
        {
            Bloodstream bloodstream = (Bloodstream) getWorld();
            bloodstream.updateScore(-15);
            getWorld().removeObject(this);
           
        }
    }
}
