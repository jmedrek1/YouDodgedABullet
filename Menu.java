package com.game.main;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Menu extends MouseAdapter {

    private Game game;
    private Handler handler;
    private Random r = new Random();
    private HUD hud;

    public Menu(Game game, Handler handler, HUD hud) {
        this.game = game;
        this.handler = handler;
        this.hud = hud;
    }

    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();

        if (game.gameState == Game.STATE.Menu) {
            //play button
            if (mouseOver(mx, my, 210, 150, 215, 64)) {
                game.gameState = Game.STATE.Select;

                return;
            }

            //help button
            if (mouseOver(mx, my, 210, 250, 215, 64))
                game.gameState = Game.STATE.Help;

            //quit button
            if (mouseOver(mx, my, 210, 350, 215, 64))
                System.exit(1);
        }
        if (game.gameState == Game.STATE.Select) {
            //normal button
            if (mouseOver(mx, my, 210, 150, 215, 64)) {
                game.gameState = Game.STATE.Game;
                handler.addObject(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player, handler));
                handler.clearEnemies();
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));

                game.diff = 0;
            }
            //hard button
            if (mouseOver(mx, my, 210, 250, 215, 64)) {
                game.gameState = Game.STATE.Game;
                handler.addObject(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player, handler));
                handler.clearEnemies();
                handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));

                game.diff = 1;
            }
            //back button
            if (mouseOver(mx, my, 210, 350, 215, 64)) {
                game.gameState = Game.STATE.Menu;
                return;
            }
        }
        //back button for help
        if (game.gameState == Game.STATE.Help) {
            if (mouseOver(mx, my, 210, 350, 215, 64)) {
                game.gameState = Game.STATE.Menu;
                return;
            }
        }

        //try again button
        if (game.gameState == Game.STATE.End) {
            if (mouseOver(mx, my, 210, 350, 215, 64)) {
                game.gameState = Game.STATE.Menu;
                hud.setLevel(1);
                hud.setScore(0);
            }
        }
    }
    public void mouseReleased(MouseEvent e) {

    }

    private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
        return (mx > x && mx < x + width) && (my > y && my < y + height);
    }

    public void tick() {

    }
    public void render(Graphics g) {
        if (game.gameState == Game.STATE.Menu) {
            Font fnt = new Font("arial", 1, 50);
            Font fnt2 = new Font("arial", 1, 30);

            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("Wave", 250, 70);

            g.setFont(fnt2);
            g.setColor(Color.white);

            g.drawString("Play", 285, 190);
            g.drawRect(210, 150, 215, 64);

            g.drawString("Help", 285, 290);
            g.drawRect(210, 250, 215, 64);

            g.drawString("Quit", 285, 390);
            g.drawRect(210, 350, 215, 64);
        }
        else if (game.gameState == Game.STATE.Help) {
            Font fnt = new Font("arial", 1, 50);
            Font fnt2 = new Font("arial", 1, 30);
            Font fnt3 = new Font("arial", 1, 20);

            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("Help", 250, 70);

            g.setFont(fnt3);
            g.drawString("Use WASD keys to move player and dodge enemies.", 60, 200);

            g.setFont(fnt2);
            g.drawRect(210, 350, 215, 64);
            g.drawString("Back", 285, 390);
        }
        else if (game.gameState == Game.STATE.End) {
            Font fnt = new Font("arial", 1, 50);
            Font fnt2 = new Font("arial", 1, 30);
            Font fnt3 = new Font("arial", 1, 20);

            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("Game Over", 200, 70);

            g.setFont(fnt3);
            g.drawString("You lost with a score of " + hud.getScore(), 200, 200);

            g.setFont(fnt2);
            g.drawRect(210, 350, 215, 64);
            g.drawString("Try Again", 255, 390);
        }
        else if (game.gameState == Game.STATE.Select) {
            Font fnt = new Font("arial", 1, 50);
            Font fnt2 = new Font("arial", 1, 30);

            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("SELECT DIFFICULTY", 60, 70);

            g.setFont(fnt2);
            g.setColor(Color.white);

            g.drawString("Normal", 270, 190);
            g.drawRect(210, 150, 215, 64);

            g.drawString("Hard", 285, 290);
            g.drawRect(210, 250, 215, 64);

            g.drawString("Back", 285, 390);
            g.drawRect(210, 350, 215, 64);
        }
    }
}
