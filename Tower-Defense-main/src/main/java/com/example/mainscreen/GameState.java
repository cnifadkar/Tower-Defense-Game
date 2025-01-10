package com.example.mainscreen;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public abstract class GameState {
    protected Scene scene;

    public GameState(int width, int height) {
        scene = new Scene(new Pane(), width, height);
    }

    public Scene getScene() {
        return scene;
    }
}
