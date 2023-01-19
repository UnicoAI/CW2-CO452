import greenfoot.*;


public class Asteroid extends ScrollActors
{
    public String NameImage;
   
    
    private int rSpeed = 2*QVAL-Greenfoot.getRandomNumber(4*QVAL+1); // tumble rate
    private int angle = 175*QVAL+Greenfoot.getRandomNumber(10*QVAL+1); // angular direction
    private int speed = 0; // velocity
    
    public Asteroid()
    {
        
        setBoundedAction(REMOVE, 0); // set bounded action to remove when 50 past edge
    }
    public Asteroid(String NameImage){
         this.NameImage = NameImage;;

    getImage().scale(400,300);
    }
    
    public void act()
    {
        // turning
        turn(rSpeed);
        // moving
        move(speed, angle);
        // removed
        
      
    }
}