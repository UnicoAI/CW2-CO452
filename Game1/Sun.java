import greenfoot.*;


public class Sun extends ScrollActors
{
    public String NameImage;
    public static Actor scoreDisp; // actor displaying number of avoided rocks (unhit)
    public static int created, unhit; // class counts
    
    private int rSpeed = 2*QVAL-Greenfoot.getRandomNumber(4*QVAL+1); // tumble rate
    private int angle = 175*QVAL+Greenfoot.getRandomNumber(10*QVAL+1); // angular direction
    private int speed = QVAL/2+Greenfoot.getRandomNumber(2*QVAL)+created; // velocity
    
    public Sun()
    {
        created++; // bump counter
        setBoundedAction(REMOVE, 0); // set bounded action to remove when 50 past edge
    }
    public Sun(String NameImage){
         this.NameImage = NameImage;;

    getImage().scale(30,30);
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