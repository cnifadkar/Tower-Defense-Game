package com.example.mainscreen;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.FileInputStream;
import java.io.IOException;

public class GameOverScreen extends GameState {
    private static GameOverScreen instance;
    public static int enemiesKilled;
    public static int damageDealt;
    public static int moneySpent;

    public GameOverScreen(int width, int height, int enemyKilled, int damage, int spentMoney) {
        super(width, height);
        Parent root;
        enemiesKilled = enemyKilled;
        damageDealt = damage;
        moneySpent = spentMoney;
        try {
            FXMLLoader loader = new FXMLLoader();
            String fxmlDocPath = "src/main/resources/com/example/mainscreen/GameOverScreen.fxml";
            FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
            root = loader.load(fxmlStream);
            scene.setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static GameOverScreen getInstance() {
        if (instance == null) {
            resetInstance();
        }
        return instance;
    }

    public static void resetInstance() {
        instance = new GameOverScreen(800, 800, 0, 0, 0);
    }
}
