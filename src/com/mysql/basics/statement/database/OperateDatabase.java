package com.mysql.basics.statement.database;

public class OperateDatabase {
    /*
        查看、删除数据库
        显示数据库语句:
        SHOW DATABASES
        显示数据库创建语句:
        SHOW CREATE DATABASE db_name
        数据库删除语句[一定要慎用]:
        DROP DATABASE [IF EXISTS] db_ name

        #演示删除和查询数据库
        #查看当前数据库服务器中的所有数据库
        SHOW DATABASES
        #查看前面创建的hsp_db01数据库的定义信息
        SHOW CREATE DATABASE `hsp_db01`
        #在创建数据库,表的时候，为了规避关键字，可以使用反引号解决，比如有数据库的名称就叫做CREATE，那么就需要使用` `解决。

        #删除前面创建的hsp_db01数据库
        DROP DATABASE hsp_db01
     */
}
