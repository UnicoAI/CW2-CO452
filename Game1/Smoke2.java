import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Smoke2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Smoke2 extends ScrollActors
{
    /**
     * Act - do whatever the Smoke wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage image;
    private int fade; 
    public void act() 
    {
        shrink();
        
    }
    public Smoke2()
    {
        image = getImage();
        fade = Greenfoot.getRandomNumber(4) +1;
        if(fade>3)
        {
            fade = 2;
        }
    }
    public void shrink()
    {
       if(getImage().getWidth() < 5)
       {
           getWorld().removeObject(this);
        }
        else
        {
            GreenfootImage img = new GreenfootImage(image);
            img.scale(getImage().getWidth() - fade, getImage().getHeight() - fade);
            img.setTransparency(getImage().getTransparency()- (fade*5));
            setImage(img);
        }
    }
}
