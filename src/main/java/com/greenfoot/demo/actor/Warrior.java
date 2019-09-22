package com.greenfoot.demo.actor;

import greenfoot.Actor;
import greenfoot.Greenfoot;

public class Warrior extends Player {

    private static final double GRAVITY = 0.7;
    private static final double MAX_VEL = 14;
    private static final int RIGHT = 0;
    private static final int LEFT = 1;

    private double runSpeed = 0.5;
    private int direction = RIGHT;
    private int imageCount = 0;
    private int jumpForce = 14;
    private boolean canJump;

    public Warrior() {
        setImage("standing.gif");
    }


    public void act() {
        manageJumping();
        checkCollisionHorizontal();
        checkKeys();
        move();
    }


    public void checkKeys()
    {
        if (Greenfoot.isKeyDown("right") && !(Greenfoot.isKeyDown("left")) && !isTouching(Pole.class))
        {
            direction = RIGHT;
            runRight();
        } else if (Greenfoot.isKeyDown("left") && !(Greenfoot.isKeyDown("right")) && !isTouching(Pole.class)) {
            direction = LEFT;
            runLeft();
        } else {
            stopMoving();
            if(direction == RIGHT) {
                setImage("standing.gif");
            }
            if(direction == LEFT) {
                setImage("standingleft.gif");
            }
        }

        if (Greenfoot.isKeyDown("up")) {
            jump();
        }

    }

    /**
     * Run to the right.
     */
    public void runRight()
    {
        setVelocityX(runSpeed);
        imageCount++;
        if(imageCount <= 1){
            setImage("run3.gif");
        }
        if(imageCount == 11){
            setImage("run1.gif");
        }
        if(imageCount == 21){
            setImage("run3.gif");
            imageCount = 0;
        }
    }

    /**
     * Run to the left.
     */
    public void runLeft()
    {
        setVelocityX(-runSpeed);
        imageCount++;
        if(imageCount <= 1){
            setImage("run3left.gif");
        }
        if(imageCount == 11){
            setImage("run1left.gif");
        }
        if(imageCount == 21){
            setImage("run3left.gif");
            imageCount = 0;
        }
    }

    /**
     * Stop moving.
     */
    public void stopMoving()
    {
        setVelocityX(0.0);
    }
    /**
     * Perform a jump.
     */
    public void jump()
    {
        if (canJump)
        {
            setVelocityY(-jumpForce);
            canJump = false;
        }
    }

    /**
     * Check for vertical collisions and adjust jumping or falling.
     */
    private void manageJumping()
    {
        // Calculate distance sprite will move vertically
        double velocityY = getVelocityY();
        int lookY;
        if (velocityY > 0) {
            lookY = (int) (velocityY + GRAVITY + getHeight() / 2);
        } else {
            lookY = (int) (velocityY + GRAVITY - getHeight() / 2);
        }
        // Check for vertical collision this cycle
        Actor tile = getOneObjectAtOffset(0, lookY, Platform.class);
        if (tile == null) {
            // No collision this cycle
            applyGravity();
            canJump = false; // in case of falling off an edge
        } else  {
            // Collision detected
            moveToContactVertical(tile);
            if (velocityY > 0)
            {
                // Player has landed
                canJump = true;
            }
            setVelocityY(0.0);
        }
    }

    /**
     * Apply gravity when the sprite is jumping or falling.
     */
    public void applyGravity()
    {
        double velocityY = getVelocityY() + GRAVITY; // add gravity
        if (velocityY > MAX_VEL) {
            velocityY = MAX_VEL; // limit velocity
        }
        setVelocityY(velocityY);  // save current velocity
    }

    /**
     * Move this sprite into contact with the specified Actor vertically.
     *
     * @param target The target this sprite is approaching.
     */
    public void moveToContactVertical(Actor target)
    {
        int h2 = (target.getImage().getHeight() + getImage().getHeight()) / 2;
        int newY;

        if (target.getY() > getY())  {
            newY = target.getY() - h2;
        }  else  {
            newY = target.getY() + h2;
        }
        setLocation(getX(), newY);

    }

    private void checkCollisionHorizontal() {
        double velocityX = getVelocityX();
        if (velocityX == 0) {
            return;
        }
        int lookX;
        if (velocityX < 0) {
            lookX = (int) velocityX - getWidth() / 2;
        } else {
            lookX = (int) velocityX + getWidth() / 2;
        }
        Actor a = getOneObjectAtOffset(lookX, 0, Platform.class);
        if (a != null) {
            moveToContactHorizontal(a);
            stopMoving();
        }
    }

    /**
     * Move this Actor into contact with the specified Actor in the
     * horizontal (x) direction.
     *
     * @param target The target this sprite is approaching.
     */
    private void moveToContactHorizontal(Actor target)
    {
        int w2 = (getWidth() + target.getImage().getWidth()) / 1;
        int newX ;
        if (target.getX() > getX()) {
            newX = target.getX() - w2;
        } else {
            newX = target.getX() + w2;
        }
        setLocation(newX, getY());
    }


}
