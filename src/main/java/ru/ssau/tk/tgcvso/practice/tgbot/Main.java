package ru.ssau.tk.tgcvso.practice.tgbot;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;


public class Main {
    public static void main(String[] args) throws TelegramApiException {
        ApiContextInitializer.init();

        TelegramBotsApi botsApi = new TelegramBotsApi();
        botsApi.registerBot(new Bot());
    }


}
