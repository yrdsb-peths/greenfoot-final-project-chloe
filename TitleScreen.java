import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{

    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 

        Ground ground = new Ground();
        addObject(ground, 300, 375);

        TitleLabel titleLabel = new TitleLabel();
        addObject(titleLabel, getWidth()/2, getHeight()/2 -100);
        
        TitleFlappy titleFlappy = new TitleFlappy();
        addObject(titleFlappy,getWidth()/2, getHeight()/2 + 10 );
        
        Button button = new Button("play.png", new MyWorld());
        addObject(button, getWidth()/2, getHeight()/2 + 100);
    }
}
