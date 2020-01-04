import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Main Background class. Creates world and starship actor
 * 
 * @Dinu Wijetunga
 * @v1.3(21/01/2018)
 */
public class background extends World
{
    
    /**
     * Constructor for objects of class background.
     * 
     */
    
    //Allows background to access starship actor and make changes to it
    Starship starship; 
    //ArrayList<Rock> rock = new ArrayList<Rock>();
    
    //creates new instance of scoreboard counter
    static Counter theCounter;
    
    
    public background()
    {    
        // Create a new world with 800x600 cells with a cell size of 1x1 pixels.
        super(800, 600, 1);
        //starts game and prepares world
        Greenfoot.start();
        prepare();
        
        
    }
    //used to get the value produced by scoreboard counter
    public static Counter getCounter()
    {
        return theCounter;
    }

    //Creates new actors required to play game
    private void prepare()
    {
        //displays instructions in middle of screen
        instructions instructions = new instructions();
        addObject(instructions, 400, 300);
        //adds spaceship (main actor) to game in bottom center of screen
        starship = new Starship();
        addObject(starship,400,600);
        //adds scoreboard (counter) to the game in bottom right of game
        theCounter = new Counter();
        addObject(theCounter, 700,550);
        }
            

    

    
}
