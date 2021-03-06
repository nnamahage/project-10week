package com.company;

import java.sql.*;

public class TeacherManagement extends DB{

    ResultSet rs = null;
    PreparedStatement ps = null;
    Connection c = null;
    Statement stmt = null;


    @Override
    public void connect() {
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/project", "postgres", "12345");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": " + e.getMessage());
            System.exit(0);
        }
    }

    @Override
    public void remove(int id) {
        //remove teacher by id
        try {
            stmt = c.createStatement();
            String sql = "DELETE * FROM teachers WHERE teacher_id = " + id;
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName()+": "+ e.getMessage());
            System.exit(0);
        }
    }

    @Override
    public void showTable() {
        //show the whole table
        try {
            String sql = "SELECT * FROM teachers";
            ps = c.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("teacher_id");
                String name = rs.getString("teacher_name");
                String surname = rs.getString("teacher_surname");
                String subject = rs.getString("subject");

                System.out.println("id: " + id + ", name: ," + name
                        + ", surname: " + surname + ", subject: " + subject);
            }
        }
        catch(Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public void addTeacher(int id, String name, String surname, String subject) {
        //add new teacher
        try {
            stmt = c.createStatement();
            String sql = "INSERT INTO teachers VALUES(" + id + ", '"+ name +
                    "', '" + surname + "', '" + subject + "')";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName()+": "+ e.getMessage());
            System.exit(0);
        }
    }
}