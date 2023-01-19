import greenfoot.*;
/**
 * Author: Marius Daniel Boncica- Group project
 * UPDATE 14/12/2022 Asteroid class to be removed
 */

public class Asteroid extends ScrollActors
{//declare speed, angle rotation variables
    public String NameImage;
   
    
    private int rSpeed = 2*QVAL-Greenfoot.getRandomNumber(4*QVAL+1); // tumble rate
    private int angle = 175*QVAL+Greenfoot.getRandomNumber(10*QVAL+1); // angular direction
    private int speed = 0; // velocity
    /**
 * Constructor
 * remove when past 50 edge
 */
    public Asteroid()
    {
        
        setBoundedAction(REMOVE, 0); // set bounded action to remove when 50 past edge
    }
    //scale image
    public Asteroid(String NameImage){
         this.NameImage = NameImage;;

    getImage().scale(400,300);
    }
    /**
 * method act
 * move and turn
 */
    public void act()
    {
        // turning
        turn(rSpeed);
        // moving
        move(speed, angle);
        // removed
        
      
    }
}