package com.greenfoot.demo;

import greenfoot.Actor;

public class Bank extends Actor {

    int totalMoney = 0;

    public Bank() {
        setImage("house.png");
    }

    public void act() {
        updateWorld();
    }

    public void addValue(int v) {
        this.totalMoney = v + this.totalMoney;
    }

    public void removeValue() {
        this.totalMoney = 0;
    }

    private void updateWorld() {
        MoneyWorld moneyWorld = (MoneyWorld) getWorld();
        moneyWorld.setBankAmount(totalMoney);
    }

}
