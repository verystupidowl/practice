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
}