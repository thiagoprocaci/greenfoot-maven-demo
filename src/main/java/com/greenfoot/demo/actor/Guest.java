package com.greenfoot.demo.actor;

import greenfoot.Actor;

public class Guest extends Actor {

    boolean inTheHouse;

    public Guest() {
        inTheHouse = false;
    }

    public boolean isInTheHouse() {
        return inTheHouse;
    }

    public void setInTheHouse(boolean inTheHouse) {
        this.inTheHouse = inTheHouse;
    }

    public void makeInvisible() {
        getImage().setTransparency(0);
    }

    public void makeVisible() {
        getImage().setTransparency(255);
    }
}
