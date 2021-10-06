package ru.ssau.tk.tgcvso.practice.tgbot;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Keyboard {
    public synchronized static void setRulesButtons(SendMessage sendMessage) {

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);
        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRow.add(new KeyboardButton("Вернуться в меню"));
        keyboard.add(keyboardRow);
        replyKeyboardMarkup.setKeyboard(keyboard);
    }

    public synchronized static void setSongsButtons(SendMessage sendMessage) {
        String[] string = new String[4];
        int j = 0;
        int k = 0;
        String text = sendMessage.getText().replace('*', '\n');
        char[] c = text.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            j += k;
            stringBuilder.setLength(0);
            while (c[j] != '\n') {
                stringBuilder.insert(stringBuilder.length(), c[j]);
                j++;
            }
            k = 1;
            string[i] = stringBuilder.toString().trim();
            System.out.println(string[i]);
        }
        stringBuilder.setLength(0);
        stringBuilder.insert(0, string[0].toUpperCase(Locale.ROOT))
                .insert(stringBuilder.length(), ' ')
                .insert(stringBuilder.length(), string[1]);
        string[1] = stringBuilder.toString();
        stringBuilder.setLength(0);
        stringBuilder.insert(0, string[0].toUpperCase(Locale.ROOT))
                .insert(stringBuilder.length(), ' ')
                .insert(stringBuilder.length(), string[2]);
        string[2] = stringBuilder.toString();
        stringBuilder.setLength(0);
        stringBuilder.insert(0, string[0].toUpperCase(Locale.ROOT))
                .insert(stringBuilder.length(), ' ')
                .insert(stringBuilder.length(), string[3]);
        string[3] = stringBuilder.toString();
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);
        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow keyboardRow1 = new KeyboardRow();
        keyboardRow1.add(new KeyboardButton(string[1]));
        KeyboardRow keyboardRow2 = new KeyboardRow();
        keyboardRow2.add(new KeyboardButton(string[2]));
        KeyboardRow keyboardRow3 = new KeyboardRow();
        keyboardRow3.add(new KeyboardButton(string[3]));
        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRow.add(new KeyboardButton("Вернуться в меню"));
        keyboard.add(keyboardRow1);
        keyboard.add(keyboardRow2);
        keyboard.add(keyboardRow3);
        keyboard.add(keyboardRow);
        replyKeyboardMarkup.setKeyboard(keyboard);
    }

    public synchronized static void setButtons(SendMessage sendMessage) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);


        List<KeyboardRow> keyboard = new ArrayList<>();


        KeyboardRow keyboardFirstRow = new KeyboardRow();
        keyboardFirstRow.add(new KeyboardButton("Правила"));

        keyboardFirstRow.add(new KeyboardButton("Помощь"));

        KeyboardRow keyboardSecondRow = new KeyboardRow();
        keyboardSecondRow.add(new KeyboardButton("Найти текст песни"));

        keyboard.add(keyboardFirstRow);
        keyboard.add(keyboardSecondRow);
        replyKeyboardMarkup.setKeyboard(keyboard);
    }
}
