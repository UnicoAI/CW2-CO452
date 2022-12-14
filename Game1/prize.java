import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Author Marius Daniel Boncica
 * updated 14/12/2022
 */
public class prize extends Actor
{
    int speed = 3;
    public void act() 
    {
        move(speed);
        if(isAtEdge()) turn(20);
    }    
}
