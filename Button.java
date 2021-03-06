import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the button that appears on the title screen. If it is pressed,
 * the screen will change to the main game screen
 * 
 * @author Chloe Hoang 
 * @version June 15, 2022
 */
public class Button extends Title
{
    private World link;
    
    public Button(String image, World link){
        setImage(new GreenfootImage(image));
        this.link = link;
    }
    
    public void act()
    {
        if(Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(this.link);
        }
    }
}
