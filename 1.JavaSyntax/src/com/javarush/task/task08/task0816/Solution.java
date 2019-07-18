package com.javarush.task.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static HashMap<String, Date> createMap() throws ParseException {
        DateFormat df = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", df.parse("JUNE 1 1980"));
        map.put("Pavlov", df.parse("JUNE 1 1980"));
        map.put("Ivanov", df.parse("JUNE 1 1985"));
        map.put("Kekov", df.parse("JUNE 1 1980"));
        map.put("Tarkov", df.parse("JUNE 1 1980"));
        map.put("Rakov", df.parse("JUNE 1 1982"));
        map.put("Stalone", df.parse("JUNE 1 1980"));
        map.put("Ponne", df.parse("JUNE 1 1980"));
        map.put("Statam", df.parse("JUNE 1 1980"));
        map.put("Rekt", df.parse("JUNE 1 1990"));

        //напишите тут ваш код
        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {
        //напишите тут ваш код
        Iterator<Map.Entry<String,Date>> iter = map.entrySet().iterator();

        while (iter.hasNext()) {
            Map.Entry<String,Date> entry = iter.next();
            if (entry.getValue().getMonth() > 4 && entry.getValue().getMonth() < 8) {
                iter.remove();
            }
        }

    }

    public static void main(String[] args) {

    }
}
