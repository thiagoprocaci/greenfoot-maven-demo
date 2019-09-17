package com.greenfoot.demo;

import greenfoot.Actor;
import greenfoot.Greenfoot;

public class FoodObstacle extends Obstacle {


    public FoodObstacle() {
        super("2a.wav");
        setImage("pear.png");
    }

    public void act() {
        Body body = (Body) getOneIntersectingObject(Body.class);
        if (touched && body == null)   // not touched anymore
        {
            touched = false;
            //  setImage ("pear.png"); para fazer o exercicio 5
            setImage ("pear.png");
        }
        else if (!touched && body != null)   // just being touched now
        {
            touched = true;
            setImage ("apple1.png");
            Greenfoot.playSound(sound);
            body.turnOn();
        }
    }

}
