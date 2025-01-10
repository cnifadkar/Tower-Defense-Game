package com.example.mainscreen;

import javafx.animation.PathTransition;
import javafx.application.Platform;
import javafx.geometry.Point2D;
import javafx.scene.effect.Light;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class Enemy {
    private String type;
    private Point2D pos;
    private int health;
    private ImageView enemyImageView;
    private Map<Point2D, Point2D> pointMap = new HashMap<>();
    private int dmg;
    private boolean isDestroyed;

    public Enemy(String type, Point2D pos) {

        this.type = type;
        this.pos = pos;
        isDestroyed = false;
        enemyImageView = new ImageView();
        createMap();
        switch (type) {
            case "Final":
                health = 30;
                dmg = 100;
                InputStream finalStream = null;
                try {
                    finalStream = new FileInputStream("src/assets/enemyIcons/finalBoss.png");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                Image finalEnemy = new Image(finalStream);
                enemyImageView.setImage(finalEnemy);
                enemyImageView.setFitHeight(80);
                enemyImageView.setFitWidth(80);
                break;
            case "Snake":
                health = 15;
                dmg = 20;
                InputStream snakeStream = null;
                try {
                    snakeStream = new FileInputStream("src/assets/enemyIcons/snakeMove.png");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                Image snakeEnemy = new Image(snakeStream);
                enemyImageView.setImage(snakeEnemy);
                enemyImageView.setFitHeight(80);
                enemyImageView.setFitWidth(80);
                break;
            case "Jaguar":
                health = 20;
                dmg = 30;
                InputStream jaguarStream = null;
                try {
                    jaguarStream = new FileInputStream("src/assets/enemyIcons/jaguar.png");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                Image jaguarEnemy = new Image(jaguarStream);
                enemyImageView.setImage(jaguarEnemy);
                enemyImageView.setFitHeight(80);
                enemyImageView.setFitWidth(80);
                break;
            case "Toucan":
                health = 30;
                dmg = 50;
                InputStream toucanStream = null;
                try {
                    toucanStream = new FileInputStream("src/assets/enemyIcons/toucan.png");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                Image toucanEnemy = new Image(toucanStream);
                enemyImageView.setImage(toucanEnemy);
                enemyImageView.setFitHeight(80);
                enemyImageView.setFitWidth(80);
                break;
        }
    }

    public void update() {
        new Timer().schedule(
                new TimerTask() {
                    @Override
                    public void run() {
                        int monumentHealth = Integer.parseInt(GameScreen.health.getText());
                        if (monumentHealth <= 0) {
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    Controller.getInstance().setState(new GameOverScreen(1280, 800, GameScreen.getInstance().getEnemiesKilled(), GameScreen.getInstance().getDamageDealt(), GameScreen.getInstance().getMoneySpent()));
                                    cancel();
                                }
                            });
                            cancel();
                        } else if (health <= 0) {
                            cancel();
                        } else if (!(pos.equals(new Point2D(0, 10)))) {
                            pos = getPointMap().get(pos);
                        } else {
                            System.out.println("Old Health: " + GameScreen.health.getText());
                            monumentHealth -= dmg;
                            GameScreen.health.setText(monumentHealth + "");
                            System.out.println("New Health: " + GameScreen.health.getText());
                        }
//                        System.out.println("Enemy position: " + pos);
                    }
                }, 0, 1500);
        int monumentHealth = Integer.parseInt(GameScreen.health.getText());
        if (monumentHealth <= 0) {
        }
    }

    public void destroy() {
        int mon = Integer.parseInt(GameScreen.money.getText());
        mon += 50;
        GameScreen.money.setText(mon + "");
        isDestroyed = true;
    }

    public void createMap() {
        pointMap.put(new Point2D(10,10), new Point2D(0,0));
        pointMap.put(new Point2D(0,0), new Point2D(0,1));
        pointMap.put(new Point2D(0,1), new Point2D(0,2));
        pointMap.put(new Point2D(0,2), new Point2D(1,2));
        pointMap.put(new Point2D(1,2), new Point2D(2,2));
        pointMap.put(new Point2D(2,2), new Point2D(3,2));
        pointMap.put(new Point2D(3,2), new Point2D(4,2));
        pointMap.put(new Point2D(4,2), new Point2D(4,3));
        pointMap.put(new Point2D(4,3), new Point2D(4,4));
        pointMap.put(new Point2D(4,4), new Point2D(4,5));
        pointMap.put(new Point2D(4,5), new Point2D(4,6));
        pointMap.put(new Point2D(4,6), new Point2D(3,6));
        pointMap.put(new Point2D(3,6), new Point2D(2,6));
        pointMap.put(new Point2D(2,6), new Point2D(2,7));
        pointMap.put(new Point2D(2,7), new Point2D(2,8));
        pointMap.put(new Point2D(2,8), new Point2D(1,8));
        pointMap.put(new Point2D(1,8), new Point2D(0,8));
        pointMap.put(new Point2D(0,8), new Point2D(0,9));
        pointMap.put(new Point2D(0,9), new Point2D(0,10));
    }

    public Point2D getPos() {
        return pos;
    }

    public void setPos(Point2D newPos) {
        pos = newPos;
    }

    public Map<Point2D, Point2D> getPointMap() {
        return pointMap;
    }

    public int getHealth() {
        return health;
    }

    public String getType() {
        return type;
    }

    public int getDmg() {
        return dmg;
    }

    public void setHealth(int newHealth) {
        health = newHealth;
    }

    public ImageView getEnemyImageView() {
        return enemyImageView;
    }

    public boolean checkIfDestroyed() {
        return isDestroyed;
    }


}