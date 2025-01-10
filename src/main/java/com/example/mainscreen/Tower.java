package com.example.mainscreen;

import javafx.geometry.Point2D;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

public class Tower {
    String type;
    int health;
    private int dmg;
    Point2D pos;
    private Image towerImage;
    private ImageView towerImageView;
    private ArrayList<Point2D> range;

    public Tower(String type, Point2D pos) {
        this.type = type;
        this.pos = pos;
        towerImageView = new ImageView();
        switch (type) {
            case "Monkey":
                health = 60;
                dmg = 5;
                InputStream monkeyStream = null;
                try {
                    monkeyStream = new FileInputStream("src/assets/towerGraphics/monkeyTower.png");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                Image monkeyTower = new Image(monkeyStream);
                towerImage = monkeyTower;
                towerImageView.setImage(monkeyTower);
                towerImageView.setFitHeight(80);
                towerImageView.setFitWidth(80);
                break;
            case "Orangutan":
                health = 80;
                dmg = 10;
                InputStream orangutanStream = null;
                try {
                    orangutanStream = new FileInputStream("src/assets/towerGraphics/orangutanTower.png");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                Image orangutanTower = new Image(orangutanStream);
                towerImage = orangutanTower;
                towerImageView.setImage(orangutanTower);
                towerImageView.setFitHeight(80);
                towerImageView.setFitWidth(80);
                break;
            case "Gorilla":
                health = 100;
                dmg = 15;
                InputStream gorillaStream = null;
                try {
                    gorillaStream = new FileInputStream("src/assets/towerGraphics/gorillaTower.png");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                Image gorillaTower = new Image(gorillaStream);
                towerImage = gorillaTower;
                towerImageView.setImage(gorillaTower);
                towerImageView.setFitHeight(80);
                towerImageView.setFitWidth(80);
                break;
        }
    }

    public ArrayList createRange(Point2D pos) {
        range = new ArrayList<>();
        int xPos = ((int) pos.getX()) - 1;
        for (int i = 0; i < 3; i++) {
            int yPos = ((int) pos.getY()) - 1;
            for (int j = 0; j < 3; j++) {
                range.add(new Point2D(xPos, yPos));
                yPos++;
            }
            xPos++;
        }
        return range;
    }

    public void attack(Enemy enemy) {
        ArrayList thisRange = createRange(pos);
        if (thisRange.contains(enemy.getPos())) {
            enemy.setHealth(enemy.getHealth() - dmg);
        }
    }

    public void upgrade(GridPane mainGrid) {
        int money = Integer.parseInt(GameScreen.money.getText());

        InputStream starStream = null;
        try {
            starStream = new FileInputStream("src/assets/goldStar.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image starImage = new Image(starStream);
        ImageView starView = new ImageView(starImage);
        starView.setFitWidth(20);
        starView.setFitHeight(20);

        switch (type) {
            case "Monkey":
                if (money >= 25) {
                    dmg += 5;
                    GameScreen.money.setText((money - 25) + "");
                    mainGrid.add(starView, (int)pos.getX(), (int)pos.getY());
                } else {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Error");
                    alert.setHeaderText("Error");
                    alert.setContentText("You don't have enough money");
                    alert.show();
                }
                break;
            case "Orangutan":
                if (money >= 50) {
                    dmg += 10;
                    GameScreen.money.setText((money - 50) + "");
                    mainGrid.add(starView, (int)pos.getX(), (int)pos.getY());
                } else {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Error");
                    alert.setHeaderText("Error");
                    alert.setContentText("You don't have enough money");
                    alert.show();
                }
            case "Gorilla":
                if (money >= 75) {
                    dmg += 15;
                    GameScreen.money.setText((money - 75) + "");
                    mainGrid.add(starView, (int)pos.getX(), (int)pos.getY());
                } else {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Error");
                    alert.setHeaderText("Error");
                    alert.setContentText("You don't have enough money");
                    alert.show();
                }
        }
    }

    public Point2D getPos() {
        return pos;
    }

    public void setPos(Point2D newPos) {
        pos = newPos;
    }

    public int getDmg() {
        return dmg;
    }

    public ImageView getTowerImageView() {
        return towerImageView;
    }

    public Image getTowerImage() {
        return towerImage;
    }
}
