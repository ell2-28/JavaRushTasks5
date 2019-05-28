package com.javarush.task.task12.task1233;

/* 
Изоморфы наступают
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] data = new int[]{1, 2, 3, 5, -2, -8, 0, 77, 5, 5};

        Pair<Integer, Integer> result = getMinimumAndIndex(data);

        System.out.println("The minimum is " + result.x);
        System.out.println("The index of the minimum element is " + result.y);
    }

    public static Pair<Integer, Integer> getMinimumAndIndex(int[] array) {
        if (array == null || array.length == 0) {
            return new Pair<Integer, Integer>(null, null);
        }

        //напишите тут ваш код

        int min[] = new int[array.length];
        min = array.clone();
        for (int i=0;i<min.length-1;i++){
            for (int s=0;s<min.length-1-i;s++){
                if (min[s]>min[s+1])
                {
                    int replace=min[s+1];
                    min[s+1]=min[s];
                    min[s]=replace;
                }
            }
        }
        //Ищем индекс, сравнивая минимальное число с числами исходной версии массива
        int index = 0;
        for (int n=0; n<array.length; n++){
            if (min[0]==array[n]) index = n;
        }

        return new Pair<Integer, Integer>(0, 0);
    }


    public static class Pair<X, Y> {
        public X x;
        public Y y;

        public Pair(X x, Y y) {
            this.x = x;
            this.y = y;
        }
    }
}
