package com.mysql.basics.statement.table;

public class Select {
    /*
        select 语句
        基本语法
        注意事项(创建测试表学生表)
        1.Select 指定查询哪些列的数据。
        2.column指定列名。
        3.*号代表查询所有列。
        4.From指定查询哪张表。
        5.DISTINCT可选, 指显示结果时，是否去掉重复数据。

        练习

        -- select 语句【重点 难点】
        CREATE TABLE student(
            id INT NOT NULL DEFAULT 1,
            NAME VARCHAR(20) NOT NULL DEFAULT '',
            chinese FLOAT NOT NULL DEFAULT 0.0,
            english FLOAT NOT NULL DEFAULT 0.0,
            math FLOAT NOT NULL DEFAULT 0.0
        );

        INSERT INTO student(id,NAME,chinese,english,math) VALUES(1,'韩顺平',89,78,90);
        INSERT INTO student(id,NAME,chinese,english,math) VALUES(2,'张飞',67,98,56);
        INSERT INTO student(id,NAME,chinese,english,math) VALUES(3,'宋江',87,78,77);
        INSERT INTO student(id,NAME,chinese,english,math) VALUES(4,'关羽',88,98,90);
        INSERT INTO student(id,NAME,chinese,english,math) VALUES(5,'赵云',82,84,67);
        INSERT INTO student(id,NAME,chinese,english,math) VALUES(6,'欧阳锋',55,85,45);
        INSERT INTO student(id,NAME,chinese,english,math) VALUES(7,'黄蓉',75,65,30);
        INSERT INTO student(id,NAME,chinese,english,math) VALUES(8,'韩信',45,65,99);

        SELECT * FROM student;

        -- 查询表中所有学生的信息。
        SELECT * FROM student;
        -- 查询表中所有学生的姓名和对应的英语成绩。
        SELECT `name`,english FROM student;
        -- 过滤表中重复数据 distinct 。
        SELECT DISTINCT english FROM student;
        -- 要查询的记录，每个字段都相同，才会去重
        SELECT DISTINCT `name`, english FROM student;


        -- select 语句的使用
        使用表达式对查询的列进行运算
        -- 统计每个学生的总分
        SELECT `name`, (chinese+english+math) FROM student;
        -- 在所有学生总分加10分的情况
        SELECT `name`, (chinese + english + math + 10) FROM student;
        在select 语句中可使用as 语句
        -- 使用别名表示学生分数。
        SELECT `name` AS '名字', (chinese + english + math + 10) AS total_score
            FROM student;
     */
}
