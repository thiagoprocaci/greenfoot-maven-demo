package com.greenfoot.demo;

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RedCell here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RedCell extends Actor
{
    private int speed;
    
    public RedCell() {
          speed = Greenfoot.getRandomNumber(2) + 1;
    }
    
    /**
     * Act - do whatever the RedCell wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setLocation(getX() - speed, getY());
        setRotation(Greenfoot.getRandomNumber(360));
        
        if (getX() == 0) 
        {
            getWorld().removeObject(this);
        }
    }    
}
