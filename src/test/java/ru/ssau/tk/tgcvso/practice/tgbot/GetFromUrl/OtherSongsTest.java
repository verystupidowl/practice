package ru.ssau.tk.tgcvso.practice.tgbot.GetFromUrl;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class OtherSongsTest {

    @Test
    public void testGetFromURL() {
        OtherSongs otherSongs = new OtherSongs("metallica enter sandman");
        List<String> stringList = otherSongs.getFromURL();
        List<String> knownList = new ArrayList<>();
        knownList.add("METALLICA*");
        assertEquals(stringList.get(0).trim(), knownList.get(0).trim());
    }
}