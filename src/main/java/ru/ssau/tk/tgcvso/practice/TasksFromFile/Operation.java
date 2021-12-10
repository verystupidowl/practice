package ru.ssau.tk.tgcvso.practice.TasksFromFile;

public abstract class Operation {
    abstract double apply(double number);

    double applyTriple(double number) {
        return apply(apply(apply(number)));
    }
}