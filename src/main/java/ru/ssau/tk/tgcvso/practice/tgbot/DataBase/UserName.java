package ru.ssau.tk.tgcvso.practice.tgbot.DataBase;

public class UserName {
    private String username;
    private String firstName;

    public UserName() {

    }

    public UserName(String username, String firstName) {
        this.username = username;
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
