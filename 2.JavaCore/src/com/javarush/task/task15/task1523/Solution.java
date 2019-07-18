package com.javarush.task.task15.task1523;

/* 
Перегрузка конструкторов
*/

public class Solution {

    public int a;
    public double b;
    public boolean c;
    public String s;

    public Solution(int a) {
        this.a = a;
    }
    protected Solution(double b) {
        this.b = b;
    }
    Solution(boolean c) {
        this.c = c;
    }
    private Solution(String s) {
        this.s = s;
    }


    public static void main(String[] args) {

    }
}

