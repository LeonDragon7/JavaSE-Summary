package com.mysql.basics.statement.table;

public class Delete {
    /*
        delete 语句
        使用delete 语句删除表中数据
        删除只能按照行删除，不能按照列删除。
        -- delete 语句演示

        --  删除表中名称为’老妖怪’的记录。
        DELETE FROM employee
            WHERE user_name = '老妖怪';
        --  删除表中所有记录
        DELETE FROM employee;

        -- Delete语句不能删除某一列的值（可使用update 设为 null 或者 ''）
        UPDATE employee SET job = '' WHERE user_name = '老妖怪';

        SELECT * FROM employee

        -- 要删除这个表
        DROP TABLE employee;

        使用细节
        · 如果不使用where子句，将删除表中所有数据。
        · Delete语句不能删除某一列的值(可使用update设为null 或者"")
        · 使用delete语句删除记录,不删除表本身。如要删除表，使用drop table语句。drop table 表名;
     */
}
