package com.example.mainscreen;

import java.io.FileInputStream;
import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class ConfigScreen extends GameState {
    private static ConfigScreen instance;

    public ConfigScreen(int width, int height) {
        super(width, height);
        Parent root;
        try {
            FXMLLoader loader = new FXMLLoader();
            String fxmlDocPath = "src/main/resources/com/example/mainscreen/ConfigScreen.fxml";
            FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
            root = loader.load(fxmlStream);
            scene.setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ConfigScreen getInstance() {
        if (instance == null) {
            resetInstance();
        }
        return instance;
    }

    public static void resetInstance() {
        instance = new ConfigScreen(800, 800);
    }
}