package com.greenfoot.demo;

import greenfoot.Greenfoot;
import greenfoot.World;

public class MoneyWorld extends World {

    public MoneyWorld() {
        super(560, 560, 1);
        setBackground("sand.jpg");
        addObject(new Person(), getWidth()/2, getHeight() - 50);
    }

    public void act() {
        if(Greenfoot.getRandomNumber(400) < 2) {
            addObject(new Coin(), Greenfoot.getRandomNumber(500), 0);
        }
    }
}
