package com.hibernatecodes;

import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {
    public static void main(String[] args) {
        Student s = new Student();
        s.setId(1);
        // s.setName("Varun");

        // search "MVNrepository" get Hibernate ORM Hibernate Core dependency
        Configuration con = new Configuration()
                .configure()
                .addAnnotatedClass(Student.class);

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(con.getProperties())
                .build();

        SessionFactory sf = con.buildSessionFactory(registry);
        Session session = sf.openSession();

        // to save changes we must follow "ACID properties" -
        // Atomicity, conscistency, Isolation and Durablity
        // all changes is part of transactions
        session.beginTransaction();
        session.persist(s);
        session.getTransaction().commit();

        session.close();
        sf.close();
    }
}