package com.greenfoot.demo.actor;

import greenfoot.Actor;


public class Scroller extends Actor {

    public static int scrollX; //The variable used when scrolling.

    public Scroller()  {
        scrollX = 0;
    }

    public void act() {

    }

    /**
     * Set the actor's location.
     */
    public void setLocation()
    {

    }

    /**
     * Move the world a certain amount when arrow keys are pressed.
     */
    public void checkKeyPress(int amount)  {

    }

    /**
     * add scrollingMethods to all actors that should scroll
     */
    public void scroll()  {

    }

    public static void stopScroll() {
        scrollX = 0;
    }
}
