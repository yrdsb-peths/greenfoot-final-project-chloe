import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class pipe here.
 * 
 * @author Chloe Hoang 
 * @version June 15, 2022
 */
public class Pipe extends Actor
{
    int PIPE_SPEED = -4;
    
    /**
     * Act - do whatever the Pipe wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {   
        setLocation(getX() + PIPE_SPEED, getY());
    }
}
