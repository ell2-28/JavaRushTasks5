package com.javarush.games.snake;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;
import com.javarush.engine.cell.*;

public class Apple extends GameObject {

    public boolean isAlive = true;

    public Apple(int x, int y) {
    super(x, y);
    }

    private static final String APPLE_SIGN = "\uD83C\uDF4E";

    public void draw(Game g) {
        g.setCellValueEx(5, 5, Color.NONE, APPLE_SIGN, Color.YELLOW, 75);
    }
}