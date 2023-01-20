import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Button redirect to Galaxy3rdLevel
 * 
 * @Marius Boncica
 * @version (3 19/01/2023)
 */
public class PlayMenu extends Actor
{ GreenfootImage myGif = new GreenfootImage("Play1.png");
    /**
     *  Constructor--Scale Image
     */
    public PlayMenu(){
        GreenfootImage myGif = getImage();
        int h = (int)myGif.getHeight()/1;
        int w = (int)myGif.getWidth()/2;
        myGif.scale(h,w);
    }
    //METHOD ACT DESCRIBE ANIMATION BEHAVIOUR OF IMAGE ON CLICK EVENT
    public void act()
    {if(Greenfoot.mousePressed(this))
        {getImage().scale((int)Math.round(getImage().getWidth()*0.9),
            (int)Math.round(getImage().getHeight()*0.9));
        }
        // Add your action code here.
    

if(Greenfoot.mouseClicked(this))
{   Greenfoot.delay(5);
    //REDIRECT ON CLICK EVENT TO WORLD Galaxy3rdLevel
    Greenfoot.setWorld(new Galaxy3rdLevel());
}
}
}

