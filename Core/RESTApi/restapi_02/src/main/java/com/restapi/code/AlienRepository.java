package com.restapi.code;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlienRepository {

    Connection con = null;
    List<Alien> aliens;

    public void connect() {
        try {
            String url = "jdbc:mysql://localhost:3306/college";
            String uname = "root";
            String pass = "#@Pratham23";
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, uname, pass);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // *** Constructor ***
    public AlienRepository() {
        try {
            connect(); // connection

            // first insert demo values in aliens table
            // String query = "INSERT INTO aliens values (?,?,?)"; // id , name , points
            // PreparedStatement pt = con.prepareStatement(query);

            // Alien a1 = new Alien();
            // a1.setId(101);
            // a1.setName("Pratham");
            // a1.setPoints(61);

            // int id = a1.getId();
            // String name = a1.getName();
            // int points = a1.getPoints();

            // pt.setInt(1, id);
            // pt.setString(2, name);
            // pt.setInt(3, points);

            // int count = pt.executeUpdate();
            // System.out.println(count + " row/s affected.");

            // fetch aliens from table
            Statement st = con.createStatement();
            String query = "SELECT * FROM aliens";
            ResultSet rs = st.executeQuery(query);

            aliens = new ArrayList<>();
            while (rs.next()) {
                Alien a = new Alien();
                a.setId(rs.getInt(1));
                a.setName(rs.getString(2));
                a.setPoints(rs.getInt(3));
                aliens.add(a);
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + " " + rs.getInt(3));
            }
            System.out.println(aliens);

            st.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        // System.out.println("Alien is called!");
        // aliens = new ArrayList<>();

        // Alien a1 = new Alien();
        // a1.setId(101);
        // a1.setName("Pratham");
        // a1.setPoints(61);
        // aliens.add(a1);

        // Alien a2 = new Alien();
        // a2.setId(102);
        // a2.setName("Rishabh");
        // a2.setPoints(57);
        // aliens.add(a2);

        // Alien a3 = new Alien();
        // a3.setId(103);
        // a3.setName("Manthan");
        // a3.setPoints(55);
        // aliens.add(a3);
    }

    // get all aliens
    public List<Alien> getAliens() {
        try {
            connect();
            // fetch aliens from table
            Statement st = con.createStatement();
            String query = "SELECT * FROM aliens";
            ResultSet rs = st.executeQuery(query);

            aliens = new ArrayList<>();
            while (rs.next()) {
                Alien a = new Alien();
                a.setId(rs.getInt(1));
                a.setName(rs.getString(2));
                a.setPoints(rs.getInt(3));
                aliens.add(a);
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + " " + rs.getInt(3));
            }
            System.out.println(aliens);

            st.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        return aliens;
    }

    // get specific id aliens
    public Alien getAlien(int id) {
        try {
            connect();
            // fetch aliens from table
            Statement st = con.createStatement();
            String query = "SELECT * FROM aliens WHERE id =" + id;
            ResultSet rs = st.executeQuery(query);

            rs.next(); // fetch
            Alien a = new Alien();
            a.setId(rs.getInt(1));
            a.setName(rs.getString(2));
            a.setPoints(rs.getInt(3));

            st.close();
            con.close();
            System.out.println("Alien with id " + id + " fetch SuccessFully");
            return a;

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    // create new alien
    public void createAlien(Alien a) {
        try {
            connect();
            String query = "INSERT INTO aliens values (?,?,?)"; // id , name , points
            PreparedStatement pt = con.prepareStatement(query);

            int id = a.getId();
            String name = a.getName();
            int points = a.getPoints();

            pt.setInt(1, id);
            pt.setString(2, name);
            pt.setInt(3, points);

            int count = pt.executeUpdate();
            System.out.println(count + " row/s affected.");
            System.out.println("New alien created successfully!");
            pt.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // update new alien
    public void updateAlien(Alien a, int id) {
        try {
            connect();
            String query = "UPDATE aliens SET name = ?, points = ? WHERE id = ?";
            PreparedStatement pt = con.prepareStatement(query);

            pt.setString(1, a.getName());
            pt.setInt(2, a.getPoints());
            pt.setInt(3, id);

            int count = pt.executeUpdate();
            System.out.println(count + " row/s affected.");
            System.out.println("Alien updated successfully!");
            pt.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // delete new alien
    public void deleteAlien(int id) {
        try {
            connect();
            String query = "DELETE FROM aliens WHERE id = ?";
            PreparedStatement pt = con.prepareStatement(query);

            pt.setInt(1, id);

            int count = pt.executeUpdate();
            System.out.println(count + " row/s affected.");
            System.out.println("Alien deleted successfully!");
            pt.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        AlienRepository repo = new AlienRepository(); // initialize aliens List<>

        // *** CRUD operations *** on Aliens table -

        // "Read" all aliens 
        // System.out.println(repo.getAliens());

        // get aliens with specific id
        // System.out.println(repo.getAlien(101));

        // "Create" new Alien
        // Alien a3 = new Alien();
        // a3.setId(103);
        // a3.setName("Manthan");
        // a3.setPoints(55);
        // repo.createAlien(a3);
        // System.out.println(repo.aliens);

        // "Update" alien 
        // Alien a3 = new Alien();
        // a3.setId(103);
        // a3.setName("Manthan");
        // a3.setPoints(50);
        // repo.updateAlien(a3, 103);
        System.out.println(repo.aliens);

        // "Delete" alien 
        // repo.deleteAlien(105);
    }
}
