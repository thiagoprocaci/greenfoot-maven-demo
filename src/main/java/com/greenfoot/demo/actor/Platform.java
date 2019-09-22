package com.greenfoot.demo.actor;


public class Platform extends Scroller{

    public Platform() {
        setImage("platform-top.png");
    }

    public void act() {
        scrollingMethods();
    }
}
