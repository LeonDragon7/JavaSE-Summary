package com.mysql;

public class MysqlTest04 {
    /*
        8.设学校环境如下:一个系有若干个专业，每个专业一年只招一个班，每个班有若干个学生.现要建立关于系、学生、班级的数据库，关系模式为:
        · 班CLASS (班号classid，专业名subject，系名deptname，入学年份enrolltime，人数num)
        · 学生STUDENT(学号studentid，姓名name，年龄age，班号classid)
        · 系DEPARTMENT (系号departmentid，系名deptname)

        试用SQL语言完成以下功能:

        1.建表，在定义中要求声明:
        (1)每个表的主外码。

        (2) deptname是唯一约束。

        (3)学生姓名不能为空。

        2.插入如下数据

        DEPARTMENT (001，数学; 002，计算机; 003,化学;004,中文;005，经济;)

        3.完成以下查询功能

        3.1找出所有姓李的学生。

        3.2列出所有开设超过1个专业的系的名字

        3.3列出人数大于等于30的系的编号和名字。

        4.学校又新增加了一个物理系,编号为006

        5.学生张三退学，请更新相关的表
     */
}
