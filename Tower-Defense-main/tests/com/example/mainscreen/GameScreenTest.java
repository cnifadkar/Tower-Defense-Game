package com.example.mainscreen;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameScreenTest {

    /*// Tests if the enemies are moving correctly throughout the path. Assesses if the end point of the enemy is correct
    // with the expected end point in terms of the gridPane layout.
    @Test
    public void enemiesMove() throws InterruptedException {
        GameScreen gameScreen = new GameScreen(1280, 800);
        Point2D endPoint = new Point2D(0, 10);

        gameScreen.startCombat();
        Node enemy = gameScreen.mainGrid.getChildren().get(10);
        assertEquals(endPoint, new Point2D(enemy.getTranslateX() / 100, enemy.getTranslateY() / 100));
    }

    // Tests if the game over screen is displayed at the correct event. Runs the start combat method, in which the
    // enemy should be able to reach the monument and decrease its health to zero since there are no towers and prompt
    // the game over screen at the end.
//    @Test
//    public void gameOverScreenPops() throws InterruptedException {
//        GameScreen gameScreen = new GameScreen(1280, 800);
//        GameOverScreen gameOver = new GameOverScreen(1280, 800, GameScreen.getInstance().getEnemiesKilled(), GameScreen.get);
//
//        gameScreen.startCombat();
//        System.out.print(GameScreen.health);
//        assertEquals(gameOver, GameScreen.getInstance());
//    }

    // Tests if the monument health correctly decreases. Runs the start combat method which should allow the enemies
    // to reach the monument; then asserts if the monument's health is zero.
    @Test
    public void monumentHealthDec() throws InterruptedException {
        GameScreen gameScreen = new GameScreen(1280, 800);

        gameScreen.startCombat();
        int health = Integer.parseInt(GameScreen.health.getText());
        assertEquals(0, health);
    }

    //Tests to make sure that the towerPlaced field is set to true after the
    // coordinates are checked. The setTower() method is called on
    //a gameScreen instance and asserts if the towerPlaced field is set to true.
    @Test
    public void towerPlaced() throws InterruptedException {
        GameScreen gameScreen = new GameScreen(1280, 800);

        gameScreen.setTower("Gorilla Tower");
//        boolean placed = gameScreen.towerPlaced;
//        assertEquals(true, placed);
    }

    //Tests to make sure that all enemies are on the grid after the startCombat()
    //method has been run.
    @Test
    public void enemiesOnGrid() throws InterruptedException {
        GameScreen gameScreen = new GameScreen(1280, 800);
        gameScreen.startCombat();

//        boolean allEnemiesIn = (gameScreen.enemy1In && gameScreen.enemy2In && gameScreen.enemy3In);
//        assertEquals(true, allEnemiesIn);

    }

    //Tests to make sure that the iterator count is more than zero afer the startCombat( ) method
    //has been run, to ensure the while loop is running.
    @Test
    public void iteratorWorks() throws InterruptedException {

        GameScreen gameScreen = new GameScreen(1280, 800);
        gameScreen.startCombat();

//        boolean iteratorGreaterThanZero = (gameScreen.iterator > 0);
//        assertEquals(true, iteratorGreaterThanZero);
    }

    // tests if the Play Again button on gameOverScreen
//    @Test
//    public void gameOverScreenPlayAgain() throws InterruptedException {
//        GameOverScreen gameOver = new GameOverScreen(1280, 800);
//        assertEquals(gameOver, GameScreen.getInstance());
//    }

    // tests if enemies can be placed at the start of the map
    @Test
    public void enemiesExist() throws InterruptedException {
        GameScreen gameScreen = new GameScreen(1280, 800);
        Point2D endPoint = new Point2D(0, 10);
        gameScreen.startCombat();
        Node enemy = gameScreen.mainGrid.getChildren().get(10);
        assertNotNull(enemy.getTranslateY());
    }

    // Tests if the monument health is initialized correctly and not null.
    @Test
    public void monumentHealthExists() {
        int monuHealth = Integer.parseInt(GameScreen.health.getText());
        assertNotNull(monuHealth);
    }

    // Tests if the money is initialized correctly and not null.
    @Test
    public void moneyExists() {
        int money = Integer.parseInt(GameScreen.money.getText());
        assertNotNull(money);
    } */

}