import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Metauniverse Game level 2 description intro
 * 
 * @author (Marius Boncica) 
 * @version (version2 10/01/2022)
 */
public class Galaxy2ndLevel extends World
{ 

    /**
     * Constructor for objects of class Quit.
     * 
     */
    public Galaxy2ndLevel()
    {    
        // Create a new world with 900x600 cells with a cell size of 1x1 pixels.
        super(900,600,1); 
        //add button to forward on Galaxy2ndLevel when clicked
        PlaySingle button = new PlaySingle();
        addObject(button,470,450);
          //arrange text display on screen
           showText("Single Player -  score: " + PlayerSingle.scor, 470, 50);
            showText("Drive Space Ship Around Earth To Protect Earth ", 300, 100);
            showText("Use Arrows to navigate ", 170, 140);
            showText("Mouse click to Shoot Aliens ", 170, 180);
            showText("Collect Points By Touching Satelites ", 200,220);
            showText("Press Space Bar To Remove Steroids--Needed 10 points", 300, 260);
            showText("Touch space balls to increase speed", 200, 300);
            showText("Time Limit 1 Minute", 170, 340);
          
            showText("Start", 470, 480);
         
       
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
        {            
             int x = Greenfoot.getRandomNumber( getWidth() );
             int y = Greenfoot.getRandomNumber( getHeight() );
             int color = 150 - Greenfoot.getRandomNumber(120);
             background.setColorAt(x, y, new Color(color,color,color));
        }
    }
    
}

