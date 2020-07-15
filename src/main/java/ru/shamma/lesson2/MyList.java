package ru.shamma.lesson2;

public interface MyList<T> {
    void add(T t);

    void delete(T t);

    void delete(int index);

    boolean contains(T t);

    void info();

    void add(T s, int i);
}
