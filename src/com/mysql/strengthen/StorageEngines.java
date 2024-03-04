package com.mysql.strengthen;

public class StorageEngines {
    /*
        mysql 表类型和存储引擎
        基本介绍
        1.MySQL的表类型由存储引擎(Storage Engines）决定，主要包括MylSAM、innoDB、Memory等。
        2.MySQL 数据表主要支持六种类型，分别是: CSV.Memory、ARCHIVE. MRG MYISAM、MYISAM、InnoBDB。
        3.这六种又分为两类
        · 一类是”事务安全型”(transaction-safe) 支持事务，比如: InnoDB;
        · 其余都属于第二类，称为”非事务安全型”(non-transaction-safe) 不支持事务 [mysiam和memory].

        主要的存储引擎/表类型特点

        细节说明
        重点介绍三种: MyISAM、InnoDB、MEMORY
        1.MylSAM不支持事务、也不支持外键，但其访问速度快，对事务完整性没有要求
        2.InnoDB存储引擎提供了具有提交、回滚和崩溃恢复能力的事务安全。但是比起 MylSAM存储引擎，InnoDB写的处理效率差一些并且会占用更多的磁盘空间以保留数据和索引。
        3.MEMORY存储引擎使用存在内存中的内容来创建表。每个MEMORY表只实际对应 个磁盘文件。MEMORY类型的表访问非常得快，因为它的数据是放在内存中的，并且默认使用HASH索引。但是一旦MySQL服务关闭，表中的数据就会丢失掉, 表的结构还在。

        三种存储引擎表使用案例
        -- 表类型和存储引擎

        -- 查看所有的存储引擎
        SHOW ENGINES
        -- innodb 存储引擎，是前面使用过.
        -- 1. 支持事务 2. 支持外键 3. 支持行级锁

        -- myisam 存储引擎
        CREATE TABLE t28 (
            id INT,
            `name` VARCHAR(32)) ENGINE MYISAM
        -- 1. 添加速度快 2. 不支持外键和事务 3. 支持表级锁

        START TRANSACTION;
        SAVEPOINT t1
        INSERT INTO t28 VALUES(1, 'jack');
        SELECT * FROM t28;
        ROLLBACK TO t1

        -- memory 存储引擎
        -- 1. 数据存储在内存中[关闭了Mysql服务，数据丢失, 但是表结构还在]
        -- 2. 执行速度很快(没有IO读写) 3. 默认支持索引(hash表)

        CREATE TABLE t29 (
            id INT,
            `name` VARCHAR(32)) ENGINE MEMORY
        DESC t29 -- 表结构还在
        INSERT INTO t29
            VALUES(1,'tom'), (2,'jack'), (3, 'hsp');
        SELECT * FROM t29

        -- 指令修改存储引擎
        ALTER TABLE `t29` ENGINE = INNODB

        如何选择表的存储引擎
        1.如果你的应用不需要事务，处理的只是基本的CRUD操作，那么MylSAM 是不二选择,速度快
        2.如果需要支持事务,选择InnoDB。
        3.Memory存储引擎就是将数据存储在内存中，由于没有磁盘I/O的等待, 速度极快。但由于是内存存储引擎，所做的任何修改在服务器重启后都将消失。(经典用法用户的在线状态())

        修改存储引擎
        ALTER TABLE `表名` ENGINE = 储存引擎;
     */
}
