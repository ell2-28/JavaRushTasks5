package com.javarush.games.snake;

import com.javarush.engine.cell.Game;
import com.javarush.engine.cell.*;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    public int x;
    public int y;
    public boolean isAlive = true;

    private Direction direction = Direction.LEFT;

//    public void setDirection(Direction direction) {
//        switch (direction) {
//            case RIGHT:
//                if (this.direction == Direction.LEFT) return;
//            case LEFT:
//                if (this.direction == Direction.RIGHT) return;
//            case UP:
//                if (this.direction == Direction.DOWN) return;
//            case DOWN:
//                if (this.direction == Direction.UP) return;
//        }
//        this.direction = direction;
//    }

    public void setDirection(Direction direction) {
        switch (this.direction) {
            case LEFT:
            case RIGHT:
                if (snakeParts.get(0).x == snakeParts.get(1).x) return;
                break;
            case UP:
            case DOWN:
                if (snakeParts.get(0).y == snakeParts.get(1).y) return;
                break;
        }
        this.direction = direction;
    }


    public Snake(int x, int y) {
        this.x = x;
        this.y = y;
        snakeParts.add(new GameObject(x, y));
        snakeParts.add(new GameObject(x + 1, y));
        snakeParts.add(new GameObject(x + 2, y));
    }

    private List<GameObject> snakeParts = new ArrayList<>();

    private final static String HEAD_SIGN = "\uD83D\uDC7E";
    private final static String BODY_SIGN = "\u26AB";

    public void draw(Game game) {
        if (!isAlive) {
            for (int i = 1; i < snakeParts.size(); i++) {
                GameObject body = snakeParts.get(i);
                game.setCellValueEx(body.x, body.y, Color.NONE, BODY_SIGN, Color.RED, 75);
            }
            GameObject head = snakeParts.get(0);
            game.setCellValueEx(head.x, head.y, Color.NONE, HEAD_SIGN, Color.RED, 75);
        } else {
            for (int i = 1; i < snakeParts.size(); i++) {
                GameObject body = snakeParts.get(i);
                game.setCellValueEx(body.x, body.y, Color.NONE, BODY_SIGN, Color.GREEN, 75);
            }
            GameObject head = snakeParts.get(0);
            game.setCellValueEx(head.x, head.y, Color.NONE, HEAD_SIGN, Color.GREEN, 75);
        }
    }

    public void move(Apple apple) {
        GameObject newHead = createNewHead();
        if (checkCollision(newHead)) {
            isAlive = false;
            return;
        }
        if (newHead.x < 0 || newHead.x >= SnakeGame.WIDTH ||
                newHead.y < 0 || newHead.y >= SnakeGame.HEIGHT) {
            isAlive = false;
            return;
        }
        if (apple.x == newHead.x && apple.y == newHead.y) {
            apple.isAlive = false;
        } else {
            removeTail();
        }
        snakeParts.add(0, newHead);

    }

    public GameObject createNewHead() {
        GameObject result = null;
        switch (direction) {
            case LEFT:
                result = new GameObject(snakeParts.get(0).x - 1, snakeParts.get(0).y);
                break;
            case RIGHT:
                result = new GameObject(snakeParts.get(0).x + 1, snakeParts.get(0).y);
                break;
            case UP:
                result = new GameObject(snakeParts.get(0).x, snakeParts.get(0).y - 1);
                break;
            case DOWN:
                result = new GameObject(snakeParts.get(0).x, snakeParts.get(0).y + 1);
                break;
        }
        return result;
    }

    public void removeTail() {
        snakeParts.remove(snakeParts.size() - 1);
    }

    public boolean checkCollision(GameObject obj) {
        for (int i = 0; i < snakeParts.size(); i++) {
            if (snakeParts.get(i).x == obj.x && snakeParts.get(i).y == obj.y) {
                return true;
            }
        }
        return false;
    }

    public int getLength() {
        return snakeParts.size();
    }

}
