package ru.ssau.tk.tgcvso.practice.TasksFromFile;

public class PrintType {
    public static void printType(int i) {
        System.out.println(i);
    }

    public static void printType(byte b) {
        System.out.print(b);
    }

    public static void printType(char c) {
        System.out.print(c);
    }

    public static void printType(short s) {
        System.out.print(s);
    }

    public static void printType(long l) {
        System.out.print(l);
    }

    public static void printType(float f) {
        System.out.print(f);
    }

    public static void printType(double d) {
        System.out.print(d);
    }

    public static void printType(boolean b) {
        System.out.print(b);
    }

    public static void printType(Object object){
        if(object == null)
            System.out.print("null");
        else
            System.out.print(object.getClass().getSimpleName());
    }
}
