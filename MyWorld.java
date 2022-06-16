import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This code is the world class, which is the main class. It is the basis of 
 * what the game looks like.
 * 
 * @author Chloe Hoang 
 * @version June 15, 2022
 */
public class MyWorld extends World
{
    int pipeCounter = 0;
    int flappyCounter = 0;
    int PIPE_SPACING = 150;
    int score = 0;
    int FIRST_PIPE = 240;
    Score scoreObj = null;

    GreenfootSound point = new GreenfootSound("point.mp3");
    Label label;

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false);

        // Set paint order
        setPaintOrder(Score.class, GameOver.class, Pipe.class, FlappyBird.class);

        // Create a Flappy Bird Object
        FlappyBird flappy = new FlappyBird();

        // Add flappy to our world
        addObject(flappy, 100, getHeight()/2);

        //Instructions
        label = new Label("Use <space> or \u2191 to jump", 40);
        addObject(label,getWidth()/2, 50);

        if(Greenfoot.isKeyDown("space") || Greenfoot.isKeyDown("up"))
        {
            removeObject(label);
        }

        // Create a Score object
        scoreObj = new Score();
        scoreObj.setScore(0);

        // Add it to our world
        addObject(scoreObj, 40, 386);
    }

    public void act()
    {
        if(Greenfoot.isKeyDown("space") || Greenfoot.isKeyDown("up"))
        {
            removeObject(label);
        }
        
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
                //Increase the score
                score++;
                scoreObj.setScore(score);
                point.play();
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

        addObject(botPipe, getWidth(), getHeight()/2 + image.getHeight() - Greenfoot.getRandomNumber(150));
        addObject(topPipe, getWidth(), botPipe.getY() - image.getHeight() - PIPE_SPACING);
    }
}
