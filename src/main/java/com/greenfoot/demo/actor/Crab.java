package com.greenfoot.demo.actor;



public class Crab extends Guest {

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


}
