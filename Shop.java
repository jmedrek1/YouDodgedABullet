package com.game.main;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Shop extends MouseAdapter {

    Handler handler;
    HUD hud;

    private int[] costs = {1000, 1000, 1000};

    public Shop(Handler handler, HUD hud) {
        this.handler = handler;
        this.hud = hud;
    }

    public void render(Graphics g) {
        g.setColor(Color.white);
        g.setFont(new Font("arial", 0, 48));
        g.drawString("SHOP", Game.WIDTH / 2 - 80, 50);

        //box 1
        g.setFont(new Font("arial", 0, 12));
        g.drawString("Upgrade Health", 105, 120);
        g.drawString("Cost: " + costs[0], 115, 140);
        g.drawRect(100, 100, 100, 80);

        //box 2
        g.drawString("Upgrade Speed", 255, 120);
        g.drawString("Cost: " + costs[1], 265, 140);
        g.drawRect(250, 100, 100, 80);

        //box 3
        g.drawString("Refill Health", 415, 120);
        g.drawString("Cost: " + costs[2], 420, 140);
        g.drawRect(400, 100, 100, 80);

        //info for player
        g.setFont(new Font("arial", 0, 20));
        g.drawString("SCORE: " + hud.getScore(), Game.WIDTH / 2 - 70, 300);
        g.drawString("Press Space to go back", Game.WIDTH / 2 - 120, 330);
    }

    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();

        //box 1
        if (mx >= 100 && mx <= 200) {
            if (my >= 100 && my <= 180) {
                //box 1 was selected
                if (hud.getScore() >= costs[0]) {
                    hud.setScore(hud.getScore() - costs[0]);
                    costs[0] += 1000;
                    hud.bounds += 20;
                    hud.HEALTH = 100 + (hud.bounds / 2);
                }
            }
        }

        //box 2
        if (mx >= 250 && mx <= 350) {
            if (my >= 100 && my <= 180) {
                //box 2 was selected
                if (hud.getScore() >= costs[1]) {
                    hud.setScore(hud.getScore() - costs[1]);
                    costs[1] += 1000;
                    handler.speed++;
                }
            }
        }

        //box 3
        if (mx >= 400 && mx <= 500) {
            if (my >= 100 && my <= 180) {
                //box 3 was selected
                if (hud.getScore() >= costs[2]) {
                    hud.setScore(hud.getScore() - costs[2]);
                    hud.HEALTH = 100 + (hud.bounds / 2);
                }
            }
        }
    }
}
