package com.greenfoot.demo.actor;

import greenfoot.Actor;
import greenfoot.Greenfoot;

import java.util.ArrayList;

public class House extends Actor {

    ArrayList<Guest> guestList = new ArrayList<>();
    int visitors = 3;

    public House() {
        setImage("house.png");
    }

    public void act() {
        if(isTouching(Bricklayer.class)) {
            int number = Greenfoot.getRandomNumber(10);
            if(number > guestList.size()) {
                visitors = number;
            }
        }

        Guest guest = (Guest) getOneIntersectingObject(Guest.class);
        if(guest != null && guestList.size() < visitors) {
            guest.setInTheHouse(true);
            guest.makeInvisible();
            guestList.add(guest);
        }
        int randomNumber = Greenfoot.getRandomNumber(200);
        if(randomNumber < 10 && guestList.size() > 0) {
            randomNumber = Greenfoot.getRandomNumber(guestList.size());
            Guest removedGuest = guestList.remove(randomNumber);
            removedGuest.move(2);
            removedGuest.setInTheHouse(false);
            removedGuest.makeVisible();
        }

        int quantCrab = 0;
        int quantWombat = 0;
        for(Guest g : guestList) {
            if(g instanceof  Crab) {
                quantCrab++;
            }
            if(g instanceof  Wombat) {
                quantWombat++;
            }
        }

        getWorld().showText( "Capacidade total da casa: " + visitors, 4, 0);
        getWorld().showText(guestList.size() + " visitantes na casa.", 2, 1);
        getWorld().showText(quantCrab + " Crabs e " + quantWombat  + " Wombats", 2, 2);

    }



}
