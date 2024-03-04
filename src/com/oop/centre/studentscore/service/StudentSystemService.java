package com.oop.centre.studentscore.service;

import com.oop.centre.studentscore.domain.Record;
import com.oop.centre.studentscore.domain.Student;
import com.oop.centre.studentscore.domain.StudentSystemInterface;


public class StudentSystemService implements StudentSystemInterface {

    private Record[] records;
    private int gradeNums = 1;
    private int idCounter = 1;

    public StudentSystemService(int size){
        records = new Record[size];
        records[0] = new Record(1, new Student("张三","1"),"软件工程",78.9);
    }


    @Override
    public Record[] displayAllRecords() {
        return records;
    }

    @Override
    public boolean addRecord(Record record) {
        if(gradeNums == records.length){
            System.out.println("数组已满，不能再添加了...");
            return false;
        }
        records[gradeNums++] = record;
        record.setSerialNumber(++idCounter);
        return true;
    }

    @Override
    public Record findStudentId(String studentId) {
        for (int i = 0; i < gradeNums; i++) {
            //错误 == 应该是equals
            if(studentId.equals(records[i].getStudentId())){
                return records[i];
            }
        }
        return null;
    }

    @Override
    public boolean deleteRecord(String studentId) {
        int index = -1;
        for (int i = 0; i < gradeNums; i++) {
            if(studentId.equals(records[i].getStudentId())){
                index = i;
            }
        }
        if(index == -1){
            return false;
        }
        //错误 因为记录的是index(索引)，所以如果不减1，会导致数组越界
        for (int i = index; i < gradeNums - 1; i++) {
            records[i] = records[i + 1];
        }
        records[--gradeNums] = null;
        return true;
    }
    @Override
    public void calculateCourseStats(String courseName) {

        double totalScore = 0;
        double maxScore = Double.MIN_VALUE;
        double minScore = Double.MAX_VALUE;
        int count = 0;

        for (Record record : records) {

            if(record == null){
                continue;
            }
            if (record.getCourseName().equals(courseName)) {
                double score = record.getScore();
                totalScore += score;

                if (score > maxScore) {
                    maxScore = score;
                }
                if (score < minScore) {
                    minScore = score;
                }
                count++;
            }
        }

        if (count > 0) {
            double averageScore = totalScore / count;
            System.out.println("课程：" + courseName);
            System.out.println("平均分：" + averageScore);
            System.out.println("最高分：" + maxScore);
            System.out.println("最低分：" + minScore);
        } else {
            System.out.println("未找到课程：" + courseName + " 的成绩记录！");
        }
    }


    @Override
    public void sortByScoreDesc() {
        Record record = null;
        //判断数组是否为空，有没有初始化
        if(records == null || records.length == 0){
            System.out.println("Records array is not initialized or empty.");
            return;
        }
        for (int i = 0; i < records.length - 1; i++) {
            for (int j = 0; j < records.length - i - 1; j++) {
                /*
                判断数组中有没有空值
                因为我在Controller层设值数组大小为10
                private StudentSystemService service = new StudentSystemService(10);
                records本身可能有空值，或者该getScore()方法问空，要进行空值判断
                 */
                if(records[j] == null || records[j + 1] == null){
                    continue;
                }
                if(records[j].getScore() < records[j + 1].getScore()){
                    record = records[j];
                    records[j] = records[j + 1];
                    records[j + 1] = record;
                }
            }
        }
        for(Record record1 : records){
            if(record1 == null){
                break;
            }
            System.out.println(record1);
        }
    }
}
