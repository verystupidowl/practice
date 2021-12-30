package ru.ssau.tk.tgcvso.practice.tgbot.GetFromUrl;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class GetInfoAboutSongTest {

    @Test
    public void testGetFromURL() {
        GetInfoAboutSong getInfoAboutSong = new GetInfoAboutSong("nirvana smells like teen spirit");
        GetInfoAboutSong getInfoAboutSong1 = new GetInfoAboutSong("Kanye West Praise God");
        List<String> stringList = getInfoAboutSong.getFromURL();
        List<String> knownList = new ArrayList<>();
        List<String> stringList1 = getInfoAboutSong1.getFromURL();
        List<String> knownList1 = new ArrayList<>();
        knownList1.add("“Praise God” has the collaboration of Baby Keem and well-known protégé of Kanye, Travis Scott, as well as speech from the person the album is named after, Kanye’s late mother Donda West. As the title of the song states, the trio praise God and raise awareness towards His cause.");
        knownList.add("One of Nirvana’s biggest hits, “Smells Like Teen Spirit” was the lead single from their second album, Nevermind. The song’s success and omnipresence in the early ‘90s brought the band unrivaled popularity. Eventually, Kurt grew tired of it and removed it from their live set as often as possible. \n" +
                "Rock history recalls Kathleen Hanna from Bikini Kill scrawling the phrase “Kurt Smells Like Teen Spirit” in spray paint on a wall, from which Kurt took the title. Some say Kurt took it as a call for a revolution, in reference to the Bikini Kill-led riot grrl movement; but according to producer Butch Vig, Kurt just thought the phrase “was stupid,” and it didn’t really mean anything at all. However, it was later revealed that Hanna was referring to the brand of deodorant worn by Kurt’s then-girlfriend and Hanna’s then-bandmate Tobi Vail. \n" +
                "In a 1994 interview with Rolling Stone, Cobain said:  \n" +
                "I was trying to write the ultimate pop song. I was basically trying to rip off the Pixies. I have to admit it. When I heard [them] for the first time, I connected with that band so heavily I should have been in that band—or at least in a Pixies cover band. We used their sense of dynamics, being soft and quiet and then loud and hard.  \n" +
                "It was one of the last tracks written and recorded for the album, and the final version is comprised of the second take out of just three takes, according to Montage of Heck and other sources. \n" +
                "“Smells Like Teen Spirit” was voted #9 on Rolling Stone’s list of the 500 Greatest Songs of All Time.");
        assertEquals(stringList.get(0).trim(), knownList.get(0).trim());
        assertEquals(stringList1.get(0).trim(), knownList1.get(0).trim());
    }
}