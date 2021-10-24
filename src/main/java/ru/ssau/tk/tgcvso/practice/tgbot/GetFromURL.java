package ru.ssau.tk.tgcvso.practice.tgbot;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.IOException;
import java.util.Locale;

public class GetFromURL {

    public static String getFromURL(String songName) {
        String text = Consts.DEFAULT_TEXT;
        int i = 1;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            while (text.equals(Consts.DEFAULT_TEXT)) {
                Document doc = Jsoup.connect("https://genius.com/" + songName.replace(' ', '-').toLowerCase(Locale.ROOT) + "-lyrics/")
                        .userAgent("Chrome/81.0.4044.138")
                        .referrer("http://www.google.com")
                        .get();
                Elements lyrics = doc.getElementsByAttributeValue("class", "lyrics"); //TODO:добавить обложки с гениуса
                for (Element element : lyrics) { //TODO:Решить проблему со строками!!!
                    text = element.text();
                    //System.out.println(text);
                    stringBuilder.insert(stringBuilder.length(), text);
                    stringBuilder.insert(stringBuilder.length(), "\n");
                }
                //System.out.println(stringBuilder);
                i++;
            }
            LogsProcessing.logsProcessing("Успешно", i);
        } catch (HttpStatusException e) {
            LogsProcessing.logsProcessing("Неверно введено название", i);
            return text;
        } catch (IOException e) {
            e.printStackTrace();
            LogsProcessing.logsProcessing("Сервер не отвечает", i);
            return "Сервер не отвечает, повторите попытку";
        }
        String newText = stringBuilder.toString().replace('[', '\n');
        String newText1 = newText.replace(']', '\n');
        return newText1.trim();

    }
}
