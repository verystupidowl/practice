package ru.ssau.tk.tgcvso.practice.tgbot.GetFromUrl;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.safety.Whitelist;

import java.io.IOException;
import java.util.List;

public interface GetFromUrl {

    List<String> getFromURL();

    Document getConnection(String url) throws IOException;

    default String cleanHTMLCode(String bodyHtml) {
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
