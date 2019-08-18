package com.greenfoot.demo;

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Virus here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Virus extends Actor
{
    /**
     * Act - do whatever the Virus wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       setLocation(getX() - 4, getY());
       turn(1);
       if(getX() == 0) {
           getWorld().removeObject(this);
       }
    }    
}
