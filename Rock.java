import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Sets up the rock which acts as an obstacle to the starship
 * 
 * @Dinu Wijetunga
 * @v1.3(21/01/2018)
 */

//Starship is the parent class of Rock
public class Rock extends Starship
{
    public void act() 
    {
      //allows Rock to access class laserBlast
      Actor laserBlast;
      laserBlast = getOneObjectAtOffset(0,0,laserBlast.class);
      
      //if the laserBlast hits a rock, the blast is removed from the world
      if (laserBlast != null){
          getWorld().removeObject(laserBlast);
          
        }
    }      
}
