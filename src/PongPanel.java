import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class PongPanel extends JPanel implements ActionListener, KeyListener {
    private Pong game;
    private Ball ball;
    private Racket plyr1, plyr2;
    private int scr1, scr2;

    public PongPanel(Pong game)
    {
        setBackground(Color.WHITE);
        this.game = game;
        ball = new Ball(game);
        plyr1 = new Racket(game, KeyEvent.VK_W, KeyEvent.VK_S,0,1);
        plyr2 = new Racket(game, KeyEvent.VK_UP, KeyEvent.VK_DOWN, 650,2);
        Timer timer = new Timer(5, this);
        timer.start();
        addKeyListener(this);
        setFocusable(true);
    }

    public Racket getPlayer(int playerNo)
    {
        if (playerNo == 1)
            return plyr1;
        else
            return plyr2;
    }

    public void increaseScore(int playerNo) {
        if (playerNo == 1)
            scr1++;
        else
            scr2++;
    }

    public int getScore(int playerNo) {
        if (playerNo == 1)
            return scr1;
        else
            return scr2;
    }

    private void update() 
    {
        ball.update();
        plyr1.update();
        plyr2.update();
    }

    public void actionPerformed(ActionEvent e) {
        update();
        repaint();
    }

    public void keyPressed(KeyEvent e) {
        plyr1.pressed(e.getKeyCode());
        plyr2.pressed(e.getKeyCode());
    }

    public void keyReleased(KeyEvent e) {
        plyr1.released(e.getKeyCode());
        plyr2.released(e.getKeyCode());
    }

    public void keyTyped(KeyEvent e)
    {

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString(game.getPanel().getScore(1) + " : " + game.getPanel().getScore(2), game.getWidth() / 2, 10);
        ball.paint(g);
        plyr1.paint(g);
        plyr2.paint(g);
    }
}