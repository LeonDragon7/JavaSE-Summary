package com.mysql.strengthen;

public class Restraint {
    /*
        mysql 约束
        基本介绍
        约束用于确保数据库的数据满足特定的商业规则。在mysql中，约束包括: not null、unique, primary key, foreign key, 和 check 五种.

        primary key(主键)
        字段名 字段类型 primary key （表示该字段为主键）
        用于唯一的标示表行的数据,当定义主键约束后，该列不能重复

        · primary key不能重复而且不能为null.
        · 一张表最多只能有一个主键,但可以是复合主键
        · 主键的指定方式有两种
        （1）直接在字段名后指定:字段名primary key
        （2）在表定义最后写primary key(列名);
        . 使用 desc 表名，可以看到primary key的情况。
        . 在实际开发中，每个表往往都会设计一个主键。

        -- 主键使用

        -- id	name 	email
        CREATE TABLE t17
            (id INT PRIMARY KEY, -- 表示id列是主键
            `name` VARCHAR(32),
            email VARCHAR(32));

        -- 主键列的值是不可以重复
        INSERT INTO t17
            VALUES(1, 'jack', 'jack@sohu.com');
        INSERT INTO t17
            VALUES(2, 'tom', 'tom@sohu.com');

        INSERT INTO t17
            VALUES(1, 'hsp', 'hsp@sohu.com'); -- 报错

        SELECT * FROM t17;

        -- 主键使用的细节讨论
        -- primary key不能重复而且不能为 null。
        INSERT INTO t17
            VALUES(NULL, 'hsp', 'hsp@sohu.com');
        -- 一张表最多只能有一个主键, 但可以是复合主键(比如 id+name[作为一个主键])
        CREATE TABLE t18
            (id INT PRIMARY KEY, -- 表示id列是主键
            `name` VARCHAR(32), PRIMARY KEY -- 错误的
            email VARCHAR(32));
        -- 演示复合主键 (id 和 name 做成复合主键)
        CREATE TABLE t18
            (id INT ,
            `name` VARCHAR(32),
            email VARCHAR(32),
            PRIMARY KEY (id, `name`) -- 这里就是复合主键 只有多个主键里面的属性同时相同才会报错
            );

        INSERT INTO t18
            VALUES(1, 'tom', 'tom@sohu.com');
        INSERT INTO t18
            VALUES(1, 'jack', 'jack@sohu.com');
        INSERT INTO t18
            VALUES(1, 'tom', 'xx@sohu.com'); -- 这里就违反了复合主键
        SELECT * FROM t18;

        -- 主键的指定方式 有两种
        -- 1. 直接在字段名后指定：字段名  primakry key
        -- 2. 在表定义最后写 primary key(列名);
        CREATE TABLE t19
            (id INT ,
            `name` VARCHAR(32) PRIMARY KEY,
            email VARCHAR(32)
            );

        CREATE TABLE t20
            (id INT ,
            `name` VARCHAR(32) ,
            email VARCHAR(32),
            PRIMARY KEY(`name`) -- 在表定义最后写 primary key(列名)
            );

        -- 使用desc 表名，可以看到primary key的情况

        DESC t20 -- 查看 t20表的结果，显示约束的情况
        DESC t18

        not null(非空)
        如果在列上定义了not null, 那么当插入数据时，必须为列提供数据。
        字段名 字段类型 not null

        unique(唯一)
        当定义了唯一约束后，该列值是不能重复的。
        字段名 字段类型 unique
        1.如果没有指定not null，则unique字段可以有多个null
        2.一张表可以有多个unique字段
        -- unique的使用

        CREATE TABLE t21
            (id INT UNIQUE ,  -- 表示 id 列是不可以重复的.
            `name` VARCHAR(32) ,
            email VARCHAR(32)
            );

        INSERT INTO t21
            VALUES(1, 'jack', 'jack@sohu.com');

        INSERT INTO t21
            VALUES(1, 'tom', 'tom@sohu.com');

        -- unqiue使用细节
        -- 1. 如果没有指定 not null , 则 unique 字段可以有多个null
        -- 如果一个列(字段)， 是 unique not null 使用效果类似 primary key
        INSERT INTO t21
            VALUES(NULL, 'tom', 'tom@sohu.com');
        SELECT * FROM t21;
        -- 2. 一张表可以有多个unique字段

        CREATE TABLE t22
            (id INT UNIQUE ,  -- 表示 id 列是不可以重复的.
            `name` VARCHAR(32) UNIQUE , -- 表示name不可以重复
            email VARCHAR(32)
            );
        DESC t22


        foreign key(外键)
        用于定义主表和从表之间的关系:
        · 外键约束要定义在从表上，主表则必须具有主键约束或是unique约束,
        · 当定义外键约束后，要求外键列数据必须在主表的主键列存在或是为null(学生/班级图示)。
        细节说明：
        1.外键指向的表的字段，要求是primary key或者是unique
        2.表的引擎类型是innodb，这样的表才支持外键
        3.外键字段的类型要和主键字段的类型一致（长度可以不同）
        4.外键字段的值，必须在主键字段中出现过，或者为null[前提是外键字段允许为null]
        5.一旦建立主外键的关系，数据不能随意删除了
        -- 外键演示 先建主表后建从表

        -- 创建 主表 my_class
        CREATE TABLE my_class (
            id INT PRIMARY KEY , -- 班级编号
            `name` VARCHAR(32) NOT NULL DEFAULT '');

        -- 创建 从表 my_stu
        CREATE TABLE my_stu (
            id INT PRIMARY KEY , -- 学生编号
            `name` VARCHAR(32) NOT NULL DEFAULT '',
            class_id INT , -- 学生所在班级的编号
            -- 下面指定外键关系
            FOREIGN KEY(class_id) REFERENCES my_class(id)
            )
        -- 测试数据
        INSERT INTO my_class
            VALUES(100, 'java'), (200, 'web');
        INSERT INTO my_class
            VALUES(300, 'php');

        SELECT * FROM my_class;
        INSERT INTO my_stu
            VALUES(1, 'tom', 100);
        INSERT INTO my_stu
            VALUES(2, 'jack', 200);
        INSERT INTO my_stu
            VALUES(3, 'hsp', 300);
        INSERT INTO my_stu
            VALUES(4, 'mary', 400); -- 这里会失败...因为400班级不存在

        INSERT INTO my_stu
            VALUES(5, 'king', NULL); -- 可以, 外键 没有写 not null
        SELECT * FROM my_class;

        -- 一旦建立主外键的关系，数据不能随意删除
        -- 可以先删除从表的记录在删除主表的记录，反之则不行
        DELETE FROM my_class
            WHERE id = 100;


        check
        用于强制行数据必须满足的条件,假定在sal列上定义了check约束,并要求sal列值在1000 ~2000之间，
        如果不在1000~2000之间就会提示出错。
        提示:oracle和 sql server 均支持check ,但是mysql5.7目前还不支持check ,只做语法校验，但不会生效。
        -- 演示check的使用
        -- mysql5.7目前还不支持check ,只做语法校验，但不会生效
        -- 了解
        -- 学习 oracle, sql server, 这两个数据库是真的生效.

        -- 测试
        CREATE TABLE t23 (
            id INT PRIMARY KEY,
            `name` VARCHAR(32) ,
            sex VARCHAR(6) CHECK (sex IN('man','woman')),
            sal DOUBLE CHECK ( sal > 1000 AND sal < 2000)
            );

        -- 添加数据
        INSERT INTO t23
            VALUES(1, 'jack', 'mid', 1);
        SELECT * FROM t23;

        在MySQL中实现check的功能，一般是在程序中控制，或者通过触发器完成。
     */
}
