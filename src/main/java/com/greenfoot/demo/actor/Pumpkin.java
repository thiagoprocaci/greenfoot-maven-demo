package com.greenfoot.demo.actor;

import greenfoot.Actor;
import greenfoot.Greenfoot;

public class Pumpkin extends Actor {

    public Pumpkin() {
        setImage("pumpkin.png");
    }

    public void act() {
        if(isTouching(Wombat.class)) {
            removeTouching(Wombat.class);
            getWorld().showText("Wombat caiu na armadilha", 3, 1);
            Greenfoot.stop();
        }
    }

}
