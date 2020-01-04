import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The scoreboard, which tracks how many aliens the player has destroyed.
 * Resets after each game over
 * 
 * @Dinu Wijetunga
 * @v1.3(21/01/2018)
 */
public class Counter extends Actor
{
    //declares the integer variable that counts score
    private int totalCount = 0;
    //a method which creates a new scoreboard
    public Counter(){
        setImage(new GreenfootImage("Score: 0", 35, Color.WHITE, new Color(0,0,0,200)));
    }
    //a method which resets the scoreboard score to 0
    public void resetCounter(){
        setImage(new GreenfootImage("Score: 0", 35, Color.WHITE, new Color(0,0,0,200)));
        totalCount = 0;
    }
    //method used to count score and increment score each time it is called
    public void bumpCount(int amount) 
    {
        totalCount += amount;
        setImage(new GreenfootImage("Score: " + totalCount, 35, Color.WHITE, new Color(0,0,0,200)));
    }    
}
