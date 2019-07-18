package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/
import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            throw new IllegalArgumentException();
        }

        File file1 = new File(args[0]);
        FileInputStream in = new FileInputStream(file1);
        TreeMap<Character, Integer> map = new TreeMap<>();
        byte[] data;
        char[] c = new char[0];


        while(in.available() > 0){
            data = new byte[in.available()];
            in.read(data);
            c = new String(data).toCharArray();
        }

        for(char b : c){
            if(map.containsKey(b)){
                int val = map.get(b) + 1;
                map.put(b, val);
            } else {
                map.put(b, 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        in.close();
    }
}