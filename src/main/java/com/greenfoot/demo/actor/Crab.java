package com.greenfoot.demo.actor;

import greenfoot.Actor;
import greenfoot.Greenfoot;

public class Crab extends Actor {

    boolean invencible = false;

    public Crab() {
        setImage("crab.png");
    }

    public void act() {


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
