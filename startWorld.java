import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The first scree nthat the player sees when playing the game
 * Starts basic functions of game
 * 
 * @Dinu Wijetunga
 * @v1.3 (21/01/2018)
 */
public class startWorld extends World
{
    //Constructor for world
    public startWorld()
    {    
        // Create a new world with 800x600 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        prepare();
    }
    
    //sets up the initial world 
    private void prepare()
    {
        //adds ins new start screen actor at the center of the screen
        startScreen startScreen = new startScreen();
        addObject(startScreen,400,300);
        
        //plays background music
        Greenfoot.playSound("backgroundMusic.mp3");
    }
    //act runs continously
    public void act(){
        //checks if player presses space to being game
        if (Greenfoot.isKeyDown("space")){
            //plays game by creating a background class
            Greenfoot.setWorld(new background());
            
        }
    }
}
