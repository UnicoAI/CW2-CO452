import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
  * Test for steps project.
 * 
 * @author Marius Boncica 
 * @version (1.01 8/12/2022)
 */
public class Rus extends Actor

{ protected Rus rus;
       protected int width;
    protected int height;
    protected String Name;
    protected GreenfootImage image;
    GifImage myGif = new GifImage("star.gif");
    private GreenfootImage myImage = getImage();
    private String[] imageNames = {"space.gif", "star.gif","space.gif"};
    private int currentImage = 0;
    int xPos;
    int yPos;
    public void addedToWorld(World w){
    xPos=getX();
yPos = getY();}
  /**
     * Act - do whatever the plane wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Rus(){
              myGif.getCurrentImage().scale(getImage().getWidth()/20, getImage().getHeight()/20);
 

   }
  public void scaleDown(int x, int y){
      xPos=x;
      yPos=y;
      myGif.getCurrentImage().scale(getImage().getWidth()/xPos, getImage().getHeight()/yPos);
 
  }
   
    public void act()
    {
        // Add ymoverour action code here.
        setImage( myGif.getCurrentImage());
 
        mover();
        bomb();
        move(0);
       youLoose();
       youWin();
        Greenfoot.start();
     
       
    }

public void mover(){

    if(Greenfoot.isKeyDown("w") ){
        setLocation(getX(), getY()-10);
           if(youLoose()){
            getWorld().showText("You Lose!!!!Hahhahaha!!!!", getWorld().getWidth()/2, 200);
    Greenfoot.stop();
        }
        
    }
    else if(Greenfoot.isKeyDown("a"))
        move(-10);
           if(youLoose()){
            getWorld().showText("You Lose!!!!Hahhahaha!!!!", getWorld().getWidth()/2, 200);
    Greenfoot.stop();
        }
       
    else if(Greenfoot.isKeyDown("s"))
        setLocation(getX(), getY()+10);
       if(youLoose()){
            getWorld().showText("You Lose!!!!Hahhahaha!!!!", getWorld().getWidth()/2, 200);
    Greenfoot.stop();
        }
    else if(Greenfoot.isKeyDown("d"))
        move(+10);
         if(youLoose()){
            getWorld().showText("You Lose!!!!Hahhahaha!!!!", getWorld().getWidth()/2, 200);
    Greenfoot.stop();
        }
    
}
public void bomb(){
    World w = getWorld();
    if (Greenfoot.isKeyDown("space")){
        w.addObject(new Step1("space.gif"),getX()+160 , getY()+1);
        move(10);
        if(youLoose()){
            getWorld().showText("You Lose!!!!Hahhahaha!!!!", getWorld().getWidth()/2, 200);
    Greenfoot.stop();
        }
    }
}
    public boolean youLoose(){
    if(isTouching(Obstacle.class ) && !isTouching(Step1.class)){
    return true;} else{return false;}
}
  public void Stage2(){
    if(isTouching(Nextworld.class )){
    getWorld().showText("You Win!!!!Hahhahaha!!!!", getWorld().getWidth()/2, 200);
    Greenfoot.stop();
    }
}
public void youWin(){
    if(getY()<60)
    getWorld().showText("You are a Winner!!!", getWorld().getWidth()/2 , 200);
    Greenfoot.stop();
    

}

}