package com.greenfoot.demo;

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.util.Collection;
import java.util.List;

/**
 * A 'Body' is any kind of object in space that has a mass. It could be a star, or a planet, 
 * or anything else that floats around in space.
 * 
 * @author Michael K�lling 
 *   (Including improvements by J. Buhl.)
 * @version 1.3
 */
public class Body extends SmoothMover
{
    private static final double GRAVITY = 7.8;
    private static final Color defaultColor = new Color(255, 216, 0);
    
    private double mass;
    private boolean on = false;
    private int countTimeOn = 0;
    
    /**
     * Construct a Body with default size, mass, velocity and color.
     */
    public Body()
    {
        this (20, 300, new Vector(0, 0.0), defaultColor);
    }
    
    /**
     * Construct a Body with a specified size, mass, velocity and color.
     */
    public Body(int size, double mass, Vector velocity, Color color)
    {
        this.mass = mass;
        addToVelocity(velocity);
        GreenfootImage image = new GreenfootImage (size, size);
        image.setColor (color);
        image.fillOval (0, 0, size-1, size-1);
        setImage (image);
    }
    
    /**
     * Act. That is: apply  the gravitation forces from
     * all other bodies around, and then move.
     */
    public void act() 
    {

        applyForces();
        move();
        isAtEdgeVerification();
        bounceAtEdge();
        crazyChange();
    }

    public void changeColor() {
        Color c = new Color(Greenfoot.getRandomNumber(255),Greenfoot.getRandomNumber(255), Greenfoot.getRandomNumber(255));
        int size = getImage().getWidth();
        GreenfootImage image = new GreenfootImage (size, size);
        image.setColor (c);
        image.fillOval (0, 0, size-1, size-1);
        setImage (image);
    }

    private void isAtEdgeVerification() {
        if(isAtEdge()) {
            changeColor();
        }
    }
    
    /**
     * Check whether we have hit the edge of the universe. If so, bounce off it.
     */
    private void bounceAtEdge()
    {
        if (getX() == 0 || getX() == getWorld().getWidth()-1) {
            setLocation((double)getX(), (double)getY());
            invertHorizontalVelocity();
            accelerate(0.9);
        }
        else if (getY() == 0 || getY() == getWorld().getHeight()-1) {
            setLocation((double)getX(), (double)getY());
            invertVerticalVelocity();
            accelerate(0.9);
        }
    }
    
    /**
     * Apply the forces of gravity from all other celestial bodies in this universe.
     */
    private void applyForces()
    {
        List<Body> bodies = getWorld().getObjects(Body.class);
        
        for (Body body : bodies) 
        {
            if (body != this) 
            {
                applyGravity(body);
            }
        }
        
        // ensure that we don't get too fast: If the current speed is very fast, decelerate a bit.
        if (getSpeed() > 7) 
        {
            accelerate (0.9);  // acceleration with factor < 1 is actually slowing down.
        }
    }
    
    /**
     * Apply the force of gravity of a given body to this one.
     * (Force is applied for one time unit; dt==1.)
     */
    private void applyGravity(Body other)
    {
        double dx = other.getExactX() - this.getExactX();
        double dy = other.getExactY() - this.getExactY();
        Vector dv = new Vector (dx, dy); //sets direction correctly; length still invalid
        double distance = Math.sqrt (dx*dx + dy*dy);
        double force = GRAVITY * this.mass * other.mass / (distance * distance);
        double acceleration = force / this.mass;
        dv.setLength (acceleration);
        addToVelocity (dv);
    }


    public void turnOn() {
        if(!on) {
            on = true;
            countTimeOn = 0;
        }
    }

    public void turnOff() {
        if(on && countTimeOn > 100) {
            on = false;
            countTimeOn = 0;
        }
    }

    public void crazyChange() {
        if(on) {
            changeColor();
            countTimeOn++;
        }
        turnOff();
    }

    
    /**
     * Return the mass of this body.
     */
    public double getMass()
    {
        return mass;
    }
}
