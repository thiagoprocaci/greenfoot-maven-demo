package com.greenfoot.demo;

import greenfoot.Actor;

import greenfoot.Greenfoot;


public class Coin extends Actor {

    private int value = 0;

    public Coin() {
        while(value == 0) {
            value = Greenfoot.getRandomNumber(5);
        }
        setImage("coin.png");
        int size = value * 15;
        getImage().scale(size, size);
    }

    public void act() {
        setLocation(getX(), getY() + 1);
        turn(1);
        if(getY() == getWorld().getHeight() - 2) {
            getWorld().removeObject(this);
        }
    }

    public int getValue() {
        return value;
    }
}
