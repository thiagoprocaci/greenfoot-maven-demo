package com.greenfoot.demo;

import greenfoot.Greenfoot;
import greenfoot.World;

public class MoneyWorld extends World {

    int bankAmount = 0;
    int personAmount = 0;
    int stolenCount = 0;

    public MoneyWorld() {
        super(560, 560, 1);
        setBackground("sand.jpg");
        addObject(new Person(), getWidth()/2, getHeight() - 50);
        addObject(new Bank(), getWidth()/4, getHeight() - 50);
    }

    public void act() {
        addCoins();
        addThief();
        showMessage();
        endGame();
    }

    private void endGame() {
        if(stolenCount >= 3) {
            Greenfoot.stop();
        }
        if(bankAmount >= 20) {
            Greenfoot.stop();
        }
    }

    private void addThief() {
        if(Greenfoot.getRandomNumber(600) < 2) {
            addObject(new Thief(), getWidth() - 10, getHeight() - 40);
        }
    }

    private void addCoins() {
        if(Greenfoot.getRandomNumber(400) < 2) {
            addObject(new Coin(), Greenfoot.getRandomNumber(500), 0);
        }
    }

    private void showMessage() {
        showText("Bank $: " + bankAmount, 150, 30);
        showText("Person $: " + personAmount, 150, 50);
        showText("Stolen Count: " + stolenCount, 150, 80);
    }

    public void setBankAmount(int bankAmount) {
        this.bankAmount = bankAmount;
    }

    public void setPersonAmount(int personAmount) {
        this.personAmount = personAmount;
    }

    public void setStolenCount(int stolenCount) {
        this.stolenCount = stolenCount;
    }
}
