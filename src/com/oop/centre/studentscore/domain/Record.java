package com.oop.centre.studentscore.domain;

public class Record {
    private int serialNumber;
    private Student student;
    private String courseName;
    private double score;

    public Record(int serialNumber, Student student, String courseName, double score) {
        this.serialNumber = serialNumber;
        this.student = student;
        this.courseName = courseName;
        this.score = score;
    }

    public String getStudentId() {
        return student.getStudentId();
    }

    public void setStudentId(String studentId) {
        this.student.setStudentId(studentId);
    }

    public String getStudentName() {
        return student.getStudentName();
    }

    public void setStudentName(String studentName) {
        this.student.setStudentName(studentName);
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "序号: " + serialNumber +
                ", " + student +
                ", 课程名称: '" + courseName + '\'' +
                ", 成绩: " + score;
    }
}
