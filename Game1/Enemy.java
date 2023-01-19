import greenfoot.*;

//Author : Marius Boncica
//Updated jan  2023
public class Enemy extends ScrollActors
{
    public String NameImage;
    public static Actor scoreDisp; 
    public static int created; // class counts
    
    private int rSpeed = 2*QVAL-Greenfoot.getRandomNumber(4*QVAL+1); // tumble rate
    private int angle = 175*QVAL+Greenfoot.getRandomNumber(10*QVAL+1); // angular direction
    private int speed = QVAL/2+Greenfoot.getRandomNumber(2*QVAL)+created; // velocity
    
    public Enemy()
    {
        created++; // bump counter
        setBoundedAction(REMOVE, 50); // set bounded action to remove when 50 past edge
    }
    public Enemy(String NameImage){
         this.NameImage = NameImage;;

    getImage().scale(150,150);
    }
    
    public void act()
    {
        touchPlane();// turning
        turn(rSpeed);
               // moving
 move(speed, angle);
 
        // removed when touch projectile
        touchProjectile();
      
    }
    public void touchProjectile(){
        Actor bullet = getOneIntersectingObject(Projectile.class);
        if( isTouching(Projectile.class ) ){
            getWorld().removeObject(bullet);
            getWorld().removeObject(this);
        }            
            
               
    }
    public void touchPlane(){
        
         int dir = 1-2*((getRotation()+90)/180);
          
        if( isTouching(Plane.class ) )

setRotation(135+90*(1-dir)+Greenfoot.getRandomNumber(91));
    }
  
    
}