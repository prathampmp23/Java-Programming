package jdbc;

import java.sql.*; // 1st step - Import packages

public class JDBCConnection {
    /*
     * Steps for java DataBase connectivity -->>
     * 
     * 1. Import packages
     * 2. Load and register Driver
     * 3. Establish Connection
     * 4. Create the statemnt
     * 5. Execute the query
     * 6. Process the results
     * 7. Close connection
     * 
     */
    public static void main(String[] args) throws Exception {

        String url = "jdbc:mysql://localhost:3306/college";
        String uname = "root";
        String pass = "#@Pratham23";

        // 2nd step load driver
        // "com.mysql.jdbc.Driver" This is deprecated. The new driver class is `com.mysql.cj.jdbc.Driver'
        Class.forName("com.mysql.cj.jdbc.Driver"); 

        // 2nd step register driver and 3rd step Establish connection
        Connection con = DriverManager.getConnection(url, uname, pass); 
        
        // 4th step - create statement
        Statement st = con.createStatement(); 

        // 5th step - Execute query
        // String query = "SELECT name FROM student WHERE id = 1"; // to fetch one value
        String query = "SELECT * FROM student"; // to fetch entire table
        
        //6th step - process result
        ResultSet rs = st.executeQuery(query); 
        
        // for printing single data - 
        // rs.next(); // fetch 
        // String name = rs.getString("name");
        // System.out.println(name);

        // for printing table data of multiple rows and column - 
        // String userData = rs.getInt(1) + " " + rs.getString(2);
        // loop to print table data
        System.out.println("Student table - ");
        System.out.println("Id" + " " + "Name");
        while (rs.next()) {
            System.out.println(rs.getInt(1) + "  " + rs.getString(2));
        }

        // 7th step - close
        st.close();
        con.close();
    }
}