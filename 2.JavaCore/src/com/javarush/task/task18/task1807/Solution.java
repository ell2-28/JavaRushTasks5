package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        FileInputStream inputStream = new FileInputStream(name);
        int res = 0;
        while (inputStream.available() > 0) {
            int data = inputStream.read();
            if (data == 0x2C) {
                res = res + 1;
            }
        }
        System.out.println(res);
        inputStream.close();
    }
}
