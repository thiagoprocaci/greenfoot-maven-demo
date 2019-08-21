package com.greenfoot.demo;

import greenfoot.Actor;

import greenfoot.Greenfoot;


public class Coin extends Actor {

    private int valor;

    public Coin() {
        while(valor == 0) {
            valor = Greenfoot.getRandomNumber(5);
        }
        setImage("gold-ball.png");
        int tamanho = valor * 12;
        getImage().scale(tamanho, tamanho);

    }

    public void act() {
        setLocation(getX(), getY() + 1);
        turn(1);
        if(getY() == getWorld().getHeight() - 2) {
            getWorld().removeObject(this);
        }
    }


}
