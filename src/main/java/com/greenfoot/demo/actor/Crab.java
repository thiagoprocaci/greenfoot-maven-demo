package com.greenfoot.demo.actor;

import greenfoot.Actor;
import greenfoot.Greenfoot;

public class Crab extends Actor {

    boolean invencible = false;

    public Crab() {
        setImage("crab.png");
    }

    public void act() {
        if(Greenfoot.isKeyDown("left")) {
            setDirection(2);
        }
        if(Greenfoot.isKeyDown("right")) {
            setDirection(0);
        }
        if(Greenfoot.isKeyDown("up")) {
            setDirection(3);
        }
        if(Greenfoot.isKeyDown("down")) {
            setDirection(1);
        }
        if(Greenfoot.isKeyDown("s")) {
            move(1);
        }
        if(Greenfoot.isKeyDown("a")) {
           int x = getX();
           int y = getY();
           getWorld().addObject(new Pumpkin(), x, y);
        }

        if(isTouching(House.class)) {
            invencible = true;
            makeInvisible();
        } else {
            invencible = false;
            makeVisible();
        }

    }

    void setDirection(int direction) {
        setRotation(direction * 90);
    }

    public boolean isInvencible() {
        return invencible;
    }

    public void makeInvisible() {
        getImage().setTransparency(0);
    }

    public void makeVisible() {
        getImage().setTransparency(255);
    }
}
