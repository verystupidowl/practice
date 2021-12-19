package ru.ssau.tk.tgcvso.practice.tgbot.GetFromUrl;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.ssau.tk.tgcvso.practice.tgbot.Consts;
import ru.ssau.tk.tgcvso.practice.tgbot.GetEnglishNames;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class OtherSongs implements GetFromUrl{
    private final String songName;

    public OtherSongs (String songName) {
        this.songName = songName;
    }
    @Override
    public List<String> getFromURL() {
        String text = "Изображение не найдено";
        List<String> stringList = new ArrayList<>();
        List<String> returnList = new ArrayList<>();
        try {
            while (text.equals("Изображение не найдено")) {
                Document doc = Jsoup.connect("https://genius.com/" + songName.replace(' ', '-').toLowerCase(Locale.ROOT) + "-lyrics/")
                        .userAgent("Chrome/81.0.4044.138")
                        .referrer("http://www.google.com")
                        .get();
                //Elements pic = doc.getElementsByAttributeValue("class", "SongHeaderVariantdesktop__Title-sc-12tszai-7 iWUdKG");
                Elements pics = doc.select("a");
                for (Element element1 : pics) {
                    text = element1.text(); //7
                    stringList.add(text);
                }
            }
        } catch (SocketTimeoutException e) {
            e.printStackTrace();
            returnList.add(Consts.SERVER_IS_NOT_RESPONDING);
            return returnList;
        } catch (HttpStatusException e) {
            returnList.add(Consts.DEFAULT_TEXT);
            return returnList;
        } catch (IOException e) {
            e.printStackTrace();
        }
        returnList.add(GetEnglishNames.getEnglishNames(stringList.get(7).toLowerCase(Locale.ROOT)).toUpperCase(Locale.ROOT) + "*");
        return returnList;
    }
}
