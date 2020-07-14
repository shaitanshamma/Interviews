package ru.shamma.figures;

public class Square extends Figure {
    private double side;

    public Square(String title, String color, double side) {
        super(title, color);
        this.side = side;
    }

    public double area() {
        return Math.pow(side, 2);
    }

    public void info() {
        System.out.println(toString() + "\n" + "Сторона квадрата - " + side);
        System.out.println("Площадь фигуры - " + area());
        System.out.println("********************");
    }
}
