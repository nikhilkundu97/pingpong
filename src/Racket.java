import java.awt.Graphics;
import java.awt.Rectangle;

public class Racket {
    private static final int WIDTH = 10, HEIGHT = 60;
    public int barnum;
    private Pong game;
    private int up, down;
    private int x;
    private int y, speedy;

    public Racket(Pong game, int up, int down, int x,int barnum)
    {//initialize
    	this.barnum=barnum;
        this.game = game;
        if(barnum==1)
        this.x = 0;
        
        else if (barnum==2)
        this.x=680;
        
        y = 185;
        this.up = up;
        this.down = down;
    }

    
    public void update() 
    {//during game
        if (y > 0 && y < game.getHeight() - HEIGHT - 29)
            y += speedy;
        else if (y <= 0)
            y+=5;
        else if (y > game.getHeight() - HEIGHT - 29)
            y-=5;
    }

    public void pressed(int keyCode) 
    {//used for the movement of keys
        if (keyCode == up)
            speedy = -5;
        else if (keyCode == down)
            speedy = 5;
    }

    public void released(int keyCode)
    {//used for the movement of keys
        if ((keyCode != up) || keyCode != down)
            speedy = 0;
    }

    public Rectangle getBounds()
    {//set the bounds or range
        return new Rectangle(x, y, WIDTH, HEIGHT);
    }

    public void paint(Graphics g)
    {
        g.fillRect(x, y, WIDTH, HEIGHT);
    }
}