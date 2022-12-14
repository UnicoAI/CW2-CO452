import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Test for steps project.
 * 
 * @author Marius Boncica 
 * @version (1.01 8/12/2022)
 */
public class Step1 extends Actor
{
    /**
     * Act - do whatever the Step1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    String image;
   
    public Step1(String imageName)
    {
        image = imageName;
        setImage(this.image);
    getImage().scale(50,50);
    }
    public void act()
    {
        // Add your action code here.
    }
}
