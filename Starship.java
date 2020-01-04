import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Largest class in game.
 * Used to control the main actor (starship).
 * Determines interactions between starship and the environment around it.
 * 
 * @Dinu Wijetunga
 * @v1.3(21/01/2018)
 */
public class Starship extends Actor
{
    //a boolean used to check whether the starship is a live. Starts as true
    boolean isAlive = true;
    
    //A method used to create a random integer within a range of 2 numbers
    //Greenfoot does not have a built in method to do this
    public int getRandomCustomNumber(int start,int end)
    {
       //returns an integer between the two values inputted 
       int normal = Greenfoot.getRandomNumber(end-start+1);
       return normal+start;
       
    }
    //main act program -- runs continously 
    public void act() 
    {
        //checks if the if the alien is alive.
        if (isAlive == true){
            //allows the Starship to access class laserBlast
            Actor laserBlast;
            laserBlast = getOneObjectAtOffset(0,0,laserBlast.class);
            
            //checks which key was last pressed by user
            //Allows the program to check for single clicks (whereas getKey checks if the key is held down)
            String key = Greenfoot.getKey();
            //if the key is space, a the ship shoots a laser blast
            if ("space".equals(key)){
                //laser blast sound effect is played, and new blast is created
                Greenfoot.playSound("laser.mp3");
                getWorld().addObject(new laserBlast(), this.getX(), this.getY()-50);
            }
            
            //checks if the player is clicking any of the ship control keys
            //built redunacy so that player can use WASD or arrow keys
            else if ("up".equals(key) ||"w".equals(key)){
                //moves ship up 20 pixels
                setLocation(getX(), getY()-20);
                            }
            else if ("down".equals(key) ||"s".equals(key)){
                //moves ship down 20 pixels
                setLocation(getX(), getY()+20);
            }
            if(Greenfoot.isKeyDown("D") || Greenfoot.isKeyDown("right")){
                //moves ship right 8 pixels
                setLocation(getX()+8, getY());
            }
            if(Greenfoot.isKeyDown("A") || Greenfoot.isKeyDown("left")){
                //moves ship left 8 pixels
                setLocation(getX()-8, getY());
            }
            
            //checks if the ship has reached the top of the screen
            //used to create an infinite scrolling game
            if(getY() <= 1){
                //resets the ship to the bottom of the screen
                setLocation(getX(), 599);
                
                //removes all the actors from the screen
                getWorld().removeObjects(getWorld().getObjects(Rock.class));
                getWorld().removeObjects(getWorld().getObjects(Alien.class));
                getWorld().removeObjects(getWorld().getObjects(instructions.class));
                
                //sets integer randomValue equal to a number between 2 & 6
                int randomValue = getRandomCustomNumber(2,6);
                
                //spawns a random number of aliens 
                for(int i = 0; i < randomValue; i++){
                    //gets random x and y values
                    int x = Greenfoot.getRandomNumber(799);
                    int y  = Greenfoot.getRandomNumber(100);
                    //creates an alien at the randomized coordinates
                    getWorld().addObject(new Alien(), x, y);
                }
          
                //repeats the above process for rocks
                int randomValue2 = getRandomCustomNumber(7,12);
                for(int i = 0; i < randomValue2;i++){
                    int x = Greenfoot.getRandomNumber(799);
                    int y  = Greenfoot.getRandomNumber(500);
                    
                    getWorld().addObject(new Rock(), x, y);
                    
                }
            }
            //if the Starship is not at the edge of the screen, it moves up
            else{
                setLocation(getX(), getY()-3);  
            }
            
            //Allows starship to access Alien and Rock classes
            Actor Alien;
            Actor Rock;
            
            Alien = getOneObjectAtOffset(0,0,Alien.class);
            Rock = getOneObjectAtOffset(0,0,Rock.class);
            
            //checks if the alien collides into an Alien or Rock
            if(Alien != null || Rock != null){
                //if a collision is detcted an explosion sound is played        
                Greenfoot.playSound("explosionSound.mp3");
                //AThe explosion animaton
                setImage("explosion1.png");
                Greenfoot.delay(6);
                setImage("explosion2.png");
                Greenfoot.delay(6);
                setImage("explosion3.png");
                Greenfoot.delay(8);
                setImage("explosion4.png");
                Greenfoot.delay(6);
                setImage("explosion5.png");
                Greenfoot.delay(6);
                setImage("explosion6.png");
                Greenfoot.delay(6);
                setImage("explosion7.png");
                //the Spaceship transparency is set to 0
                getImage().setTransparency(0);
                //The restart game screen is added & all actos are removed
                Greenfoot.delay(10);
                getWorld().addObject(new restartGame(), 400, 350);
                getWorld().removeObjects(getWorld().getObjects(Rock.class));
                getWorld().removeObjects(getWorld().getObjects(Alien.class));
                getWorld().removeObjects(getWorld().getObjects(laserBlast.class));
                //moves scoreboard counter to the center of the screen
                Counter counter = background.getCounter();
                counter.setLocation(400, 400);
                //plays game over sound effect
                Greenfoot.playSound("gameOver.mp3");
                //sets variable isAlive to false, which wll later delete the ship
                isAlive = false;
            }
        }
        //if the spaceship is not alive, it is deleted from the world
        else if (isAlive == false){
            getWorld().removeObject(this);
        }
    }
    
}
