package ru.ssau.tk.tgcvso.practice.tgbot.GetFromUrl;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class GetPhotoTest {

    @Test
    public void testGetFromURL() {
        GetPhoto getPhoto = new GetPhoto("loqiemean");
        List<String> stringList = getPhoto.getFromURL();
        List<String> knownList = new ArrayList<>();
        knownList.add("https://images.genius.com/1d55302e776ea6b0a8aba36ff8cd3900.1000x1000x1.jpg");
        assertEquals(stringList.get(0).trim(), knownList.get(0).trim());
    }
}