import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Test for steps project.
 * 
 * @author Marius Boncica 
 * @version (1.01 8/12/2022)
 */
public class MyWorld extends World
{
int[][] map= { 
{1,1,1,3,1,1,6,1,1,1,3,1,1,1,1,1},
{1,1,1,3,6,3,3,1,1,1,6,1,1,1,1,1,1,1},
{1,1,1,3,3,5,1,1,1,1,5,1,1,1,1,1},
{1,1,1,6,3,1,1,1,1,5,1,1,1,1,1,1},
{1,1,1,1,1,1,5,1,1,1,1,1,1,1,1,1},
{1,1,1,1,1,1,1,1,6,1,1,1,1,1,1,1},
{1,1,1,0,0,1,1,1,1,1,1,1,1,1,1,1},
{1,1,1,0,0,1,1,1,1,1,1,1,1,1,1,1},
{1,1,1,0,0,1,1,1,1,1,1,1,1,1,1,1},
{1,1,1,2,2,1,1,5,1,1,5,1,1,1,1,1},
{1,1,1,2,2,1,1,6,1,6,1,1,1,1,1,1},
{1,1,1,2,2,1,1,1,1,1,1,1,1,1,1,1},
{5,1,1,1,1,1,1,5,1,1,1,1,1,5,1,1},
{1,1,1,5,1,1,1,1,1,1,5,1,1,1,1,1},
{5,1,1,1,1,1,1,5,1,1,1,1,1,5,1,1},
{1,1,1,5,1,1,1,1,1,1,5,1,1,1,1,1}
};
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(750, 750, 1);
        for(int i = 0; i<16;i++)
        for (int j =0; j<16; j++)
if (map[i][j]==0)

addObject(new Step1("universe.jpeg"),j*50,i*50);

else if(map[i][j] == 2)
addObject(new Step1("steel-ball.png"),j*50,i*50);



else if (map[i][j] == 3)
addObject(new Step1("steel-ball.png"),j*50,i*50);

else if (map[i][j] == 4)
addObject(new Step1("steel-ball.png"),j*50,i*50);
else if (map[i][j] == 5)
addObject(new Obstacle("space.gif"),j*50,i*50);
else if (map[i][j] == 6){

addObject(new Obstacle("airplane.png"),j*50,i*50);}

        prepare();
       
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
       
       
        Rus name = new Rus();
        addObject(name,375,710);
        setPaintOrder(Rus.class, Step1.class, Obstacle.class);
       
         
    }
    
}
