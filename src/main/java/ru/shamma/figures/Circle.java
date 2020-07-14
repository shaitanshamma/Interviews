package ru.shamma.figures;

public class Circle extends Figure {
    private double radius;

    public Circle(String title, String color, double radius) {
        super(title, color);
        this.radius = radius;
    }

    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }

    public void info() {
        System.out.println(toString() + "\n" + "Радиус - " + radius);
        System.out.println("Площадь фигуры - " + area());
        System.out.println("********************");

    }
}
