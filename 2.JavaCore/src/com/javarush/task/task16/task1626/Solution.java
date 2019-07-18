package com.javarush.task.task16.task1626;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Solution {
    public static int number = 5;

    public static void main(String[] args) throws InterruptedException {
        new Thread(new CountdownRunnable(), "Уменьшаем").start();
        new Thread(new CountUpRunnable(), "Увеличиваем").start();
        //Thread.sleep(2000);
//        long start = System.currentTimeMillis();
//        Thread thread = new Thread(new CountUpRunnable(), "Увеличиваем");
//        thread.start();
//        thread.join();
//        long end = System.currentTimeMillis() - start;
//
//        System.out.println(new SimpleDateFormat("'seconds : ' s, 'miliseconds : ' S").format(new Date(end)));



}

    public static class CountUpRunnable implements Runnable {
        //Add your code here - добавь код тут
        private int countIndexUp = 1;

        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println(toString());
                    countIndexUp += 1;
                    Thread.sleep(500);
                    if (countIndexUp > number) return;
                }
            } catch (InterruptedException e) {
            }
        }
        public String toString() {
            return Thread.currentThread().getName() + ": " + countIndexUp;
        }

    }


    public static class CountdownRunnable implements Runnable {
        private int countIndexDown = Solution.number;

        public void run() {
            try {
                while (true) {
                    System.out.println(toString());
                    countIndexDown -= 1;
                    if (countIndexDown == 0) return;
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
            }
        }

        public String toString() {
            return Thread.currentThread().getName() + ": " + countIndexDown;
        }
    }
}
