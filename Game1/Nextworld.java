import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Nextworld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Nextworld extends Actor
{String NextworldName;
    public Nextworld(String NextworldName){
        this.NextworldName = NextworldName;
    setImage(this.NextworldName);
    getImage().scale(50,50);
    }
    /**
     * Act - do whatever the Nextworld wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
