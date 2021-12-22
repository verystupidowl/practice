package ru.ssau.tk.tgcvso.practice.tgbot.GetFromUrl;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetTopChart implements GetFromUrl{
    @Override
    public List<String> getFromURL() {
        String track;
        List<String> list = new ArrayList<>();
        try {
            Document doc = Jsoup.connect("https://genius.com/#top-songs")
                    .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.11; rv:49.0) Gecko/20100101 Firefox/49.0")
                    .referrer("https://genius.com/")
                    .get();
            Elements url = doc.getElementsByAttributeValue("class", "PageGridFull-idpot7-0 jeWXO");
            for (Element element : url.select("a")) {
                track = element.attr("href");
                list.add(track);
                list.add("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        list.removeAll(Arrays.asList("", null));
        return list;
    }
}
