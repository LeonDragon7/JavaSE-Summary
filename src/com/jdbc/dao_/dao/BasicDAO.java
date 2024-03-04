package com.jdbc.dao_.dao;

import com.jdbc.dao_.utils.JDBCUtilsByDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
/*
    DAO 和增删改查通用方法-BasicDao
    先分析一个问题
    apache-dbutils+ Druid简化了JDBC开发,但还有不足:
    1.SQL语句是固定，不能通过参数传入，通用性不好，需要进行改进，更方便执行增删改查
    2.对于select 操作，如果有返回值，返回类型不能固定，需要使用泛型
    3.将来的表很多，业务需求复杂,不可能只靠一个Java类完成
    4.引出=》 BasicDAO画出示意图，看看在实际开发中，应该如何处理

    基本说明
    1.DAO : data access object数据访问对象
    2.这样的通用类，称为 BasicDao，是专门和数据库交互的，即完成对数据库(表)的crud操作。
    3.在BasicDao的基础上，实现一张表对应一个Dao，更好的完成功能，比如 Customer表-Customer.java类(javabean)-CustomerDao.java

    BasicDAO 应用实例
    完成一个简单设计com.jdbc.dao_
    1.com.jdbc.dao _.utils //工具类
    2.com.jdbc.dao_.domain // javabean
    3.com.jdbc.dao_.dao//存放XxxDAO和BasicDAO_
    4.com.jdbc.dao_.test //写测试类

 */
/**
 * 开发BasicDAO , 是其他DAO的父类
 */
public class BasicDAO<T> {//泛型指定具体类型
    private QueryRunner qr =  new QueryRunner();

    //开发通用的dml方法, 针对任意的表
    public int update(String sql, Object... parameters) {
        Connection connection = null;

        try {
            connection = JDBCUtilsByDruid.getConnection();
            int update = qr.update(connection, sql, parameters);
            return  update;
        } catch (SQLException e) {
            throw  new RuntimeException(e); //将编译异常->运行异常 ,抛出
        } finally {
            JDBCUtilsByDruid.close(null, null, connection);
        }
    }

    //返回多个对象(即查询的结果是多行), 针对任意表

    /**
     *
     * @param sql sql 语句，可以有 ?
     * @param clazz 传入一个类的Class对象 比如 Actor.class
     * @param parameters 传入 ? 的具体的值，可以是多个
     * @return 根据Actor.class 返回对应的 ArrayList 集合
     */
    public List<T> queryMulti(String sql, Class<T> clazz, Object... parameters) {

        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            return qr.query(connection, sql, new BeanListHandler<T>(clazz), parameters);

        } catch (SQLException e) {
            throw  new RuntimeException(e); //将编译异常->运行异常 ,抛出
        } finally {
            JDBCUtilsByDruid.close(null, null, connection);
        }

    }

    //查询单行结果 的通用方法
    public T querySingle(String sql, Class<T> clazz, Object... parameters) {

        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            return qr.query(connection, sql, new BeanHandler<T>(clazz), parameters);

        } catch (SQLException e) {
            throw  new RuntimeException(e); //将编译异常->运行异常 ,抛出
        } finally {
            JDBCUtilsByDruid.close(null, null, connection);
        }
    }

    //查询单行单列的方法,即返回单值的方法

    public Object queryScalar(String sql, Object... parameters) {

        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            return  qr.query(connection, sql, new ScalarHandler(), parameters);

        } catch (SQLException e) {
            throw  new RuntimeException(e); //将编译异常->运行异常 ,抛出
        } finally {
            JDBCUtilsByDruid.close(null, null, connection);
        }
    }
}
