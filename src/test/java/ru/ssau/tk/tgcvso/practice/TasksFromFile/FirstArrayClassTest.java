package ru.ssau.tk.tgcvso.practice.TasksFromFile;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;

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
}