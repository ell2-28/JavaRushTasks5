package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        String name;
        Sex sex;
        Date bd;
        int id = 0;
        Person person;
        SimpleDateFormat dateInput = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

        switch (args[0]) {
            case "-c":
                for (int i = 1; i < args.length; i += 3) {
                    synchronized (allPeople) {
                        name = args[i];
                        sex = (args[i+1] == "м") ? Sex.MALE : Sex.FEMALE;
                        bd = dateInput.parse(args[i + 2]);
                        if (sex == Sex.MALE)
                            person = Person.createMale(name, bd);
                        else
                            person = Person.createFemale(name, bd);
                        allPeople.add(person);
                        System.out.println(allPeople.indexOf(person));
                    }
                }
                break;

            case "-u":
                for (int i = 1; i < args.length; i += 4) {
                    synchronized (allPeople) {
                        if (Integer.parseInt(args[i]) < args.length )
                            id = Integer.parseInt(args[i]);
                        person = allPeople.get(id);

                        person.setName(args[i+1]);
                        person.setSex((args[i + 2] == "м") ? Sex.MALE : Sex.FEMALE);
                        person.setBirthDate(dateInput.parse(args[i + 3]));
                    }
                }
                break;

            case "-d":
                for (int i = 1; i < args.length; i++) {
                    synchronized (allPeople) {
                        id = Integer.parseInt(args[i]);
                        person = allPeople.get(id);

                        person.setName(null);
                        person.setSex(null);
                        person.setBirthDate(null);
                    }
                }
                break;

            case "-i":
                for (int i = 1; i < args.length; i++) {
                    synchronized (allPeople) {
                        id = Integer.parseInt(args[i]);
                        person = allPeople.get(id);
                        name = person.getName();
                        String textSex = (person.getSex() == Sex.MALE) ? "м" : "ж";
                        SimpleDateFormat dateOutput = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                        String textBd = dateOutput.format(person.getBirthDate());

                        System.out.println(name + " " + textSex + " " + textBd);
                    }
                }
                break;
        }
    }
}