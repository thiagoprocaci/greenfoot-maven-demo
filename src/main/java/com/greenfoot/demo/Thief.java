package com.greenfoot.demo;

import greenfoot.Actor;

public class Thief extends Actor {

    boolean dead = false;

    public Thief() {
        setImage("pengu-left.png");
        getImage().scale(getImage().getWidth() - 10, getImage().getHeight() - 10);
    }

    public void act() {
        getMoney();
        checkFireCollision();
        walk();
    }

    private void walk() {
        if(!dead) {
            setLocation(getX() - 3, getY());
            if(getX() == 10) {
                getWorld().removeObject(this);
            }
        } else {
            getWorld().removeObject(this);
        }
    }

    private void getMoney() {
        Person person = (Person) getOneIntersectingObject(Person.class);
        if(person != null && !dead) {
            person.removeMoney();
            dead = true;
        }
    }

    private void checkFireCollision() {
        Bullet bullet = (Bullet) getOneIntersectingObject(Bullet.class);
        if(bullet != null) {
            bullet.shotSomeone();
            dead = true;
        }
    }



}
