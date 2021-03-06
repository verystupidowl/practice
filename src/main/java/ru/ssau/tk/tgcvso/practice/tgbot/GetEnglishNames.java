package ru.ssau.tk.tgcvso.practice.tgbot;

public class GetEnglishNames {
    public static String getEnglishNames(String text) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] c = text.toCharArray();
        try {
            if (c[0] == '&') {
                stringBuilder.insert(0, "and");
            }
            if ((c[0] >= 97 && c[0] <= 122) || (c[0] >= 48 && c[0] <= 57) || c[0] == '-') {
                stringBuilder.insert(0, c[0]);
            }
            for (int i = 1; i < c.length; i++) {
                if (c[i] == '&') {
                    stringBuilder.insert(stringBuilder.length(), "and");
                }
                if (c[i] != ' ' && c[i] != '\n') {
                    if ((c[i] >= 97 && c[i] <= 122) || (c[i] >= 48 && c[i] <= 57) || c[i] == '-') {
                        stringBuilder.insert(stringBuilder.length(), c[i]);
                    }
                } else {
                    stringBuilder.insert(stringBuilder.length(), c[i]);
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        String returnString = stringBuilder.toString();
        while (returnString.contains("  ")) {
            returnString = returnString.replace("  ", " ");
        }
        return returnString;
    }
}