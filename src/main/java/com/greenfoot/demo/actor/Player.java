package com.greenfoot.demo.actor;

import greenfoot.Actor;
import greenfoot.World;

public abstract class Player extends Actor {

    private double x = 0;
    private double y = 0;
    private double velocityX; // in pixels per act() call
    private double velocityY; // in pixels per act() call
    private int state;

    /**
     * Default constructor sets velocity to 0.0.
     */
    public Player()
    {
    }

    /**
     * Constructor that sets velocity of the sprite.
     *
     * @param newVelocityX The x component of the velocity.
     * @param newVelocityY The y component of the velocity.
     */
    public Player(double newVelocityX, double newVelocityY)
    {
        velocityX = newVelocityX;
        velocityY = newVelocityY;
    }

    /**
     * Initialize the x and y coordinates when added to the world.
     *
     * @param world The game world.
     */
    protected void addedToWorld(World world)
    {
        x = getX();
        y = getY();
    }

    /**
     * Move based on velocity.
     */
    public void move()
    {
        setLocation(x + velocityX, y + velocityY);

    }

    /**
     * Allows precise tracking of the location and eventually calls
     * the built-in 'setLocation' method of Actor.
     *
     * @param x The x-coordinate.
     * @param y The y-coordinate.
     */
    public void setLocation(double x, double y)
    {
        this.x = x;
        this.y = y;
        super.setLocation((int) x, (int) y);
    }

    /**
     * Override the default 'setLocation' method to keep our coordinates
     * up-to-date.
     *
     * @param x The x-coordinate.
     * @param y The y-coordinate.
     */
    @Override
    public void setLocation(int x, int y)
    {
        setLocation((double) x, (double) y);
    }

    /**
     * Gets the horizontal velocity of this Sprite in
     * pixels per act() call.
     *
     * @return The x horizontal velocity of this Sprite.
     */
    public double getVelocityX()
    {
        return velocityX;
    }

    /**
     * Gets the vertical velocity of this Sprite in
     * pixels per act() call.
     *
     * @return The y velocity of this Sprite.
     */
    public double getVelocityY()
    {
        return velocityY;
    }

    public void delete(Class clss)
    {
        Actor actor = getOneIntersectingObject(clss);
        if(actor != null) {
            getWorld().removeObject(actor);
        }
    }

    /**
     * Sets the horizontal velocity of this Sprite in
     * pixels per act() call.
     *
     * @param newvelocityX The new x velocity
     */
    public void setVelocityX(double newvelocityX)
    {
        velocityX = newvelocityX;
    }

    /**
     * Sets the vertical velocity of this Sprite in
     * pixels per act() call.
     *
     * @param newVelocityY The new y velocity
     */
    public void setVelocityY(double newVelocityY)
    {
        velocityY = newVelocityY;
    }

    /**
     * Returns the height of this Sprite's image.
     *
     * @return Height of the image.
     */
    public int getHeight()
    {
        return getImage().getHeight();
    }

    /**
     * Returns the width of this Sprite's image.
     *
     * @return Width of the image.
     */
    public int getWidth()
    {
        return getImage().getWidth();
    }

    /**
     * Sets the state of this Sprite.
     *
     * @param newState The new state of this Sprite
     */
    public void setState(int newState)
    {
        state = newState;
    }

    /**
     * Returns this Sprite's current state.
     *
     * @return The current state
     */
    public int getState()
    {
        return state;
    }

    /**
     * Remove this object from the world.
     */
    public void removeFromWorld()
    {
        getWorld().removeObject(this);
    }

    /**
     * Test if we are close to one of the edges of the world. Return true is we are.
     */
    public boolean atWorldEdge()
    {
        if(getX() < 20 || getX() > getWorld().getWidth() - 20)
            return true;
        if(getY() < 20 || getY() > getWorld().getHeight() - 20)
            return true;
        else
            return false;
    }


}
