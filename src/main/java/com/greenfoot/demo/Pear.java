package com.greenfoot.demo;

import greenfoot.Actor;
import greenfoot.World;

public class Pear extends Actor {

    boolean goRight = true;

    public Pear() {
        setImage("pear.png");
    }

    public void moveRight() {
        setLocation(getX() + 20, getY());
    }

    public void moveLeft() {
        setLocation(getX() - 20, getY());
    }

    public void move() {
        if(isAtEdge()) {
            World world = getWorld();
            if(getX() < world.getWidth()/2) {
                goRight = true;
            } else if(getX() > world.getWidth()/2) {
                goRight = false;
            }
        }
        if(goRight) {
            moveRight();
        } else {
            moveLeft();
        }
    }
}
