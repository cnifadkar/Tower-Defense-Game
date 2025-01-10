package com.example.mainscreen;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ConfigScreenController {

    @FXML
    public TextField nameInput;
    @FXML
    public ComboBox difficultyInput;

    @FXML
    public void initialize() {
        difficultyInput.getItems().add("easy");
        difficultyInput.getItems().add("medium");
        difficultyInput.getItems().add("hard");
    }

    private boolean nameRestrictions() {
        String name = nameInput.getText();
        if (name.equals("") || name.contains(" ") || name == null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid Name");
            alert.setContentText("Your name cannot be empty or contain spaces," 
                + "please retype your name");
            alert.show();
            return false;
        } else {
            return true;
        }
    }

    private void doDiff() {
        String diff = (String) difficultyInput.getValue();
        if (diff == null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("Please select a difficulty");
            alert.show();
        } else if (diff.equals("easy")) {
            GameScreen run1 = new GameScreen(1280, 800);
            run1.setDifficulty("easy");
            Controller.getInstance().setState(run1);
        } else if (diff.equals("medium")) {
            GameScreen run2 = new GameScreen(1280, 800);
            run2.setDifficulty("medium");
            Controller.getInstance().setState(run2);
        } else if (diff.equals("hard")) {
            GameScreen run3 = new GameScreen(1280, 800);
            run3.setDifficulty("hard");
            Controller.getInstance().setState(run3);
        }
    }


    public void createGame() {
        if (nameRestrictions()) {
            doDiff();
        }
    }

    public void cancel() {
        Controller.getInstance().setState(new WelcomeScreen(1280, 800));
    }
}
