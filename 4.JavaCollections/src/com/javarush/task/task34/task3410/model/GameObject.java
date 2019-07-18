package com.javarush.task.task34.task3410.model;

import java.awt.*;

import static com.javarush.task.task34.task3410.model.Model.FIELD_CELL_SIZE;

public abstract class GameObject {
    public int x, y, width, height;
    public static final int FIELD_CELL_SIZE = 20;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public GameObject(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = FIELD_CELL_SIZE;
        this.height = FIELD_CELL_SIZE;
    }

    public GameObject(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public abstract void draw(Graphics graphics);

}
