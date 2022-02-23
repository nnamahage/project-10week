package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TeacherManagement {
    Connection c = null;
    Statement stmt = null;
    public void connect() {
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/library", "postgres", "1724");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("DB opened successfully");
    }
    public void addTeacher(int id, String name, String surname, String subject ) {
        try {
            stmt = c.createStatement();
            String sql = "INSERT INTO teachers VALUES(" + id + ", '"+ name +
                    "', '" + surname + "', " + "subject" + ")";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName()+": "+ e.getMessage());
            System.exit(0);
        }
    }

    public void removeTeacher id) {
        try {
            stmt = c.createStatement();
            String sql = "DELETE * FROM students WHERE id = " + id;
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName()+": "+ e.getMessage());
            System.exit(0);
        }
    }
}
