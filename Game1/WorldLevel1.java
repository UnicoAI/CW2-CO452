import greenfoot.*;
/**
 * MetaUniverse level Galaxy view single player
 * 
 * @author (Marius Boncica) 
 * @version (version2 10/01/2022)
 */

public class WorldLevel1 extends Scroll
{//declare variables
    private Actor ship; // the main actor
    public static Counter planeLife = new Counter(); //counter
    private int timer = 1*60*55; //time limit to 1 minute
    //define constructor
    public WorldLevel1()
    {
        super(800, 600, 1);// the background image
        //image scale
        GreenfootImage image = new GreenfootImage("galaxy.jpg");
        image.scale(getWidth(), getHeight());
        setBackground(image);
       // set scrolling speed and direction
        setDirection(0);
        setScrollSpeed(2);
        // the ship
        addObject(ship = new Plane("spaces11.png"), getWidth()/8, getHeight()/8);
   
      
        
       // add enemey object
        addObject(Enemy.scoreDisp = new Actor(){}, 80, 20);
        Enemy.scoreDisp.setImage(new GreenfootImage(1, 1));
         Enemy.created = 0;
    
        
       // the actor to display the score
        addObject(Sun.scoreDisp = new Actor(){}, 40, 40);
        Earth.created = 0;
    Earth.unhit = 0;
        
       // the actor to display the score
        addObject(Earth.scoreDisp = new Actor(){}, 30, 60);
        Mars.created = 0;
    Mars.unhit = 0;
        
       // the actor to display the score 
        addObject(Mars.scoreDisp = new Actor(){}, 20, 80);
    
    }
    
    public void act()
    {
        // keeps ship center screen
        setActorAt(ship, getWidth()/2, getHeight()/2);
        //add text on screen to customize user experience
         showText("WELCOME TO META UNIVERSE ", 470, 20);
            showText("Score: " + Plane.score, 100, 40);
      
        // timer:
      showText("Time left: "+ (timer%(60*55))/55, 450, 40 );
       
           
        // change worlds
        if ("enter".equals(Greenfoot.getKey())) {
        Greenfoot.setWorld(new Menu());}
    
        // scroll background image
        scrollBackground();
        // spawn alienships (with increasing frequency)
        if (Greenfoot.getRandomNumber(200-Enemy.created/10) == 0)
        {
            int y = Greenfoot.getRandomNumber(getHeight());
            addObject(new Enemy(), getWidth()+40, y);
        }
         if (Greenfoot.getRandomNumber(200-Sun.created/10) == 0)
        {
            int y = Greenfoot.getRandomNumber(getHeight());
            addObject(new Sun(), getWidth()+40, y);
        }
        if (Greenfoot.getRandomNumber(200-Earth.created/10) == 0)
        {
            int y = Greenfoot.getRandomNumber(getHeight());
            addObject(new Earth(), getWidth()+40, y);
        }
        if (Greenfoot.getRandomNumber(250-Mars.created/10) == 0)
        {
            int y = Greenfoot.getRandomNumber(getHeight());
            addObject(new Mars(), getWidth()+40, y);
        }
        //function when time ends and display text according the number of points 
        if (--timer == 0)
    {
        removeObjects(getObjects(null));
        Greenfoot.stop();
        if(Plane.score >= 0){
        showText("YOU WON ||| Score: " + Plane.score, 350,200);
}


else if(Plane.score < 0){
showText("You Loose ||| Score  "+ Plane.score, 450,300);
}
//delay response
Greenfoot.delay(5);
//enter new world
Greenfoot.setWorld(new Menu());
   }
}
    
}
