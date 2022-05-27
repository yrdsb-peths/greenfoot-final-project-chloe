import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    int counter = 0;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false); 
        
        Ground ground = new Ground();
        addObject(ground, 300, 375);
        
        // Create a Flappy Bird Object
        FlappyBird flappy = new FlappyBird();
        
        //Add flappy to our world
        addObject(flappy, 100, getHeight()/2);
    }
    
    public void act()
    {
        counter++;
        if(counter == 100)
        {
            // Create a pipe object
            Pipe pipe = new Pipe();
            
            GreenfootImage image = pipe.getImage();
            int percent = 150; // for 50% larger image
            image.scale(image.getWidth()*percent/100, image.getHeight()*percent/100);
            
            
            addObject(pipe, getWidth(), getHeight()/2 + image.getHeight()-150);
            counter = 0;
        }
    }
}
