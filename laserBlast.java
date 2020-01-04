import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Controls simple actions of the laser blast shot from the Starship
 * 
 * @Dinu Wijetunga
 * @v1.3(21/01/2018)
 */
public class laserBlast extends Actor
{
    /**
     * Act method runs continuosly 
     */
    public void act() 
    {
        //checks if the laser blast has reached the end of the world
        if (getY() <= 1){
          //if the laser blast reaches the end, it is deleted  
          getWorld().removeObject(this);
        }
        //if the laser blast is not at the edge of the screen, it moves up
        else{
            setLocation(getX(), getY()-12);
        }                
    }    
}
