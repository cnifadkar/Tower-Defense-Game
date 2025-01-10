package com.example.mainscreen;

import javafx.animation.*;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.effect.Light;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.transform.Translate;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicReference;

public class GameScreen extends GameState {
    private static GameScreen instance;

    public static Text money;
    public static Text health;
    public static Text diff;


    private int enemiesKilled;
    private int damageDealt;
    private int moneySpent;



    public StackPane root = new StackPane();

    GridPane mainGrid = new GridPane();

    BorderPane stats = new BorderPane();

    ArrayList<Enemy> enemyList = new ArrayList<>();
    ArrayList<Tower> towerList = new ArrayList<>();

    Tower mTower;
    Tower oTower;
    Tower gTower;

    public GameScreen(int width, int height) {
        super(width, height);
        InputStream stream2 = null;
        InputStream stream1 = null;
        InputStream stream = null;
        try {
            stream2 = new FileInputStream("src/assets/bananaTree.png"); //comment
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image tree = new Image(stream2);
        ImageView treeView = new ImageView();
        treeView.setImage(tree);
        treeView.setFitHeight(250);
        treeView.setFitWidth(250);

        try {
            stream = new FileInputStream("src/assets/goldCoin.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image coin = new Image(stream);
        ImageView coinView = new ImageView();
        coinView.setImage(coin);
        coinView.setFitHeight(100);
        coinView.setFitWidth(100);

        try {
            stream1 = new FileInputStream("src/assets/heart.jpg");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Image heart = new Image(stream1);
        ImageView heartView = new ImageView();
        heartView.setImage(heart);
        heartView.setFitHeight(100);
        heartView.setFitWidth(100);
        if (money == null) {
            money = new Text("100");
            money.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 50));
        }
        if (health == null) {
            health = new Text("120");
            health.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 50));
        }
        if (diff == null) {
            diff = new Text("Easy");
            diff.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 50));
        }

        //Create buy button

        Button buyButton = new Button("Buy Towers");
        buyButton.setOnAction(value -> {
            Controller.getInstance().setState(new BuyTowers(1280, 800));
        });

        //Create Start Combat button

        Button startCombatButton = new Button("Start Combat");
        startCombatButton.setOnAction(value -> {
            try {
                startCombat();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        //Add money and health


        HBox hbox = new HBox();
        hbox.getChildren().addAll(coinView, money, heartView, health);

        HBox hbox1 = new HBox();
        hbox1.getChildren().add(diff);
        hbox1.setAlignment(Pos.CENTER_RIGHT);

        HBox hButton = new HBox();
        hButton.getChildren().add(buyButton);
        hButton.setAlignment(Pos.BOTTOM_CENTER);

        HBox sButton = new HBox();
        sButton.getChildren().add(startCombatButton);
        sButton.setAlignment(Pos.BOTTOM_CENTER);

        HBox monument = new HBox();
        monument.getChildren().add(treeView);
        monument.setAlignment(Pos.TOP_LEFT);

        stats.setPadding(new Insets(10, 20, 10, 20));

        mainGrid.setAlignment(Pos.CENTER_LEFT);

        //PATH AND TOWER SPACE CODE BEGINS!!!.....
        //........................................
        //........................................

        for (int i = 0; i <= 10; i++) {
            for (int z = 0; z <= 4; z++) {
                Rectangle block = new Rectangle();
                block.setHeight(100);
                block.setWidth(100);

                if (i == 0 && z == 0) {
                    block.setFill(Color.rgb(140, 140, 140));
                    mainGrid.add(block, i, z);
                } else if (i == 1 && z == 0) {
                    block.setFill(Color.rgb(140, 140, 140));
                    mainGrid.add(block, i, z);
                } else if (i == 2 && z == 0) {
                    block.setFill(Color.rgb(140, 140, 140));
                    mainGrid.add(block, i, z);
                } else if (i == 2 && z == 1) {
                    block.setFill(Color.rgb(140, 140, 140));
                    mainGrid.add(block, i, z);
                } else if (i == 2 && z == 2) {
                    block.setFill(Color.rgb(140, 140, 140));
                    mainGrid.add(block, i, z);
                } else if (i == 2 && z == 3) {
                    block.setFill(Color.rgb(140, 140, 140));
                    mainGrid.add(block, i, z);
                } else if (i == 2 && z == 4) {
                    block.setFill(Color.rgb(140, 140, 140));
                    mainGrid.add(block, i, z);
                } else if (i == 3 && z == 4) {
                    block.setFill(Color.rgb(140, 140, 140));
                    mainGrid.add(block, i, z);
                } else if (i == 4 && z == 4) {
                    block.setFill(Color.rgb(140, 140, 140));
                    mainGrid.add(block, i, z);
                } else if (i == 5 && z == 4) {
                    block.setFill(Color.rgb(140, 140, 140));
                    mainGrid.add(block, i, z);
                } else if (i == 6 && z == 4) {
                    block.setFill(Color.rgb(140, 140, 140));
                    mainGrid.add(block, i, z);
                } else if (i == 6 && z == 3) {
                    block.setFill(Color.rgb(140, 140, 140));
                    mainGrid.add(block, i, z);
                } else if (i == 6 && z == 2) {
                    block.setFill(Color.rgb(140, 140, 140));
                    mainGrid.add(block, i, z);
                } else if (i == 7 && z == 2) {
                    block.setFill(Color.rgb(140, 140, 140));
                    mainGrid.add(block, i, z);
                } else if (i == 8 && z == 2) {
                    block.setFill(Color.rgb(140, 140, 140));
                    mainGrid.add(block, i, z);
                } else if (i == 8 && z == 1) {
                    block.setFill(Color.rgb(140, 140, 140));
                    mainGrid.add(block, i, z);
                } else if (i == 8 && z == 0) {
                    block.setFill(Color.rgb(140, 140, 140));
                    mainGrid.add(block, i, z);
                } else if (i == 9 && z == 0) {
                    block.setFill(Color.rgb(140, 140, 140));
                    mainGrid.add(block, i, z);
                } else if (i == 10 && z == 0) {
                    block.setFill(Color.rgb(140, 140, 140));
                    mainGrid.add(block, i, z);
                } else {
                    block.setFill(Color.rgb(34, 139, 39));
                    mainGrid.add(block, i, z);
                }
            }
        }

        mainGrid.setGridLinesVisible(true);
        //PATH AND TOWER SPACE CODE ENDS!!!.....
        //........................................
        //........................................


        stats.setTop(hbox);
        stats.setBottom(hbox1);
        stats.setLeft(hButton);
        stats.setBottom(sButton);
        stats.setCenter(mainGrid);
        stats.setRight(monument);
        showEnemies();

        root.getChildren().addAll(mainGrid, stats);
        root.setStyle("-fx-background-color: rgb(78, 207, 89);");
        scene = new Scene(root, 1280, 800);

    }

    public static GameScreen getInstance() {
        if (instance == null) {
            resetInstance();
        }
        return instance;
    }

    public static void resetInstance() {
        instance = new GameScreen(1280, 800);
    }


    public void setDifficulty(String difficulty) {
        if (difficulty.equals("easy")) {
            money.setText("100");
            health.setText("120");
            diff.setText("Easy");
        } else if (difficulty.equals("medium")) {
            money.setText("80");
            health.setText("100");
            diff.setText("Medium");
        } else if (difficulty.equals("hard")) {
            money.setText("60");
            health.setText("80");
            diff.setText("Hard");
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void setTower(String tower) {
        int mon = Integer.parseInt(money.getText());
        if (tower.equals("Gorilla Tower")) {
            gTower = new Tower("Gorilla", new Point2D(0, 0));
            if ((mon >= 200 && diff.getText().equals("Easy")) || ((
                    mon >= 250 && diff.getText().equals("Medium"))) || ((
                    mon >= 300 & diff.getText().equals("Hard")))) {
                if (diff.getText().equals("Easy")) {
                    mon -= 200;
                    moneySpent += 200;
                } else if (diff.getText().equals("Medium")) {
                    mon -= 250;
                    moneySpent += 250;
                } else {
                    mon -= 300;
                    moneySpent += 300;
                }
                money.setText(mon + "");

                EventHandler<MouseEvent> handler = new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        int xCoord = (int) mouseEvent.getX();
                        int yCoord = (int) mouseEvent.getY();

                        System.out.println(xCoord);
                        System.out.println(yCoord);

                        int[][] path = {{0,0},{1,0},{2,0},{2,1},{2,2},{2,3},{2,4},{3,4},{4,4},{5,4}, {6,4},{6,3},{6,2},{7,2},{8,2},{8,1},{8,0},{9,0},{10,0}};
                        int xGrid = xCoord/100;
                        int yGrid = (yCoord-150)/100;
                        boolean onPath = false;
                        for (int[] item : path) {
                            if (item[0] == xGrid && item[1] == yGrid) {
                                onPath = true;
                            }
                        }
                        gTower.setPos(new Point2D(xGrid, yGrid));
                        if (!onPath) {
                            mainGrid.add(gTower.getTowerImageView(), xGrid, yGrid);
                        }
                        towerList.add(gTower);
                        root.removeEventHandler(MouseEvent.MOUSE_CLICKED, this);
                    }
                };
                root.addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
            } else {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Error");
                alert.setHeaderText("Error");
                alert.setContentText("You don't have enough money");
                alert.show();
            }
        } else if (tower.equals("Monkey Tower")) {
            //this is the smallest tower so you must have be able to buy it immediately
            mTower = new Tower("Monkey", new Point2D(0, 0));
            if ((mon >= 50 && diff.getText().equals("Easy")) || ((
                    mon >= 55 && diff.getText().equals("Medium"))) || ((
                    mon >= 60 & diff.getText().equals("Hard")))) {
                if (diff.getText().equals("Easy")) {
                    mon -= 50;
                    moneySpent += 50;
                } else if (diff.getText().equals("Medium")) {
                    mon -= 55;
                    moneySpent += 55;
                } else {
                    mon -= 60;
                    moneySpent += 60;
                }
                money.setText(mon + "");

                EventHandler<MouseEvent> handler = new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        System.out.println("stop");
                        int xCoord = (int) mouseEvent.getX();
                        int yCoord = (int) mouseEvent.getY();

                        System.out.println(xCoord);
                        System.out.println(yCoord);

                        int[][] path = {{0,0},{1,0},{2,0},{2,1},{2,2},{2,3},{2,4},{3,4},{4,4},{5,4}, {6,4},{6,3},{6,2},{7,2},{8,2},{8,1},{8,0},{9,0},{10,0}};
                        int xGrid = xCoord/100;
                        int yGrid = (yCoord-150)/100;
                        boolean onPath = false;
                        for (int[] item : path) {
                            if (item[0] == xGrid && item[1] == yGrid) {
                                onPath = true;
                            }
                        }
                        mTower = new Tower("Monkey", new Point2D(xGrid, yGrid));
                        if (!onPath) {
                            mainGrid.add(mTower.getTowerImageView(), xGrid, yGrid);
                        }
                        towerList.add(mTower);
                        root.removeEventHandler(MouseEvent.MOUSE_CLICKED, this);
                    }
                };
                root.addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
            } else {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Error");
                alert.setHeaderText("Error");
                alert.setContentText("You don't have enough money");
                alert.show();
            }

        } else if (tower.equals("Orangutan Tower")) {
            oTower = new Tower("Orangutan", new Point2D(0, 0));
            if ((mon >= 100 && diff.getText().equals("Easy")) || ((
                    mon >= 125 && diff.getText().equals("Medium")))
                    || ((mon >= 150 & diff.getText().equals("Hard")))) {
                if (diff.getText().equals("Easy")) {
                    mon -= 100;
                    moneySpent += 100;
                } else if (diff.getText().equals("Medium")) {
                    mon -= 125;
                    moneySpent += 125;
                } else {
                    mon -= 150;
                    moneySpent += 150;
                }
                money.setText(mon + "");

                EventHandler<MouseEvent> handler = new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        int xCoord = (int) mouseEvent.getX();
                        int yCoord = (int) mouseEvent.getY();

                        System.out.println(xCoord);
                        System.out.println(yCoord);

                        int[][] path = {{0,0},{1,0},{2,0},{2,1},{2,2},{2,3},{2,4},{3,4},{4,4},{5,4}, {6,4},{6,3},{6,2},{7,2},{8,2},{8,1},{8,0},{9,0},{10,0}};
                        int xGrid = xCoord/100;
                        int yGrid = (yCoord-150)/100;
                        boolean onPath = false;
                        for (int[] item : path) {
                            if (item[0] == xGrid && item[1] == yGrid) {
                                onPath = true;
                            }
                        }
                        if (!onPath) {
                            mainGrid.add(oTower.getTowerImageView(), xGrid, yGrid);
                        }
                        towerList.add(oTower);
                        root.removeEventHandler(MouseEvent.MOUSE_CLICKED, this);
                    }
                };
                root.addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
            } else {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Error");
                alert.setHeaderText("Error");
                alert.setContentText("You don't have enough money");
                alert.show();
            }

        } else {
            throw new IllegalArgumentException();
        }
    }

    public void showEnemies() {
        Enemy toucanEnemy = new Enemy("Toucan", new Point2D(0, 0));
        Enemy jaguarEnemy = new Enemy("Jaguar", new Point2D(0, 0));
        Enemy snakeEnemy = new Enemy("Snake", new Point2D(0, 0));
        enemyList.add(toucanEnemy);
        enemyList.add(jaguarEnemy);
        enemyList.add(snakeEnemy);
    }


    public int[] convertGrid(int x, int y) {
        int[] temp = {-1, 1};
        if (x == 0 && y == 0) {
            temp[0] = 0;
            temp[1] = 0;
        } else {
            temp[0] = 50 + (100 * x);
            temp[1] = y * 50;
        }
        return temp;
    }

    public Path pathCreation(Enemy enemy) {
        Path path = new Path();
        MoveTo move = new MoveTo(50, 50);
        LineTo line1 = new LineTo(250, 50);
        LineTo line2 = new LineTo(250, 450);
        LineTo line3 = new LineTo(650, 450);
        LineTo line4 = new LineTo(650, 250);
        LineTo line5 = new LineTo(850, 250);
        LineTo line6 = new LineTo(850, 50);
        LineTo line7 = new LineTo(1050, 50);
        path.getElements().add(move);
        path.getElements().addAll(line1, line2, line3, line4, line5, line6, line7);
        return path;
    }

    HashMap<Enemy, PathTransition> pathTransitions = new HashMap<>();

    public void moveEnemies(Enemy enemy, Path path) {
        PathTransition enemyTransition = new PathTransition();
        enemyTransition.setDuration(Duration.seconds(30));
        enemyTransition.setPath(path);
        enemyTransition.setNode(enemy.getEnemyImageView());
        enemyTransition.play();
        pathTransitions.put(enemy, enemyTransition);
    }

    public AnimationTimer attackEnemies() throws InterruptedException {
        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                for (Enemy enemy : enemyList) {
                    if (enemy.getHealth() <= 0 && !enemy.checkIfDestroyed()) {
                        System.out.println("Enemy destroyed");
                        enemy.destroy();
                        enemiesKilled++;
                        pathTransitions.get(enemy).stop();
                    } else {
                        for (Tower tower : towerList) {
                            if (!enemy.checkIfDestroyed()) {
                                tower.attack(enemy);
                                damageDealt += tower.getDmg();
                            }
                        }
                    }
                }
            }
        };
        return animationTimer;
    }
    Enemy finalEnemy = new Enemy("Final", new Point2D(0, 0));

    public AnimationTimer spawnFinalBoss() {
        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                finalEnemy.update();
                Path path = pathCreation(finalEnemy);
                enemyList.add(finalEnemy);
                Platform.runLater(() ->mainGrid.add(enemyList.get(3).getEnemyImageView(), 0, 0));
                Platform.runLater(() -> moveEnemies(finalEnemy, path));
            }
        };
        return animationTimer;
    }

    boolean finalIsSpawned = false;

    public void keepAttacking() {
        new Timer().schedule(
                new TimerTask() {
                    @Override
                    public void run() {
                        int monuHealth = Integer.parseInt(health.getText());
                        System.out.println(enemiesKilled);
                        if (enemiesKilled == 3 && !finalIsSpawned){
                            System.out.println("hi");
                            spawnFinalBoss().handle(0);
                            finalIsSpawned = true;
                        } else if (monuHealth > 0 && enemiesKilled != 4) {
                            try {
                                if (enemiesKilled == 3 && finalIsSpawned) {
                                    System.out.println(enemyList.get(3).getHealth());
                                }
                                attackEnemies().handle(0);
                                //System.out.println(enemyList.get(0).getType() + ": " + enemyList.get(0).getHealth());
                                //System.out.println(enemyList.get(1).getType() + ": " + enemyList.get(1).getHealth());
                                //System.out.println(enemyList.get(2).getType() + ": " + enemyList.get(2).getHealth());
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } else if (enemiesKilled == 4) {
                            Platform.runLater(() ->Controller.getInstance().setState(new WinScreen(1280, 800, enemiesKilled, damageDealt, moneySpent)));
                            cancel();
                        } else {
                            cancel();
                        }
                    }
                }, 0, 1500);
    }

    boolean towerUpgraded = false;

    public void upgradeTower() {
        EventHandler<MouseEvent> handler = mouseEvent -> {
            int xCoord = (int) mouseEvent.getX();
            int yCoord = (int) mouseEvent.getY();

            int xGrid = xCoord / 100;
            int yGrid = (yCoord - 150) / 100;

            for (Tower tower : towerList) {
                if (tower.getPos().equals(new Point2D(xGrid, yGrid))) {
                    tower.upgrade(mainGrid);
                    towerUpgraded = true;
                }
            }
        };
        root.addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
    }

    public void startCombat() throws InterruptedException {
        mainGrid.add(enemyList.get(0).getEnemyImageView(), 0, 0);
        mainGrid.add(enemyList.get(1).getEnemyImageView(), 0, 0);
        mainGrid.add(enemyList.get(2).getEnemyImageView(), 0, 0);

        for (Enemy enemy : enemyList) {
            enemy.update();
            Path path = pathCreation(enemy);
            Platform.runLater(() -> moveEnemies(enemy, path));
        }

        upgradeTower();
        keepAttacking();
    }

    public int getEnemiesKilled() {
        return enemiesKilled;
    }

    public int getDamageDealt() {
        return damageDealt;
    }

    public int getMoneySpent() {
        return moneySpent;
    }

    public void setEnemiesKilled(int enemiesKilled) {
        this.enemiesKilled = enemiesKilled;
    }

}