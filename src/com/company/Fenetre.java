package com.company;

import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Fenetre extends JFrame implements KeyListener {
    private Pannel pan = new Pannel();

    public Fenetre() {

        this.setTitle("Animation");
        this.setSize(600, 540);
        this.setContentPane(pan);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        addKeyListener(this);
        go3();
    }

    private void go3() {

        int x = pan.getX(), y = pan.getY();
        int score = 0;

        boolean backX = false;

        boolean backY = false;

        while (true) {
            //left player scores
            if (x < 1) {
                System.out.println("regret");
                backX = false;
                pan.score2++;
            }
            //right player scores
            if (x > 510) {
                backX = true;
                pan.score++;
            }

            //left player bloques the ball
            if (x < 15 && y > pan.panel_1 - 7 && y < pan.panel_1 + 50) {
                backX = false;
                score++;
            }
            //right player bloques the ball
            if (x > 495 && y > pan.panel_2 - 7 && y < pan.panel_2 + 50) {
                backX = true;
                score++;
            }
            //dont touch this
            if (y < 1) {
                backY = false;
            }
            if (y > 320)
                backY = true;

            if (!backX)
                pan.setX(++x);
            else
                pan.setX(--x);
            if (!backY)
                pan.setY(++y);
            else
                pan.setY(--y);
            //On redessine notre Panneau
            pan.repaint();
            try {
                if (score == 7) score = 6;
                Thread.sleep(10 - score);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("the ball x: " + x);
            System.out.println("the ball y: " + y);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        int speed1 = 0;
        int speed2 = 0;
        if (key == KeyEvent.VK_UP) {
            speed2 = -5;
            System.out.println("up");
        }
        if (key == KeyEvent.VK_DOWN) {
            speed2 = 5;
            System.out.println("down");
        }
        if (key == KeyEvent.VK_Z) {
            speed1 = -5;
        }
        if (key == KeyEvent.VK_S) {
            speed1 = 5;
        }

        if (pan.panel_1 < 5) {
            pan.panel_1 = 6;
            System.out.println("bloqued 1 up ");
        }
        if (pan.panel_1 > 288) {
            pan.panel_1 = 287;
            System.out.println("bloqued 1 down ");
        }

        if (pan.panel_2 < 5) {
            pan.panel_2 = 6;
            System.out.println("bloqued 2 up ");
        }
        if (pan.panel_2 > 288) {
            pan.panel_2 = 287;
            System.out.println("bloqued 2 down ");
        }
        pan.panel_1 += speed1;
        pan.panel_2 += speed2;
        System.out.println("panel blue y: " + pan.panel_1);
        System.out.println("panel red y: " + pan.panel_2);
        pan.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}