package com.mysql.basics.statement.table;

public class CreateTable {
    /*
        创建表
        CREATE TABLE table_name
        (
            field1 datatype,
            field2 datatype,
            field3 datatype
        )character set 字符集 collate 校对规则 engine 存储引擎

        · field:指定列名 datatype:指定列类型(字段类型)
        · character set:如不指定则为所在数据库字符集
        · collate:如不指定则为所在数据库校对规则
        · engine:引擎(这个涉及内容较多)

        #指令创建表
        #注意：db02创建表时，要根据需保存的数据创建相应的列，并根据数据的类型定义相应的列类型。例：user表 (快速入门案例 create_tab01.sql)
        #id        	整形               [图形化，指令]
        #name 		字符串
        #password 	字符串
        #birthday 	日期
        CREATE TABLE `user` (
            id INT,
            `name` VARCHAR(255),
            `password` VARCHAR(255),
            `birthday` DATE
            )CHARACTER SET utf8 COLLATE utf8_bin ENGINE INNODB;

     */
}
