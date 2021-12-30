package ru.ssau.tk.tgcvso.practice.tgbot.GetFromUrl;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class GetTopSongsTest {

    @Test
    public void testGetFromURL() {
        GetTopSongs getTopSongs = new GetTopSongs("pyrokinesis");
        GetTopSongs getTopSongs1 = new GetTopSongs("Metro Boomin");
        List<String> stringList1 = getTopSongs1.getFromURL();
        List<String> knownList1 = new ArrayList<>();
        knownList1.add("К сожалению, у этого исполнителя нет собственных популярных песен\uD83D\uDE22Попробуйте другого или введите название определенной песни");
        List<String> stringList = getTopSongs.getFromURL();
        List<String> knownList = new ArrayList<>();
        knownList.add("rainbow colors\n" +
                " cigarette without button\n" +
                " cotton candy\n" +
                " ill come to you with strawberries in december\n" +
                " the legend about death god\n" +
                " black sun\n" +
                " kdpr\n" +
                " beautiful far away\n" +
                " freckles");
        assertEquals(stringList.get(0).trim(), knownList.get(0).trim());
        assertEquals(stringList1.get(0).trim(), knownList1.get(0).trim());
    }
}