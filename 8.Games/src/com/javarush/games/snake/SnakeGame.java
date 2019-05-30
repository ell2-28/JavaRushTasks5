package com.javarush.games.snake;

import com.javarush.engine.cell.*;
import com.javarush.engine.cell.Game;

public class SnakeGame extends Game {
    public boolean isAlive = true;
    public static final int WIDTH = 15;
    public static final int HEIGHT = 15;
    private int turnDelay;
    private Apple apple;
    private boolean isGameStopped;
    private static final int GOAL = 28;
    private int score;

    @Override
    public void initialize() {
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }

    private void createGame(){
        score = 0;
        setScore(score);
        snake = new Snake(WIDTH / 2, HEIGHT / 2);
        //apple = new Apple(5, 5);
        createNewApple();
        isGameStopped = false;
        drawScene();
        turnDelay = 300;
        setTurnTimer(turnDelay);
    }

    private void drawScene(){
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < WIDTH; j++) {
                //setCellColor(i, j, Color.AQUA);
                setCellValueEx(i, j, Color.DARKSEAGREEN, "");
            }
        }
        snake.draw(this);
        apple.draw(this);
    }

    private Snake snake;


    @Override
    public void onTurn(int step) {

        snake.move(apple);
        if (!apple.isAlive) {
            createNewApple();
            score = score + 5;
            setScore(score);
            turnDelay = turnDelay - 10;
            setTurnTimer(turnDelay);
        }
        if (!snake.isAlive) { //isAlive == false
            gameOver();
        }
        if (GOAL < snake.getLength()) {
            win();
        }
        drawScene();


    }

    @Override
    public void onKeyPress(Key key) {
        if (key == Key.LEFT) {
            snake.setDirection(Direction.LEFT);
        }
        else if (key == Key.RIGHT) {
            snake.setDirection(Direction.RIGHT);
        }
        else if (key == Key.UP) {
            snake.setDirection(Direction.UP);
        }
        else if (key == Key.DOWN) {
            snake.setDirection(Direction.DOWN);
        }
        else if (isGameStopped == true && key == Key.SPACE) {
            createGame();
        }
    }

    private void createNewApple() {
        do {
            apple = new Apple(getRandomNumber(WIDTH), getRandomNumber(HEIGHT));
        }
        while (snake.checkCollision(apple));
    }

    private void gameOver() {
        this.stopTurnTimer();
        isGameStopped = true;
        this.showMessageDialog(Color.RED, "Game Over", Color.GREEN, 30);
    }

    private void win() {
        stopTurnTimer();
        isGameStopped = true;
        showMessageDialog(Color.RED, "UWIN", Color.GREEN, 40);

    }


}

