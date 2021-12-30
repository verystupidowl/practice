package ru.ssau.tk.tgcvso.practice.tgbot.GetFromUrl;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.ssau.tk.tgcvso.practice.tgbot.LogsProcessing;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class GetPhoto implements GetFromUrl {
    private final String songName;

    public GetPhoto(String songName) {
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
        String src = "Изображение не найдено";
        List<String> stringList = new ArrayList<>();
        List<String> returnList = new ArrayList<>();
        int i = 0;
        String url = "https://genius.com/artists/" + songName.replace('*', ' ').trim().toLowerCase(Locale.ROOT).replaceAll(" ", "- ");
        try {
            while (src.equals("Изображение не найдено")) {
                Document doc = getConnection(url);
                Elements pic = doc.getElementsByTag("meta");
                for (Element element1 : pic) {
                    src = element1.toString();
                    stringList.add(src);
                }
                for (String s : stringList) {
                    if (s.contains("property=\"twitter:image\""))
                        src = s.replaceAll("<meta content=\"", "").replaceAll("\" property=\"twitter:image\">", "");

                }
                i++;
                if (i > 10) {
                    LogsProcessing.logsProcessing("Сервер не отвечает", i);
                    returnList.add("https://otvet.imgsmail.ru/download/172833000_cd54766c53b4c1e73d5cfec5c5123806_800.jpg");
                    return returnList;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        returnList.add(src);
        return returnList;
    }

}
