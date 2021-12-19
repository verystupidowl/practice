package ru.ssau.tk.tgcvso.practice.tgbot.GetFromUrl;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.ssau.tk.tgcvso.practice.tgbot.Consts;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class GetInfoAboutSong implements GetFromUrl{
    private static final int TIMEOUT = 1000;
    private final String songName;

    public GetInfoAboutSong (String songName) {
        this.songName = songName;
    }


    @Override
    public List<String> getFromURL() {
        String info = "Не найдено";
        List<String> returnList = new ArrayList<>();
        int k = 0;
        String url = "https://genius.com/" + songName.replace(' ', '-').replaceAll("\\.", "").toLowerCase(Locale.ROOT) + "-lyrics/";
        while (info.equals("Не найдено")) {
            try {
                Document document = Jsoup.connect(url)
                        .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/94.0.4606.85 YaBrowser/21.11.2.773 Yowser/2.5 Safari/537.36")
                        .referrer("https://genius.com/")
                        .timeout(5 * TIMEOUT)
                        .get();
                Elements infos = document.getElementsByAttributeValue("class", "ExpandableContent__Container-sc-1165iv-0 ikywhQ SongDescription__ExpandableContent-sc-615rvk-3 eahHPb");
                for (Element element : infos) {
                    info = cleanHTMLCode(element.toString()).trim();
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
            k++;
            if (k > 5) {
                returnList.add("Не найдено");
                return returnList;
            }
        }
        returnList.add(info.substring(0, info.length() - 6));
        return returnList;
    }
}
