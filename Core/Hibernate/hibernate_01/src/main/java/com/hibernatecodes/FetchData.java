package com.hibernatecodes;

import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class FetchData {
    public static void main(String[] args) {
        Student stu = null;

        Configuration con = new Configuration()
                .configure()
                .addAnnotatedClass(Student.class);

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(con.getProperties())
                .build();

        SessionFactory sf = con.buildSessionFactory(registry);
        Session session = sf.openSession();

        Transaction ts = session.beginTransaction();
        ts.commit();

        // fetch data
        // stu = (Student)session.get(Student.class, 1); // as .get() is depricated
        stu = (Student)session.find(Student.class, 1);

        System.out.println(stu);

        session.close();
        sf.close();
    }
}
