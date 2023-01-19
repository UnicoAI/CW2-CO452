import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Quit here.
 * 
 * @author (Marius Boncica) 
 * @version (version2 10/01/2022)
 */
public class Galaxy extends World
{ 

    /**
     * Constructor for objects of class Quit.
     * 
     */
    public Galaxy()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900,600,1); 
        
        GalaxySingle button2 = new GalaxySingle();
        addObject(button2,470,450);
          
           showText("Single Player -  score: " + PlayerSingle.scor, 470, 50);
            showText("Drive Space Ship in the Universe To Find Earth like Planet ", 300, 100);
            showText("Use Arrows to navigate ", 170, 140);
            showText("Mouse click to Shoot Aliens ", 170, 180);
            showText("Avoid Touching Sun or Aliens ", 170,220);
            showText("Time Limit 1 Minute", 170, 260);
          
            showText("Galaxy View", 470, 480);
         
          
       
    }
    public void prepare(){
         GreenfootImage bkg = getBackground();
        bkg.setColor(Color.BLACK);
        bkg.fill();
        createStars(300);
    }
     private void createStars(int number) 
    {
        GreenfootImage background = getBackground();             
        for (int i=0; i < number; i++)
        {            
             int x = Greenfoot.getRandomNumber( getWidth() );
             int y = Greenfoot.getRandomNumber( getHeight() );
             int color = 150 - Greenfoot.getRandomNumber(120);
             background.setColorAt(x, y, new Color(color,color,color));
        }
    }
}

