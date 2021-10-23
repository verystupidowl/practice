package ru.ssau.tk.tgcvso.practice.tgbot;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class GetTopSongs {
    public static String getTopSongs(String artistName) {
        String text = Consts.DEFAULT_TEXT;
        String names;
        int i = 1;
        int k = 0;
        int j = 0;
        StringBuilder stringBuilder = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        try {
            while (text.equals(Consts.DEFAULT_TEXT)) {
                Document doc = Jsoup.connect("https://genius.com/artists/" + artistName.toLowerCase(Locale.ROOT))
                        .userAgent("Chrome/81.0.4044.138")
                        .referrer("http://www.google.com")
                        .get();
                Elements artist = doc.getElementsByAttributeValue("class", "mini_card-subtitle");
                Elements lyrics = doc.getElementsByAttributeValue("class", "mini_card-title");
                for (Element element1 : artist) {
                    names = element1.text();
                    if (!GetEnglishNames.getEnglishNames(names.toLowerCase(Locale.ROOT)).trim().equals(GetEnglishNames.getEnglishNames(artistName).trim())) {
                        //System.out.println(GetEnglishNames.getEnglishNames(names.toLowerCase(Locale.ROOT)).trim());
                        //System.out.println(GetEnglishNames.getEnglishNames(names.toLowerCase(Locale.ROOT).trim()));
                        list.add(k);
                    }
                    k++;
                    //System.out.println(list);
                }
                k = 0;
                if(list.size() != 10) {
                    for (Element element : lyrics.before("full_width_button u-clickable u-bottom_margin")) {
                        if (!list.contains(j)) {
                            System.out.println(j);
                            text = element.text();
                            stringBuilder.insert(stringBuilder.length(), text);
                            stringBuilder.insert(stringBuilder.length(), "\n");
                        }
                        j++;
                    }
                }else{
                    return Consts.WITHOUT_SONGS;
                }
                i++;
            }
            LogsProcessing.logsProcessing("Успешно", i);
        } catch (HttpStatusException e) {
            LogsProcessing.logsProcessing("Неверно введено название", i);
            return Consts.DEFAULT_TEXT;
        } catch (IOException e) {
            e.printStackTrace();
            LogsProcessing.logsProcessing("Сервер не отвечает", i);
            return Consts.SERVER_IS_NOT_RESPONDING;
        }
        //System.out.println(stringBuilder);
        return GetEnglishNames.getEnglishNames(stringBuilder.toString().toLowerCase(Locale.ROOT));
    }
}
