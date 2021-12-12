package ru.ssau.tk.tgcvso.practice.TasksFromFile;

public class NamedPoint extends Point {
    private String name;

    public NamedPoint(double x, double y, double z) {
        super(x, y, z);
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
}
