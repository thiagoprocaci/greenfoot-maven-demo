package com.greenfoot.demo.actor;

import greenfoot.Actor;

public abstract class Player extends Actor {

    private double x = 0;
    private double y = 0;
    private double velocityX;
    private double velocityY;


    public Player() {

    }

    public void move() {
        setLocation(x + velocityX, y + velocityY);
    }

    /**
     * Allows precise tracking of the location and eventually calls
     * the built-in 'setLocation' method of Actor.
     *
     * @param x The x-coordinate.
     * @param y The y-coordinate.
     */
    public void setLocation(double x, double y) {
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
    public void setLocation(int x, int y) {
        setLocation((double) x, (double) y);
    }

    /**
     * Gets the horizontal velocity of this Sprite in
     * pixels per act() call.
     *
     * @return The x horizontal velocity of this Sprite.
     */
    public double getVelocityX() {
        return velocityX;
    }

    /**
     * Gets the vertical velocity of this Sprite in
     * pixels per act() call.
     *
     * @return The y velocity of this Sprite.
     */
    public double getVelocityY() {
        return velocityY;
    }


    /**
     * Sets the horizontal velocity of this Sprite in
     * pixels per act() call.
     *
     * @param newvelocityX The new x velocity
     */
    public void setVelocityX(double newvelocityX) {
        velocityX = newvelocityX;
    }

    /**
     * Sets the vertical velocity of this Sprite in
     * pixels per act() call.
     *
     * @param newVelocityY The new y velocity
     */
    public void setVelocityY(double newVelocityY) {
        velocityY = newVelocityY;
    }

    /**
     * Returns the height of this Sprite's image.
     *
     * @return Height of the image.
     */
    public int getHeight() {
        return getImage().getHeight();
    }

    /**
     * Returns the width of this Sprite's image.
     *
     * @return Width of the image.
     */
    public int getWidth() {
        return getImage().getWidth();
    }


}
