package ru.ssau.tk.tgcvso.practice.tgbot;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class KeyboardInline {
    public static SendMessage sendInlineKeyBoardMessage(String chatId) {                                                //method for creating an inline keyboard
        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
        List<InlineKeyboardButton> rowInline = new ArrayList<>();

        InlineKeyboardButton button1 = new InlineKeyboardButton();                                                      //creating a button
        button1.setText("Да");
        button1.setCallbackData(Consts.POSITIVE_ANSWER);                                                                //setting data

        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("Нет");
        button2.setCallbackData(Consts.NEGATIVE_ANSWER);

        rowInline.add(button1);
        rowInline.add(button2);
        rowsInline.add(rowInline);


        List<InlineKeyboardButton> rowInline2 = new ArrayList<>();

        InlineKeyboardButton button3 = new InlineKeyboardButton();

        button3.setText("Кинуть денежку))0)\uD83D\uDCB5");
        button3.setCallbackData(Consts.TEST);
        button3.setUrl("qiwi.com/n/VERYSTUPIDOWL");
        rowInline2.add(button3);
        rowsInline.add(rowInline2);

        markupInline.setKeyboard(rowsInline);

        SendMessage smInline = new SendMessage();
        smInline.setChatId(chatId);
        smInline.setText("Хочешь остаться?");
        smInline.setReplyMarkup(markupInline);
        return smInline;
    }
}
