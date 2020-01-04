import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Alien class. Determines what happens in the case of the alien dying,
 * moving off screen and getting shot at
 * 
 * @Dinu Wijetunga
 * @v1.3(21/01/2018)
 */
public class Alien extends Actor
{
    /**
     * Runs the mian actions inside class Alien continuously 
     */
    public void act() 
    {
      //Allows alien to access laserBlast, to determine collisons
      Actor laserBlast;
      laserBlast = getOneObjectAtOffset(0,0,laserBlast.class);
      
      //checks if the alien moves off screen, and deletes it if it does
      if (getY() >= 599){
          getWorld().removeObject(this);
          
        }
        
      //checks if the laserBlast hit the alien, then runs the commands
      else if (laserBlast != null){
          //plays the alien death sound and deltes the laser blast
          Greenfoot.playSound("alienDeath.mp3");
          getWorld().removeObject(laserBlast);
          //runs alien death animation when the alien is hit
          setImage("alienDeath1.png");
          Greenfoot.delay(1);
          setImage("alienDeath2.png");
          Greenfoot.delay(1);
          setImage("alienDeath5.png");
          Greenfoot.delay(1);
          setImage("alienDeath6.png");
          Greenfoot.delay(1);
          setImage("alienDeath8.png");
          Greenfoot.delay(1);
          //makes the image transparent and removes the alien
          getImage().setTransparency(0);
          getWorld().removeObject(this);
          //adds 1 point to the score
          Counter counter = background.getCounter();
          counter.bumpCount(1);
        }
      //if the alien is not hit by a laser or at the end of the screen,
      //the alien moves forward
      else{
        setLocation(getX(), getY()+3);
    }
    }    
}
