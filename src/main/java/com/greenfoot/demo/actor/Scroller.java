package com.greenfoot.demo.actor;

import greenfoot.Actor;
import greenfoot.Greenfoot;

public class Scroller extends Actor {

    public static int scrollX; //The variable used when scrolling.

    public Scroller()  {
        scrollX = 0;
    }

    public void act() {
        scrollingMethods();
    }

    /**
     * Set the actor's location.
     */
    public void setLocation()
    {
        setLocation(getX() + scrollX, getY());
    }

    /**
     * Move the world a certain amount when arrow keys are pressed.
     */
    public void checkKeyPress(int amount)  {

        if(Greenfoot.isKeyDown("left") && !Greenfoot.isKeyDown("right")) {
            scrollX = amount;
            if(Greenfoot.isKeyDown("z"))  {
                scrollX = amount + 2; // world will scroll faster if z is pressed while moving
            }
        } else if(Greenfoot.isKeyDown("right") && !Greenfoot.isKeyDown("left"))  {
            scrollX = -amount;
            if(Greenfoot.isKeyDown("z"))  {
                scrollX = -amount - 2; // world will scroll faster if z is pressed while moving
            }
        } else  {
            stopScroll();
        }
    }

    /**
     * add scrollingMethods to all actors that should scroll
     */
    public void scrollingMethods()  {
        checkKeyPress(2);
        setLocation();
    }

    public static void stopScroll() {
        scrollX = 0;
    }
}
