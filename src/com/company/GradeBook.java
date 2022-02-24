package com.company;

import java.sql.*;

public class GradeBook extends DB{
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
    public void remove(int teacher_id) {
        try {
            stmt = c.createStatement();
            String sql = "DELETE * FROM grade_book WHERE teacher_id = " + teacher_id;
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
        try {
            String sql = "SELECT * FROM grade_book";
            ps = c.prepareStatement(sql);
            rs = ps.executeQuery();


            while (rs.next()) {

                String teacher_id = rs.getString("teacher_id");
                String stud_id = rs.getString("stud_id");
                String grades = rs.getString("grades");

                System.out.println("teacher_id: " + teacher_id + ", stud_id: " + stud_id +", grades" + grades);
            }

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public void addGrades(int teach_id, int stud_id, String grades) {
        try {
            stmt = c.createStatement();
            String sql = "INSERT INTO grade_book VALUES(" + teach_id + ", " + stud_id + ", '" + grades + "')";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName()+": "+ e.getMessage());
            System.exit(0);
        }
    }

}