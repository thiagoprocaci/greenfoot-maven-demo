package com.greenfoot.demo;

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The bloodstream is the setting for our White Blood Cell scenario. 
 * It's a place where blood cells, bacteria and viruses float around.
 * 
 * @author Michael Kölling
 * @version 0.1
 */
public class Bloodstream extends World
{
    
    private int score;
    private int timeRemaining;

    /**
     * Constructor: Set up the staring objects.
     */
    public Bloodstream()
    {    
        super(780, 360, 1); 

        prepare();
        score = 0;
        timeRemaining = 2000;
        showMessage();
        showTime();
    }
    
    private void showTime() {
        showText("Time Remaining: " + timeRemaining, 550, 25); 
    }
    
    private void countTime() {
        timeRemaining = timeRemaining - 1;
        showTime();
        if(timeRemaining == 0) {
            showEndMessage();
        }
    }
    
    private void showEndMessage() {
         showText("You Win: " + score, 300, 300);
         Greenfoot.stop();
    }

    private void showMessage() {
       showText("Score: " + score, 73, 25); 
    }
    
    public void updateScore(int amount)
    {
        score = score + amount;
        showMessage();
        if (score < 0)
        {
          Greenfoot.playSound("game-over.wav");
          Greenfoot.stop();
        }
        
    }
    
    /**
     * Create new floating objects at irregular intervals.
     */
    public void act()
    {
        if (Greenfoot.getRandomNumber(100) < 3)
        {
            addObject(new Bacteria(), 779, Greenfoot.getRandomNumber(360));
        }
        if (Greenfoot.getRandomNumber(100) < 1)
        {
            addObject(new Lining(), 779, 1);
        }
        if (Greenfoot.getRandomNumber(100) < 1)
        {
            addObject(new Lining(), 779, 359);
        }
        if (Greenfoot.getRandomNumber(100) < 1)
        {
            addObject(new Virus(), 779, Greenfoot.getRandomNumber(360));
        }
        if (Greenfoot.getRandomNumber(100) < 6)
        {
            addObject(new RedCell(), 779, Greenfoot.getRandomNumber(360));
        }
        countTime();
    }
    
    /**
     * Prepare the world for the start of the program. In this case: Create
     * a white blood cell and the lining at the edge of the blood stream.
     */
    private void prepare()
    {
        WhiteCell whitecell = new WhiteCell();
        addObject(whitecell, 90, 179);
        Lining lining = new Lining();
        addObject(lining, 126, 1);
        Lining lining2 = new Lining();
        addObject(lining2, 342, 5);
        Lining lining3 = new Lining();
        addObject(lining3, 589, 2);
        Lining lining4 = new Lining();
        addObject(lining4, 695, 5);
        Lining lining5 = new Lining();
        addObject(lining5, 114, 359);
        Lining lining6 = new Lining();
        Lining lining7 = new Lining();
        addObject(lining7, 295, 353);
        Lining lining8 = new Lining();
        Lining lining9 = new Lining();
        Lining lining10 = new Lining();
        addObject(lining10, 480, 358);
        Lining lining11 = new Lining();
        addObject(lining11, 596, 359);
        Lining lining12 = new Lining();
        addObject(lining12, 740, 354);
        
        Border borderLeft = new Border();
        addObject(borderLeft, 0, 180);
        Border borderRight = new Border();
        addObject(borderRight, 770, 180);
        
        setPaintOrder(Border.class);
    }
}
