package com.javarush.task.task16.task1629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static volatile BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException, InterruptedException{
        Read3Strings t1 = new Read3Strings();
        Read3Strings t2 = new Read3Strings();

        t1.start();
        t1.join();

        t2.start();
        t2.join();
        //add your code here - добавьте код тут

        t1.interrupt();
        t2.interrupt();

        t1.printResult();
        t2.printResult();

        reader.close();
    }

    //add your code here - добавьте код тут
    public static class Read3Strings extends Thread {
        public String a;
        public String b;
        public String c;

        @Override
        public void run() {
            try {
                while (!isInterrupted()) {
                    if (reader.ready()) {
                        a = reader.readLine();
                        b = reader.readLine();
                        c = reader.readLine();
                        return;
                    }
                }

            } catch (IOException e) {
            }
        }
        public void printResult() {
            System.out.println(a + " " + b + " " + c);
        }

    }
}