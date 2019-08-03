package com.greenfoot.demo.actor;

import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * Leaf - a class for representing leaves.
 *
 * @author Michael Kölling
 * @version 2.0
 */
public class Leaf extends Actor
{

    String currentImage = "leaf.png";
    boolean brown = false;

    public Leaf()
    {
        setImage(currentImage);
    }

    public void act() {
        int randomNumber = Greenfoot.getRandomNumber(200);
        if(randomNumber < 1) {
               if("leaf.png" == currentImage) {
                   currentImage = "leaf-brown.png";
                   brown = true;
               } else {
                   currentImage = "leaf.png";
                   brown = false;
               }
            setImage(currentImage);
        }

    }

    public boolean isBrown() {
        return brown;
    }
}
