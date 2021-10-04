package ru.ssau.tk.tgcvso.practice.tgbot;

import java.io.FileWriter;
import java.io.IOException;

public class LogsProcessing {
    public static void logsProcessing(String userId, String message) {
        try (FileWriter writer = new FileWriter("src/main/java/ru/ssau/tk/tgcvso/practice/tgbot/logs/logs.log", true)) {
            writer.write(userId + '\t' + message);
            writer.write("\n\n");
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void logsProcessing(String text, int i) {
        try (FileWriter writer = new FileWriter("src/main/java/ru/ssau/tk/tgcvso/practice/tgbot/logs/logs.log", true)) {
            writer.write("количество попыток - " + i + ":\t" + text);
            writer.write('\n');
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
