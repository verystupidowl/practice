package ru.ssau.tk.tgcvso.practice.TasksFromFile;

public class Point {
    public final double x;
    public final double y;
    public final double z;

    public Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double length() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public static void main(String[] args) {
        Point A = new Point(2.0, 5.0, 6.0);
        Point B = new Point(6.1, 9.12, 82.1);
        Point C = new Point(543.13, 3456.52, 423.53);
    }
}