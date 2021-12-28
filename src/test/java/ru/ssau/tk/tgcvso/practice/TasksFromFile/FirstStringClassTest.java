package ru.ssau.tk.tgcvso.practice.TasksFromFile;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FirstStringClassTest {

    @Test
    public void testIsTheStringAPalindrome() {
        FirstStringClass object = new FirstStringClass();
        String firstString = "asdffdsa", secondString = "qwertyyyewq", thirdString = "gurtrug", fourthString = "rwketafwr";
        Assert.assertTrue(object.isTheStringAPalindrome(firstString));
        Assert.assertTrue(object.isTheStringAPalindrome(thirdString));
        Assert.assertFalse(object.isTheStringAPalindrome(secondString));
        Assert.assertFalse(object.isTheStringAPalindrome(fourthString));
    }

    @Test
    public void testDoTheStringsDifferOnlyInCase() {
        FirstStringClass object = new FirstStringClass();
        Assert.assertTrue(object.doTheStringsDifferOnlyInCase("EpSILoNN", "EpsilonN"));
        Assert.assertTrue(object.doTheStringsDifferOnlyInCase("AlIyFa", "alIYFA"));
        Assert.assertFalse(object.doTheStringsDifferOnlyInCase(null, null));
        Assert.assertFalse(object.doTheStringsDifferOnlyInCase(null, "FALSe"));
        Assert.assertFalse(object.doTheStringsDifferOnlyInCase("FAlse", null));
        Assert.assertFalse(object.doTheStringsDifferOnlyInCase("CoNtROLL", "ShiFT"));
    }

    @Test
    public void testSubstringSearch() {
        FirstStringClass object = new FirstStringClass();
        Assert.assertEquals(object.substringSearch("coalition", "al"), 2);
        Assert.assertEquals(object.substringSearch("cocylka", "lka"), 4);
        Assert.assertEquals(object.substringSearch("kilometre", "awq"), -1);
    }

    @Test
    public void testLastIndexOfSubstringInStringInFirstHalf() {
        FirstStringClass object = new FirstStringClass();
        Assert.assertEquals(object.lastIndexOfSubstringInStringInFirstHalf("Floccinaucinihilipilification", "oc"), 2);
        Assert.assertEquals(object.lastIndexOfSubstringInStringInFirstHalf("Floccinaucinihilipilification", "nauc"), 6);
        Assert.assertEquals(object.lastIndexOfSubstringInStringInFirstHalf("Floccinaucinihilipilification", "ihi"), 12);
        Assert.assertEquals(object.lastIndexOfSubstringInStringInFirstHalf("Floccinaucinihilipilification", "zxy"), -1);
    }

    @Test
    public void testGetNumberOfLinesWithSpecifiedStartAndEnd() {
        FirstStringClass object = new FirstStringClass();
        String[] array = {"asxdoktr", "asxutyopi", "gyrteopi"};
        Assert.assertEquals(object.getNumberOfLinesWithSpecifiedStartAndEnd(array, "asx", "opi"), 1);
        array = new String[]{"oufrtsqp", "ghutyinsqp", "ghujfoisesqp"};
        Assert.assertEquals(object.getNumberOfLinesWithSpecifiedStartAndEnd(array, "ghu", "sqp"), 2);
    }
}