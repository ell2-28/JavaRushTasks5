package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {

        int count = 0;
        if(args.length > 0){
            FileInputStream in = new FileInputStream(args[0]);

            while(in.available() > 0){
                int data = in.read();
                if((data >= (int) 'A' && data <= (int) 'Z')
                        || (data >= (int) 'a' && data <= (int) 'z')){
                    count++;
                }
            }

            in.close();
        }

        System.out.println(Integer.valueOf(count));

    }
}