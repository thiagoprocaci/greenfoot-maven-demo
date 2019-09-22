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

    public void checkKeys() {

    }

    public void runRight() {

    }


    public void runLeft() {

    }


    public void stopMoving() {

    }


    public void jump() {

    }

    private void manageJumping() {

    }

    private void checkCollisionHorizontal() {

    }

    public void applyGravity() {
        double velocityY = getVelocityY() + GRAVITY; // add gravity
        if (velocityY > MAX_VEL) {
            velocityY = MAX_VEL; // limit velocity
        }
        setVelocityY(velocityY);  // save current velocity
    }

    public void moveToContactVertical(Actor target) {
        int h2 = (target.getImage().getHeight() + getImage().getHeight()) / 2;
        int newY;

        if (target.getY() > getY()) {
            newY = target.getY() - h2;
        } else {
            newY = target.getY() + h2;
        }
        setLocation(getX(), newY);

    }

    private void moveToContactHorizontal(Actor target) {
        int w2 = (getWidth() + target.getImage().getWidth()) / 1;
        int newX;
        if (target.getX() > getX()) {
            newX = target.getX() - w2;
        } else {
            newX = target.getX() + w2;
        }
        setLocation(newX, getY());
    }


}
