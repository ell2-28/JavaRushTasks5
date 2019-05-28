package com.javarush.task.task12.task1207;

/* 
Int и Integer
*/

public class Solution {
    public static void main(String[] args) {
        print(1);
        print(new Integer(228));
    }

    //Напишите тут ваши методы
    public static void print(int a) {
        System.out.println("int" + a);
    }
    public static void print(Integer a) {
        System.out.println("Integer" + a);
    }
}
