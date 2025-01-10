package com.example.mainscreen;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.FileInputStream;
import java.io.IOException;

public class WinScreen extends GameState {
    private static WinScreen instance;
    public static int enemiesKilled;
    public static int damageTaken;
    public static int moneySpent;

    public WinScreen(int width, int height, int enemyKilled, int damage, int spentMoney) {
        super(width, height);
        Parent root;
        enemiesKilled = enemyKilled;
        damageTaken = damage;
        moneySpent = spentMoney;
        try {
            FXMLLoader loader = new FXMLLoader();
            String fxmlDocPath = "src/main/resources/com/example/mainscreen/WinScreen.fxml";
            FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
            root = loader.load(fxmlStream);
            scene.setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static WinScreen getInstance() {
        if (instance == null) {
            resetInstance();
        }
        return instance;
    }

    public static void resetInstance() {
        instance = new WinScreen(800, 800, 0, 0, 0);
    }
}
