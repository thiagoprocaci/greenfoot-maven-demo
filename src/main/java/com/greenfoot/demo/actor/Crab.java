package com.greenfoot.demo.actor;


import greenfoot.Greenfoot;

public class Crab extends Guest {

    boolean invencible = false;

    public Crab() {
        setImage("crab.png");
    }

    public void act() {
        if(isAtEdge()) {
            int direction = Greenfoot.getRandomNumber(4);
            setRotation(direction * 90);
        }
        move(1);
    }

    void setDirection(int direction) {
        setRotation(direction * 90);
    }

    public boolean isInvencible() {
        return invencible;
    }


}
