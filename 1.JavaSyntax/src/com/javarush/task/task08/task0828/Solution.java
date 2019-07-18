package com.javarush.task.task08.task0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Номер месяца
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String monthName = reader.readLine(); //читаем с клавиатуры имя месяца

        Map<String, Integer> mapMonths = new HashMap<>(); //создаем и инициализируем мапу для хранения значений

        mapMonths.put("January", 1);
        mapMonths.put("February", 2);
        mapMonths.put("March", 3);
        mapMonths.put("April", 4);
        mapMonths.put("May", 5);
        mapMonths.put("June", 6);
        mapMonths.put("July", 7);
        mapMonths.put("August", 8);
        mapMonths.put("September", 9);
        mapMonths.put("October", 10);
        mapMonths.put("November", 11);
        mapMonths.put("December", 12);

        for (Map.Entry<String, Integer> pair : mapMonths.entrySet()) //цикл для мапы
        {
            if (pair.getKey().contains(monthName)) //перебирает ключи каждой пары и в случае contains совпадения с именем месяца введенным с клавиатуры выводит сообщение
            {
                System.out.println(monthName + " is the " + pair.getValue() + " month");
            }
        }
    }

}