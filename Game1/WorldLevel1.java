import greenfoot.*;

public class WorldLevel1 extends Scroll
{
    private Actor ship; // the main actor
    public static Counter planeLife = new Counter();
    private int timer = 1*60*55;
    public WorldLevel1()
    {
        super(800, 600, 1);
        // the background image
        GreenfootImage image = new GreenfootImage("galaxy.jpg");
        image.scale(getWidth(), getHeight());
        setBackground(image);
       // set scrolling fields
        setDirection(0);
        setScrollSpeed(2);
        // the ship
        addObject(ship = new Plane("spaces11.png"), getWidth()/8, getHeight()/8);
   Enemy.created = 0;
      
        
       // the actor to display the score (number of avoided rocks)
        addObject(Enemy.scoreDisp = new Actor(){}, 80, 20);
        Enemy.scoreDisp.setImage(new GreenfootImage(1, 1));
         Sun.created = 0;
    Sun.unhit = 0;
        
       // the actor to display the score (number of avoided rocks)
        addObject(Sun.scoreDisp = new Actor(){}, 40, 40);
        Earth.created = 0;
    Earth.unhit = 0;
        
       // the actor to display the score (number of avoided rocks)
        addObject(Earth.scoreDisp = new Actor(){}, 30, 60);
        Mars.created = 0;
    Mars.unhit = 0;
        
       // the actor to display the score (number of avoided rocks)
        addObject(Mars.scoreDisp = new Actor(){}, 20, 80);
    
    }
    
    public void act()
    {
        // keeps ship center screen
        setActorAt(ship, getWidth()/2, getHeight()/2);
         showText("WELCOME TO META UNIVERSE ", 470, 20);
            showText("Score: " + Plane.score, 100, 40);
      
        // timer:
      showText("Time left: "+ (timer%(60*55))/55, 450, 40 );
       
           
        // change worlds
        if ("enter".equals(Greenfoot.getKey())) {
        Greenfoot.setWorld(new Quit());}
    
        // scroll background image
        scrollBackground();
        // spawn rocks (with increasing frequency)
        if (Greenfoot.getRandomNumber(100-Enemy.created/10) == 0)
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
Greenfoot.delay(5);
Greenfoot.setWorld(new Quit());
   }
}
    
}
