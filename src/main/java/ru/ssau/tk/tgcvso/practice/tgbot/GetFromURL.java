package ru.ssau.tk.tgcvso.practice.tgbot;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Locale;

public class GetFromURL {

    public static String getFromUR(String artistName) throws IOException {
        String text = "Не найдено";
        String newArtistName = artistName.replace(' ', '-');
        //Document doc = Jsoup.connect("https://genius.com/Pyrokinesis-cigarette-without-button-lyrics/")
        try {
            Document doc = Jsoup.connect("https://genius.com/" + newArtistName.toLowerCase(Locale.ROOT) + "-lyrics/")
                    .userAgent("Chrome/81.0.4044.138")
                    .referrer("http://www.google.com")
                    .get();
            Elements lyrics = doc.getElementsByAttributeValue("class", "lyrics"); //TODO:добавить обложки с гениуса
            for (Element element : lyrics.select("*")) {
                text = element.text(); //TODO:решить ошибку с безуспешным поиском текста
                if(text.equals("Не найдено")){

                }else{
                    break;
                }
            }
            if (text.equals("Не найдено")) {
                LogsProcessing.logsProcessing("Безуспешно: ");
                text = "Сервер не отвечает, повторите попытку";
            } else{
                LogsProcessing.logsProcessing("Успешно: ");
            }
        } catch(HttpStatusException e){
            e.printStackTrace();
            return text;
        }
        finally {
            String newText = text.replace('[', '\n');
            String newText1 = newText.replace(']', '\n');
            return newText1.trim();
        }

    }
}
