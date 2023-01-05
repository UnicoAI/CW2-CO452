import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Test for steps project.
 * 
 * @author Marius Boncica 
 * @version (1.01 8/12/2022)
 */
public class Step1 extends Actor
{
    private String img;
    private GifImage gif;
    GifImage myGif = new GifImage("sunearth.gif");

    /**
     * Act - do whatever the Step1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    
    

   public Step1(String img)
    {
     this.img = img;
        gif = new GifImage( img );
      
  }

    public void act()
    { 
setImage( myGif.getCurrentImage() );
        // Add sayour action code here.
    }
}
