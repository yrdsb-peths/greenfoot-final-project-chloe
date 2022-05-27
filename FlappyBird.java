import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FlappyBird here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FlappyBird extends Actor
{
    double dy = 0;
    double g = 1.3;
    double BOOST_SPEED = -15;
    
    /**
     * Act - do whatever the FlappyBird wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        setLocation(getX(), (int) (getY() + dy));
        
        // If user pressed UP arrow, launch Flappy Bird upward
        if(Greenfoot.isKeyDown("up") == true)
        {
            dy = BOOST_SPEED;
        }
        
        if(-10 < dy < 10)
        {
            // Set angle to 30
            setRotation(30);
        }

        
        // If FlappyBird drops out of the world, Game Over!
        if(getY() > getWorld().getHeight())
        {
            GameOver gameOver = new GameOver();
            getWorld().addObject(gameOver, getWorld().getWidth()/2, getWorld().getHeight()/2);
            Greenfoot.stop();
        }
        
        dy = dy + g;
    }
}
