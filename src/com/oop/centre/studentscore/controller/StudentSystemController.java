package com.oop.centre.studentscore.controller;

import com.oop.centre.studentscore.domain.Record;
import com.oop.centre.studentscore.domain.Student;
import com.oop.centre.studentscore.service.StudentSystemService;
import com.oop.centre.studentscore.utils.Utility;

public class StudentSystemController{
    private boolean loop = true;//控制显示菜单
    private char key = ' ';//接收用户选择
    private StudentSystemService service = new StudentSystemService(10);

    //显示
    public void displayGradeRecords(){
        System.out.println("学生成绩单:");
        Record[] list = service.displayAllRecords();
        for (int i = 0; i < list.length; i++) {
            if(list[i] == null){
                break;
            }
            System.out.println(list[i]);
        }
    }

    //添加
    public void addGradeRecord(){
        System.out.println("添加学生成绩记录");
        System.out.print("学生姓名: ");
        String studentName = Utility.readString(8);
        System.out.print("学号: ");
        String studentId = Utility.readString(12);
        System.out.print("课程名称: ");
        String courseName = Utility.readString(50);
        System.out.print("成绩: ");
        double score = Utility.readDouble();
        Record record = new Record(0, new Student(studentName, studentId), courseName, score);
        if(service.addRecord(record)){
            System.out.println("添加成功！");
        }else {
            System.out.println("添加失败！");
        }
    }

    //修改
    public void updateGradeRecord(){
        System.out.println("修改学生成绩记录");
        System.out.println("请选择待修改学号(0表示退出)");
        String updateId = Utility.readString(12);
        if(updateId.equals("0")){
            System.out.println("退出");
            return;
        }
        Record record = service.findStudentId(updateId);
        if(record == null){
            System.out.println("修改的学号不存在");
            return;
        }

        System.out.print("成绩(" + record.getScore() + "): ");
        double score = Utility.readDouble(8, 0);
        if(score != 0){
            record.setScore(score);
        }
    }

    //删除
    public void delGradeRecord(){
        System.out.println("删除学生成绩记录");
        System.out.println("请输入待删除学号(0表示退出)");
        String deleteId = Utility.readString(12);
        if(deleteId.equals("")){
            System.out.println("退出");
            return;
        }
        char choice = Utility.readConfirmSelection();
        if(choice == 'Y'){
            if(service.deleteRecord(deleteId)){
                System.out.println("删除成功！");
            }else {
                System.out.println("删除失败！");
            }
        }else {
            System.out.println("放弃删除！");
        }
    }

    //查找
    public void findStudentId(){
        System.out.println("查找学生成绩记录");
        System.out.println("请输入你要查找的学号");
        String stuId = Utility.readString(12);
        Record recode = service.findStudentId(stuId);
        if(recode != null){
            System.out.println(recode);
        }else {
            System.out.println("查找失败");
        }

    }
    //统计
    public void calculateGradeRecord(){
        System.out.println("统计学生成绩记录");
        System.out.println("请输入你要查找的课程名称");

        String courseName = Utility.readString(50);
        if(courseName.equals("")){
            System.out.println("退出");
            return;
        }
        service.calculateCourseStats(courseName);
    }

    //排序
    public void sortGradeRecord(){
        System.out.println("成绩记录从高到低排序");
        service.sortByScoreDesc();
    }
    //退出
    public void exit(){
        char choice = Utility.readConfirmSelection();
        if(choice == 'Y'){
            loop = false;
        }
    }
    //显示主菜单
    public void mainMenu(){
        do {
            // 显示菜单
            System.out.println("学生成绩管理系统菜单:");
            System.out.println("1. 查看学生成绩单");
            System.out.println("2. 添加学生成绩记录");
            System.out.println("3. 修改学生成绩记录");
            System.out.println("4. 删除学生成绩记录");
            System.out.println("5. 统计课程成绩");
            System.out.println("6. 查找学生成绩");
            System.out.println("7. 成绩排序");
            System.out.println("0. 退出系统");
            System.out.print("请选择操作：");
            key = Utility.readChar();
            switch (key){
                case '1':
                    displayGradeRecords();
                    break;
                case '2':
                    addGradeRecord();
                    break;
                case '3':
                    updateGradeRecord();
                    break;
                case '4':
                    delGradeRecord();
                    break;
                case '5':
                    calculateGradeRecord();
                    break;
                case '6':
                    findStudentId();
                    break;
                case '7':
                    sortGradeRecord();
                    break;
                case '0':
                    exit();
                    break;
                default:
                    System.out.println("无效的选择，请重新输入！");
            }
        }while(loop);
    }
}
