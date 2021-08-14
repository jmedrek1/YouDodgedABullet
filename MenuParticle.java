package com.game.main;

import java.awt.*;
import java.util.Random;

public class MenuParticle extends GameObject {

    private Handler handler;

    Random r = new Random();

    private Color color;

    public MenuParticle(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;

        velX = r.nextInt(14) - 7;
        velY = r.nextInt(14) - 7;
        if (velX == 0) velX = 1;
        if (velY == 0) velY = 1;

        color = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 16, 16);
    }
    public void tick() {
        x += velX;
        y += velY;

        if (y <= 0 || y >= Game.HEIGHT - 32) velY *= -1;
        if (x <= 0 || x >= Game.WIDTH - 16) velX *= -1;

        handler.addObject(new Trail(x, y, ID.Trail, color, 16, 16, 0.05f, handler));
    }

    public void render(Graphics g) {
        g.setColor(color);
        g.fillRect((int) x, (int) y, 16, 16);
    }
}
