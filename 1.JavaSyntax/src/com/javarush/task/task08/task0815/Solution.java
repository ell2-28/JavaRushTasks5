package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* 
Перепись населения
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<>();
        map.put("Ivanhov", "Ivan");
        map.put("Ivanov", "Pavel");
        map.put("Petrmov", "Petr");
        map.put("Petrov", "Slava");
        map.put("Zlvoi", "Petr");
        map.put("Zloi", "Ivan");
        map.put("Reg", "Petthr");
        map.put("bgfn", "trewf");
        map.put("Petrewdov", "Pewwtr");
        map.put("Pefghtrov", "Peeetr");
        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
        //напишите тут ваш код
        int count = 0;
        for (String s : map.values())
            if (s.equals(name))
                count += 1;
        return count;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {
        //напишите тут ваш код
        int count = 0;
        for (String s : map.keySet())
            if (s.equals(lastName))
                count += 1;
        return count;
    }

    public static void main(String[] args) {

    }
}
