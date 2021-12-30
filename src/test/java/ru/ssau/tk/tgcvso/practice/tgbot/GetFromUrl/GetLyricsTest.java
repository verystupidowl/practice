package ru.ssau.tk.tgcvso.practice.tgbot.GetFromUrl;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class GetLyricsTest {

    @Test
    public void testGetFromURL() {
        GetLyrics getLyrics = new GetLyrics("loqiemean Ragnarok");
        List<String> stringList = getLyrics.getFromURL();
        List<String> knownList = new ArrayList<>();
        knownList.add("[Текст песни \"Рагнарёк\"] \n" +
                " \n" +
                "Instrumental\n" +
                "\n" +
                "https://images.genius.com/7cbc8e63348e9fe4cc5c11a7ebf188c8.640x640x1.jpg");
        assertEquals(stringList.get(0).trim(), knownList.get(0).trim());
    }
}