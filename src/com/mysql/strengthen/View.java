package com.mysql.strengthen;

public class View {
    /*
        视图(view)
        看一个需求
        emp表的列信息很多，有些信息是个人重要信息(比如sal, comm,mgr, hiredate)，如果我们希望某个用户只能查询emp表的(empno,ename, job和deptno)信息，有什么办法?=>视图
        基本概念
        1.视图是一个虚拟表，其内容由查询定义。同真实的表一样，视图包含列，其数据来自对应的真实表(基表)
        2.视图和基表关系的示意图：

        视图的基本使用
        1.create view 视图名 as select语句
        2.alter view 视图名 as select语句 --更新成新的视图
        3.SHOW CREATE VIEW 视图名
        4.drop view 视图名1,视图名2

        -- 视图的使用
        -- 创建一个视图emp_view01，只能查询emp表的(empno、ename, job 和 deptno ) 信息

        -- 创建视图
        CREATE VIEW emp_view01
            AS
            SELECT empno, ename, job, deptno FROM emp;

        -- 查看视图
        DESC emp_view01

        SELECT * FROM emp_view01;
        SELECT empno, job  FROM emp_view01;

        -- 查看创建视图的指令
        SHOW CREATE VIEW emp_view01
        -- 删除视图
        DROP VIEW emp_view01;


        -- 视图的细节

        -- 1. 创建视图后，到数据库去看，对应视图只有一个视图结构文件(形式: 视图名.frm)
        -- 2. 视图的数据变化会影响到基表，基表的数据变化也会影响到视图[insert update delete ]

        -- 修改视图 会影响到基表

        UPDATE emp_view01
            SET job = 'MANAGER'
            WHERE empno = 7369

        SELECT * FROM emp; -- 查询基表


        SELECT * FROM emp_view01

        -- 修改基本表， 会影响到视图

        UPDATE emp
            SET job = 'SALESMAN'
            WHERE empno = 7369

        -- 3. 视图中可以再使用视图 , 比如从emp_view01 视图中，选出empno,和ename做出新视图
        DESC emp_view01

        CREATE VIEW emp_view02
            AS
            SELECT empno, ename FROM emp_view01

        SELECT * FROM emp_view02

        视图细节讨论
        1.创建视图后，到数据库去看，对应视图只有一个视图结构文件(形式:视图名.frm)
        2.视图的数据变化会影响到基表，基表的数据变化也会影响到视图[insert update delete ]
        3.视图中可以再使用视图，数据仍然来自基表.

        视图最佳实践
        1.安全。一些数据表有着重要的信息。有些字段是保密的，不能让用户直接看到。这时就可以创建一个视图，在这张视图中只保留一部分字段。这样，用户就可以查询自己需要的字段,不能查看保密的字段。
        2.性能。关系数据库的数据常常会分表存储，使用外键建立这些表的之间关系。这时,数据库查询通常会用到连接(JOIN)。这样做不但麻烦，效率相对也比较低。如果建立一个视图，将相关的表和字段组合在一起，就可以避免使用JOIN查询数据。
        3.灵活。如果系统中有一张旧的表，这张表由于设计的问题，即将被废弃。然而，很多应用都是基于这张表，不易修改。这时就可以建立一张视图，视图中的数据直接映射到新建的表。这样，就可以少做很多改动，也达到了升级数据表的目的。

        -- 视图的课堂练习
        -- 针对 emp，dept , 和 salgrade 张三表.创建一个视图 emp_view03，
        -- 可以显示雇员编号，雇员名，雇员部门名称和 薪水级别[即使用三张表，构建一个视图]
        /
            分析: 使用三表联合查询，得到结果
            将得到的结果，构建成视图
        /
            CREATE VIEW emp_view03
                    AS
            SELECT empno, ename, dname, grade
            FROM emp, dept, salgrade
            WHERE emp.deptno = dept.deptno AND
                    (sal BETWEEN losal AND hisal)

            DESC emp_view03
            SELECT * FROM emp_view03

     */
}
