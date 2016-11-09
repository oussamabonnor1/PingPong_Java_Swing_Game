package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Created by Oussama on 12/04/2016.
 */
public class Pannel extends JPanel {
    Random r = new Random();
    int x = 245;
    int y = r.nextInt(300);

    Color ball = new Color(100, 50, 255);
    Color player1 = new Color(0, 50, 255);
    Color player2 = new Color(200, 0, 0);
    int panel_1 = 150;
    int panel_2 = 150;
    int score = 0;
    int score2 = 0;


    @Override
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(ball);
        g.drawRect(1, 0, 528, 340);
        g.fillOval(x, y, 20, 20);
        g.setColor(player1);
        g.fillRect(10, panel_1, 10, 50);
        g.setColor(player2);
        g.fillRect(510, panel_2, 10, 50);
        g.setColor(player2);
        g.drawString("player 2: " + score2, 450, 350);
        g.setColor(player1);
        g.drawString("player 1: " + score, 20, 350);
        //player one wins
        if (score == 5) {
            score = 0;
            score2 = 0;
            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            g.setColor(Color.black);
            g.fillRect(0, 0, getWidth(), getHeight());
            g.setColor(player1);
            g.drawString("player 1 beats player 2 !!!! ", 245, 200);
        }
        //player two wins
        if (score2 == 5) {
            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            g.setColor(Color.black);
            g.fillRect(0, 0, getWidth(), getHeight());
            g.setColor(player2);
            g.drawString("player 2 beats player 1 !!!! ", 245, 200);
        }
        if (score2 == 5) {
            score = 0;
            score2 = 0;
        }
        if (score == 5) {
            score = 0;
            score2 = 0;
        }

    }
}
