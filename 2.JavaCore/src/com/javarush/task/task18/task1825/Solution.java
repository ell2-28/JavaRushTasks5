package com.javarush.task.task18.task1825;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/* 
Собираем файл
*/


import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;
public class Solution {
    public static void main(String[] args) throws IOException {
        //String testString = "Lion.avi.part3\nLion.avi.part2\nPumba.avi.part2\nLion.avi.part4\nLion.avi.part1\nPumba.avi.part1\nend";
        //System.setIn(new ByteArrayInputStream(testString.getBytes()));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s;
        TreeSet<String> set = new TreeSet<>();
        for (s = reader.readLine(); !s.equals("end"); s = reader.readLine())
            set.add(s);
        reader.close();
        String currentFileName = "", nextName;
        FileOutputStream out = null;
        Iterator<String> iterator =  set.iterator();
        while (iterator.hasNext()) {
            nextName = iterator.next();
            if (!nextName.contains(currentFileName) || currentFileName.equals("")) {
                if (out != null) out.close();
                currentFileName = nextName.substring(0, nextName.lastIndexOf('.'));
                out = new FileOutputStream(currentFileName);
            }
            FileInputStream in = new FileInputStream(nextName);
            byte[] buf = new byte[in.available()];
            while (in.available() > 0) {
                int readed = in.read(buf);
                out.write(buf, 0, readed);
            }
            in.close();
        }
        if (out != null) out.close();
    }
}