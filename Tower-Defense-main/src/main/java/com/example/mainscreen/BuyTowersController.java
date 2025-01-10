package com.example.mainscreen;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;

public class BuyTowersController {

    @FXML
    public ComboBox towerType;
    public String[] info1;


    @FXML
    public void initialize() {
        towerType.getItems().add("Gorilla Tower");
        towerType.getItems().add("Monkey Tower");
        towerType.getItems().add("Orangutan Tower");
    }

    public void buyTower() {
        String diffTower = (String) towerType.getValue();
        if (diffTower == null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("Please select a Tower ");
            alert.show();
        } else if (diffTower.equals("Gorilla Tower")) {
            GameScreen run1 = GameScreen.getInstance();
            Controller.getInstance().setState(run1);
            run1.setTower("Gorilla Tower");

        } else if (diffTower.equals("Monkey Tower")) {
            GameScreen run2 = GameScreen.getInstance();
            Controller.getInstance().setState(run2);
            run2.setTower("Monkey Tower");

        } else if (diffTower.equals("Orangutan Tower")) {
            GameScreen run3 = GameScreen.getInstance();
            Controller.getInstance().setState(run3);
            run3.setTower("Orangutan Tower");

        }
    }

    public void cancel() {
        Controller.getInstance().setState(new GameScreen(1280, 800));
    }
}