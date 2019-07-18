package com.javarush.task.task08.task0824;

/* 
Собираем семейство
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Human child1 = new Human();
        child1.name = "my name is child1";
        child1.sex = false;
        child1.age = 10;
        //child1.children = null;

        Human child2 = new Human();
        child2.name = "my name is child2";
        child2.sex = true;
        child2.age = 15;
        //child2.children = null;

        Human child3 = new Human();
        child3.name = "my name is child3";
        child3.sex = false;
        child3.age = 11;
        //child3.children = null;

        Human mother = new Human();
        mother.name = "my name is mother";
        mother.sex = false;
        mother.age = 30;
        //mother.children = new ArrayList<>();
        mother.children.add(child1);
        mother.children.add(child2);
        mother.children.add(child3);

        Human father = new Human();
        father.name = "my name is father";
        father.sex = false;
        father.age = 35;
        father.children.add(child1);
        father.children.add(child2);
        father.children.add(child3);

        Human babushka1 = new Human();
        babushka1.name = "my name is babushka1";
        babushka1.sex = false;
        babushka1.age = 80;
        babushka1.children.add(mother);

        Human dedushka1 = new Human();
        dedushka1.name = "my name is dedushka1";
        dedushka1.sex = true;
        dedushka1.age = 70;
        dedushka1.children.add(mother);

        Human babushka2 = new Human();
        babushka2.name = "my name is babushka2";
        babushka2.sex = false;
        babushka2.age = 81;
        babushka2.children.add(father);

        Human dedushka2 = new Human();
        dedushka2.name = "my name is dedushka2";
        dedushka2.sex = true;
        dedushka2.age = 73;
        dedushka2.children.add(father);

        System.out.println(child1.toString());
        System.out.println(child2.toString());
        System.out.println(child3.toString());
        System.out.println(mother.toString());
        System.out.println(father.toString());
        System.out.println(babushka1.toString());
        System.out.println(dedushka1.toString());
        System.out.println(babushka2.toString());
        System.out.println(dedushka2.toString());

    }

    public static class Human {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList<>();

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }

}
