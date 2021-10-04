package ru.ssau.tk.tgcvso.practice.tgbot;

public class GetEnglishNames {
    public static String getEnglishNames(String text) throws StringIndexOutOfBoundsException {
        StringBuilder stringBuilder = new StringBuilder();
        char[] c = text.toCharArray();
        try {
            if ((c[0] >= 97 && c[0] <= 122) || (c[0] >= 49 && c[0] <= 57)) {
                stringBuilder.insert(0, c[0]);
            }
            for (int i = 1; i < c.length; i++) {
                if (c[i] != ' ' && c[i] != '\n') {
                    if ((c[i] >= 97 && c[i] <= 122) || (c[i] >= 49 && c[i] <= 57)) {
                        stringBuilder.insert(stringBuilder.length(), c[i]);
                    }
                } else {
                    stringBuilder.insert(stringBuilder.length(), c[i]);
                }
            }
        } catch (StringIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
