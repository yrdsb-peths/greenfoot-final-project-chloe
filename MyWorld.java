import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    int pipeCounter = 0;
    int flappyCounter = 0;
    int PIPE_SPACING = 150;
    int score = 0;
    int FIRST_PIPE = 240;
    Score scoreObj = null;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false);

        // Set paint order
        setPaintOrder(Pipe.class, FlappyBird.class, Score.class, GameOver.class);

        Ground ground = new Ground();
        addObject(ground, 300, 375);

        // Create a Flappy Bird Object
        FlappyBird flappy = new FlappyBird();

        // Add flappy to our world
        addObject(flappy, 100, getHeight()/2);

        // Create a Score object
        scoreObj = new Score();
        scoreObj.setScore(0);

        // Add it to our world
        addObject(scoreObj, 40, 386);
    }
    
    public void act()
    {
        pipeCounter++;
        
        if(pipeCounter % 100 == 0)
        {
            // Create a pipe object
            createPipes();
        }
        
        if(pipeCounter >= FIRST_PIPE)
        {
            if(flappyCounter % 100 == 0)
            {
                score++;
                scoreObj.setScore(score);
            }
            flappyCounter++;
        }

    }
    
    private void createPipes()
    {
        // Create a pipe object
        Pipe topPipe = new Pipe();
        Pipe botPipe = new Pipe();
        
        GreenfootImage image = botPipe.getImage();
        int percent = 150; // for 50% larger image
        image.scale(image.getWidth()*percent/100, image.getHeight()*percent/100);
        
        addObject(botPipe, getWidth(), getHeight()/2 + image.getHeight() - Greenfoot.getRandomNumber(150));
        addObject(topPipe, getWidth(), botPipe.getY() - image.getHeight() - PIPE_SPACING);
    }
}
