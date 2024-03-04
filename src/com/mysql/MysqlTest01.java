package com.mysql;

public class MysqlTest01 {
    /*
    (1).以下哪条语句是错误的?
    A.SELECT empno,ename name,sal salary FROM emp;
    B.SELECT empno,ename name,sal AS salary FROM emp;
    C.SELECT ename,sal*12 AS "Annual Salary" FROM emp;
    D.SELECT ename,sal*12 Annual Salary FROM emp; -- 有空格最好引起来

    (2).某用户希望显示补助非空的所有雇员信息，应该使用哪条语句?
    A.SELECT ename.sal,comm FROM emp WHERE comm<>null;
    B.SELECT ename,sal,comm FROM emp WHERE comm IS NOT null;
    C.SELECT ename,sal,comm FROM emp WHERE comm<>0;

    (3).以下哪条语句是错误的?
    A.SELECT ename,sal salary FROM emp ORDER BY sal;
    B.SELECT ename,sal salary FROM emp ORDER BY salary；
    C. SELECT ename,sal salary FROM emp ORDER BY 3;

    2.写础查看DEPT表和EMP表的结构的sql语句

    3.使用简单查询语句完成:
    (1)显示所有部门名称。
    (2)显示所有雇员名及其全年收入13月(工资+补助),并指定列别名"年收入”

    4.限制查询数据。
    (1)显示工资超过2850的雇员姓名和工资。
    (2)显示工资不在1500到2850之间的所有雇员名及工资。
    (3)显示编号为7566的雇员姓名及所在部门编号。
    (4)显示部门10和30中工资超过1500的雇员名及工资。
    (5)显示无管理者的雇员名及岗位。

    5.排序数据。
    1)显示在1991年2月1日到1991年5月1日之间雇用的雇员名,岗位及雇佣日期,并以雇佣日期进行排序[默认]。
    2)显示获得补助的所有雇员名,工资及补助,并以工资降序排序


     */
}
