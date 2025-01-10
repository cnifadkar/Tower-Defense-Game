package com.example.mainscreen;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class GameOverScreenController {
    @FXML
    public Label enemiesKilled;
    public Label damageDealt;
    public Label damageTaken;

    @FXML
    public void initialize() {
        enemiesKilled.setText("Enemies Killed: " + GameScreen.getInstance().getEnemiesKilled());
        damageDealt.setText("Damage Dealt: " + GameScreen.getInstance().getDamageDealt());
        damageTaken.setText("Damage Taken: " + (100 - Integer.parseInt(GameScreen.getInstance().health.getText())));
    }

    public void play() {
        Controller.getInstance().setState(new WelcomeScreen(1280, 800));
    }

    public void cancel() {
        Controller.quit();
    }
}
