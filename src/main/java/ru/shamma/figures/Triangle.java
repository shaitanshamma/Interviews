package ru.shamma.figures;

public class Triangle extends Figure {
    private double bottomSide;
    private double height;

    public Triangle(String title, String color, double bottomSide, double height) {
        super(title, color);
        this.bottomSide = bottomSide;
        this.height = height;
    }

    public double area() {

        return 0.5 * height * bottomSide;
    }

    public void info() {
        System.out.println(toString() + "\n" + "Основание треугольника - " + bottomSide + "\n" +
                            "Высота треугольника - " + height);
        System.out.println("Площадь фигуры - " + area());
        System.out.println("********************");

    }
}
