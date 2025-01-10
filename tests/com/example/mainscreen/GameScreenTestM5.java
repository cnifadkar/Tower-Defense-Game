package com.example.mainscreen;
import javafx.collections.ObservableList;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class GameScreenTestM5 {

    // Checks to see that all towers have the correct health assigned to them.

    @Test
    public void checkTowerHealth() {
        Tower monkeyTowerTemp = new Tower("Monkey", new Point2D(0, 0));
        Tower gorillaTowerTemp = new Tower("Gorilla", new Point2D(0, 0));
        Tower orangTowerTemp = new Tower("Orangutan", new Point2D(0, 0));

        int monkeyHealth = monkeyTowerTemp.health;
        int gorillaHealth = gorillaTowerTemp.health;
        int orangHealth = orangTowerTemp.health;

        boolean monkeyRight = (monkeyHealth == 60);
        boolean gorillaRight = (gorillaHealth == 100);
        boolean orangRight = (orangHealth == 80);

        boolean allRight = (monkeyRight && gorillaRight && orangRight);
        assertTrue(allRight);

    }

    // Checks to make sure createRange() makes a list containing the right points

    @Test
    public void checkTowerRange() {

        Tower tempTower = new Tower("Monkey", new Point2D(4, 2));
        ArrayList myRange = tempTower.createRange(tempTower.pos);
        boolean allPoints = (myRange.contains(new Point2D(3, 1)) && myRange.contains(new Point2D(4, 2))
                && myRange.contains(new Point2D(5, 1)) && myRange.contains(new Point2D(3, 2)) &&
                myRange.contains(new Point2D(5, 2)) && myRange.contains(new Point2D(3, 3))
                && myRange.contains(new Point2D(4, 3)) && myRange.contains(new Point2D(5, 3)));
        assertTrue(allPoints);
    }

//    @Test
//    //Checks to make sure that money increases by 50 after an enemy is destroyed.
//    public void checkMoneyGain() {
//
//        GameScreen gameScreen = new GameScreen(1280, 800);
//        Enemy tempSnake = new Enemy("Snake", new Point2D(0, 0));
//        int tempMoney = Integer.parseInt(GameScreen.money.getText());
//        int rightMoney = tempMoney - 50;
//        tempSnake.destroy(gameScreen.mainGrid, tempMoney);
//        assertEquals(tempMoney, rightMoney);
//    }

//    @Test
//    //Checks to make sure that the enemy is removed after being destroyed
//    public void enemyRemoved() {
//        GameScreen gameScreen = new GameScreen(1280, 800);
//        Enemy tempSnake = new Enemy("Jaguar", new Point2D(0, 0));
//        int tempMoney = Integer.parseInt(GameScreen.money.getText());
//        tempSnake.destroy(gameScreen.mainGrid, tempMoney);
//        ObservableList<Node> nodeList = gameScreen.mainGrid.getChildren();
//        boolean enemyGone = !nodeList.contains(tempSnake);
//        assertTrue(enemyGone);
//
//    }

    @Test
    //makes sure enemy's position is not null after combat.
    public void checkEnemyPos() throws InterruptedException {
        GameScreen gameScreen = new GameScreen(1280, 800);
        Enemy tempEnemy = new Enemy("Jaguar", new Point2D(0,0));
        gameScreen.startCombat();
        assertNotNull(tempEnemy.getPos());
    }

    @Test
    // checks enemy's health decreases appropriately after an attack

    public void checkEnemyHealth() {
        Enemy tempEnemy = new Enemy("Jaguar", new Point2D(0,0));
        Tower tempTower = new Tower("Monkey", new Point2D(4, 2));
        tempTower.attack(tempEnemy);
        assertEquals(tempEnemy.getHealth(),10);
    }

    @Test

    //checks all enemies have been added to the enemy list after show enemies is called
    public void checkShowEnemies() {

        Enemy tempToucanEnemy = new Enemy("Toucan", new Point2D(0, 0));
        Enemy tempJaguarEnemy = new Enemy("Jaguar", new Point2D(0, 0));
        Enemy tempSnakeEnemy = new Enemy("Snake", new Point2D(0, 0));
        GameScreen gameScreen = new GameScreen(1280, 800);
        gameScreen.showEnemies();
        assertTrue(gameScreen.enemyList.contains(tempJaguarEnemy) &&
                gameScreen.enemyList.contains(tempToucanEnemy) &&
                gameScreen.enemyList.contains(tempSnakeEnemy));
    }

    @Test
    public void checkTowerAdded() {
        GameScreen gameScreen = new GameScreen(1280, 800);
        gameScreen.setTower("Monkey");
        boolean monkeyAdded = gameScreen.towerList.contains(gameScreen.mTower);
        boolean orangAdded = gameScreen.towerList.contains(gameScreen.oTower);
        boolean gorillaAdded = gameScreen.towerList.contains(gameScreen.gTower);
        assertTrue(monkeyAdded && orangAdded && gorillaAdded);
    }

    @Test
    public void checkEnemyDamage() {
        Enemy tempToucanEnemy = new Enemy("Toucan", new Point2D(0, 0));
        Enemy tempJaguarEnemy = new Enemy("Jaguar", new Point2D(0, 0));
        Enemy tempSnakeEnemy = new Enemy("Snake", new Point2D(0, 0));

        int toucanDamage= tempToucanEnemy.getDmg();
        int gorillaDamage = tempJaguarEnemy.getDmg();
        int orangDamage = tempSnakeEnemy.getDmg();

        boolean monkeyRight = (toucanDamage == 60);
        boolean gorillaRight = (gorillaDamage == 100);
        boolean orangRight = (orangDamage == 80);

        assertTrue(monkeyRight && gorillaRight && orangRight);

    }


//    @Test
//    public void checkEnemyAfterDestroy() {
//        Enemy tempToucanEnemy = new Enemy("Toucan", new Point2D(0, 0));
//        GameScreen gameScreen = new GameScreen(1280, 800);
//        int tempMoney = Integer.parseInt(GameScreen.money.getText());
//        tempToucanEnemy.destroy(gameScreen.mainGrid, tempMoney);
//        boolean isDestroyed = (tempToucanEnemy.getHealth() == 0);
//        assertTrue(isDestroyed);
//
//    }









}
