import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Quit here.
 * 
 * @author (Marius Boncica) 
 * @version (version2 10/01/2022)
 */
public class Quit extends World
{ 

    /**
     * Constructor for objects of class Quit.
     * 
     */
    public Quit()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900,600,1); 
        
        PlayMenu button = new PlayMenu();
        addObject(button,270,450);
         PlaySingleMenu button1 = new PlaySingleMenu();
        addObject(button1,670,450);
        GalaxySingleMenu button2 = new GalaxySingleMenu();
        addObject(button2,470,450);
          showText("Player 1  -  score: " + Player1.scor, 150, 50);
           showText("Player 2 -  score: " + Player2.scor, 750, 50);
           showText("Single Player -  score: " + PlayerSingle.scor, 470, 50);
            showText("META UNIVERSE ", 470, 270);
            showText("Multi Players ", 270, 480);
            showText("Single Player", 670, 480);
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

