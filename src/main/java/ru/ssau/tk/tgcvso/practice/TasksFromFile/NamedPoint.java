package ru.ssau.tk.tgcvso.practice.TasksFromFile;

public class NamedPoint implements Resettable {
    private String name;

    @Override
    public void reset() {
        name = "Absent";
    }
}
