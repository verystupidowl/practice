package ru.ssau.tk.tgcvso.practice.tgbot;

import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Locale;


public class Bot extends TelegramLongPollingBot {
    //TODO: Добавить поиск по сайту
    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText().trim();                  //message from user
            String chatId = update.getMessage().getChatId().toString();             //chat ID
            String userFirstName = update.getMessage().getChat().getFirstName();    //username
            String userId = update.getMessage().getChat().getUserName();            //user ID
            switch (message) {
                case "Привет": {
                    SendMessage sendMessage = new SendMessage();                    //create an object of SendMessage
                    sendMessage.setChatId(chatId);                                  //set chat ID
                    sendMessage.setText("Ну привет, " + userFirstName + "\uD83D\uDC4B\uD83C\uDFFB"); //set text
                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case "Правила☝\uD83C\uDFFB": {
                    SendMessage sendMessage = new SendMessage();
                    sendMessage.setChatId(chatId);
                    sendMessage.setText(Consts.RULES);
                    Keyboard.setRulesButtons(sendMessage);                            //creating keyboard with 1 button "Вернуться в меню"
                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case "Помощь\uD83C\uDD98": {
                    SendMessage sendMessage = new SendMessage();
                    sendMessage.setChatId(chatId);
                    sendMessage.setText(Consts.HELP);
                    Keyboard.setRulesButtons(sendMessage);                             //creating keyboard with 1 button "Вернуться в меню"
                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case "/start": {
                    SendMessage sendMessage = new SendMessage();
                    sendMessage.enableMarkdown(true);
                    sendMessage.setChatId(chatId);
                    sendMessage.setText("Привет, " + userFirstName + "!\uD83D\uDE43\nЯ бот, который поможет тебе найти текст песни.");
                    SendMessage sendMessage1 = KeyboardInline.sendInlineKeyBoardMessage(chatId);
                    try {
                        execute(sendMessage);
                        execute(sendMessage1);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    LogsProcessing.logsProcessing(userId, message);                     //writing to logs
                    break;
                }
                case "Найти текст песни\uD83D\uDD0E": {
                    SendMessage sendMessage = new SendMessage();
                    sendMessage.enableMarkdown(true);
                    sendMessage.setChatId(chatId);
                    sendMessage.setText(Consts.SONG_EXAMPLE);
                    Keyboard.setRulesButtons(sendMessage);                              //creating keyboard with 1 button "Вернуться в меню"
                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case "Топ - чарт⬆️": {
                    SendMessage sendMessage = new SendMessage();
                    sendMessage.enableMarkdown(true);
                    sendMessage.setChatId(chatId);
                    List<String> list = GetFromURL.getTopChart();                        //creating collection of top songs
                    sendMessage.setText("Топ - чарт на сегодня:");
                    Keyboard.setChartButtons(sendMessage, list);                        //creating a keyboard with buttons - top tracks
                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    break;
                }

                case "Вернуться в меню": {
                    SendMessage sendMessage = new SendMessage();
                    sendMessage.enableMarkdown(true);
                    sendMessage.setChatId(chatId);
                    sendMessage.setText("Воспользуйтесь меню");
                    Keyboard.setButtons(sendMessage);
                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                default: {
                    SendMessage sendMessage = new SendMessage();
                    sendMessage.setChatId(chatId);
                    if(message.indexOf('/') != -1){
                        sendMessage.setText(GetFromURL.getInfoAboutSong(message.substring(1).replaceAll("_", "-")));
                        sendMessage.setChatId(chatId);
                        try{
                            execute(sendMessage);
                        }catch (TelegramApiException e){
                            e.printStackTrace();
                        }
                    } else if (message.indexOf('*') != -1) {                               //checking for existence of symbol * if "true" message contains artist name*
                        StringBuilder stringBuilder = new StringBuilder();
                        String text = GetFromURL.getTopSongs(message.toLowerCase(Locale.ROOT));//creating a string variable, which contains top songs of artist
                        if (text.equals("Сервер не отвечает, повторите попытку")) {               //checking for some problems with connection to genius
                            sendMessage.setText(text);
                            try {
                                execute(sendMessage);
                            } catch (TelegramApiException e) {
                                e.printStackTrace();
                            }
                        }
                        if (!text.equals(Consts.WITHOUT_SONGS)) {                   //checking for existence of songs
                            LogsProcessing.logsProcessing(userId, message);
                            if (text.equals(Consts.DEFAULT_TEXT)) {                 //checking for existence of artist name
                                try {
                                    //text = GetFromURL.getSearch(message);
                                    sendMessage.setText(text);
                                    execute(sendMessage);
                                } catch (TelegramApiException e) {
                                    e.printStackTrace();
                                }
                            } else {
                                stringBuilder.insert(0, message);             //adding artist name to string builder
                                stringBuilder.insert(stringBuilder.length(), text); //adding top songs to string builder
                                sendMessage.setText(stringBuilder.toString());      //set text to the object of SendMessage
                                SendPhoto sendPhoto = new SendPhoto();
                                sendPhoto.setCaption("Самые популярные песни исполнителя " + message.   //adding a caption to a photo
                                        replace('*', ' ').toUpperCase(Locale.ROOT) +    //removing symbol * from the received from the user artist name
                                        ":\n(Нажмите, чтобы открыть текст)");
                                sendPhoto.setPhoto(GetFromURL.getPhoto(message));   //setting a photo from URL
                                sendPhoto.setChatId(chatId);
                                Keyboard.setSongsButtons(sendMessage, sendPhoto);   //creating keyboard with top songs
                                sendMessage.setChatId(chatId);
                                try {
                                    execute(sendPhoto);
                                } catch (TelegramApiException e) {
                                    e.printStackTrace();
                                }
                            }
                        } else {
                            sendMessage.setText(text);
                            try {
                                execute(sendMessage);
                            } catch (TelegramApiException e) {
                                e.printStackTrace();
                            }
                        }
                    } else {                                                    //if message from user contains artist name + song name
                        String text = GetFromURL.getFromURL(message);           //receiving lyrics from genius
                        LogsProcessing.logsProcessing(userId, message);
                        if (text.length() > 4000 && text.length() < 8000) {     //checking for count of symbols
                            String newText = text.substring(0, 4000);           //splitting
                            String newText2 = text.substring(4000);
                            SendMessage sendMessage1 = new SendMessage();
                            sendMessage.setText(newText);
                            sendMessage1.setText(newText2);
                            sendMessage.setChatId(chatId);
                            sendMessage1.setChatId(chatId);
                            SendMessage sendMessage2 = KeyboardInline.sendInlineKeyboardAboutSong(chatId, message, newText2);
                            Keyboard.setArtistButtons(sendMessage1, message);
                            try {
                                execute(sendMessage);
                            } catch (TelegramApiException e) {
                                e.printStackTrace();
                            }
                            try {
                                execute(sendMessage2);
                            } catch (TelegramApiException e) {
                                e.printStackTrace();
                            }
                        } else if (text.length() > 8000) {                  //splitting if needed
                            String newText = text.substring(0, 4000);
                            String newText2 = text.substring(4000, 8000);
                            String newText3 = text.substring(8000);
                            SendMessage sendMessage1 = new SendMessage();
                            SendMessage sendMessage2 = new SendMessage();
                            sendMessage.setText(newText);                   //creating 3 SendMessage objects
                            sendMessage1.setText(newText2);
                            sendMessage2.setText(newText3);
                            sendMessage.setChatId(chatId);
                            sendMessage1.setChatId(chatId);
                            sendMessage2.setChatId(chatId);
                            SendMessage sendMessage3 = KeyboardInline.sendInlineKeyboardAboutSong(chatId, message, newText3);
                            Keyboard.setArtistButtons(sendMessage1, message);
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
                            try {
                                execute(sendMessage3);
                            } catch (TelegramApiException e) {
                                e.printStackTrace();
                            }
                        } else {
                            sendMessage.setText("Текст " + message);
                            sendMessage.setChatId(chatId);
                            SendMessage sendMessage1 = KeyboardInline.sendInlineKeyboardAboutSong(chatId, message, text);
                            Keyboard.setArtistButtons(sendMessage, message);
                            try {
                                execute(sendMessage);
                            } catch (TelegramApiException e) {
                                e.printStackTrace();
                            }
                            try{
                                execute(sendMessage1);
                            }catch (TelegramApiException e){
                                e.printStackTrace();
                            }
                            break;
                        }
                    }
                }
            }
        } else if (update.hasCallbackQuery()) {
            SendMessage sendMessage = new SendMessage();
            String chatId = update.getCallbackQuery().getMessage().getChatId().toString();
            sendMessage.setChatId(chatId);
            String textMessage = update.getCallbackQuery().getData();
            sendMessage.setText(textMessage);
            if (sendMessage.getText().equals(Consts.POSITIVE_ANSWER)) {
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
        return "verystupidowl_bot";
    }

    @SneakyThrows
    public String getBotToken() {
        File file = new File("src/main/java/ru/ssau/tk/tgcvso/practice/tgbot/BotToken/BotToken.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        StringBuilder botToken = new StringBuilder();
        try {
            String s = br.readLine();
            botToken.insert(0, s);
            while ((s = br.readLine()) != null)
                botToken.insert(botToken.length() + 1, s);
            br.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return botToken.toString();
    }

}