import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TagWorld extends World
{
    private PlayerOne blue;
    private PlayerTwo red;
    private PlayerThree green;
    private PlayerFour black;
    private YouAreIt youareit;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public TagWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(700, 450, 1); 
        blue=new PlayerOne();
        addObject(blue, 20, 20);
        red=new PlayerTwo();
        addObject(red, 700, 20);
        green=new PlayerThree();
        addObject(green, 20, 480);
        black=new PlayerFour();
        addObject(black, 700, 480);
        youareit=new YouAreIt(blue, red, green, black);
        addObject(youareit, 300, 300);
        blue.setRedPlayer(red);
        blue.setGreenPlayer(green);
        blue.setBlackPlayer(black);
        red.setBluePlayer(blue);
        red.setGreenPlayer(green);
        red.setBlackPlayer(black);
        green.setBluePlayer(blue);
        green.setRedPlayer(red);
        green.setBlackPlayer(black);
        black.setBluePlayer(blue);
        black.setRedPlayer(red);
        black.setGreenPlayer(green);
        blue.setYouAreIt(youareit);
        red.setYouAreIt(youareit);
        green.setYouAreIt(youareit);
        black.setYouAreIt(youareit);
    }
    public void act()
    {
        showText("blue: "+blue.getTime(),300,225);
        showText("red: "+red.getTime(),300,255);
        showText("green: "+green.getTime(),300,275);
        showText("black: "+black.getTime(),300,295);
    }
}
