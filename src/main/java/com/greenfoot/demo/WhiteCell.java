package com.greenfoot.demo;

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is a white blood cell. This kind of cell has the job to catch 
 * bacteria and remove them from the blood.
 * 
 * @author Michael Kölling
 * @version 0.1
 */
public class WhiteCell extends Actor
{
   
    
   public WhiteCell() {
      
   }
   
    /**
     * Act: move up and down when cursor keys are pressed.
     */
    public void act() 
    {
        checkKeyPress();
        checkcollision();
    }
    
    /**
     * Check whether a keyboard key has been pressed and react if it has.
     */
    private void checkKeyPress()
    {
        if (Greenfoot.isKeyDown("up")) 
        {
            setLocation(getX(), getY()-4);
        }
        
        if (Greenfoot.isKeyDown("down")) 
        {
            setLocation(getX(), getY()+4);
        }
    }
    
    private void checkcollision() {
        if(isTouching(Bacteria.class)) {
            Greenfoot.playSound("slurp.wav");
            Bloodstream bloodstream = (Bloodstream) getWorld();
            bloodstream.updateScore(20);
            removeTouching(Bacteria.class);
        }
        if(isTouching(Virus.class)) {
           // Greenfoot.playSound("au.wav");
            Bloodstream bloodstream = (Bloodstream) getWorld();
            bloodstream.updateScore(-100);
        }
    }
}
