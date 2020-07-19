package ru.shamma.lesson2;



public interface MyLinkedList<E>  {

    void insertFirst(E value);

    E removeFirst();

    boolean remove(E value);

    boolean contains(E value);

    void display();

    boolean isEmpty();

    int size();

    E getFirstValue();


    class Entry<T> {
        public final T value;
        public Entry<T> next;

        public Entry(T value) {
            this.value = value;
        }
    }

}
