package com.javarush.task.task38.task3803;

/* 
Runtime исключения (unchecked exception)
*/


import java.util.Objects;

public class VeryComplexClass {
    public void methodThrowsClassCastException() {
        Object i = Integer.valueOf(42);
        String s = (String)i;
    }

    public void methodThrowsNullPointerException() {
        Object object = null;
        object.hashCode();
    }

    public static void main(String[] args) {
        //methodThrowsNullPointerException();
        //methodThrowsClassCastException();
    }
}
