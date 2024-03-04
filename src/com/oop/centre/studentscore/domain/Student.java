package com.oop.centre.studentscore.domain;

public class Student {
    private String studentName;
    private String studentId;

    public Student(String studentName, String studentId) {
        this.studentName = studentName;
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "学生姓名: '" + studentName + '\'' +
                ", 学号: '" + studentId + '\'';
    }
}
