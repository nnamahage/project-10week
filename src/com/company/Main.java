package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManagementSystem st = new StudentManagementSystem();
        GradeBook gb = new GradeBook();
        TeacherManagement t = new TeacherManagement();

        int n = 0;
        while (n != 4) {
            System.out.println("1. Student\n2. Teacher\n3. Grades");
            n = sc.nextInt();
            switch (n) {
                case 1:
                    System.out.println("1. Add student\n2. Remove student(id)\n3. Show students by group\n4. Show student's avg grade by id\n5. Show table");
                    int m = 0;
                    m = sc.nextInt();
                    st.connect();
                    switch (m) {
                        case 1:
                            System.out.println("Insert id, name, surname, date of birth(DD-MM-YYYY) and group by ENTER");
                            st.addStudent(sc.nextInt(), sc.next(), sc.next(), sc.next(), sc.next());
                            break;
                        case 2:
                            System.out.println("Isert id of student you want to remove");
                            st.remove(sc.nextInt());
                            break;
                        case 3:
                            System.out.println("Insert group");
                            st.studByGroup(sc.next());
                            break;
                        case 4:
                            System.out.println("Insert id of student you want to see avg grade");
                            st.avgGrade(sc.nextInt());
                            break;
                        case 5:
                            st.showTable();
                            break;
                    }
                    break;
                case 2:
                    t.connect();
                    System.out.println("1. Add teacher\n2. Remove teacher(id)\n3. Show teachers");
                    m = 0;
                    m = sc.nextInt();
                    switch (m) {
                        case 1:
                            System.out.println("Insert id, name, surname and subject");
                            t.addTeacher(sc.nextInt(), sc.next(), sc.next(), sc.next());
                            break;
                        case 2:
                            System.out.println("Isert id of teacher you want to remove");
                            t.remove(sc.nextInt());
                            break;
                        case 3:
                            t.showTable();
                            break;
                    }
                    break;
                case 3:
                    gb.connect();
                    System.out.println("1. Add grades\n2. Remove grades of student by his id\n3. Show table");
                    m = 0;
                    m = sc.nextInt();
                    switch (m) {
                        case 1:
                            System.out.println("Insert teacher id, student id and 3 grades by ENTER");
                            int t_id = sc.nextInt();
                            int s_id = sc.nextInt();
                            int[] a = new int [3];
                            a[0] = sc.nextInt();
                            a[1] = sc.nextInt();
                            a[2] = sc.nextInt();
                            String b = "{" + Integer.toString(a[0]) + ", " + Integer.toString(a[1]) + ", " + Integer.toString(a[2]) + "}";

                            gb.addGrades(t_id, s_id, b);
                            break;
                        case 2:
                            System.out.println("Insert id of st whose grades you want to delete");
                            gb.remove(sc.nextInt());
                        case 3:
                            gb.showTable();
                    }
                    break;
            }
//            gb.connect();
//            st.addStudent(sc.nextInt(), sc.next(), sc.next(), sc.next(), sc.next());
//            t.addTeacher(sc.nextInt(), sc.next(), sc.next(), sc.next());
//            int[] a = {1,2,3};
//            String b = "{" + Integer.toString(a[0]) + ", " + Integer.toString(a[1]) + ", " + Integer.toString(a[2]) + "}";
//            gb.addGrades(1, 2, b);
//            n++;
        }
    }
}