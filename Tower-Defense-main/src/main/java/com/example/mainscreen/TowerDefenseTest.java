package com.example.mainscreen;

import org.junit.Before;
import org.junit.Test;

public class TowerDefenseTest {
    private GameScreen testScreen;

    @Before
    public void setUp() throws Exception{
        testScreen = new GameScreen(1280, 800);
    }

    @Test
    public void checkTowerOnPath() throws ExceptionInInitializerError {
     testScreen.setTower("Monkey Tower");

    }
}