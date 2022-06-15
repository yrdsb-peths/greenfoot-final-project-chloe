import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This code controls the title screen, which is the first thing you see 
 * before starting the game.
 * 
 * @author Chloe Hoang 
 * @version June 15, 2022
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
        
        Settings instructions = new Settings("instructions.png", new Instructions());
        addObject(instructions, 30, 30); 
    }
}
