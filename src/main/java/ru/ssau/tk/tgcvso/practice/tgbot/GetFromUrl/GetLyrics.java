package ru.ssau.tk.tgcvso.practice.tgbot.GetFromUrl;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.ssau.tk.tgcvso.practice.tgbot.Consts;
import ru.ssau.tk.tgcvso.practice.tgbot.LogsProcessing;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class GetLyrics implements GetFromUrl {
    private final String songName;

    public GetLyrics(String songName) {
        this.songName = songName;
    }

    @Override
    public Document getConnection(String url) throws IOException {
        int TIMEOUT = 1000;
        return Jsoup.connect(url)
                .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/94.0.4606.85 YaBrowser/21.11.2.773 Yowser/2.5 Safari/537.36")
                .referrer("https://genius.com/")
                .timeout(5 * TIMEOUT)
                .get();
    }

    @Override
    public List<String> getFromURL() {
        List<String> stringList = new ArrayList<>();
        String text = Consts.DEFAULT_TEXT;
        String src = "Изображение не найдено";
        int i = 0;
        List<String> stringList1 = new ArrayList<>();
        String url = "https://genius.com/" + songName.replace(' ', '-').replaceAll("\\.", "").toLowerCase(Locale.ROOT) + "-lyrics/";
        try {
            while (text.equals(Consts.DEFAULT_TEXT)) {
                Document document = getConnection(url);
                Elements lyrics = document.getElementsByAttributeValue("id", "lyrics-root-pin-spacer");
                Elements pic = document.getElementsByTag("meta");
                for (Element element1 : pic) {
                    src = element1.toString();
                    stringList.add(src);
                }
                text = cleanHTMLCode(lyrics.toString());
                for (String s : stringList) {
                    if (s.contains("property=\"og:image\"")) {
                        src = s.replaceAll("<meta content=\"", "").replaceAll("\" property=\"og:image\">", "");
                    }
                }
                i++;
            }
            LogsProcessing.logsProcessing("Успешно", i);
        } catch (HttpStatusException e) {
            LogsProcessing.logsProcessing("Неверно введено название", i);
            stringList1.add(text);
            return stringList1;
        } catch (IOException e) {
            e.printStackTrace();
            LogsProcessing.logsProcessing("Сервер не отвечает", i);
            stringList1.add(Consts.SERVER_IS_NOT_RESPONDING);
            return stringList1;
        }
        stringList1.add((text + "\n\n" + src).trim());
        return stringList1;
    }

}