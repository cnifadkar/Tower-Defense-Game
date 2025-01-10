package com.example.mainscreen;

import javafx.collections.ObservableList;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class gameScreenTestM6 {

    @Test
    //Checks gamescreen money changes after tower is bought.

    public void checkMoneyUpgrades() throws InterruptedException {

        GameScreen gameScreen = new GameScreen(1280, 800);
        Tower monkeyTowerTemp = new Tower("Monkey", new Point2D(0, 0));
        int tempMoney = Integer.parseInt(GameScreen.money.getText());
        int rightMoney = tempMoney - 5;
        monkeyTowerTemp.upgrade(gameScreen.mainGrid);
        assertEquals(tempMoney, rightMoney);
    }

    @Test

    //Checks star image displayed after upgrade.

    public void checkStarImage() {
        GameScreen gameScreen = new GameScreen(1280, 800);
        Tower monkeyTowerTemp = new Tower("Monkey", new Point2D(0, 0));

        InputStream starStream = null;
        try {
            starStream = new FileInputStream("src/assets/goldStar.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Image starImage = new Image(starStream);
        ImageView starView = new ImageView(starImage);
        starView.setFitWidth(20);
        starView.setFitHeight(20);
        monkeyTowerTemp.upgrade(gameScreen.mainGrid);

        ObservableList<Node> theList = gameScreen.mainGrid.getChildren();
        assertTrue(theList.contains(starView));
    }

    // Checks isDestroyed is true after enemies are destroyed.

    @Test

    public void isDestroyedTrue() {
        Enemy tempEnemy = new Enemy("Jaguar", new Point2D(0, 0));
        tempEnemy.destroy();
        assertTrue(tempEnemy.checkIfDestroyed());
    }

    //Checks

    @Test

    public void checkNoUpgrade() {
        GameScreen gameScreen = new GameScreen(1280, 800);
        gameScreen.health.setText("0");
        Tower monkeyTowerTemp = new Tower("Monkey", new Point2D(0, 0));
        monkeyTowerTemp.upgrade(gameScreen.mainGrid);

        InputStream starStream = null;
        try {
            starStream = new FileInputStream("src/assets/goldStar.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Image starImage = new Image(starStream);
        ImageView starView = new ImageView(starImage);
        starView.setFitWidth(20);
        starView.setFitHeight(20);
        ObservableList<Node> theList = gameScreen.mainGrid.getChildren();
        assertFalse(theList.contains(starView));

    }

    //Checks final boss is spawned after enemies are killed

    @Test

    public void checkFinalBossSpawned() throws InterruptedException {

        GameScreen gameScreen = new GameScreen(1280, 800);
        gameScreen.startCombat();;

        Enemy tempToucanEnemy = new Enemy("Toucan", new Point2D(0, 0));
        Enemy tempJaguarEnemy = new Enemy("Jaguar", new Point2D(0, 0));
        Enemy tempSnakeEnemy = new Enemy("Snake", new Point2D(0, 0));

        tempToucanEnemy.destroy();
        tempJaguarEnemy.destroy();
        tempSnakeEnemy.destroy();

        assertTrue(gameScreen.finalIsSpawned);

    }

    //Checks number of enemies is equal to 3 after being destroyed.

    @Test

    public void checkEnemiesKilled() throws InterruptedException {

        GameScreen gameScreen = new GameScreen(1280, 800);
        gameScreen.startCombat();

        Enemy tempToucanEnemy = new Enemy("Toucan", new Point2D(0, 0));
        Enemy tempJaguarEnemy = new Enemy("Jaguar", new Point2D(0, 0));
        Enemy tempSnakeEnemy = new Enemy("Snake", new Point2D(0, 0));

        tempToucanEnemy.destroy();
        tempJaguarEnemy.destroy();
        tempSnakeEnemy.destroy();


        Assertions.assertEquals(3, gameScreen.getEnemiesKilled());

    }

    // checks tower has been upgraded

    @Test

    public void checkTowerUpgraded() throws InterruptedException {

        GameScreen gameScreen = new GameScreen(1280, 800);
        gameScreen.startCombat();
        Tower monkeyTowerTemp = new Tower("Monkey", new Point2D(0, 0));

        monkeyTowerTemp.upgrade(gameScreen.mainGrid);

        assertTrue(gameScreen.towerUpgraded);
    }

    //checks final boss is in enemy list

    @Test

    public void checkBossInList() throws InterruptedException {

        GameScreen gameScreen = new GameScreen(1280, 800);
        gameScreen.startCombat();

        Enemy tempToucanEnemy = new Enemy("Toucan", new Point2D(0, 0));
        Enemy tempJaguarEnemy = new Enemy("Jaguar", new Point2D(0, 0));
        Enemy tempSnakeEnemy = new Enemy("Snake", new Point2D(0, 0));

        tempToucanEnemy.destroy();
        tempJaguarEnemy.destroy();
        tempSnakeEnemy.destroy();

        assertTrue(gameScreen.enemyList.contains(gameScreen.finalEnemy));


    }

    //checks final boss enemy appears on screen

    @Test

    public void checkBossOnScreen() throws InterruptedException {

        GameScreen gameScreen = new GameScreen(1280, 800);
        gameScreen.startCombat();

        Enemy tempToucanEnemy = new Enemy("Toucan", new Point2D(0, 0));
        Enemy tempJaguarEnemy = new Enemy("Jaguar", new Point2D(0, 0));
        Enemy tempSnakeEnemy = new Enemy("Snake", new Point2D(0, 0));

        tempToucanEnemy.destroy();
        tempJaguarEnemy.destroy();
        tempSnakeEnemy.destroy();

        ObservableList<Node> theList = gameScreen.mainGrid.getChildren();

        assertTrue(theList.contains(gameScreen.enemyList.get(3).getEnemyImageView()));


    }

    //checks winscreen's variables

    @Test

    public void checkWinVariables() throws InterruptedException {

        GameScreen gameScreen = new GameScreen(1280, 800);
        gameScreen.startCombat();

        gameScreen.setEnemiesKilled(4);

        assertTrue(gameScreen.getDamageDealt() > 0 && gameScreen.getEnemiesKilled()
                > 0 && gameScreen.getMoneySpent() > 0);


    }











}
