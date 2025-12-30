package jdbc;

import java.sql.*;

public class JDBCFetch {
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();
        // Get Operation
        dao.connect();
        Student s1 = dao.getStudent(1);
        System.out.println(s1.id + " " + s1.name);

        dao.connect();
        Student s2 = dao.getStudent(2);
        System.out.println(s2.id + " " + s2.name);

        // Add operation
        // Student s3 = new Student();
        // s3.id = 10;
        // s3.name = "Ajay";
        // dao.connect();
        // dao.addStudent(s3);
    }
}

// DAO -> Data Access Object
class StudentDAO {

    Connection con = null;

    public void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "#@Pratham23");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Student getStudent(int id) {
        try {
            Student s = new Student();
            s.id = id; // store id
            Statement st = con.createStatement();
            String query = "SELECT name FROM student WHERE id =" + id;
            ResultSet rs = st.executeQuery(query);

            rs.next(); // fetch
            String name = rs.getString(1);
            s.name = name; // store name from database

            st.close();
            con.close();
            return s;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public void addStudent(Student s) {
        try {
            Statement st = con.createStatement();

            String query = "INSERT INTO student values (?,?)";
            PreparedStatement pt = con.prepareStatement(query);

            int id = s.id;
            String name = s.name;
            pt.setInt(1, id);
            pt.setString(2, name);

            int count = pt.executeUpdate();
            System.out.println(count + " row/s affected.");

            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

class Student {
    int id;
    String name;

    public Student() {
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
