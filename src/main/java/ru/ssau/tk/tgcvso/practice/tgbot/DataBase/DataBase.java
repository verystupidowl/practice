package ru.ssau.tk.tgcvso.practice.tgbot.DataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBase {
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Ghbdtn12345");
    }

    public static void addToDB(Request request) {
        try {
            Connection connection = getConnection();
            String sql = "INSERT INTO requests (user_name, user_firstname, request) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, request.getUserName().getUsername());
            statement.setString(2, request.getUserName().getFirstName());
            statement.setString(3, request.getRequest());
            int row = statement.executeUpdate();
            if (row > 0)
                System.out.println("new user has been inserted");
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
