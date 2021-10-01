package ru.ssau.tk.tgcvso.practice.tgbot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;


public class Bot extends TelegramLongPollingBot {
    private final String BOT_NAME = "verystupidowl_bot";
    private final String BOT_TOKEN = "2036819241:AAHR9h1aGMwEPjEMSzljgNuv8HwqVDRpmrQ";

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText().trim();
            String chatId = update.getMessage().getChatId().toString();
            String UserId = update.getMessage().getChat().getFirstName();
            switch (message) {
                case "Привет": {
                    SendMessage sm = new SendMessage();
                    sm.setChatId(chatId);
                    sm.setText("Ну привет, " + UserId);
                    try {
                        execute(sm);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case "Помощь": {
                    SendMessage sm = new SendMessage();
                    sm.setChatId(chatId);
                    sm.setText("Я ещё не доделанный бот, извините:(");
                    try {
                        execute(sm);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case "/start": {
                    SendMessage sm = new SendMessage();
                    sm.enableMarkdown(true);
                    sm.setChatId(chatId);
                    sm.setText("Ну привет, дружок - пирожок");
                    SendMessage sm2 = KeyboardInline.sendInlineKeyBoardMessage(chatId);
                    try {
                        execute(sm);
                        execute(sm2);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                default: {
                    SendMessage sendMessage = new SendMessage();
                    sendMessage.setChatId(chatId);
                    sendMessage.setText("Я не знаю такого");

                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }
        } else if (update.hasCallbackQuery()) {
            SendMessage sendMessage = new SendMessage();
            String chatId = update.getCallbackQuery().getMessage().getChatId().toString();
            sendMessage.setChatId(chatId);
            String textMessage = update.getCallbackQuery().getData();
            sendMessage.setText(textMessage);
            if (sendMessage.getText().equals(Consts.da)) {
                Keyboard.setButtons(sendMessage);
            }
            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }

        }

    }


    @Override
    public String getBotUsername() {
        return BOT_NAME;
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }
}


