package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        //напишите тут ваш код
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Вася", 1000);
        map.put("Дима", 12);
        map.put("Миша", 34);
        map.put("Вера", 45);
        map.put("Даша", 57);
        map.put("Петя", 78);
        map.put("Рита", 8);
        map.put("Таня", 5);
        map.put("Настя", 7);
        map.put("Игорь", 8888);
        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        HashMap<String, Integer> copy = new HashMap<>(map);
        for (Map.Entry<String, Integer> pair : copy.entrySet()) {
            if (pair.getValue() < 500)
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {

    }
}