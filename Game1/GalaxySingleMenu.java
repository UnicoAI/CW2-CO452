import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Game Cw2
 * 
 * @Marius Boncica & Martin Konecny
 * @version 12
 */
public class GalaxySingleMenu extends Actor
{ GreenfootImage myGif = new GreenfootImage("Play1.png");
   
    /**
     * Act - do whatever the Play wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public GalaxySingleMenu(){
        GreenfootImage myGif = getImage();
        int h = (int)myGif.getHeight()/1;
        int w = (int)myGif.getWidth()/2;
        myGif.scale(h,w);
    }
   
    public void act()
    {if(Greenfoot.mousePressed(this))
        {getImage().scale((int)Math.round(getImage().getWidth()*0.9),
            (int)Math.round(getImage().getHeight()*0.9));
        }
        // Add your action code here.
    

if(Greenfoot.mouseClicked(this))
{   Greenfoot.delay(5);
    Greenfoot.setWorld(new Galaxy());
}
}
}

