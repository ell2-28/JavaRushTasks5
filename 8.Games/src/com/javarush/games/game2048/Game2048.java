package com.javarush.games.game2048;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;

public class Game2048 extends Game {
    private static final int SIDE = 4;// переменная, в которой хранится размерность массива
    private int[][] gameField = new int[SIDE][SIDE]; // создаем двумерный массив int размером SIDExSIDE

    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);//устанавливаем размер поля 4х4
        createGame();//создаем игру
        drawScene();//рисуем, раскрашиваем поле
    }

    private void createGame(){
        createNewNumber();
        createNewNumber();
    }

    private void drawScene() {
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                //setCellColor(i, j, Color.GREEN);
                setCellColoredNumber(j, i, gameField[i][j]);//хз какой порядок
            }
        }
    }

    private void createNewNumber() {
        int x, y;
        do {
            x = getRandomNumber(SIDE);
            y = getRandomNumber(SIDE);
        }
        while (gameField[y][x]!= 0);

        if (getRandomNumber(10) == 9) {
            gameField[y][x] = 4;
        }
        else {
            gameField[y][x] = 2;
        }
    }

    private Color getColorByValue(int value) {
        if (value == 0) return Color.GREEN;
        else if (value == 2) return Color.DARKRED;
        else if (value == 4) return Color.YELLOW;
        else if (value == 8) return Color.DARKSEAGREEN;
        else if (value == 16) return Color.AZURE;
        else if (value == 32) return Color.BISQUE;
        else if (value == 64) return Color.BLUEVIOLET;
        else if (value == 128) return Color.CYAN;
        else if (value == 256) return Color.DARKCYAN;
        else if (value == 512) return Color.ALICEBLUE;
        else if (value == 1024) return Color.GRAY;
        else if (value == 2038) return Color.GOLD;
        return null;
    }

    private void setCellColoredNumber(int x, int y, int value) {
        if (value == 0) {
            setCellValueEx(x, y, getColorByValue(value), "");
        }
        else setCellValueEx(x, y, getColorByValue(value), "" + value);
    }

    private boolean compressRow(int[] row){
        boolean move = false;
        for(int i = 1; i < row.length; i++){
            if(row[i] == 0) continue;
            if(row[i] != 0 && row[i-1] == 0){
                row[i-1] = row[i];
                row[i] = 0;
                move = true;
                i = 0;
            }
        }
        return move;
    }
}
