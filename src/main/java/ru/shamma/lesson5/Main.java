package ru.shamma.lesson5;


import java.util.List;

public class Main {
    public static void main(String[] args) {
        DAO dao = new DAO();
        dao.initDb();
        findAll();
        save();
        update();
    }

    static void findAll() {
        DAO dao = new DAO();
        List<Student> students = dao.findAll();
        for (Student s : students) {
            System.out.println(s.toString());
        }
    }

    static void update() {
        DAO dao = new DAO();
        Student dbStud = dao.getById(2L);
        System.out.println("Исходный студент - " + dbStud.toString());
        dbStud.setName("Bob измененыый");
        dao.update(dbStud);
        Student newDbStud = dao.getById(2L);
        System.out.println("Измененный студент - " + newDbStud.toString());
    }

    static void save() {
        DAO dao = new DAO();
        Student student = new Student("Bobby", "5");
        dao.save(student);
    }
}
