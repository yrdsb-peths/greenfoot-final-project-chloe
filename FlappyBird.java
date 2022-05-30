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
    double g = 2.5;
    double BOOST_SPEED = -10;
    
    public void act()
    {
        // If we are touching a pipe, the Game Over
        if(getOneIntersectingObject(Pipe.class) != null)
        {
            displayGameOver();
        }
        
        rotateFlappyBird();
        setLocation(getX(), (int) (getY() + dy));
        
        // If user pressed UP arrow, launch Flappy Bird upward
        if(Greenfoot.isKeyDown("space") == true)
        {
            dy = BOOST_SPEED;
        }
        
        // If FlappyBird drops out of the world, Game Over!
        if(getY() > getWorld().getHeight())
        {
            displayGameOver();
        }
        
        dy = dy + g;
    }
    
    private void displayGameOver()
    {
        GameOver gameOver = new GameOver();
        getWorld().addObject(gameOver, getWorld().getWidth()/2, getWorld().getHeight()/2);
        Greenfoot.stop();
    }
    
    private void rotateFlappyBird()
    {
        if(dy < 1)
        {
            setRotation(-30);
        }
        else if(dy > 1)
        {
            setRotation(30);
        }
    }
}
