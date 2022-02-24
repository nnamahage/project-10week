package com.company;

import java.sql.*;

public class StudentManagementSystem extends DB{
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
        //remove stud from table by id
        try {
            stmt = c.createStatement();
            String sql = "DELETE FROM students WHERE stud_id = " + id;
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
            String sql = "SELECT * FROM students";
            ps = c.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("stud_id");
                String name = rs.getString("stud_name");
                String surname = rs.getString("stud_surname");
                String date = rs.getString("date_of_birth");
                String group = rs.getString("ngroup");

                System.out.println("id: " + id + ", name: " + name
                        + ", surname: " + surname + ", birth date: " + date + ", group: " + group);
            }
        }
        catch(Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public void addStudent(int id, String name, String surname, String date_of_birth, String group) {
        //add new student
        try {
            stmt = c.createStatement();
            String sql = "INSERT INTO students VALUES(" + id + ", '"+ name +
                    "', '" + surname + "', '" + date_of_birth + "', '" + group + "')";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName()+": "+ e.getMessage());
            System.exit(0);
        }
    }


    public void avgGrade(int id) {
        //get average grade of student by his id
        try {
            String sql = "SELECT * FROM grades WHERE stud_id = " + id;
            ps = c.prepareStatement(sql);
            rs = ps.executeQuery();


            while (rs.next()) {

                String grades = rs.getString("grades");
                int a = Character.getNumericValue(grades.charAt(0));
                int b = Character.getNumericValue(grades.charAt(1));
                int c = Character.getNumericValue(grades.charAt(2));
                System.out.println((a+b+c)/3);

            }

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
    public void studByGroup(String group) {
        //show student that studies in given group
        try {
            String sql = "SELECT * FROM students WHERE ngroup = '" + group + "'";
            ps = c.prepareStatement(sql);
            rs = ps.executeQuery();


            while (rs.next()) {


                int st_id = rs.getInt("stud_id");
                String st_name = rs.getString("stud_name");
                String st_surname = rs.getString("stud_surname");
                System.out.println("student_id: " + st_id + ", student_name: " + st_name + ", student_surname: "
                        + st_surname + ", group: " + group);

            }

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

}