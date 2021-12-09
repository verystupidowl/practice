package ru.ssau.tk.tgcvso.practice.TasksFromFile;

public class Points {
    static Point A = new Point(2, 5, 6);
    static Point B = new Point(6.1, 9.12, 82.1);

    private Points() {

    }

    public static Point sum(Point A, Point B) {
        return new Point(A.x + B.x, A.y + B.y, A.z + B.z);
    }

    public static Point subtract(Point A, Point B) {
        return new Point(A.x - B.x, A.y - B.y, A.z - B.z);
    }

    public static Point multiply(Point A, Point B) {
        return new Point(A.x * B.x, A.y * B.y, A.z * B.z);
    }

    public static Point divide(Point A, Point B) {
        return new Point(A.x / B.x, A.y / B.y, A.z / B.z);
    }

    public static Point enlarge(Point point, double d) {
        return new Point(point.x * d, point.y * d, point.z * d);
    }

    public static double length(Point point) {
        return point.length();
    }

    public static Point opposite(Point point) {
        return new Point(point.x * -1, point.y * -1, point.z * -1);
    }

    public static Point inverse(Point point) {
        return new Point(1 / point.x, 1 / point.y, 1 / point.z);
    }

    public static double scalarProduct(Point firstPoint, Point secondPoint) {
        return firstPoint.x * secondPoint.x + firstPoint.y * secondPoint.y + firstPoint.z * secondPoint.z;
    }

    public static Point vectorProduct(Point firstPoint, Point secondPoint) {
        return new Point((firstPoint.y * secondPoint.z - firstPoint.z * secondPoint.y)
                , (firstPoint.z * secondPoint.x - firstPoint.x * secondPoint.z)//
                , (firstPoint.x * secondPoint.y - firstPoint.y * secondPoint.x));
    }
}
