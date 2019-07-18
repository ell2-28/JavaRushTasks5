package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Парсер реквестов
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        //String url = "http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo";// reader.readLine();
        //String url = "http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo";
        //Вывод:        //lvl view name

        String url2 = url.substring(url.indexOf("?") + 1); // обрезает после знака
        //System.out.println(url2 + "\n"); // line after '?' sign

        String segments[] = url2.split("&");
        ArrayList<String> beforeArr = new ArrayList<>();
        ArrayList<Object> afterArr = new ArrayList<>();
        ArrayList<Object> objNumber = new ArrayList<>();

        for (String a : segments
        ) {
            String beforeSign = null;
            String afterSign = null;
            if (a.contains("=")) { // если в строке есть равно
                beforeSign = a;
                afterSign = a;
                beforeSign = beforeSign.substring(0, beforeSign.indexOf("="));// оставляет все что находится перед = равно
                afterSign = afterSign.substring(afterSign.lastIndexOf("=") + 1);
                // System.out.println("Before sign: " + beforeSign);
                // System.out.println("After sign: " + afterSign);

                beforeArr.add(beforeSign);
                afterArr.add(afterSign);
                if(beforeSign.equals("obj")){
                    //double x = Double.parseDouble(afterSign);
                    // objNumber.add(x);
                    objNumber.add(afterSign);
                }

            }
            if (!a.contains("=")) {
                beforeArr.add(a);
                afterArr.add(0);
            }
        }
        //   System.out.println("Arrays: " + beforeArr.toString() + afterArr.toString());
        //    System.out.println("Object numbers (if so): " + objNumber.toString());

        String x = "";
        for (String s: beforeArr
        ) {

            x +=s + " ";

            // System.out.print(s + " ");
        }
        String  y = x.trim();
        System.out.println(y);
        for (Object n:objNumber
        ) {

            try{
                //if(n instanceof Double){
                String d = (String) n;
                alert((double)Double.parseDouble(d));
                // }
            }

            catch(Exception e){
                String string = (String) n;
                alert((String)string);
            }
        }
    }



    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}