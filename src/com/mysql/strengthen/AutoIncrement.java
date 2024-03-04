package com.mysql.strengthen;

public class AutoIncrement {
    /*
        自增长
        自增长基本介绍
        在某张表中，存在一个id列(整数),我们希望在添加记录的时候.该列从1开始,自动的增长，怎么处理?
        字段名 整型 primary key auto_increment

        自增长使用细节
        1.一般来说自增长是和primary key配合使用的
        2.自增长也可以单独使用[但是需要配合一个unique]
        3.自增长修饰的字段为整数型的(虽然小数也可以但是非常非常少这样使用)
        4.自增长默认从1开始，你也可以通过如下命令修改alter table 表名 auto_increment = 新的开始值;
        5.如果你添加数据时，给自增长字段(列)指定的有值，则以指定的值为准,**如果指定了自增长，一般来说，就按照自增长的规则（从指定的值开始，再自增长）**来添加数据

        -- 演示自增长的使用
        -- 创建表
        CREATE TABLE t24
            (id INT PRIMARY KEY AUTO_INCREMENT,
             email VARCHAR(32)NOT NULL DEFAULT '',
             `name` VARCHAR(32)NOT NULL DEFAULT '');
        DESC t24
        -- 测试自增长的使用
        INSERT INTO t24
            VALUES(NULL, 'tom@qq.com', 'tom'); -- 没有给值，自动维护，id自增长，第一次默认为1

        INSERT INTO t24
            (email, `name`) VALUES('hsp@sohu.com', 'hsp');

        SELECT * FROM t24;

        -- 修改默认的自增长开始值
        ALTER TABLE t25 AUTO_INCREMENT = 100
        CREATE TABLE t25
            (id INT PRIMARY KEY AUTO_INCREMENT,
             email VARCHAR(32)NOT NULL DEFAULT '',
             `name` VARCHAR(32)NOT NULL DEFAULT '');
        INSERT INTO t25
            VALUES(NULL, 'mary@qq.com', 'mary');
        INSERT INTO t25
            VALUES(666, 'hsp@qq.com', 'hsp');
        SELECT * FROM t25;

        CREATE DATABASE tmp;
        CREATE TABLE dept( -- 部门表
            deptno MEDIUMINT   UNSIGNED  NOT NULL  DEFAULT 0,
            dname VARCHAR(20)  NOT NULL  DEFAULT "",
            loc VARCHAR(13) NOT NULL DEFAULT ""
                    ) ;

        #创建表EMP雇员
            CREATE TABLE emp
                    (empno  MEDIUMINT UNSIGNED  NOT NULL  DEFAULT 0, -- 编号
                     ename VARCHAR(20) NOT NULL DEFAULT "", -- 名字
            job VARCHAR(9) NOT NULL DEFAULT "",-- 工作
            mgr MEDIUMINT UNSIGNED NOT NULL DEFAULT 0,-- 上级编号
            hiredate DATE NOT NULL,-- 入职时间
            sal DECIMAL(7,2)  NOT NULL,-- 薪水
            comm DECIMAL(7,2) NOT NULL,-- 红利
            deptno MEDIUMINT UNSIGNED NOT NULL DEFAULT 0 -- 部门编号
                    ) ;

        工资级别表
            CREATE TABLE salgrade
                    (
                            grade MEDIUMINT UNSIGNED NOT NULL DEFAULT 0,
                            losal DECIMAL(17,2)  NOT NULL,
            hisal DECIMAL(17,2)  NOT NULL
        );

        #测试数据
            INSERT INTO salgrade VALUES (1,700,1200);
            INSERT INTO salgrade VALUES (2,1201,1400);
            INSERT INTO salgrade VALUES (3,1401,2000);
            INSERT INTO salgrade VALUES (4,2001,3000);
            INSERT INTO salgrade VALUES (5,3001,9999);
     */
}
