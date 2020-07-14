package ru.shamma.figures;

public abstract class Figure {
    private String title;
    private String color;

    public Figure(String title, String color) {
        this.title = title;
        this.color = color;
    }

    public abstract double area();

    public abstract void info();

    @Override
    public String toString() {
        return "Название фигуры - " +
                 title + '\n' +
                "Цвет - " + color;
    }
}
