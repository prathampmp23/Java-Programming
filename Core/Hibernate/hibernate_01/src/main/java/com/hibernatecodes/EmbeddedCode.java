package com.hibernatecodes;

import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class EmbeddedCode {
    public static void main(String[] args) {

        /*
         * Hibernate: drop table if exists student_table
         * Hibernate: create table student_table (id integer not null, firstName
         * varchar(255), lastName varchar(255), middleName varchar(255), primary key
         * (id)) engine=InnoDB
         * Hibernate: insert into student_table (firstName,lastName,middleName,id)
         * values (?,?,?,?)
         */
        /*
         * mysql> select * from student_table;
         * +----+-----------+----------+------------+
         * | id | firstName | lastName | middleName |
         * +----+-----------+----------+------------+
         * | 1  | Pratham   | Potdar   | Manish     |
         * +----+-----------+----------+------------+
         */
        Student s = new Student();
        s.setId(1);
        // s.setName("Rohan");

        // Using Embeddable Object -
        EmbeddedName en = new EmbeddedName();
        en.setFirstName("Pratham");
        en.setMiddleName("Manish");
        en.setLastName("Potdar");

        s.setName(en);

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