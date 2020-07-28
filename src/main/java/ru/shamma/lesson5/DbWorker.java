package ru.shamma.lesson5;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DbWorker {

    static SessionFactory init(){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        return factory;
    }

}
