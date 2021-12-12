package ru.ssau.tk.tgcvso.practice.tgbot.DataBase;

public class Request {
    private String request;
    private UserName userName;

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public UserName getUserName() {
        return userName;
    }

    public void setUserName(UserName userName) {
        this.userName = userName;
    }

    public Request(){

    }
    public Request(String request, UserName username){
        this.request = request;
        this.userName = username;
    }
}
