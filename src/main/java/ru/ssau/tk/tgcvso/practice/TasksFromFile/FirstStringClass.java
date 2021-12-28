package ru.ssau.tk.tgcvso.practice.TasksFromFile;

import java.util.Objects;

public class FirstStringClass {
    public void stringCharactersInTheConsole(String string) {
        for (int i = 0; i < string.length(); i++) {
            System.out.println(string.charAt(i));
        }
    }
    public void bytesOfTheStringInTheConsole(String string) {
        byte[] bytesOfString = string.getBytes();
        for (byte b : bytesOfString) {
            System.out.println(b);
        }
    }

    public void comparingStringsInDifferentWays() {
        String literal = "dofuhty";
        String string = new String(literal);
        System.out.println(string == literal);
        System.out.println(literal.equals(string));
    }

    public boolean isTheStringAPalindrome(String string) {
        boolean result = true;
        for (int i = 0; i < (string.length() / 2); i++) {
            if (string.charAt(i) != string.charAt((string.length() - 1) - i)) {
                result = false;
                break;
            }
        }
        return result;
    }

    public boolean doTheStringsDifferOnlyInCase(String firstString, String secondString) {
        if ((firstString == null) || (secondString == null)) {
            return false;
        }
        return ((firstString.equals(secondString)) || (firstString.equalsIgnoreCase(secondString)));
    }

    public void studyingCharacterEscaping() {
        int i = 0;
        System.out.println("Символ\t№" + ++i);
        System.out.println("Символ\b№" + ++i);
        System.out.println("Символ\n№" + ++i);
        System.out.println("Символ\r№" + ++i);
        System.out.println("Символ\'№" + ++i);
        System.out.println("Символ\"№" + ++i);
        System.out.println("Символ\\№" + ++i);
    }

    public int substringSearch(String firstString, String secondString) {
        return firstString.indexOf(secondString);
    }

    public int substringSearchInTheSecondHalf(String firstString, String secondString) {
        return firstString.indexOf(secondString, firstString.length() / 2);
    }

    public int lastIndexOfSubstringInStringInFirstHalf(String firstString, String secondString) {
        return firstString.lastIndexOf(secondString, (firstString.length() / 2) + 1);
    }

    public int getNumberOfLinesWithSpecifiedStartAndEnd(String[] arrayString, String prefix, String postfix) {
        int count = 0;
        for (String string : arrayString) {
            if (string.startsWith(prefix) && string.endsWith(postfix)) {
                count++;
            }
        }
        return count;
    }

    public int getNumberOfLinesWithSpecifiedStartAndEndWithoutSpaces(String[] arrayString, String prefix, String postfix) {
        int count = 0;
        String temp;
        for (String string : arrayString) {
            temp = string.trim();
            if (temp.startsWith(prefix) && temp.endsWith(postfix)) {
                count++;
            }
        }
        return count;
    }

    public String replaceAllSubstringsInString(String string, String replaceable, String placeholder) {
        String resultOfMethod = string;
        int i = 0;
        while (resultOfMethod.contains(replaceable)) {
            if (i == 100) {
                break;
            }
            resultOfMethod = resultOfMethod.replaceAll(replaceable, placeholder);
            i++;
        }
        return resultOfMethod;
    }

    public String searchASubstringWithConditions(String string, int from, int to) {
        if (from >= to) {
            return null;
        }
        return string.substring((Math.max(from, 0)), (Math.min(to, string.length())));
    }

    public void descriptionOfTheObject(Object object) {
        System.out.println("Описание объекта: ");
        System.out.print(object);
    }

    public String[] splittingAStringIntoSeparateWords(String sourceString) {
        String[] array = sourceString.split(" ");
        for (int i = 0; i < array.length; i++) {
            if (Objects.equals(array[i], "")) {
                continue;
            }
            array[i] = array[i].substring(0, 1).toUpperCase().concat(array[i].substring(1));
        }
        return array;
    }

    public String combiningAllRowsIntoOne(String[] stringArray) {
        String outPutString = "";
        for (String string : stringArray) {
            outPutString = String.join(", ", stringArray);
        }
        return outPutString;
    }

    public String changingLettersToIndexes(String sourceString) {
        StringBuilder string = new StringBuilder(sourceString);
        for (int i = 0; i < sourceString.length(); i++) {
            if (i % 2 == 1) {
                string.deleteCharAt(i);
                string.insert(i, i + 1);
            }
        }
        string.reverse();
        return string.toString();
    }
}
