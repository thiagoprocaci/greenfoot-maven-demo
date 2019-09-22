package com.greenfoot.demo.actor;

public class Lift extends Platform {
    private int top;
    private int bottom;

    public Lift(int bottomTurn, int topTurn) {
        bottom = bottomTurn;
        top = topTurn;
        setImage("lift.png");
    }

    public void act() {
        move(2);
        startTurn();
        topWall();
        bottomWall();
        scroll();
    }

    public void startTurn() {
        if (getY() == bottom) {
            setRotation(270);
        }
    }

    /**
     * When lift reaches a certain y value, go down.
     */
    public void topWall() {
        if (getY() <= top) {
            setRotation(90);
        }
    }

    /**
     * When lift reaches a certain y value, go up.
     */
    public void bottomWall() {
        if (getY() >= bottom) {
            setRotation(270);
        }
    }
}
