package com.javarush.task.task07.task0716;

import java.util.ArrayList;

/* 
Р или Л
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<String>();
        list.add("роза"); // 0
        list.add("лоза"); // 1
        list.add("лира"); // 2
        list = fix(list);

        for (String s : list) {
            System.out.println(s);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> list) {
        ArrayList<String> res = new ArrayList<>();
        for (String s : list) {
            if (s.contains("р") && s.contains("л")) {
                res.add(s);
            } else if (s.contains("р")) {
                //NOP
            } else if (s.contains("л")) {
                res.add(s);
                res.add(s);
            } else {
                res.add(s);
            }
        }
        return res;
    }
}