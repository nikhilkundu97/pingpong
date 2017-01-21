import java.awt.Graphics;
import java.awt.Rectangle;

import javafx.scene.shape.Circle;

public class Ball {
    private static final int WIDTH = 30, HEIGHT = 30;
    private Pong game;
    private int x, y, speedx = 5,speedy= 5;

    public Ball(Pong game)
    {//initialize
        this.game = game;
        x = game.getWidth() / 2;
        y = game.getHeight() / 2;
    }

    public void update() 
    {//during game
        x += speedx;
        y += speedy;
        if (x <= 0) 
        {
            game.getPanel().increaseScore(1);
            x = game.getWidth() / 2;
            speedx = -speedx;
        }
        else if (x > game.getWidth() - WIDTH - 7)
        {
            game.getPanel().increaseScore(2);
            x = game.getWidth() / 2;
            speedx = -speedx;
        }
        else if (y < 0 || y > game.getHeight() - HEIGHT - 29)
            speedy = -speedy;
        checkCollision();
    }

    public void checkCollision()
    {
        if (game.getPanel().getPlayer(1).getBounds().intersects(getBounds()) || game.getPanel().getPlayer(2).getBounds().intersects(getBounds()))
            speedx = -speedx;
    }

    public Rectangle getBounds()
    {//range of the rectangle
        return new Rectangle(x, y, WIDTH,HEIGHT);
    }

    public void paint(Graphics g) {
        g.fillOval(x, y, WIDTH, HEIGHT);
    }
}