package ru.shamma.lesson2;

import java.util.Arrays;

public class MyArrayList<T> implements MyList<T> {
    private int size = 0;
    private Object[] data;
    private int capacity;

    public MyArrayList() {
        capacity = 10;
        data = new Object[capacity];
    }

    public MyArrayList(int capacity) {
        this.capacity = capacity;
        data = new Object[capacity];
    }

    private void ensureCapacity() {
        data = Arrays.copyOf(data, data.length * 2);
    }

    public void add(T t) {
        if (size == data.length) {
            ensureCapacity();
            data[size] = t;
            size++;
        } else {
            data[size] = t;
            size++;
        }
        data = trim(size);
    }

    public int size() {
        return size;
    }

    public void add(T t, int index) {
        ensureCapacity();
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = t;
        size++;
        data = trim(size);
    }

    public void delete(T t) {
        int index = findIndex(t);
        for (int i = 0; i < size; i++) {
            if (t == data[i]) {
                index = i;
            }
        }
        delete(index);
    }

    private int findIndex(T t) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == t) {
                return i;
            }
        }
        return -1;
    }

    public void delete(int index) {
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        data = trim(size);
    }

    private Object[] trim(int size) {
        return Arrays.copyOf(data, size);
    }

    public boolean contains(T t) {
        for (int i = 0; i < size; i++) {
            if (data[i] == t) {
                return true;
            }
        }
        return false;
    }

    public void info() {
        Object[] objects = new Object[data.length];
        for (int i = 0; i < data.length; i++) {
            objects[i] = data[i];
        }
        System.out.println(Arrays.toString(objects));
    }
}
