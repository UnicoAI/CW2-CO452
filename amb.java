import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class amb here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class amb extends Actor
{
    private int dx;
    private int dy;
    /**
     * Act - do whatever the amb wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add ymour action code here.
        move();
        checkCollisions();
        collectDead();
    }
    public void move(){
       if(Greenfoot.isKeyDown("w") ){
        setLocation(getX(), getY()-2);
    }
    else if(Greenfoot.isKeyDown("a")){
        move(-2);
    }
    else if(Greenfoot.isKeyDown("s")){
        setLocation(getX(), getY()+2);
    }
    else if(Greenfoot.isKeyDown("d")){
        move(+2);
}
}
private void checkCollisions(){
    if(getOneIntersectingObject(house.class) != null)
    {setLocation(getX()-2, getY()+2);
   return;
}
}
private void collectDead(){
    if(getOneIntersectingObject(deadpeople.class) !=null)
    {removeTouching(deadpeople.class);
        return;
    }
}
}
