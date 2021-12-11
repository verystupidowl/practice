package ru.ssau.tk.tgcvso.practice.TasksFromFile;

import java.util.Arrays;

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

    public int[] getEvenArray(int size) {
        int k = 2;
        int[] array = new int[size];
        for (int i = array.length - 1; i >= 0; i--) {
            array[i] = k;
            k += 2;
        }
        return array;
    }

    public int[] getFibonacciArray(int size) {
        int[] array = new int[size];
        array[0] = 0;
        array[1] = 1;
        for (int i = 1; i < array.length - 1; i++) {
            array[i + 1] = array[i] + array[i - 1];
        }
        return array;
    }

    public int[] getSquaredInt(int size) {
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = i * i;
        }
        return array;
    }

    public double[] getTheQuadraticEquationArray(double a, double b, double c) {
        if (a == 0)
            return new double[]{-c / b};
        if (b == 0) {
            double result = -c / a;
            if (result < 0)
                return new double[]{};
            else
                return new double[]{-Math.sqrt(result), Math.sqrt(result)};
        }
        if (c == 0) {
            double result = -b / a;
            if (result < 0)
                return new double[]{result, 0};
            else
                return new double[]{0, result};
        }
        double discriminant = b * b - 4 * a * c;
        if (discriminant < 0) return new double[]{};
        if (discriminant == 0) return new double[]{-b / (2 * a)};
        double firstX = (-b + Math.sqrt(discriminant)) / (2 * a);
        double secondX = (-b - Math.sqrt(discriminant)) / (2 * a);
        if (firstX == secondX) return new double[]{firstX};
        if (secondX < firstX) return new double[]{secondX, firstX};
        return new double[]{firstX, secondX};
    }

    public int[] getNaturalNumbers(int size) {
        int[] array = new int[size];
        int k = 0;
        for (int i = 0; array[size - 1] == 0; i++) {
            if (i % 3 == 0) {
                k++;
                continue;
            }
            array[i - k] = i;
        }
        return array;
    }

    public int[] getArithmeticSequence(int size, int firstElement, int difference) {
        int[] array = new int[size];
        array[0] = firstElement;
        for (int i = 1; i < array.length; i++)
            array[i] = array[i - 1] + difference;
        return array;
    }

    public int[] getGeometricSequence(int size, int firstElement, int difference) {
        int[] array = new int[size];
        array[0] = firstElement;
        for (int i = 1; i < array.length; i++)
            array[i] = array[i - 1] * difference;
        return array;
    }

    public int[] getDividerArray(int number) {
        int numberOfDividers = 0;
        for (int i = 1; i <= Math.sqrt(number); i++)
            if (number % i == 0) numberOfDividers++;
        if (numberOfDividers == 0)
            return null;
        int[] array = new int[numberOfDividers];
        int j = 0;
        for (int i = 1; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                array[j++] = i;
            }
        }
        return array;
    }

    public int[] getPrimeNumbers(int number) {
        int numberOfPositivePrimes = 0;
        for (int i = 2; i <= number; i++) {
            boolean isSimple = true;
            for (int j = 2; j < i; j++) {
                if ((i % j) != 0)
                    continue;
                isSimple = false;
            }
            if (isSimple) numberOfPositivePrimes++;
        }
        int[] array = new int[numberOfPositivePrimes];
        int index = 0;
        for (int i = 2; i <= number; i++) {
            boolean isSimple = true;
            for (int j = 2; j < i; j++) {
                if (i % j != 0)
                    continue;
                isSimple = false;
            }
            if (isSimple)
                array[index++] = i;
        }
        return array;
    }

    public int[] getNaturalReversed(int number) {
        int[] array = new int[number];
        int k = 1;
        for (int i = 0; i < array.length / 2; i++) {
            array[i] = k;
            k++;
        }
        k = array.length / 2;
        for (int i = array.length / 2; i < array.length; i++) {
            array[i] = k;
            k--;
        }
        return array;
    }

    public void getSymmetricNumbers(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] *= -1;
        }
    }

    public boolean getContainsNumber(int[] array, int number) {
        for (int i : array) {
            if (i == number)
                return true;
        }
        return false;
    }

    public boolean getContainsNull(Integer[] array) {
        for (Integer i : array) {
            if (i == null)
                return true;
        }
        return false;
    }

    public int getCountOfEvenNumbers(int[] array) {
        int countOfEvenNumbers = 0;
        for (int i : array) {
            if (i % 2 == 0)
                countOfEvenNumbers++;
        }
        return countOfEvenNumbers;
    }

    public Integer getMaxElement (int[] array) {
        if(array.length == 0)
            return null;
        array = Arrays.stream(array).sorted().toArray();
        return array[array.length - 1];
    }
}

