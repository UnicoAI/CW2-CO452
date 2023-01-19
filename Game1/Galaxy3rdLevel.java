import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Quit here.
 * 
 * @author (Marius Boncica) 
 * @version (version2 10/01/2022)
 */
public class Galaxy3rdLevel extends World
{ 

    /**
     * Constructor for objects of class Quit.
     * 
     */
    public Galaxy3rdLevel()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900,600,1); 
        
        Play button = new Play();
        addObject(button,470,450);
        showText("Player 1  -  score: " + Player1.scor, 150, 50);
           showText("Player 2 -  score: " + Player2.scor, 750, 50);
           
            showText("META UNIVERSE ", 470, 270);
          
            showText("Drive Space Ship Around Earth To Protect Earth ", 300, 100);
            showText("Use Arrows and W A S D to navigate ", 190, 140);
            showText("Mouse click to Shoot Aliens ", 170, 180);
            showText("Collect Points By Touching Satelites ", 200,220);
            showText("Press Space Bar To Remove Steroids--Needed 10 points", 300, 260);
            showText("Touch space balls to increase speed", 200, 300);
            showText("CLICK AND Q TO SHOOT", 170, 340);
            showText("Time Limit 1 Minute", 170, 380);
          
            showText("Start", 470, 480);
         
          
       
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

