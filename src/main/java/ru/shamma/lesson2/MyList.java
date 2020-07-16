package ru.shamma.lesson2;

public interface MyList<T> {
    void add(T obj);

    void delete(T obj);

    void delete(int index);

    boolean contains(T obj);

    void info();

    void add(T obj, int index);
}
