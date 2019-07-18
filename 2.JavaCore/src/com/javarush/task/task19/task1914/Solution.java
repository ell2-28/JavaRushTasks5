package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream defaultPrintStream = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        testString.printSomething();
        System.setOut(defaultPrintStream);

        String result = byteArrayOutputStream.toString();
        String[] resultArray = result.split(" ");
        int firstNum = Integer.parseInt(resultArray[0]);
        int secondNum = Integer.parseInt(resultArray[2]);
        int arithmeticResult;

        switch (resultArray[1]) {
            case "+":
                arithmeticResult = firstNum + secondNum;
                break;
            case "-":
                arithmeticResult = firstNum - secondNum;
                break;
            default:
                arithmeticResult = firstNum * secondNum;
                break;
        }

        System.out.println(firstNum + " " + resultArray[1] + " " + secondNum + " = " + arithmeticResult);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

