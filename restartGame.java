import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class restartGame here.
 * 
 * @Dinu Wijetunga
 * @v1.3(21/01/2018)
 */
public class restartGame extends Actor
{
    //boolean which states whether the player wants to restart the game or not
    boolean restartButton = true;
    
    public void act() 
    {
        //Allows the restartGame class to access class Starship
        Actor Starship;
        Starship = getOneObjectAtOffset(0,0,Starship.class);
        
        //if the player wants to restart the game, this screen is removed
        if (restartButton == false){
            getWorld().removeObject(this);
        }
        //checks if the player clicks shift to restart the game
        else if (Greenfoot.isKeyDown("shift")){
            //adds a new starship to the game 
            getWorld().addObject(new Starship(), 400, 590);
            //resets the counter and moves it back to the bottom right
            Counter counter = background.getCounter();
            counter.resetCounter();
            counter.setLocation(700, 550);
            //sets boolean restartButton to false, to delete this screen
            restartButton = false;
        }
        }
        
    }    

