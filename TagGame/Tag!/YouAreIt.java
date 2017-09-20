import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class YouAreIt here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class YouAreIt extends Actor
{
    private int x;
    private int y;
    private PlayerOne blue;
    private PlayerTwo red;
    private PlayerThree green;
    private PlayerFour black;
    private int start;
    private int bigfarts;
    /**
     * Act - do whatever the YouAreIt wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        follow();
        tag();
    }    
    public YouAreIt(PlayerOne b, PlayerTwo r, PlayerThree g, PlayerFour bl)
    {
        setImage("youareit.png");
        blue=b;
        red=r;
        green=g;
        black=bl;
        bigfarts=random();
    }
    public int random()
    {
        int lol=Greenfoot.getRandomNumber(3);
        return lol;
    }
    public int returnFarts()
    {
        return bigfarts;
    }
    public void follow()
    {
        if(blue.it())
        {
            x=blue.returnX();
            y=blue.returnY();
            setLocation(x,y);
        }
        else if(red.it())
        {
            x=red.returnX();
            y=red.returnY();
            setLocation(x,y);
        }
        else if(green.it())
        {
            x=green.returnX();
            y=green.returnY();
            setLocation(x,y);
        }
        else if(black.it())
        {
            x=black.returnX();
            y=black.returnY();
            setLocation(x,y);
        }
    }
    public void tag()
    {
        if(blue.isTaggingRed()&&blue.it()==true)
        {
            blue.tag();
            red.tagged();
            red.reset();
            blue.reset();
            Greenfoot.playSound("tag.mp3");
        }
        if(blue.isTaggingGreen()&&blue.it()==true)
        {
            blue.tag();
            green.tagged();
            green.reset();
            blue.reset();
            Greenfoot.playSound("tag.mp3");
        }
        if(blue.isTaggingBlack()&&blue.it()==true)
        {
            blue.tag();
            black.tagged();
            black.reset();
            blue.reset();
            Greenfoot.playSound("tag.mp3");
        }
        if(red.isTaggingBlue()&&red.it()==true)
        {
            blue.tagged();
            red.tag();
            blue.reset();
            red.reset();
            Greenfoot.playSound("tag.mp3");
        }
        if(red.isTaggingGreen()&&red.it()==true)
        {
            green.tagged();
            red.tag();
            green.reset();
            red.reset();
            Greenfoot.playSound("tag.mp3");
        }
        if(red.isTaggingBlack()&&red.it()==true)
        {
            black.tagged();
            red.tag();
            black.reset();
            red.reset();
            Greenfoot.playSound("tag.mp3");
        }
        if(green.isTaggingBlue()&&green.it()==true)
        {
            green.tag();
            blue.tagged();
            blue.reset();
            green.reset();
            Greenfoot.playSound("tag.mp3");
        }
        if(green.isTaggingRed()&&green.it()==true)
        {
            green.tag();
            red.tagged();
            red.reset();
            green.reset();
            Greenfoot.playSound("tag.mp3");
        }
        if(green.isTaggingBlack()&&green.it()==true)
        {
            green.tag();
            black.tagged();
            black.reset();
            green.reset();
            Greenfoot.playSound("tag.mp3");
        }
        if(black.isTaggingBlue()&&black.it()==true)
        {
            black.tag();
            blue.tagged();
            blue.reset();
            black.reset();
            Greenfoot.playSound("tag.mp3");
        }
        if(black.isTaggingRed()&&black.it()==true)
        {
            black.tag();
            red.tagged();
            red.reset();
            black.reset();
            Greenfoot.playSound("tag.mp3");
        }
        if(black.isTaggingGreen()&&black.it()==true)
        {
            black.tag();
            green.tagged();
            green.reset();
            black.reset();
            Greenfoot.playSound("tag.mp3");
        }
        
    }
}
