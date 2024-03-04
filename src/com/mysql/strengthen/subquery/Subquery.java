package com.mysql.strengthen.subquery;

public class Subquery {
    /*
        mysql 表子查询

        什么是子查询
        子查询是指嵌入在其它 sql 语句中的select 语句,也叫嵌套查询

        单行子查询
        单行子查询是指只返回一行数据的子查询语句

        -- 子查询的演示
        -- 请思考：如何显示与SMITH同一部门的所有员工?

            1. 先查询到 SMITH的部门号得到
            2. 把上面的select 语句当做一个子查询来使用

            SELECT deptno
            FROM emp
            WHERE ename = 'SMITH'

                    -- 下面的答案.
                    SELECT *
            FROM emp
            WHERE deptno = (
                    SELECT deptno
            FROM emp
            WHERE ename = 'SMITH'
            )


            多行子查询
        多行子查询指返回多行数据的子查询 使用关键字in

        -- 课堂练习:如何查询和部门10的工作相同的雇员的
        -- 名字、岗位、工资、部门号, 但是不含10号部门自己的雇员.


                1. 查询到10号部门有哪些工作
                2. 把上面查询的结果当做子查询使用

            select distinct job
            from emp
            where deptno = 10;

        --  下面语句完整

            select ename, job, sal, deptno
            from emp
            where job in (
                    SELECT DISTINCT job
                    FROM emp
                    WHERE deptno = 10
            ) and deptno <> 10//<>:不等于 相当于!=
            */
}
