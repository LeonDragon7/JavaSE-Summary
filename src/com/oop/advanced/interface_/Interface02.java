package com.oop.advanced.interface_;
/*
    深入讨论
    现在有一个项目经理(段玉),管理三个程序员,功能开发一个软件.为了控制和管理软件,项目经理可以定义一些接口，然后由程序员具体实现。
    实际要求：3个程序员，编写三个类，分别完成对Mysql、Oracle、DB2数据库的连接 connect，close
 */
public class Interface02 {
    public static void main(String[] args) {
        MysqlDB mysqlDB = new MysqlDB();
        t(mysqlDB);
        OracleDB oracleDB = new OracleDB();
        t(oracleDB);
    }
    public static void t(DBInterface db) {
        db.connect();
        db.close();
    }
}
