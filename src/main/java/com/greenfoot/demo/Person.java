package com.greenfoot.demo;

import greenfoot.Actor;
import greenfoot.Greenfoot;

public class Person extends Actor {

    int totalMoney = 0;
    int gunReloadTime = 15;
    int reloadDelayCount = 0;


    public Person() {
        setImage("person.gif");
    }

    public void act() {
        checkKeyPressed();
        getMoney();
        makeDeposit();
        fire();
        updateWorld();
        reloadDelayCount++;
    }

    public void removeMoney() {
        totalMoney = 0;
    }

    private void fire() {
        if(Greenfoot.isKeyDown("space") && reloadDelayCount > gunReloadTime) {
            getWorld().addObject(new Bullet(), getX() + 2, getY());
            reloadDelayCount = 0;
        }
    }

    private void makeDeposit() {
        Bank bank = (Bank) getOneIntersectingObject(Bank.class);
        if(bank != null && Greenfoot.isKeyDown("d")) {
            bank.addValue(totalMoney);
            totalMoney = 0;
        }
    }

    private void updateWorld() {
        MoneyWorld moneyWorld = (MoneyWorld) getWorld();
        moneyWorld.setPersonAmount(totalMoney);
    }

    private void getMoney() {
        Coin coin = (Coin) getOneIntersectingObject(Coin.class);
        if(coin != null) {
            totalMoney = totalMoney + coin.getValue();
            getWorld().removeObject(coin);
        }
    }

    private void checkKeyPressed() {
        if(Greenfoot.isKeyDown("left")) {
            setLocation(getX() - 3, getY());
        }
        if(Greenfoot.isKeyDown("right")) {
            setLocation(getX() + 3, getY());
        }
    }

}
