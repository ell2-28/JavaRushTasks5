package com.javarush.task.task09.task0927;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* 
Десять котов
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap() {
        //напишите тут ваш код
        HashMap<String, Cat> map = new HashMap<>();
        map.put("cat1", new Cat("vasya"));
        map.put("cat2", new Cat("masha"));
        map.put("cat3", new Cat("baget"));
        map.put("cat4", new Cat("butus"));
        map.put("cat5", new Cat("baton"));
        map.put("cat6", new Cat("keks"));
        map.put("cat7", new Cat("reks"));
        map.put("cat8", new Cat("lol"));
        map.put("cat9", new Cat("lil"));
        map.put("cat10", new Cat("moms"));
        return map;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        //напишите тут ваш код
        return new HashSet<Cat>(map.values());
    }

    public static void printCatSet(Set<Cat> set) {
        for (Cat cat : set) {
            System.out.println(cat);
        }
    }

    public static class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        public String toString() {
            return "Cat " + this.name;
        }
    }


}
