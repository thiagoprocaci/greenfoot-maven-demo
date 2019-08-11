package com.greenfoot.demo.actor;

import greenfoot.Actor;
import greenfoot.Greenfoot;

public class Bricklayer extends Actor {

    public Bricklayer() {
        setImage("stand.png");
    }

    public void act() {
        if(isAtEdge()) {
            int direction = Greenfoot.getRandomNumber(4);
            setRotation(direction * 90);
            move(3);
        } else {
            move(1);
        }

    }

}
