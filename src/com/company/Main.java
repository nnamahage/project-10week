package com.company;

public class Main {
    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        sms.addStudent(1, "Abduakhit", "Abdugalimov", 19, 3.2);
        sms.removeStudent(1);
        TeacherManagement tm = new TeacherManagement();
        tm.addTeacher(1, "Gulzhazira", "Omirzakova", "Biology");
        tm.removeTeacher(1);
    }
}
