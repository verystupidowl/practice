package ru.ssau.tk.tgcvso.practice.TasksFromFile;

public class ResettableIntGenerator implements Resettable, IntGenerator{
    private int countOfCalls;

    public ResettableIntGenerator(){
        countOfCalls = 0;
    }

    @Override
    public int nextInt() {
        return countOfCalls++;
    }

    @Override
    public void reset() {
        countOfCalls = 0;
    }
}
