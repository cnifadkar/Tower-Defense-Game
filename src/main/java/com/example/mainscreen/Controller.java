package com.example.mainscreen;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

public class Controller extends Application {
    private static Controller instance;

    private Stage stage;
    private GameState state;

    public void start(Stage stage) {
        instance = this;
        this.stage = stage;

        state = WelcomeScreen.getInstance();
        setState(state);
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.show();
    }

    public static void setState(GameState state) {
        instance.state = state;
        instance.stage.setScene(state.getScene());
    }

    public static GameState getState() {
        return instance.state;
    }

    public static Controller getInstance() {
        return instance;
    }

    public static void quit() {
        Platform.exit();
    }
}
