package com.oop.centre.studentscore.domain;

public interface StudentSystemInterface {

    Record[] displayAllRecords();

    boolean addRecord(Record record);

    Record findStudentId(String studentId);

    boolean deleteRecord(String studentId);

    void calculateCourseStats(String courseName);

    void sortByScoreDesc();
}
