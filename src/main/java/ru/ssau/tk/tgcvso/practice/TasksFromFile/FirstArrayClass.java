package ru.ssau.tk.tgcvso.practice.TasksFromFile;

public class FirstArrayClass {
    public double[] getArrayBySize(int size) {
        return new double[size];
    }

    public int[] getArrayWithOnes(int size) {
        int[] array = new int[size];
        for (int i = 1; i < array.length - 1; i++) {
            array[i] = 1;
        }
        array[0] = 2;
        array[array.length - 1] = 2;
        return array;
    }

    public int[] getOddArray(int size) {
        int k = 1;
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = k;
            k += 2;
        }
        return array;
    }
}
