package com.mysql.basics.type.numerical;

public class Int_ {
    /*
        数值型(整数)的基本使用
        #演示整型的是一个
        #使用tinyint 来演示范围 有符号 -128 ~ 127  如果没有符号 0-255
        #说明： 表的字符集，校验规则, 存储引擎，老师使用默认
        #1. 如果没有指定 unsigned , 则TINYINT就是有符号
        #2. 如果指定 unsigned , 则TINYINT就是无符号 0-255

        CREATE TABLE t3 (
            id TINYINT);
        CREATE TABLE t4 (
            id TINYINT UNSIGNED);

        INSERT INTO t3 VALUES(127); #这是非常简单的添加语句
        SELECT * FROM t3

        INSERT INTO t4 VALUES(255);
        SELECT * FROM t4;

        定义一个无符号的整数
        create table t10 (id tinyint);//默认是有符号的
        create table t11 (id tinyint unsigned);//无符号的 （后加unsigned就行）
     */
}
