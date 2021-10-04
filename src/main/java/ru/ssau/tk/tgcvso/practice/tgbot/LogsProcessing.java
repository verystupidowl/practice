package ru.ssau.tk.tgcvso.practice.tgbot;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class LogsProcessing {
    public static void logsProcessing(String userId, String message) {
        try (FileWriter writer = new FileWriter("src/main/java/ru/ssau/tk/tgcvso/practice/tgbot/logs/logs.log", true)) {
            Date date = new Date();
            writer.write(userId + '\t' + message + '\t' + date);
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
