import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * button redirect to world MyWorld
 * 
 * @Marius Boncica
 * @3.19/01/2023
 */
public class Play extends Actor
//create object of gif 
{ GreenfootImage myGif = new GreenfootImage("Play1.png");
    /**
     * Constructor
     * scale image
     */
    public Play(){
        GreenfootImage myGif = getImage();
        int h = (int)myGif.getHeight()/1;
        int w = (int)myGif.getWidth()/2;
        myGif.scale(h,w);
    }
    //behaviour of image on click event
    public void act()
    {if(Greenfoot.mousePressed(this))
        {getImage().scale((int)Math.round(getImage().getWidth()*0.9),
            (int)Math.round(getImage().getHeight()*0.9));
        }
        // Add your action code here.
    

if(Greenfoot.mouseClicked(this))
{   Greenfoot.delay(5);
    
    //redirect event on click to world MyWorld
    Greenfoot.setWorld(new MyWorld());
}
}
}

