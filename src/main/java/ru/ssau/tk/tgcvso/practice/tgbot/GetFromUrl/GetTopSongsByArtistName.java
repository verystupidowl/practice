package ru.ssau.tk.tgcvso.practice.tgbot.GetFromUrl;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.ssau.tk.tgcvso.practice.tgbot.Consts;
import ru.ssau.tk.tgcvso.practice.tgbot.GetEnglishNames;
import ru.ssau.tk.tgcvso.practice.tgbot.LogsProcessing;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class GetTopSongsByArtistName implements GetFromUrl {
    private final String songName;

    public GetTopSongsByArtistName(String songName) {
        this.songName = songName;
    }

    @Override
    public Document getConnection(String url) throws IOException {
        return Jsoup.connect(url)
                .userAgent("Chrome/81.0.4044.138")
                .referrer("http://www.google.com")
                .get();
    }

    @Override
    public List<String> getFromURL() {
        String text = Consts.DEFAULT_TEXT;
        List<String> returnList = new ArrayList<>();
        String names;
        int i = 1;
        int k = 0;
        int j = 0;
        String url = "https://genius.com/artists/" + songName.toLowerCase(Locale.ROOT).
                replace('*', ' ').replaceAll(" ", "").
                replaceAll("\\.", "");

        StringBuilder stringBuilder = new StringBuilder();
        List<Integer> blackList = new ArrayList<>();
        try {
            while (text.equals(Consts.DEFAULT_TEXT)) {
                Document doc = getConnection(url);
                Elements artist = doc.getElementsByAttributeValue("class", "mini_card-subtitle");
                Elements lyrics = doc.getElementsByAttributeValue("class", "mini_card-title");
                for (Element element1 : artist) {
                    names = element1.text();
                    if (!GetEnglishNames.getEnglishNames(names.toLowerCase(Locale.ROOT)).trim().equals(GetEnglishNames.getEnglishNames(songName).trim())) {
                        blackList.add(k);
                    }
                    k++;
                }
                k = 0;
                if (blackList.size() != 10) {
                    for (Element element : lyrics) {
                        if (!blackList.contains(j)) {
                            text = element.text();
                            stringBuilder.insert(stringBuilder.length(), text);
                            stringBuilder.insert(stringBuilder.length(), "\n");
                        }
                        j++;
                    }
                } else {
                    returnList.add(Consts.WITHOUT_SONGS);
                    return returnList;
                }
                i++;
            }
            LogsProcessing.logsProcessing("Успешно", i);
        } catch (HttpStatusException e) {
            LogsProcessing.logsProcessing("Неверно введено название", i);
            returnList.add(Consts.DEFAULT_TEXT);
            return returnList;
        } catch (IOException e) {
            e.printStackTrace();
            LogsProcessing.logsProcessing("Сервер не отвечает", i);
            returnList.add(Consts.SERVER_IS_NOT_RESPONDING);
            return returnList;
        }
        returnList.add(GetEnglishNames.getEnglishNames(stringBuilder.toString().toLowerCase(Locale.ROOT)));
        return returnList;
    }

}
