import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This code explains how to play the game
 * 
 * @author Chloe Hoang 
 * @version June 15, 2022
 */
public class Instructions extends World
{

    /**
     * Constructor for objects of class Instructions.
     * 
     */
    public Instructions()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        Play play = new Play();
        addObject(play, getWidth()/2, getHeight()/2 - 25);
        
        Return back = new Return("back.png", new TitleScreen());
        addObject(back, 25, 25); 
        
        Label steps = new Label("Play by using <space> or \u2191", 40);
        addObject(steps,getWidth()/2, 324);
    }
}
