package ru.ssau.tk.tgcvso.practice.TasksFromFile;

public class Person {
    private String firstName;
    private String lastName;
    private int passportId;
    private Gender gender;

    public Person() {

    }

    public Person(Gender gender){
        this.gender = gender;
    }

    public Person(Gender gender, String firstName, String lastName, int passportId){
        this.gender = gender;
        this.firstName = firstName;
        this.lastName = lastName;
        this.passportId = passportId;
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person(int passportId) {
        this.passportId = passportId;
    }

    public Person(String firstName, String lastName, int passportId) {
        this.passportId = passportId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setGender(Gender gender){
        this.gender = gender;
    }

    public Gender getGender() {
        return gender;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassportId(int passportId) {
        this.passportId = passportId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getPassportId() {
        return passportId;
    }
}
