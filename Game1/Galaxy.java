import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Metauniverse Game level 1 description intro
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
        // Create a new world with 900x600 cells with a cell size of 1x1 pixels.
        super(900,600,1); 
        //add button to forward on WorlLevel1 when clicked
        GalaxySingle button2 = new GalaxySingle();
        addObject(button2,470,450); //set position bottom for button
          //arrange text display on screen
           showText("Single Player -  score: " + PlayerSingle.scor, 470, 50);
            showText("Drive Space Ship in the Universe To Find Earth like Planet ", 300, 100);
            showText("Use Arrows to navigate ", 170, 140);
            showText("Mouse click to Shoot Aliens ", 170, 180);
            showText("Avoid Touching Sun or Aliens ", 170,220);
            showText("Time Limit 1 Minute", 170, 260);
          
            showText("Galaxy View", 470, 480);
         
          
       
    }
    //set background black and add starts created with creatStars method
    public void prepare(){
         GreenfootImage bkg = getBackground();
        bkg.setColor(Color.BLACK);
        bkg.fill();
        createStars(300);
    }
    //create method for stars
     private void createStars(int number) 
    {
        GreenfootImage background = getBackground();             
        for (int i=0; i < number; i++)
        {          //declare variables used for X Y position  
             int x = Greenfoot.getRandomNumber( getWidth() );
             int y = Greenfoot.getRandomNumber( getHeight() );
             int color = 150 - Greenfoot.getRandomNumber(120);
             //set position 
             background.setColorAt(x, y, new Color(color,color,color));
        }
    }
}

