package ru.ssau.tk.tgcvso.practice.TasksFromFile;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;


public class FirstArrayClassTest {
    FirstArrayClass object = new FirstArrayClass();

    @Test
    public void testGetArrayBySize() {
        double[] array = object.getArrayBySize(5);
        double[] knownArray = {0.0, 0.0, 0.0, 0.0, 0.0};
        Assert.assertTrue(Arrays.equals(array, knownArray));
    }

    @Test
    public void testGetArrayWithOnes() {
        int[] array = object.getArrayWithOnes(5);
        int[] knownArray = {2, 1, 1, 1, 2};
        Assert.assertTrue(Arrays.equals(array, knownArray));
    }

    @Test
    public void testGetOddArray() {
        int[] array = object.getOddArray(5);
        int[] knownArray = {1, 3, 5, 7, 9};
        Assert.assertTrue(Arrays.equals(array, knownArray));
    }

    @Test
    public void testGetEvenArray() {
        int[] array = object.getEvenArray(5);
        int[] knownArray = {10, 8, 6, 4, 2};
        Assert.assertTrue(Arrays.equals(array, knownArray));
    }

    @Test
    public void testGetFibonacciArray() {
        int[] array = object.getFibonacciArray(5);
        int[] knownArray = {0, 1, 1, 2, 3};
        Assert.assertTrue(Arrays.equals(array, knownArray));
    }

    @Test
    public void testGetSquaredInt() {
        int[] array = object.getSquaredInt(7);
        int[] knownArray = {0, 1, 4, 9, 16, 25, 36};
        Assert.assertTrue(Arrays.equals(array, knownArray));
    }

    @Test
    public void testGetTheQuadraticEquationArray() {
        double[] firstArray = object.getTheQuadraticEquationArray(0, 10, 3);
        double[] secondArray = object.getTheQuadraticEquationArray(4, 0, 9);
        double[] thirdArray = object.getTheQuadraticEquationArray(10, 7, 0);
        double[] fourthArray = object.getTheQuadraticEquationArray(4, 4, 1);
        double[] fifthArray = object.getTheQuadraticEquationArray(1, 5, 6);
        double[] sixthArray = object.getTheQuadraticEquationArray(-1, -5, 14);
        double[] firstKnownArray = {-0.3};
        double[] secondKnownArray = {};
        double[] thirdKnownArray = {-0.7, 0};
        double[] fourthKnownArray = {-0.5};
        double[] fifthKnownArray = {-3, -2};
        double[] sixthKnownArray = {-7, 2};
        Assert.assertTrue(Arrays.equals(firstArray, firstKnownArray));
        Assert.assertTrue(Arrays.equals(secondArray, secondKnownArray));
        Assert.assertTrue(Arrays.equals(thirdArray, thirdKnownArray));
        Assert.assertTrue(Arrays.equals(fourthArray, fourthKnownArray));
        Assert.assertTrue(Arrays.equals(fifthArray, fifthKnownArray));
        Assert.assertTrue(Arrays.equals(sixthArray, sixthKnownArray));
    }

    @Test
    public void testGetNaturalNumbers() {
        int[] array = object.getNaturalNumbers(10);
        int[] knownArray = {1, 2, 4, 5, 7, 8, 10, 11, 13, 14};
        Assert.assertTrue(Arrays.equals(array, knownArray));
    }

    @Test
    public void testGetArithmeticSequence() {
        int[] array = object.getArithmeticSequence(7, 10, 3);
        int[] knownArray = {10, 13, 16, 19, 22, 25, 28};
        Assert.assertTrue(Arrays.equals(array, knownArray));
    }

    @Test
    public void testGetGeometricSequence() {
        int[] array = object.getGeometricSequence(5, 7, 10);
        int[] knownArray = {7, 70, 700, 7000, 70000};
        Assert.assertTrue(Arrays.equals(array, knownArray));
    }

    @Test
    public void testGetDividerArray() {
        int[] array = object.getDividerArray(12);
        int[] knownArray = {1, 2, 3};
        Assert.assertTrue(Arrays.equals(array, knownArray));
    }

    @Test
    public void testGetPrimeNumbers() {
        int[] array = object.getPrimeNumbers(10);
        int[] knownArray = {2, 3, 5, 7};
        Assert.assertTrue(Arrays.equals(array, knownArray));
    }

    @Test
    public void testGetNaturalReversed() {
        int[] array = object.getNaturalReversed(10);
        int[] knownArray = {1, 2, 3, 4, 5, 5, 4, 3, 2, 1};
        Assert.assertTrue(Arrays.equals(array, knownArray));
    }

    @Test
    public void testGetSymmetricNumbers() {
        int[] array = {1, 3, -30, 12, 123, -54};
        int[] knownArray = {-1, -3, 30, -12, -123, 54};
        object.getSymmetricNumbers(array);
        Assert.assertTrue(Arrays.equals(array, knownArray));
    }

    @Test
    public void testGetContainsNumber() {
        int[] array = {1, 54, 205, 654, 74};
        boolean isContain = object.getContainsNumber(array, 205);
        Assert.assertTrue(isContain);
    }

    @Test
    public void testGetContainsNull() {
        Integer[] array = {43, 64, 653, null, 6424, 75};
        boolean isContain = object.getContainsNull(array);
        Assert.assertTrue(isContain);
    }
}