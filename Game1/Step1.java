import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 *Step1-- center background of the world modified for 3d effect
 * 
 * @author Marius Boncica 
 * @version (1.01 8/12/2022)
 */
//constructor gif image
public class Step1 extends Actor
{
    private String img;
    private GifImage gif;
    GifImage myGif = new GifImage("sunearth.gif");

  
   public Step1(String img)
    {
     this.img = img;
        gif = new GifImage( img );
      
  }
//act method: set image current
    public void act()
    { 
setImage( myGif.getCurrentImage() );
        // Add sayour action code here.
    }
}
