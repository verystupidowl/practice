package ru.ssau.tk.tgcvso.practice.tgbot;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Locale;

public class GetTopSongs {
    public static String getTopSongs(String artistName) {
        String text = Consts.DEFAUL_TEXT;
        int i = 1;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            while (text.equals(Consts.DEFAUL_TEXT)) {
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
            if (!text.equals(Consts.DEFAUL_TEXT)) {
                LogsProcessing.logsProcessing("Успешно", i);
            }
        } catch (HttpStatusException e) {
            e.printStackTrace();
            LogsProcessing.logsProcessing("Неверно введено название", i);
        } finally {
            System.out.println(stringBuilder.toString());
            return GetEnglishNames.getEnglishNames(stringBuilder.toString().toLowerCase(Locale.ROOT));
        }
    }
}
