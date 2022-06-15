import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Settings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Settings extends Title
{
    private World link;
    
    public Settings(String image, World link){
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

