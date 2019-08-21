package com.greenfoot.demo;

import greenfoot.Actor;

public class Bullet extends Actor {

    boolean shotSomeone = false;

    public Bullet() {
        setImage("bullet.png");
        getImage().scale(3, 3);
    }

    public void act() {
        move();
    }

    private void move() {
        if(!shotSomeone) {
            setLocation(getX() + 2, getY());
            if(isAtEdge()) {
                getWorld().removeObject(this);
            }
        } else {
            getWorld().removeObject(this);
        }
    }

    public void shotSomeone() {
        this.shotSomeone = true;
    }
}
