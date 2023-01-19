import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Game Cw2
 * 
 * @Marius Boncica & Martin Konecny
 * @version 12
 */
public class GalaxySingleMenu extends Actor
//create object of gif image 
{ GreenfootImage myGif = new GreenfootImage("Play1.png");
   
    /**
     * Constructor
     * scale image
     */
    public GalaxySingleMenu(){
        GreenfootImage myGif = getImage();
        int h = (int)myGif.getHeight()/1;
        int w = (int)myGif.getWidth()/2;
        myGif.scale(h,w);
    }
   //method to animate behaviour on click event
    public void act()
    {if(Greenfoot.mousePressed(this))
        {getImage().scale((int)Math.round(getImage().getWidth()*0.9),
            (int)Math.round(getImage().getHeight()*0.9));
        }
        // Add your action code here.
    

if(Greenfoot.mouseClicked(this))
{   Greenfoot.delay(5);
    //on click event enter word Galaxy
    Greenfoot.setWorld(new Galaxy());
}
}
}

