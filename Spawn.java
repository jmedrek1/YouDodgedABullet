package com.game.main;

import java.util.Random;

public class Spawn {

    private Handler handler;
    private HUD hud;
    private Game game;
    private Random r = new Random();

    private int scoreKeep = 0;

    public Spawn(Handler handler, HUD hud, Game game) {
        this.handler = handler;
        this.hud = hud;
        this.game = game;
    }

    public void tick() {
        scoreKeep++;

        if (scoreKeep >= 250) {
            scoreKeep = 0;
            hud.setLevel(hud.getLevel() + 1);

            if (game.diff == 0) {
                switch (hud.getLevel()) {
                    case 2:
                    case 3:
                        handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
                        break;
                    case 4:
                    case 6:
                    case 7:
                        handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
                        break;
                    case 5:
                        handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.SmartEnemy, handler));
                        break;
                    case 10:
                        handler.clearEnemies();
                        handler.addObject(new EnemyBoss(Game.WIDTH / 2 - 48, -120, ID.EnemyBoss, handler));
                        break;
                }
            }
            else if (game.diff == 1) {
                switch (hud.getLevel()) {
                    case 2:
                    case 3:
                        handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.HardEnemy, handler));
                        break;
                    case 4:
                    case 6:
                    case 7:
                        handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
                        break;
                    case 5:
                        handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.SmartEnemy, handler));
                        break;
                    case 10:
                        handler.clearEnemies();
                        handler.addObject(new EnemyBoss(Game.WIDTH / 2 - 48, -120, ID.EnemyBoss, handler));
                        break;
                }
            }
        }
    }
}
