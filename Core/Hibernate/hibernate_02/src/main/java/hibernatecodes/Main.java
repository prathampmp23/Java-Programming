package hibernatecodes;

import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {
    public static void main(String[] args) {
        Student stu = new Student();
        Laptop lap = new Laptop();

        // // ****** OneToOne ****** // //
        lap.setId(101);
        lap.setName("Asus");
        lap.setStu(stu); 
        
        // OneToOne
        stu.setId(1);
        stu.setName("Pratham");
        stu.setMarks(90);
        stu.setLaptop(lap); 
        /*
           mysql> select * from laptop_table;
            +-----+--------+------+
            | id  | stu_id | name |
            +-----+--------+------+
            | 101 |      1 | Asus |
            +-----+--------+------+
            1 row in set (0.00 sec)

            mysql> select * from student_table;
            +----+-----------+-------+---------+
            | id | laptop_id | marks | name    |
            +----+-----------+-------+---------+
            |  1 |       101 |    90 | Pratham |
            +----+-----------+-------+---------+
            1 row in set (0.00 sec)
        */

        // // ****** manyToOne ****** // //
        // lap.setId(101);
        // lap.setName("Asus");
        // lap.setStu(stu); // OneToOne

        // stu.setId(1);
        // stu.setName("Pratham");
        // stu.setMarks(90);
        // stu.getLaptop().add(lap); // manyToOne
        // if @OneToMany(mappedBy = "student") is not use in student
        /*
            mysql> select * from laptop_table;
            +-----+--------+------+
            | id  | stu_id | name |
            +-----+--------+------+
            | 101 |      1 | Asus |
            +-----+--------+------+
            1 row in set (0.00 sec)

            mysql> select * from student_table;
            +----+-------+---------+
            | id | marks | name    |
            +----+-------+---------+
            |  1 |    90 | Pratham |
            +----+-------+---------+
            1 row in set (0.00 sec)

            mysql> select * from student_table_laptop_table;
            +------------+-----------+
            | Student_id | laptop_id |
            +------------+-----------+
            |          1 |       101 |
            +------------+-----------+
            1 row in set (0.00 sec)
        */

        // if use @OneToMany(mappedBy = "student") in student 
        /*
            mysql> select * from student_table;
            +----+-------+---------+
            | id | marks | name    |
            +----+-------+---------+
            |  1 |    90 | Pratham |
            +----+-------+---------+
            1 row in set (0.00 sec)

            mysql> select * from laptop_table;
            +-----+--------+------+
            | id  | stu_id | name |
            +-----+--------+------+
            | 101 |      1 | Asus |
            +-----+--------+------+
            1 row in set (0.00 sec)
        */

        // // ****** manyToMany ****** // //
        // lap.setId(101);
        // lap.setName("Asus");

        // stu.setId(1);
        // stu.setName("Pratham");
        // stu.setMarks(90);

        // lap.getStudent().add(stu); // manyToMany
        // stu.getLaptop().add(lap); // manyToMany

        // if @ManyToMany(mappedBy = "student") is not use in student create 4 tables
        /*
            mysql> show tables;
            +----------------------------+
            | Tables_in_college          |
            +----------------------------+
            | laptop_table               |
            | laptop_table_student_table |
            | student                    |
            | student_table              |
            | student_table_laptop_table |
            | teacher                    |
            | user                       |
            +----------------------------+
            7 rows in set (0.00 sec)

            mysql> select * from student_table;
            +----+-------+---------+
            | id | marks | name    |
            +----+-------+---------+
            |  1 |    90 | Pratham |
            +----+-------+---------+
            1 row in set (0.00 sec)

            mysql> select * from laptop_table; 
            +-----+------+
            | id  | name |
            +-----+------+
            | 101 | Asus |
            +-----+------+
            1 row in set (0.00 sec)

            mysql> select * from student_table_laptop_table;
            +------------+-----------+
            | Student_id | laptop_id |
            +------------+-----------+
            |          1 |       101 |
            +------------+-----------+
            1 row in set (0.00 sec)

            mysql> select * from laptop_table_student_table;
            +-----------+------------+
            | Laptop_id | student_id |
            +-----------+------------+
            |       101 |          1 |
            +-----------+------------+
            1 row in set (0.00 sec)
        */

        // if @ManyToMany(mappedBy = "student") is use in student create 3 tables
        /*
        mysql> show tables;
        +----------------------------+
        | Tables_in_college          |
        +----------------------------+
        | laptop_table               |
        | laptop_table_student_table |
        | student                    |
        | student_table              |
        | teacher                    |
        | user                       |
        +----------------------------+
        6 rows in set (0.00 sec)

        mysql> select * from laptop_table_student_table;
        +-----------+------------+
        | laptop_id | student_id |
        +-----------+------------+
        |       101 |          1 |
        |       101 |          1 |
        +-----------+------------+
        2 rows in set (0.00 sec)

        mysql> select * from student_table;
        +----+-------+---------+
        | id | marks | name    |
        +----+-------+---------+
        |  1 |    90 | Pratham |
        +----+-------+---------+
        1 row in set (0.00 sec)

        mysql> select * from laptop_table;
        +-----+------+
        | id  | name |
        +-----+------+
        | 101 | Asus |
        +-----+------+
        1 row in set (0.00 sec)
        */

        Configuration con = new Configuration()
                .configure()
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Laptop.class);
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(con.getProperties())
                .build();
        SessionFactory sf = con.buildSessionFactory(registry);
        Session session = sf.openSession();

        session.beginTransaction();
        session.persist(stu);
        session.persist(lap);
        session.getTransaction().commit();

        session.close();
        sf.close();
    }
}