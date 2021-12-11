package ru.ssau.tk.tgcvso.practice.TasksFromFile;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class PrintTypeTest {
    byte byteValue = 2;
    char charValue = 2;
    short shortValue = 2;
    int intValue = 2;
    long longValue = 2;
    float floatValue = 2.2f;
    double doubleValue = 2.3;
    boolean booleanValue = false;
    Person firstObject = new Person();
    Person secondObject = null;
    String thirdObject = "string";

    @Test
    public void testPrintType() {
        PrintType.printType(byteValue);
    }

    @Test
    public void testTestPrintType() {
        PrintType.printType(charValue);
    }

    @Test
    public void testTestPrintType1() {
        PrintType.printType(shortValue);
    }

    @Test
    public void testTestPrintType2() {
        PrintType.printType(intValue);
    }

    @Test
    public void testTestPrintType3() {
        PrintType.printType(longValue);
    }

    @Test
    public void testTestPrintType4() {
        PrintType.printType(floatValue);
    }

    @Test
    public void testTestPrintType5() {
        PrintType.printType(doubleValue);
    }

    @Test
    public void testTestPrintType6() {
        PrintType.printType(booleanValue);
    }

    @Test
    public void testTestPrintType7() {
        PrintType.printType(firstObject);
    }

    @Test
    public void testTestPrintType8() {
        PrintType.printType(secondObject);
    }

    @Test
    public void testTestPrintType9() {
        PrintType.printType(thirdObject);
    }
}