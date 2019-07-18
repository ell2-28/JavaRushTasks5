package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();

        FileInputStream inputStream = new FileInputStream(name);
        long res = 0;
        while (inputStream.available() > 0) {
            int data = inputStream.read();
            if (data > res) {
                res = data;
            }
        }
        inputStream.close();
        System.out.println(res);
        ///Users/ell/Downloads/log-file_2.txt
        ///Users/ell/Desktop/log-file_2.txt
    }
}
