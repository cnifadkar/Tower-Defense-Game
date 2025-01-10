package com.example.mainscreen;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.FileInputStream;
import java.io.IOException;

public class BuyTowers extends GameState {
    private static BuyTowers instance;

    public BuyTowers(int width, int height) {
        super(width, height);
        Parent root;
        try {
            FXMLLoader loader = new FXMLLoader();
            String fxmlDocPath = "src/main/resources/com/example/mainscreen/BuyTower.fxml";
            FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
            root = loader.load(fxmlStream);
            scene.setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static BuyTowers getInstance() {
        if (instance == null) {
            resetInstance();
        }
        return instance;
    }

    public static void resetInstance() {
        instance = new BuyTowers(800, 800);
    }
}