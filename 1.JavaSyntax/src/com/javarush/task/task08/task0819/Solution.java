package com.javarush.task.task08.task0819;

import java.sql.SQLOutput;
import java.util.HashSet;
import java.util.Set;

/* 
Set из котов
*/

public class Solution {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();

        //напишите тут ваш код. step 3 - пункт 3

        for(Cat c : cats) {
            cats.remove(c);
            break;
        }

        printCats(cats);
    }

    public static Set<Cat> createCats() {
        //напишите тут ваш код. step 2 - пункт 2
        HashSet<Cat> set = new HashSet<>();
        Cat cat = new Cat();
        Cat cat2 = new Cat();
        Cat cat3 = new Cat();
        set.add(cat);
        set.add(cat2);
        set.add(cat3);
        return set;
    }

    public static void printCats(Set<Cat> cats) {
        // step 4 - пункт 4
        for (Cat cat : cats) {
            System.out.println(cats);
        }
    }

    // step 1 - пункт 1
    public static class Cat {

    }

    public Solution() {
    }
}
