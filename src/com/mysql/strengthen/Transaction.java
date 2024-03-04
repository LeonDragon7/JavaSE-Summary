package com.mysql.strengthen;

public class Transaction {
    /*
        mysql 事务
        什么是事务
        事务用于保证数据的一致性,它由一组相关的dml（数据操作语言 增删改）语句组成,该组的dml语句要么全部成功，要么全部失败。
        如: 转账就要用事务来处理,用以保证数据的一致性。
        -- 事务的一个重要的概念和具体操作
        -- 演示
        -- 1. 创建一张测试表
        CREATE TABLE t27
            ( id INT,
              `name` VARCHAR(32));
        -- 2. 开始事务
        START TRANSACTION
        -- 3. 设置保存点
        SAVEPOINT a
        -- 执行dml 操作
        INSERT INTO t27 VALUES(100, 'tom');
        SELECT * FROM t27;

        SAVEPOINT b
        -- 执行dml操作
        INSERT INTO t27 VALUES(200, 'jack');

        -- 回退到 b
        ROLLBACK TO b
        -- 继续回退 a
        ROLLBACK TO a
        -- 如果这样, 表示直接回退到事务开始的状态.
        ROLLBACK
        -- 如果执行了commit，删除a和b保存点，就不能回滚事物
        COMMIT

        事务和锁
        当执行事务操作时(dml语句), mysql会在表上加锁, 防止其它用户改表的数据，这对用户来讲是非常重要的。
        mysql数据厍控制台事务的几个重要操作：
        1.start transaction --开始一个事务
        2.savepoint 保存点名--设置保存点
        3.rollback to 保存点名--回退事务
        4.rollback --回退全部事务
        5.commit -- 提交事务,所有的操作生效,不能回退

        回退事务
        在介绍回退事务前，先介绍一下保存点(savepoint)，保存点是事务中的点，用于取消部分事务，当结束事务时(commit)，会自动的删除该事务所定义的所有保存点当执行回退事务时，通过指定保存点可以回退到指定的点。

        提交事务
        使用commit语句可以提交事务.当执行了commit语句子后,会确认事务的变化、结束事务、删除保存点、释放锁，数据生效。当使用commit语句结束事务后,其它会话[其他连接]将可以查着到事务变化后的新数据[所有数据就正式生效.]

        事务细节讨论
        1.如果不开始事务，默认情况下，dml操作是自动提交的，不能回滚。
        2.如果开始一个事务，你没有创建保存点.你可以执行 rollback,默认就是回退到你事务开始的状态，但是在这中间的保存点全部清除了。
        3.你也可以在这个事务中(还没有提交时),创建多个保存点.比如: savepoint aaa;执行dml , savepoint bbb;
        4.你可以在事务没有提交前,选择回退到哪个保存点。
        5.mysql的事务机制需要innodb的存储引擎才可以使用，myisam不好使。
        6.开始一个事务start transaction 或者可以写 set autocommit=off;
        -- 讨论 事务细节
        -- 1. 如果不开始事务，默认情况下，dml操作是自动提交的，不能回滚
        INSERT INTO t27 VALUES(300, 'milan'); -- 自动提交 commit

        SELECT * FROM t27

        -- 2. 如果开始一个事务，你没有创建保存点. 你可以执行 rollback，
        -- 默认就是回退到你事务开始的状态
        START TRANSACTION
        INSERT INTO t27 VALUES(400, 'king');
        INSERT INTO t27 VALUES(500, 'scott');
        ROLLBACK -- 表示直接回退到事务开始的的状态
        COMMIT;

        -- 3. 你也可以在这个事务中(还没有提交时), 创建多个保存点.比如: savepoint aaa;
        -- 执行 dml , savepoint  bbb

        -- 4. 你可以在事务没有提交前，选择回退到哪个保存点
        -- 5. InnoDB 存储引擎支持事务 , MyISAM 不支持
        -- 6. 开始一个事务 start transaction 或者可以写 set autocommit=off;

        mysql 事务隔离级别
        事务隔离级别介绍
        1.多个连接开启各自事务操作数据库中数据时，数据库系统要负责隔离操作，以保证各个连接在获取数据时的准确性。(通俗解释：每一个事务看到同一张表的数据不一样)
        2.如果不考虑隔离性,可能会引发如下问题:
        · 脏读
        · 不可重复读
        · 幻读

        查看事务隔离级别
        · 脏读(dirty read):当一个事务读取另一个事务尚未提交的改变(update,insert,delete)时,产生脏读。（未commit）
        · 不可重复读(nonrepeatable read):同一查询在同一事务中多次进行，由于其他提交事务所做的修改或删除,每次返回不同的结果集，此时发生不可重复读。（已commit）
        · 幻读(phantom read):同一查询在同一事务中多次进行，由于其他提交事务所做的插入操作，每次返回不同的结果集，此时发生幻读。（已commit）

        不可重复读和幻读原理一致是同一查询进行多次后结果返回的不一致，，在同时进入MySQL查询，一个事务的改变且提交，在另一个事务可以看到提交后的元组，
        这就出现了错误，因为需要的是一开始未改变[开始事务]的属性，而不是修改后的。假如一个事务在十点
        钟改变十点钟之前的属性，但是另一个事务改变了十点钟之后的属性，提交在你之前，
        就会出现这两种错误。

        事务隔离级别
        概念: Mysql隔离级别定义了事务与事务之间的隔离程度。
        加锁会在其他线程操作数据库时，不操作数据库，自己卡住，等待其他线程commit后才进入数据库。

        mysql 的事务隔离级--案例
        -- 演示mysql的事务隔离级别

        -- 1. 开了两个mysql的控制台
        -- 2. 查看当前mysql的隔离级别
        SELECT @@tx_isolation;

        -- mysql> SELECT @@tx_isolation;
        -- +-----------------+
        -- | @@tx_isolation  |
        -- +-----------------+
        -- | REPEATABLE-READ |
        -- +-----------------+

        -- 3.把其中一个控制台的隔离级别设置 Read uncommitted

        SET SESSION TRANSACTION ISOLATION LEVEL READ UNCOMMITTED

        -- 4. 创建表
        CREATE TABLE `account`(
            id INT,
            `name` VARCHAR(32),
            money INT);


        -- 查看当前会话隔离级别
        SELECT @@tx_isolation
        -- 查看系统当前隔离级别
        SELECT @@global.tx_isolation
        -- 设置当前会话隔离级别
        SET SESSION TRANSACTION ISOLATION LEVEL READ UNCOMMITTED
        -- 设置系统当前隔离级别
        SET GLOBAL TRANSACTION ISOLATION LEVEL [你设置的级别]

        设置事务隔离级别
        1.查看当前会话隔离级别
        select @@tx_isolation;
        2.查看系统当前隔离级别
        select @@global.tx_isolation;
        3.设置当前会话隔离级别
        set session transaction isolation level repeatable read;
        4.设置系统当前隔离级别
        set global transaction isolation level repeatable read;
        5.mysql默认的事务隔离级别是 repeatable read，一般情况下，没有特殊 要求,没有必要修改(因为该级别可以满足绝大部分项目需求)

        如果想要修改默认隔离级别，可以全局修改，修改my.ini配置文件，在最后加上
        #可选参数有:READ-UNCOMMITTED, READ-COMMITTED, REPEATABLE-READ,SERIALIZABLE.
        [mysqld]
        transaction-isolation = REPEATABLE-READ

        mysql 事务ACID
        事务的acid 特性
        1.原子性(Atomicity) 原子性是指事务是一个不可分割的工作单位，事务中的操作要么都发生，要么都不发生。
        2.一致性(Consistency) 事务必须使数据库从一个二致性状态变换到另外一个一致性状态
        3.隔离性(Isolation) 事务的隔离性是多个用户并发访问数据库时，数据库为每一个用户开启的事务，不能被其他事务的操作数据所干扰，多个并发事务之间要相互隔离。
        4.持久性(Durability) 持久性是指一个事务一旦被提交，它对数据库中数据的改变就是永久性的，接下来即使数据库发生故障也不应该对其有任何影响。
     */
}
