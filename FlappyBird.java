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
    double g = 0.5;
    double BOOST_SPEED = -6;
    
    GreenfootImage[] idle = new GreenfootImage[5];
    String facing = "right";
    SimpleTimer animationTimer = new SimpleTimer();
    
    public FlappyBird()
    {
        for(int i = 0; i < idle.length; i++)
        {
            idle[i] = new GreenfootImage("images/bird_sprites/idle" + i + ".png");
            idle[i].scale(50,40);
        }
        
        animationTimer.mark();
        
        setImage(idle[0]);
    }
    
    /**
     * Animate the dolphin
     */
    int imageIndex = 0;
    public void animateFlappy()
    {
        if(animationTimer.millisElapsed() < 150)
        {
            return;
        }
        animationTimer.mark();
        
        if(facing.equals("right"))
        {
           setImage(idle[imageIndex]);
           imageIndex = (imageIndex + 1) % idle.length; 
        }
    }
    
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
        
        // If FlappyBird touches the top of the world, Game Over!
        if(getY() < 0)
        {
            displayGameOver();
        }
        
        dy = dy + g;
        
        animateFlappy();
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
