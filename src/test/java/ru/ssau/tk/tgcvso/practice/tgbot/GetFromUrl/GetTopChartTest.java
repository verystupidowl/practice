package ru.ssau.tk.tgcvso.practice.tgbot.GetFromUrl;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class GetTopChartTest {

    @Test
    public void testGetFromURL() {
        GetTopChart getTopChart = new GetTopChart();
        List<String> stringList = getTopChart.getFromURL();
        List<String> knownList = new ArrayList<>();
        knownList.add("https://genius.com/Taylor-swift-all-too-well-10-minute-version-taylors-version-live-acoustic-lyrics");
        knownList.add("");
        knownList.add("https://genius.com/Carolina-gaitan-mauro-castillo-adassa-rhenzy-feliz-diane-guerrero-and-stephanie-beatriz-we-dont-talk-about-bruno-lyrics");
        knownList.add("");
        knownList.add("https://genius.com/Zapomni-peel-lyrics");
        for (int i = 0; i < knownList.size(); i += 2) {
            assertEquals(stringList.get(i).trim(), knownList.get(i).trim());
        }
    }
}