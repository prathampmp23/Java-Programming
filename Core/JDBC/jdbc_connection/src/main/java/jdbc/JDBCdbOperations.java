package jdbc;

import java.sql.*;

public class JDBCdbOperations {

    public static void main(String[] args) throws Exception {

        String url = "jdbc:mysql://localhost:3306/college";
        String uname = "root";
        String pass = "#@Pratham23";

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, uname, pass);
        Statement st = con.createStatement();

        // Insert query
        // String query = "INSERT INTO student values(6, 'Vivek')";
        // int count = st.executeUpdate(query);
        // System.out.println(count + " row/s affected.");

        // if value comes dynmically like this
        // int id = 1;
        // String name = "Pratham";
        // String query = "INSERT INTO student values(" + id + ", '" + name + " ');";

        // but it is not suitable for more no of colums so we use prepared statements
        // ** when the values comes dynamically then we use "prepared statements" **
        String query = "INSERT INTO student values (?,?)";
        PreparedStatement pt = con.prepareStatement(query);
        int id = 8;
        String name = "Dhiraj";
        pt.setInt(1, id);
        pt.setString(2, name);

        int count = pt.executeUpdate();
        System.out.println(count + " row/s affected.");

        st.close();
        con.close();
    }
}
