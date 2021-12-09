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

    public static void main(String[] args) {
        System.out.println(Points.sum(A, B).x + " " + Points.sum(A, B).y + " " + Points.sum(A, B).z);
        System.out.println(Points.subtract(A, B).x + " " + Points.subtract(A, B).y + " " + Points.subtract(A, B).z);
        System.out.println(Points.multiply(A, B).x + " " + Points.multiply(A, B).y + " " + Points.multiply(A, B).z);
        System.out.println(Points.divide(A, B).x + " " + Points.divide(A, B).y + " " + Points.divide(A, B).z);
        System.out.println(Points.enlarge(A, 3.0).x + " " + Points.enlarge(A, 4.5).y + " " + Points.enlarge(A, 1049.53).z);
        System.out.println(A.length());
        System.out.println(length(B));
        System.out.println(inverse(B).x + " " + inverse(B).y + " " + inverse(B).z);
        System.out.println(opposite(B).x + " " + opposite(B).y + " " + opposite(B).z);
        System.out.println(scalarProduct(A, B));
        System.out.println(vectorProduct(A, B).x + " " + vectorProduct(A, B).y + " " + vectorProduct(A, B).z);
    }
}
