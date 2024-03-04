package com.jdbc.myjdbc;
/*
    JDBC 概述
    基本介绍
    1.JDBC为访问不同的数据库提供了统一的接口，为使用者屏蔽了细节问题。
    2.Java程序员使用JDBC,可以连接任何提供了JDBC驱动程序的数据库系统，从而完成对数据库的各种操作。
    3.JDBC的基本原理图[重要!]

    JDBC 带来的好处
    如果Java直接访问数据库(示意图)

    JDBC带来的好处(示意图)
    说明：JDBC是Java提供一套用于数据库操作的接口APl, Java程序员只需要面向这套接口编程即可。不同的数据库厂商,需要针对这套接口,提供不同实现。
    JDBC API是一系列的接口，它统一和规范了应用程序与数据库的连接、执行SQL语句，并到得到返回结果等各类操作,相关类和接口在java.sql与javax.sql包中

 */
/**
 * mysql 数据库实现了jdbc接口 [模拟] 【mysql厂商开发】
 */
public class MysqlJdbcImpl implements JdbcInterface{
    @Override
    public Object getConnection() {
        System.out.println("得到 mysql 的连接");
        return null;
    }

    @Override
    public void crud() {
        System.out.println("完成 mysql 增删改查");
    }

    @Override
    public void close() {
        System.out.println("关闭 mysql 的连接");
    }
}
