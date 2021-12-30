package ru.ssau.tk.tgcvso.practice.tgbot;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import ru.ssau.tk.tgcvso.practice.tgbot.GetFromUrl.GetArtistNameBySongName;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Keyboard {
    public synchronized static void setArtistButtons(SendMessage sendMessage, String message) {

        GetArtistNameBySongName getArtistNameBySongName = new GetArtistNameBySongName(message);
        String text = getArtistNameBySongName.getFromURL().get(0);
        if (!text.equals(Consts.DEFAULT_TEXT) && !text.equals(Consts.SERVER_IS_NOT_RESPONDING)) {                                                                        //checking for existence song
            ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();                                        //creating a keyboard
            sendMessage.setReplyMarkup(replyKeyboardMarkup);                                                            //creating a replyMarkup
            replyKeyboardMarkup.setSelective(true);
            replyKeyboardMarkup.setResizeKeyboard(true);
            replyKeyboardMarkup.setOneTimeKeyboard(false);
            List<KeyboardRow> keyboard = new ArrayList<>();                                                             //creating a list of keyboard rows
            KeyboardRow keyboardRow = new KeyboardRow();                                                                //creating a keyboard row
            keyboardRow.add(new KeyboardButton("Вернуться в меню"));                                               //creating and adding a keyboard button
            KeyboardRow keyboardRow1 = new KeyboardRow();
            keyboardRow1.add(new KeyboardButton(text));
            keyboard.add(keyboardRow1);                                                                                 //adding keyboard rows to a list
            keyboard.add(keyboardRow);
            replyKeyboardMarkup.setKeyboard(keyboard);
        }
    }

    public synchronized static void setDbButtons(SendMessage sendMessage, List<String> stringList) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);


        List<KeyboardRow> keyboard = new ArrayList<>();


        KeyboardRow keyboardFirstRow = new KeyboardRow();
        keyboardFirstRow.add(new KeyboardButton(stringList.get(stringList.size() - 1)));
        keyboard.add(keyboardFirstRow);

        if (stringList.size() > 1) {
            KeyboardRow keyboardSecondRow = new KeyboardRow();
            keyboardSecondRow.add(new KeyboardButton(stringList.get(stringList.size() - 2)));
            keyboard.add(keyboardSecondRow);

            if (stringList.size() > 2) {
                KeyboardRow keyboardThirdRow = new KeyboardRow();
                keyboardThirdRow.add(new KeyboardButton(stringList.get(stringList.size() - 3)));


                keyboard.add(keyboardThirdRow);

            }
        }
        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRow.add(new KeyboardButton("Вернуться в меню"));
        keyboard.add(keyboardRow);
        replyKeyboardMarkup.setKeyboard(keyboard);
    }

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

    public synchronized static void setSongsButtons(SendMessage sendMessage, SendPhoto sendPhoto) {
        String[] string = new String[4];                                                                                //creating an array of strings
        int j = 0;
        int k = 0;
        String text = sendMessage.getText().replace('*', '\n');
        char[] c = text.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();                                                              //splitting the songs into arrays
        for (int i = 0; i < 4; i++) {
            j += k;
            stringBuilder.setLength(0);
            while (j < c.length && c[j] != '\n') {
                stringBuilder.insert(stringBuilder.length(), c[j]);
                j++;
            }
            k = 1;
            string[i] = stringBuilder.toString().trim();
        }
        stringBuilder.setLength(0);
        if (!string[1].isEmpty()) {                                                                                     //checking whether array is empty
            stringBuilder.insert(0, string[0].toUpperCase(Locale.ROOT))
                    .insert(stringBuilder.length(), ' ')
                    .insert(stringBuilder.length(), string[1]);
            string[1] = stringBuilder.toString();
            stringBuilder.setLength(0);
            if (!string[2].isEmpty()) {
                stringBuilder.insert(0, string[0].toUpperCase(Locale.ROOT))
                        .insert(stringBuilder.length(), ' ')
                        .insert(stringBuilder.length(), string[2]);
                string[2] = stringBuilder.toString();
                stringBuilder.setLength(0);
                if (!string[3].isEmpty()) {
                    stringBuilder.insert(0, string[0].toUpperCase(Locale.ROOT))
                            .insert(stringBuilder.length(), ' ')
                            .insert(stringBuilder.length(), string[3]);
                    string[3] = stringBuilder.toString();
                }
            }
        }
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();                                            //creating a keyboard and adding arrays there
        sendPhoto.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);
        List<KeyboardRow> keyboard = new ArrayList<>();
        if (!string[1].isEmpty()) {
            KeyboardRow keyboardRow1 = new KeyboardRow();
            keyboardRow1.add(new KeyboardButton(string[1]));
            keyboard.add(keyboardRow1);
            if (!string[2].isEmpty()) {
                KeyboardRow keyboardRow2 = new KeyboardRow();
                keyboardRow2.add(new KeyboardButton(string[2]));
                keyboard.add(keyboardRow2);
                if (!string[3].isEmpty()) {
                    KeyboardRow keyboardRow3 = new KeyboardRow();
                    keyboardRow3.add(new KeyboardButton(string[3]));
                    keyboard.add(keyboardRow3);
                }
            }
        }
        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRow.add(new KeyboardButton("Вернуться в меню"));
        keyboard.add(keyboardRow);
        replyKeyboardMarkup.setKeyboard(keyboard);
    }

    public synchronized static void setChartButtons(SendMessage sendMessage, List<String> list) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);
        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        String chart1 = list.get(0);                                                                                    //assign the value of each list item to a variable
        chart1 = chart1.trim().substring(19, chart1.length() - 6).replace('-', ' ');
        String chart2 = list.get(2);

        chart2 = chart2.trim().substring(19, chart2.length() - 6).replace('-', ' ');
        String chart3 = list.get(4);

        chart3 = chart3.trim().substring(19, chart3.length() - 6).replace('-', ' ');
        keyboardFirstRow.add(new KeyboardButton(chart1));                                                               //creating a keyboard and adding variables there
        keyboard.add(keyboardFirstRow);
        KeyboardRow keyboardSecondRow = new KeyboardRow();
        keyboardSecondRow.add(new KeyboardButton(chart2));
        keyboard.add(keyboardSecondRow);
        KeyboardRow keyboardThirdRow = new KeyboardRow();
        keyboardThirdRow.add(new KeyboardButton(chart3));
        keyboard.add(keyboardThirdRow);
        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRow.add(new KeyboardButton("Вернуться в меню"));
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
        keyboardFirstRow.add(new KeyboardButton("Правила☝\uD83C\uDFFB"));

        keyboardFirstRow.add(new KeyboardButton("Помощь\uD83C\uDD98"));

        KeyboardRow keyboardSecondRow = new KeyboardRow();
        keyboardSecondRow.add(new KeyboardButton("Найти текст песни\uD83D\uDD0E"));

        KeyboardRow keyboardThirdRow = new KeyboardRow();
        keyboardThirdRow.add(new KeyboardButton("Топ - чарт⬆️"));

        KeyboardRow keyboardFourthRow = new KeyboardRow();
        keyboardFourthRow.add(new KeyboardButton("Последние запросы\uD83D\uDD19"));

        keyboard.add(keyboardFirstRow);
        keyboard.add(keyboardSecondRow);
        keyboard.add(keyboardThirdRow);
        keyboard.add(keyboardFourthRow);
        replyKeyboardMarkup.setKeyboard(keyboard);
    }
}
