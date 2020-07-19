package ru.shamma.lesson2;

public class Main {
    public static void main(String[] args) {
        MyList<String> a = new MyArrayList<>();
        a.add("1");
        a.add("2");
        a.add("3");
        a.add("4");
        a.info();
        a.add("34", 3);
        a.info();
        System.out.println(a.contains("5"));
        a.delete("3");
        a.info();

        MyLinkedList<String> linkedList= new SimpleLinkedList<>();
        linkedList.insertFirst("1");
        linkedList.insertFirst("2");
        linkedList.insertFirst("3");
        linkedList.insertFirst("4");
        linkedList.getFirstValue();
        linkedList.display();
        System.out.println(linkedList.contains("2"));
    }
}
