package ru.ssau.tk.tgcvso.practice.TasksFromFile;

public class IntGeneratorImpl implements IntGenerator {
    private int countOfCalls;

    public IntGeneratorImpl() {
        countOfCalls = 0;
    }

    @Override
    public int nextInt() {
        return countOfCalls++;
    }
}
