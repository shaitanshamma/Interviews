package ru.shamma;

import ru.shamma.figures.Circle;
import ru.shamma.figures.Figure;
import ru.shamma.figures.Square;
import ru.shamma.figures.Triangle;

public class Main {
    public static void main(String[] args) {
        Person person = new Person.Builder()
                .firstName("Vasyl")
                .lastName("Gaikin")
                .middleName("Ivanovich")
                .country("Russia")
                .address("aa").build();

        person.info();
    Figure cir = new Circle("круг", "красный", 2);
    Figure sq = new Square("квадрат", "синий", 2);
    Figure tr = new Triangle("треугольник", "желтый", 2, 4);
    cir.info();
    sq.info();
    tr.info();
    }
}
