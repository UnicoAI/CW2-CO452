import greenfoot.*;

/**
 * CLASS: Scroll (subclass of World)<br>
 * AUTHOR: danpost (greenfoot.org username)<br>
 * DATE: February 9, 2015<br>
 * MODIFIED: February 10, 2015 (made grid world compatible)
 * <br>
 * DESCRIPTION: a support superclass for an infinite scrolling world;
 * capable of horizontal, vertical or universal scrolling;
 * scrolls either independent of any actor or by following an actor;
 * scrolls background with or without actor relocations;
 * capable of scrolling actors without scrolling the background image;
 * capable of limited scrolling as access to field values are provided
 * through getter methods;<br>
 * <br>
 * The only limitation, which may be dealt with in a later update, is that
 * the scrolling background image is obtained from the world background
 * set at the time the direction of scrolling is set -- however, this would
 * complicate the code with more fields, checks and controls;
 */
public class Scroll extends World
{
    private GreenfootImage bg; // the scrolling background image
    private int scrollDirX, scrollDirY; // the scrolling directions along both axes
    private int scrollSpeed; // the scrolling speed
    private int scrollX, scrollY; // the current scrolled offset values
    
    /** basic World constructor call */
    public Scroll(int w, int h, int c) { super(w, h, c); }
    /** basic World constructor call (2) */
    public Scroll(int w, int h, int c, boolean b) { super(w, h, c, b); }
    /** sets the direction for future scrolling (left, right, up, or down);
     * the current world background image will be used for scrolling;
     * @param dir the rotational angle for movement divided by 90 */
    public void setDirection(int dir)
    {
        // determine scrolling directions along both axes
        dir = dir%4;
        scrollDirX = (1-dir)*((dir+1)%2);
        scrollDirY = (2-dir)*(dir%2);
        // initialize fields for background image scrolling
        bg = new GreenfootImage(getBackground());
        scrollX = 0;
        scrollY = 0;
    }
    /**
     * scrolls the background image using current field values
     */
    public void scrollBackground()
    {
        // set new scroll offsets
        scrollX = (scrollX-scrollDirX*scrollSpeed+getWidth())%getWidth();
        scrollY = (scrollY-scrollDirY*scrollSpeed+getHeight())%getHeight();
        // draw scrolling image onto background image
        getBackground().drawImage
        (
            bg,
            scrollX*getCellSize(),
            scrollY*getCellSize()
        );
        getBackground().drawImage
        (
            bg,
            ((scrollX-getWidth())*scrollDirX*scrollDirX)*getCellSize(),
            ((scrollY-getHeight())*scrollDirY*scrollDirY)*getCellSize()
        );
    }
    
    /** scrolls all movable actors using current field values;<br><br>
     * NOTE: this method is for use in projects using the QActor class by danpost;
     * if not using that class, remove this method and un-comment the other
     * 'scrollActors' method */
    public void scrollActors()
    {
        // scroll actors in world
        for (Object obj : getObjects(null))
        {
            // see if actor is of QActor type
            if (obj instanceof ScrollActors)
            {
                // scroll QActor object
                ScrollActors actor = (ScrollActors)obj;
                actor.setQLocation
                (
                    actor.getQX()-scrollDirX*scrollSpeed*ScrollActors.QVAL,
                    actor.getQY()-scrollDirY*scrollSpeed*ScrollActors.QVAL
                );
            }
            else
            {
                // scroll non-QActor object
                Actor actor = (Actor)obj;
                actor.setLocation
                (
                    actor.getX()-scrollDirX*scrollSpeed,
                    actor.getY()-scrollDirY*scrollSpeed
                );
            }
        }
    }
    /** scrolls all movable actors using current field values;<br><br>
     * NOTE: this method is for use in projects not using the QActor class by danpost;
     * if not using that class, remove the other 'scrollActors' method and un-comment
     * this one */
    //     public void scrollActors()
    //     {
    //         // scroll actors in world
    //         Actor actor = (Actor)obj;
    //         actor.setLocation
    //         (
    //             actor.getX()-scrollDirX*scrollSpeed,
    //             actor.getY()-scrollDirY*scrollSpeed
    //         );
    //     }
    /** scrolls the background and all movable actors using current field values */
    public void scrollAll()
    {
        // scroll background image
        scrollBackground();
        // scroll actors in world
        scrollActors();
    }
    /** scrolls the background and all movable actors using current field values so that
     * the given actor is scrolled to the location coordinates given;
     * @param actor the actor whose location is to be adjusted
     * @param x the coordinate along the x-axis at which the actor is to be placed
     * @param y the coordinate along the y-axis at which the actor is to be placed */
    public void setActorAt(Actor actor, int x, int y)
    {
        // ensure actor is in world
        if (actor.getWorld() != this) return;
        // scroll all horizontally getting actor to its new x-coordinate location
        setScrollSpeed(actor.getX()-x);
        setDirection(0);
        scrollAll();
        // scroll all vertically getting actor to its new y-coodinate location
        setScrollSpeed(actor.getY()-y);
        setDirection(1);
        scrollAll();
    }
    /** returns the scrolling direction along the x-axis
     * ('1' for right, '0' for none and '-1' for left)
     * @return direction of horizontal scrolling */
    public int getDirectionX() { return scrollDirX; }
    /** returns the scrolling direction along the y-axis
     * ('1' for down, '0' for none and '-1' for up)
     * @return direction of vertical scrolling */
    public int getDirectionY() { return scrollDirY; }
    /** returns the current scrolled amount along the x-axis
     * @return current distance horizontally scrolled */
    public int getScrollX() { return scrollX; }
    /** returns the current scrolled amount along the y-axis
     * @return current distance vertically scrolled */
    public int getScrollY() { return scrollY; }
    /** returns the current value set for the speed of scrolling
     * @return the current scrolling speed */
    public int getScrollSpeed() { return scrollSpeed; }
    /** sets the value for the speed of future scrolling to the given value
     * @param speed the value to set the speed of scrolling to */
    public void setScrollSpeed(int speed) { scrollSpeed = speed; }
}