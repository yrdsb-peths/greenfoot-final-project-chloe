import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PacMan here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PacMan extends Actor
{
    GreenfootImage[] idleRight = new GreenfootImage[5];
    GreenfootImage[] idleLeft = new GreenfootImage[5];
    
    String facing = "right";
    SimpleTimer animationTimer = new SimpleTimer();
    /**
     * Constructor - The code that gets run one time when object is created
     */
    public PacMan()
    {
        for(int i = 0; i < idleRight.length; i++)
        {
            idleRight[i] = new GreenfootImage("images/pacman_sprites/idle" + i + ".png");
            idleRight[i].scale(50,50);
        }
        
        for(int i = 0; i < idleLeft.length; i++)
        {
            idleLeft[i] = new GreenfootImage("images/pacman_sprites/idle" + i + ".png");
            idleLeft[i].mirrorHorizontally();
            idleLeft[i].scale(50,50);
        }
        
        animationTimer.mark();
        
        setImage(idleRight[0]);
    }
    
    /**
     * Animate the dolphin
     */
    int imageIndex = 0;
    public void animatePacMan()
    {
        if(animationTimer.millisElapsed() < 150)
        {
            return;
        }
        animationTimer.mark();
        
        if(facing.equals("right"))
        {
           setImage(idleRight[imageIndex]);
           imageIndex = (imageIndex + 1) % idleRight.length; 
        }
        else
        {
            setImage(idleLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % idleLeft.length;
        }
    }
    
    public void act()
    {
        if(Greenfoot.isKeyDown("left"))
        {
            setLocation(getX()-1, getY()); // left
            facing = "left";
        }
        
        if(Greenfoot.isKeyDown("right"))
        {
            setLocation(getX()+1, getY()); // right
            facing = "right";
        }
        
        if(Greenfoot.isKeyDown("up"))
        {
            setLocation(getX(), getY()-1); // up
            facing = "up";
        }
        
        if(Greenfoot.isKeyDown("down"))
        {
            setLocation(getX(), getY()+1); // down
            facing = "down";
        }
        
        animatePacMan();
    }
}
