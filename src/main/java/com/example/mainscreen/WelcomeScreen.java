package com.example.mainscreen;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class WelcomeScreen extends GameState {
    private static WelcomeScreen instance;

    public WelcomeScreen(int width, int height) {
        super(width, height);
        //bg
        Text titleText = new Text("WELCOME TO THE GAME");
        titleText.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 40));
        //start button
        //quit button
        Button startButton = new Button("Start");
        Button quitButton = new Button("Quit");
        startButton.setOnAction(value ->  {
            Controller.getInstance().setState(new ConfigScreen(1280, 800));
        });
        quitButton.setOnAction(value -> {
            Controller.quit();
        });

        VBox vbox = new VBox(titleText, startButton, quitButton);
        BorderPane border = new BorderPane();
        border.setCenter(vbox);

        scene = new Scene(border, 1280, 800, Color.GOLD);
    }

    public static WelcomeScreen getInstance() {
        if (instance == null) {
            resetInstance();
        }
        return instance;
    }

    public static void resetInstance() {
        instance = new WelcomeScreen(1280, 800);
    }
}
