import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Score extends Actor
{
    public Score()
    {
        GreenfootImage newImage = new GreenfootImage(100,50);
        setImage(newImage);
    }
    
    public void setScore(int score)
    {
        GreenfootImage newImage = getImage();
        newImage.clear();
        
        Font f = new Font("Comic Sans MS", 30);
        newImage.setFont(f);
        
        Color c = new Color(127,127,127,1);        
        newImage.setColor(c);
        newImage.fill();
        Color b = new Color(0,0,0,255);
        newImage.setColor(b);
        newImage.drawString("" + score,30,30);
        setImage(newImage);
    }
}
