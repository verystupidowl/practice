package ru.ssau.tk.tgcvso.practice.tgbot;

import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


import java.io.IOException;


public class Bot extends TelegramLongPollingBot {
    private final String BOT_NAME = "verystupidowl_bot";
    private final String BOT_TOKEN = "2036819241:AAHR9h1aGMwEPjEMSzljgNuv8HwqVDRpmrQ";
    private String songName = "nul";
    private String ArtistName = "nul";

    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText().trim();
            String chatId = update.getMessage().getChatId().toString();
            String userFirstName = update.getMessage().getChat().getFirstName();
            String userId = update.getMessage().getChat().getUserName();
            switch (message) {
                case "Привет": {
                    SendMessage sm = new SendMessage();
                    sm.setChatId(chatId);
                    sm.setText("Ну привет, " + userFirstName);
                    try {
                        execute(sm);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case "Правила": {
                    SendMessage sm = new SendMessage();
                    sm.setChatId(chatId);
                    sm.setText(Consts.rules);
                    Keyboard.setButtons(sm);
                    try {
                        execute(sm);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    System.out.println(message);
                    break;
                }
                case "Помощь": {
                    SendMessage sm = new SendMessage();
                    sm.setChatId(chatId);
                    sm.setText(Consts.help);
                    Keyboard.setButtons(sm);
                    try {
                        execute(sm);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    System.out.println(message);
                    break;
                }
                case "/start": {
                    SendMessage sm = new SendMessage();
                    sm.enableMarkdown(true);
                    sm.setChatId(chatId);
                    sm.setText("Привет, " + userFirstName + "!\nЯ бот, который поможет тебе найти текст песни.");
                    SendMessage sm2 = KeyboardInline.sendInlineKeyBoardMessage(chatId);
                    try {
                        execute(sm);
                        execute(sm2);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    System.out.println(message + userFirstName);
                    break;
                }
                case "Найти текст песни": {
                    SendMessage sm = new SendMessage();
                    sm.enableMarkdown(true);
                    sm.setChatId(chatId);
                    sm.setText(Consts.SongExample);
                    Keyboard.setButtons(sm);
                    try {
                        execute(sm);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case "Вернуться в меню": {
                    SendMessage sm = new SendMessage();
                    sm.enableMarkdown(true);
                    sm.setChatId(chatId);
                    sm.setText("Привет!\nЯ бот, который поможет тебе найти текст песни.");
                    Keyboard.setButtons(sm);
                    try {
                        execute(sm);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                default: {
                    SendMessage sendMessage = new SendMessage();
                    sendMessage.setChatId(chatId);
                    String text = GetFromURL.getFromUR(message);
                    System.out.println(userId + '\t' + message);
                    if (text.length() > 5000) {
                        String newText = text.substring(5000);
                        String newText2 = text.substring(5000, text.length());
                        SendMessage sendMessage1 = new SendMessage();
                        sendMessage.setText(newText);
                        sendMessage1.setText(newText2);
                        sendMessage.setChatId(chatId);
                        sendMessage1.setChatId(chatId);
                        try {
                            execute(sendMessage);
                        } catch (TelegramApiException e) {
                            e.printStackTrace();
                        }
                        try {
                            execute(sendMessage1);
                        } catch (TelegramApiException e) {
                            e.printStackTrace();
                        }
                    } else {
                        sendMessage.setText(text);
                        try {
                            execute(sendMessage);
                        } catch (TelegramApiException e) {
                            e.printStackTrace();
                        }
                        break;
                    }
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


