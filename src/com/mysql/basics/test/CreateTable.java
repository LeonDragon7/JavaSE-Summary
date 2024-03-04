package com.mysql.basics.test;

public class CreateTable {
    /*
    #创建员工表(emp)的课堂练习
    -- 字段	属性
    -- Id	整形
    -- name	字符型
    -- sex	字符型
    -- birthday	日期型（date）
    -- entry_date	日期型   (date)
    -- job	字符型
    -- Salary	小数型
    -- resume	文本型

    create table `emp`(
        id int,
        `name` varchar(32),
        sex char(1),
        birthday date,
        entry_date datetime,
        job varchar(32),
        salary double
        `resume` test
    )charset utf8 collate utf8_bin engine innodb;

    -- 添加一条
    insert into `emp`
            values(100,'小妖怪','男','2000-11-11',
            '2010-11-10 11:11:11','巡山的',300,'大王叫我来巡山');

    select * from `emp`;
     */
}
