import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayerOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerThree extends Actor
{
    private GreenfootImage[] activeFrames;
    private GreenfootImage[] runningFrames;
    private GreenfootImage[] runningFramesLeft;
    private GreenfootImage[] idleFrames;
    private int currentFrame;
    private int speed;
    private int x;
    private int y;
    private boolean notInsideBoost;
    private boolean notInsideSand;
    private boolean notInsideWater;
    private boolean it;
    private PlayerTwo red;
    private PlayerOne blue;
    private PlayerFour black;
    private YouAreIt youareit;
    private boolean tagOnce;
    private int time;
    /**
     * Act - do whatever the PlayerOne wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        GreenfootImage img = activeFrames[currentFrame];
        setImage(img);
        currentFrame++;
        x=getX();
        y=getY();
         if(currentFrame>=activeFrames.length)
        {
            currentFrame = 0;
        }
        walking();
        speedBoost();
        sandPit();
        water();
        if(it==true)
        {
            time--;
        }
        if(time<=0)
        {
            GreenLose aaron=new GreenLose();
            Greenfoot.setWorld(aaron);
        }
        //if(youareit.returnFarts()==2)
        //{
        //    it=true;
        //}
    }    
    public PlayerThree()
    {
        speed=8;
        setImage("green/0.png");
        runningFrames=new GreenfootImage[8];
        for(int i=0;i<runningFrames.length;i++)
        {
            runningFrames[i]=new GreenfootImage("green/"+i+".png");
        }
        runningFramesLeft=new GreenfootImage[8];
        for(int i=0;i<runningFramesLeft.length;i++)
        {
            runningFramesLeft[i]=new GreenfootImage("green/"+i+".png");
            runningFramesLeft[i].mirrorHorizontally();
        }
        activeFrames=runningFrames;
        runningFramesLeft[0].mirrorHorizontally();
        idleFrames=new GreenfootImage[1];
        idleFrames[0]=new GreenfootImage("green/0.png");
        currentFrame=0;
        notInsideBoost=true;
        notInsideSand=true;
        notInsideWater=true;
        it=false;
        tagOnce=true;
        time=1000;
    }
    public void checkKeyboard()
    {
        int x = getX();
        int y = getY();
        if ( Greenfoot.isKeyDown( "g" ) )
        {
            setLocation( x - speed, y);
            activeFrames=runningFramesLeft;
        }  
        else if ( Greenfoot.isKeyDown( "j" ) )
        {
            setLocation( x + speed, y);
            activeFrames=runningFrames;
        }
        else if (Greenfoot.isKeyDown( "y" ) )
        {
            setLocation(x, y-speed);
            activeFrames=runningFrames;
        }
        else if (Greenfoot.isKeyDown( "h"  ) )
        {
            setLocation(x,y+speed);
            activeFrames=runningFrames;
        }
        else
        {
            currentFrame=0;
            activeFrames=idleFrames;
            
        }
    }
    public void wallLeft()
    {
        int x=getX();
        int y=getY();
            if ( Greenfoot.isKeyDown( "g" ) )
        {
            setLocation( x - speed, y);
            activeFrames=runningFramesLeft;
        }  
        else if (Greenfoot.isKeyDown( "y" ) )
        {
            setLocation(x, y-speed);
            activeFrames=runningFrames;
        }
        else if (Greenfoot.isKeyDown( "h"  ) )
        {
            setLocation(x,y+speed);
            activeFrames=runningFrames;
        }
        else
        {
            currentFrame=0;
            activeFrames=idleFrames;
            
        }
    }
    public void wallUp()
    {
        int x = getX();
        int y = getY();
        if ( Greenfoot.isKeyDown( "g" ) )
        {
            setLocation( x - speed, y);
            activeFrames=runningFramesLeft;
        }  
        else if ( Greenfoot.isKeyDown( "j" ) )
        {
            setLocation( x + speed, y);
            activeFrames=runningFrames;
        }
        else if (Greenfoot.isKeyDown( "y" ) )
        {
            setLocation(x, y-speed);
            activeFrames=runningFrames;
        }
        else
        {
            currentFrame=0;
            activeFrames=idleFrames;
            
        }
    }
    public void wallDown()
    {
        int x = getX();
        int y = getY();
        if ( Greenfoot.isKeyDown( "g" ) )
        {
            setLocation( x - speed, y);
            activeFrames=runningFramesLeft;
        }  
        else if ( Greenfoot.isKeyDown( "j" ) )
        {
            setLocation( x + speed, y);
            activeFrames=runningFrames;
        }
        else if (Greenfoot.isKeyDown( "h"  ) )
        {
            setLocation(x,y+speed);
            activeFrames=runningFrames;
        }
        else
        {
            currentFrame=0;
            activeFrames=idleFrames;
            
        }
    }
    public void wallRight()
    {
        int x = getX();
        int y = getY();
        if ( Greenfoot.isKeyDown( "j" ) )
        {
            setLocation( x + speed, y);
            activeFrames=runningFrames;
        }
        else if (Greenfoot.isKeyDown( "y" ) )
        {
            setLocation(x, y-speed);
            activeFrames=runningFrames;
        }
        else if (Greenfoot.isKeyDown( "h"  ) )
        {
            setLocation(x,y+speed);
            activeFrames=runningFrames;
        }
        else
        {
            currentFrame=0;
            activeFrames=idleFrames;
            
        }
    }
    public void walking()
    {
        if(x<500&&x>483&&y<330&&y>270)
        {
            wallLeft();
        }
        else if(x<565&&x>485&&y<285&&y>270)
        {
            wallUp();
        }
        else if (x>550&&x<568&&y<330&&y>270)
        {
            wallRight();
        }
        else if (x<565&&x>485&&y<340&&y>315)
        {
            wallDown();
        }
        else checkKeyboard();
        
        
    }
    public void speedBoost()
    {
        if (x>100&&x<220&&y>50&&y<120&&notInsideBoost)
        {
            speed+=15;
            notInsideBoost=false;
        }
        else if(notInsideSand&&notInsideWater)
        {
            speed=8;
            notInsideBoost=true;
        }
    }
    public void sandPit()
    {
        if (x>100&&x<270&&y>250&&y<340&&notInsideSand)
        {
            speed-=7;
            notInsideSand=false;
        }
        else if(notInsideBoost&&notInsideWater)
        {
            speed=8;
            notInsideSand=true;
        }
    }
    public void water()
    {
        if(x>400&&x<585&&y>80&&y<155&&notInsideWater)
        {
            speed-=6;
            notInsideWater=false;
        }
        else if (notInsideBoost&&notInsideSand)
        {
            speed=8;
            notInsideWater=true;
        }
    }
    public int returnX()
    {
        int lol=getX();
        return lol;
    }
    public int returnY()
    {
        int lol=getY();
        return lol;
    }
    public boolean it()
    {
        return it;
    }
    public void reset()
    {
        setLocation(50, 450);
    }
    public void setRedPlayer(PlayerTwo r)
    {
        red=r;
    }
    public void setBluePlayer(PlayerOne b)
    {
        blue=b;
    }
    public void setBlackPlayer(PlayerFour bl)
    {
        black=bl;
    }
    public void setYouAreIt(YouAreIt pooping)
    {
        youareit=pooping;
    }
    public void tag()
    {
        it=false;
    }
    public void tagged()
    {
        it=true;
    }
    public boolean isTaggingRed()
    {
        boolean read=false;
        if (isTouching(PlayerTwo.class))
        {
            read=true;
        }
        return read;
    }
    public boolean isTaggingBlue()
    {
        boolean read=false;
        if (isTouching(PlayerOne.class))
        {
            read=true;
        }
        return read;
    }
    public boolean isTaggingBlack()
    {
        boolean read=false;
        if (isTouching(PlayerFour.class))
        {
            read=true;
        }
        return read;
    }
    public int getTime()
    {
        return time;
    }
}
