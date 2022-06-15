import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the button that appears on the instructions screen. If it is
 * pressed, the screen will change to the title screen.
 * 
 * @author Chloe Hoang
 * @version June 15, 2022
 */
public class Return extends Title
{
    private World link;
    
    public Return(String image, World link){
        setImage(new GreenfootImage(image));
        getImage().scale(40,40);
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
