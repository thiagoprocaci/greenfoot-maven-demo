package com.greenfoot.demo;

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * A block that bounces back and forth across the screen.
 * 
 * @author Michael Kölling
 * @version 1.0
 */
public class Block extends Actor
{
    private int delta = 2;
    
    /**
     * Move across the screen, bounce off edges. Turn leaves, if we touch any.
     */
    public void act() 
    {
        move();
        rotacionarObjetos();
        checkEdge();
        checkLeaf();
        checkMouseClick();
    }


    private void rotacionarObjetos() {
        if(isAtEdge()) {
            List<Leaf> list = getWorld().getObjects(Leaf.class);
            for(Leaf leaf : list) {
                leaf.turn(90);
            }
            List<Pear> pearList = getWorld().getObjects(Pear.class);
            for(Pear pear : pearList) {
                pear.move();
            }
            List<Apple> appleList = getWorld().getObjects(Apple.class);
            for(Apple apple : appleList) {
                apple.turn(90);
            }
        }
    }

    /**
     * Move sideways, either left or right.
     */
    private void move()
    {
        setLocation(getX()+delta, getY());
    }
    
    /**
     * Check whether we are at the edge of the screen. If we are, turn around.
     */
    private void checkEdge()
    {
        if (isAtEdge()) 
        {
            delta = -delta;
        }
    }
    
    /**
     * Check whether the mouse button was clicked. If it was, change all leaves.
     */
    private void checkMouseClick()
    {
        if (Greenfoot.mouseClicked(null)) 
        {
            World world = getWorld();
            List<Leaf> leaves = world.getObjects(Leaf.class);

            for (Leaf leaf : leaves)
            {
                if(leaf.getX() < getWorld().getWidth()/2) {
                    leaf.changeImage();
                }
            }
        }
    }
    
    /**
     * Check whether we're touching a leaf. If we are, turn it a bit.
     */
    private void checkLeaf()
    {
        Leaf leaf = (Leaf) getOneIntersectingObject(Leaf.class);
        
        if (leaf != null) {
            leaf.turn(9);
        }
    }
}
