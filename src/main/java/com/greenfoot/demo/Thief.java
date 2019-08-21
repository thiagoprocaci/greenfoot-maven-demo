package com.greenfoot.demo;

import greenfoot.Actor;

public class Thief extends Actor {

    public Thief() {
        setImage("pengu-left.png");
        getImage().scale(getImage().getWidth() - 10, getImage().getHeight() - 10);
    }

    public void act() {
        getMoney();
        walk();
    }

    private void walk() {
        setLocation(getX() - 3, getY());
        if(getX() == 10) {
            getWorld().removeObject(this);
        }
    }

    private void getMoney() {
        Person person = (Person) getOneIntersectingObject(Person.class);
        if(person != null) {
            person.removeMoney();
        }
    }



}
