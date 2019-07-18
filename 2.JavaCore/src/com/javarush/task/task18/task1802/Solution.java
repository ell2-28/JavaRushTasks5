package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();

        FileInputStream inputStream = new FileInputStream(name);
        int res = 2147483647;
        while (inputStream.available() > 0) //пока остались непрочитанные байты
        {
            int data = inputStream.read();
            if (data < res) {
                res = data;
            }
        }
        inputStream.close();
        System.out.println(res);
    }
}
