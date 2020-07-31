package ru.shamma.lesson5;

import org.hibernate.Session;

import java.util.List;

import static ru.shamma.lesson5.DbWorker.init;

public class DAO {
    Session session = init().openSession();

    public void initDb(){
        session.beginTransaction();
        for (int i = 0; i <1000 ; i++) {
            Student st_i = new Student("Bob_"+i, "mark_" + i);
            session.save(st_i);
        }
        session.getTransaction().commit();
    }

    public void save(Student student){
        session.beginTransaction();
        session.persist(student);
        session.getTransaction().commit();
    }

    public Student getById(Long id){
        session.beginTransaction();
        return session.get(Student.class, id);
    }

    public void deleteById(Long id){
        session.getTransaction();
        Student student =session.get(Student.class, id);
        if(student == null){
            throw new RuntimeException("No such student in DataBase!");
        }
        session.delete(student);
        session.getTransaction().commit();
    }

    public void update(Student student){
        session.getTransaction();
        session.merge(student);
        session.getTransaction().commit();
    }

    public List<Student> findAll(){
        session.getTransaction();
        return session.createQuery("from Student").getResultList();
    }
}
