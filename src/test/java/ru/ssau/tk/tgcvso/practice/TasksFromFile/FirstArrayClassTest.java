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

    @Test
    public void testGetCountOfEvenNumbers() {
        int[] array = {53, 54, 575, 856, 645};
        int count = object.getCountOfEvenNumbers(array);
        Assert.assertEquals(count, 2);
    }

    @Test
    public void testGetMaxElement() {
        int[] array = {5, 35, 764, 53436, 76, 46};
        Integer knownMax = 53436;
        Integer max = object.getMaxElement(array);
        Assert.assertEquals(max, knownMax);
    }

    @Test
    public void testGetSumOfEvenIndexes() {
        int[] array = {634, 64, 543, 63, 66, 53};
        int sum = object.getSumOfEvenIndexes(array);
        Assert.assertEquals(sum, 1243);
    }

    @Test
    public void testGetWhoHasTheMostDivisible() {
        int[] array = {3, 6, 65, 34, 87, 2};
        boolean whoHasTheMostDivisible = object.getWhoHasTheMostDivisible(array);
        Assert.assertTrue(whoHasTheMostDivisible);
    }

    @Test
    public void testGetFirstIndexOfNumber() {
        int[] array = {4, 654, 7, 45, 7, 85, 4};
        Integer knownIndex = 0;
        Integer index = object.getFirstIndexOfNumber(array, 4);
        Assert.assertEquals(knownIndex, index);
    }

    @Test
    public void testChangeMinAndMax() {
        int[] array = {534, 65, 7, 74, 34, 654};
        object.changeMinAndMax(array);
        int[] knownArray = {534, 65, 654, 74, 34, 7};
        Assert.assertTrue(Arrays.equals(array, knownArray));
    }

    @Test
    public void testGetBitwiseNotArray() {
        int[] array = {54, 5234, 754, 552, 86};
        int[] bitwiseNot = {-55, -5235, -755, -553, -87};
        int[] knownArray = {54, 5234, 754, 552, 86};
        object.bitwiseNotArray(array);
        Assert.assertTrue(Arrays.equals(array, bitwiseNot));
        object.bitwiseNotArray(array);
        Assert.assertTrue(Arrays.equals(array, knownArray));
    }

    @Test
    public void testGetMinElement() {
        int[] array = {5, 35, 764, 53436, 76, 46};
        Integer knownMin = 5;
        Integer min = object.getMinElement(array);
        Assert.assertEquals(min, knownMin);
    }

    @Test
    public void testTestGetBitwiseNotArray() {
        int[] array = {54, 5234, 754, 552, 86};
        int[] bitwiseNot = {-55, -5235, -755, -553, -87};
        int[] knownArray = {54, 5234, 754, 552, 86};
        int[] newArray1 = object.getBitwiseNotArray(array);
        Assert.assertTrue(Arrays.equals(newArray1, bitwiseNot));
        int[] newArray2 = object.getBitwiseNotArray(newArray1);
        Assert.assertTrue(Arrays.equals(newArray2, knownArray));
    }
}