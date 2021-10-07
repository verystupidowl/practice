package ru.ssau.tk.tgcvso.practice.tgbot;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Locale;

public class GetTopSongs {
    public static String getTopSongs(String artistName) {
        String text = Consts.DEFAULT_TEXT;
        int i = 1;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            while (text.equals(Consts.DEFAULT_TEXT)) {
                Document doc = Jsoup.connect("https://genius.com/artists/" + artistName.toLowerCase(Locale.ROOT))
                        .userAgent("Chrome/81.0.4044.138")
                        .referrer("http://www.google.com")
                        .get();
                Elements lyrics = doc.getElementsByAttributeValue("class", "mini_card-title");

                for (Element element : lyrics.select("*")) {
                    text = element.text();
                    stringBuilder.insert(stringBuilder.length(), text);
                    stringBuilder.insert(stringBuilder.length(), "\n");
                }
                i++;
            }
            LogsProcessing.logsProcessing("Успешно", i);
        } catch (HttpStatusException e) {
            e.printStackTrace();
            LogsProcessing.logsProcessing("Неверно введено название", i);
            return Consts.DEFAULT_TEXT;
        } catch (IOException e) {
            e.printStackTrace();
            LogsProcessing.logsProcessing("Сервер не отвечает", i);
            return "Сервер не отвечает, повторите попытку";
        }
        System.out.println(stringBuilder);
        return GetEnglishNames.getEnglishNames(stringBuilder.toString().toLowerCase(Locale.ROOT));
    }
}
