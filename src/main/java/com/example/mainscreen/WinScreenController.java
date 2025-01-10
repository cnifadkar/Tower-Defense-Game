package com.example.mainscreen;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class WinScreenController {

    @FXML
    public Label enemiesKilled;
    public Label damageTaken;
    public Label moneySpent;

    @FXML
    public void initialize() {
        enemiesKilled.setText("Enemies Killed: " + WinScreen.enemiesKilled);
        damageTaken.setText("Damage Taken: " + WinScreen.damageTaken);
        moneySpent.setText("Money Spent: " + WinScreen.moneySpent);
    }

    public void play() {
        Controller.getInstance().setState(new WelcomeScreen(1280, 800));
    }

    public void quit() {
        Controller.quit();
    }
}
