package ru.ssau.tk.tgcvso.practice.tgbot.DataBase;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBase {
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(getUrlConnection(), getUserDB(), getPassword());
    }

    @SneakyThrows
    private static String getUrlConnection() {
        File file = new File("src/main/java/ru/ssau/tk/tgcvso/practice/tgbot/DataBase/secret/UrlConnection.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        StringBuilder url = new StringBuilder();
        try {
            String s = br.readLine();
            url.insert(0, s);
            while ((s = br.readLine()) != null)
                url.insert(url.length() + 1, s);
            br.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return url.toString();
    }

    @SneakyThrows
    private static String getUserDB() {
        File file = new File("src/main/java/ru/ssau/tk/tgcvso/practice/tgbot/DataBase/secret/UserDB.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        StringBuilder name = new StringBuilder();
        try {
            String s = br.readLine();
            name.insert(0, s);
            while ((s = br.readLine()) != null)
                name.insert(name.length() + 1, s);
            br.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return name.toString();
    }

    @SneakyThrows
    private static String getPassword() {
        File file = new File("src/main/java/ru/ssau/tk/tgcvso/practice/tgbot/DataBase/secret/password.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        StringBuilder password = new StringBuilder();
        try {
            String s = br.readLine();
            password.insert(0, s);
            while ((s = br.readLine()) != null)
                password.insert(password.length() + 1, s);
            br.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return password.toString();
    }

    public static void addToDB(Request request) {
        try {
            Connection connection = getConnection();
            String sql = "INSERT INTO requests (user_name, user_firstname, request) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, request.getUserName().getUsername());
            statement.setString(2, request.getUserName().getFirstName());
            statement.setString(3, request.getRequest());
            statement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<String> getFromDB(String userName) {
        List<String> stringList = new ArrayList<>();
        try {
            Connection connection = getConnection();
            String sql = "SELECT * FROM requests";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                if (resultSet.getString("user_name").equals(userName)) {
                    String request = resultSet.getString("request");
                    stringList.add(request);
                }
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stringList;
    }
}
