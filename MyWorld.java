import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
private amb amb;
private house house;
private Score Score;
private deadpeople deadpeople;

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        amb = new amb();
        house = new house();
        Score = new Score();
        deadpeople = new deadpeople();
     
        addObject(amb, 50,250);
        addObject(house, 20, 100);
        addObject(house, 40, 300);
        addObject(Score,20,20);
        addObject(deadpeople, 200, 200);
        
    }
}
