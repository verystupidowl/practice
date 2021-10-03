package ru.ssau.tk.tgcvso.practice.tgbot;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.io.*;
import java.io.IOException;
import java.io.FileReader;


public class Main {
    public static void main(String[] args) throws TelegramApiException, IOException {
        ApiContextInitializer.init();

        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
        botsApi.registerBot(new Bot());
    }


}
