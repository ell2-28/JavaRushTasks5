package com.javarush.task.task08.task0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Модернизация ПО
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> map = new HashMap<>(); //список городов и фамилий в мапу/базу

        while (true) {
            String city = reader.readLine();
            if (city.isEmpty())
                break;
            else {
                String lastName = reader.readLine();
                map.put(city, lastName);
            }
        }

        String city = reader.readLine(); //считываем с клавиатуры город, по которому нужно узнать фамилию

        for (Map.Entry<String, String> pair : map.entrySet()) {
            if (pair.getKey().equals(city))
                System.out.println(pair.getValue());
        }
    }
}
