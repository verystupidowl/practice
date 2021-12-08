package ru.ssau.tk.tgcvso.practice.tgbot;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.safety.Whitelist;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class GetFromURL {
    public static String getPhoto(String songName) {        //method for finding a URL of the artist's photo
        String src = "Изображение не найдено";
        int i = 0;
        songName = songName.replace('*', ' ').trim();   //removing character *
        try {
            while (src.equals("Изображение не найдено")) {              //sending requests until it is successful
                Document doc = Jsoup.connect("https://genius.com/artists/" + songName.toLowerCase(Locale.ROOT))     //connecting to the website
                        .userAgent("Chrome/81.0.4044.138")
                        .referrer("http://www.google.com")
                        .get();
                Elements pic = doc.getElementsByAttributeValue("class", "profile_header");                              //opening a certain class in HTML code
                for (Element element1 : pic) {
                    src = element1.select("div[style]").first().attr("style");                        //scanning certain tags in HTML
                    src = src.substring(23).replaceAll("\'\\);", "");                                   //removing HTML marks
                }
                i++;
                if (i > 10) {
                    LogsProcessing.logsProcessing("Сервер не отвечает", i);
                    return "https://otvet.imgsmail.ru/download/172833000_cd54766c53b4c1e73d5cfec5c5123806_800.jpg";     //returning URL of a funny picture if there is some problems
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return src;
    }

    public static String getFromURL(String songName) {                                                                  //method for finding lyrics and album artwork
        String text = Consts.DEFAULT_TEXT;
        String src = "Изображение не найдено";
        int i = 0;
        int k = 0;
        List<String> stringList = new ArrayList<>();
        final int TIMEOUT = 1000;
        String url = "https://genius.com/" + songName.replace(' ', '-').toLowerCase(Locale.ROOT) + "-lyrics/";
        try {
            while (text.equals(Consts.DEFAULT_TEXT)) {
                final WebClient webClient = new WebClient(BrowserVersion.CHROME);
                webClient.getOptions().setJavaScriptEnabled(false);
                webClient.getOptions().setCssEnabled(false);
                webClient.getOptions().setThrowExceptionOnScriptError(true);
                webClient.getOptions().setThrowExceptionOnFailingStatusCode(true);
                HtmlPage page = webClient.getPage(url);
                webClient.waitForBackgroundJavaScript(3 * TIMEOUT);
                //System.out.println(page.asXml());
                Document doc = Jsoup.parse(page.asText());
                Document document = Jsoup.connect(url)
                        .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/94.0.4606.85 YaBrowser/21.11.2.773 Yowser/2.5 Safari/537.36")
                        .referrer("https://genius.com/")
                        .get();
                Elements lyrics = document.getElementsByAttributeValue("class", "Lyrics__Container-sc-1ynbvzw-6 lgZgEN");                                  //opening a certain class with lyrics in HTML code
                Elements pic = document.getElementsByTag("meta");                          //opening a certain class with album artworks in HTML code
                for (Element element1 : pic) {
                    src = element1.attr("content");
                    stringList.add(src);
                }
                for (Element element : lyrics) {
                    text = lyrics.toString();                                                                           //assigning the entire code in the class to the variable text
                    text = cleanHTMLCode(text);                                                                         //cleaning text from HTML marks
                }
                /*for (String s : stringList) {
                    System.out.println(s);
                }*/
                i++;                                                                                                    //a count of attempts
            }
            LogsProcessing.logsProcessing("Успешно", i);
        } catch (HttpStatusException e) {
            LogsProcessing.logsProcessing("Неверно введено название", i);
            return text;
        } catch (IOException e) {
            e.printStackTrace();
            LogsProcessing.logsProcessing("Сервер не отвечает", i);
            return Consts.SERVER_IS_NOT_RESPONDING;
        }
        return (text + "\n\n" + stringList.get(12)).trim();
    }

    public static String otherSongs(String songName) {                                                                  //method for finding other songs with the help of this song
        String text = "Изображение не найдено";
        try {
            while (text.equals("Изображение не найдено")) {
                Document doc = Jsoup.connect("https://genius.com/" + songName.replace(' ', '-').toLowerCase(Locale.ROOT) + "-lyrics/")
                        .userAgent("Chrome/81.0.4044.138")
                        .referrer("http://www.google.com")
                        .get();
                Elements pic = doc.getElementsByAttributeValue("class", "SongHeaderVariantdesktop__Title-sc-12tszai-7 iWUdKG");    //class with the name of the artist in HTML code
                for (Element element1 : pic) {
                    text = element1.firstElementSibling().text();
                }
            }
        } catch (HttpStatusException e) {
            return Consts.DEFAULT_TEXT;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return songName.toLowerCase(Locale.ROOT).trim().replaceAll(GetEnglishNames.getEnglishNames(text.toLowerCase(Locale.ROOT)).trim(), "") + "*";
    }

    public static List<String> getTopChart() {                                                                          //method for finding a top chart songs
        String track;
        List<String> list = new ArrayList<>();
        try {
            Document doc = Jsoup.connect("https://genius.com/#top-songs")
                    .userAgent("Chrome/81.0.4044.138")
                    .referrer("http://www.google.com")
                    .get();
            Elements url = doc.getElementsByAttributeValue("class", "PageGridFull-idpot7-0 jeWXO");                     //class with top chart songs of a day
            for (Element element : url.select("a")) {                                                                   //CSS tag in HTML
                track = element.attr("href");                                                                 //attribute
                list.add(track);
                list.add("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        list.removeAll(Arrays.asList("", null));
        return list;
    }

    public static String getTopSongs(String artistName) {                                                               //method for finding top songs of the certain artist
        String text = Consts.DEFAULT_TEXT;
        String names;
        int i = 1;
        int k = 0;
        int j = 0;
        StringBuilder stringBuilder = new StringBuilder();
        List<Integer> blackList = new ArrayList<>();
        try {
            while (text.equals(Consts.DEFAULT_TEXT)) {
                Document doc = Jsoup.connect("https://genius.com/artists/" + artistName.toLowerCase(Locale.ROOT))
                        .userAgent("Chrome/81.0.4044.138")
                        .referrer("http://www.google.com")
                        .get();
                Elements artist = doc.getElementsByAttributeValue("class", "mini_card-subtitle");                       //class which contains subtitles of songs
                Elements lyrics = doc.getElementsByAttributeValue("class", "mini_card-title");                          //class which contains titles of songs
                for (Element element1 : artist) {
                    names = element1.text();
                    if (!GetEnglishNames.getEnglishNames(names.toLowerCase(Locale.ROOT)).trim().equals(GetEnglishNames.getEnglishNames(artistName).trim())) {   //checking if subtitle doesn't equal artist name
                        blackList.add(k);                                                                               //adding the index of child to the blacklist
                    }
                    k++;
                }
                k = 0;
                if (blackList.size() != 10) {                                                                           //checking whether the artist has songs
                    for (Element element : lyrics) {
                        if (!blackList.contains(j)) {                                                                   //checking whether blacklist contains certain index
                            text = element.text();
                            stringBuilder.insert(stringBuilder.length(), text);
                            stringBuilder.insert(stringBuilder.length(), "\n");
                        }
                        j++;
                    }
                } else {
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
        return GetEnglishNames.getEnglishNames(stringBuilder.toString().toLowerCase(Locale.ROOT));
    }

    public static String getSearch(String message) {
        String text = Consts.DEFAULT_TEXT;
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder();
        message = message.toLowerCase(Locale.ROOT).replaceAll(" ", "%20").replace('*', ' ').trim();
        String url = "https://genius.com/search?q=" + message;
        System.out.println(url);
        final int TIMEOUT = 1000;
        try {
            while (text.equals(Consts.DEFAULT_TEXT)) {
                final WebClient webClient = new WebClient(BrowserVersion.FIREFOX_60);
                webClient.getOptions().setJavaScriptEnabled(true);
                webClient.getOptions().setCssEnabled(true);
                webClient.getOptions().setThrowExceptionOnScriptError(false);
                webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
                webClient.getOptions().setTimeout(TIMEOUT);
                final HtmlPage page = webClient.getPage(url);
                webClient.waitForBackgroundJavaScript(3 * TIMEOUT);
                System.out.println(page.getTitleText());
                Document doc = Jsoup.parse(page.asXml());
                //.userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.68")
                //  .timeout(TIMEOUT)
                //  .referrer("http://www.google.com")
                // .get();
                Elements titles = doc.select("a[href]");
                //Elements artists = doc.getElementsByAttributeValue("class", "mini_card-subtitle");
                for (Element element : titles) {
                    text = cleanHTMLCode(element.toString());
                    stringBuilder.insert(stringBuilder.length(), text);
                    stringBuilder.insert(stringBuilder.length(), "\n");
                }
                i++;
                if (i > 5)
                    break;
                webClient.close();
            }
            System.out.println(stringBuilder);
            System.out.println(stringBuilder.length());

        } catch (HttpStatusException e) {
            e.printStackTrace();
            LogsProcessing.logsProcessing("Не найдено", 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public static String cleanHTMLCode(String bodyHtml) {                                                               //method for cleaning an HTML code
        String prettyPrintedBodyFragment = Jsoup.clean(bodyHtml, "", Whitelist.none().addTags("br", "p"), new Document.OutputSettings().prettyPrint(true));//removing all HTML tags except <br> and <p>
        prettyPrintedBodyFragment = prettyPrintedBodyFragment
                .replaceAll("<p>", "")
                .replaceAll("&amp;", "&")
                .replaceAll("</p>", "")
                .replaceAll("<br>", "\n")                                                               //replacing remaining tags
                .replaceAll("\n\n", "\n");
        return prettyPrintedBodyFragment;
    }
}
