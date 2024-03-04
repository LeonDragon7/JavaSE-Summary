package com.jdbc;
/*
    事务
    基本介绍
    1.JDBC程序中当一个Connection对象创建时，默认情况下是自动提交事务:每次执行一个SQL语句时，如果执行成功，就会向数据库自动提交，而不能回滚。
    2.JDBC程序中为了让多个SQL语句作为一个整体执行，需要使用事务
    3.调用Connection的setAutoCommit(false)可以取消自动提交事务
    4.在所有的SQL语句都成功执行后，调用Connection的commit();方法提交事务
    5.在其中某个操作失败或出现异常时，调用Connection的rollback();方法回滚事务
 */

import com.jdbc.utils.JDBCUtils;
import org.junit.Test;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 演示jdbc 中如何使用事务
 */
public class Transaction_ {

    //没有使用事务.
    @Test
    public void noTransaction() {

        //操作转账的业务
        //1. 得到连接
        Connection connection = null;
        //2. 组织一个sql
        String sql = "update account set balance = balance - 100 where id = 1";
        String sql2 = "update account set balance = balance + 100 where id = 2";
        PreparedStatement preparedStatement = null;
        //3. 创建PreparedStatement 对象
        try {
            connection = JDBCUtils.getConnection(); // 在默认情况下，connection是默认自动提交
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate(); // 执行第1条sql

            int i = 1 / 0; //抛出异常,则下面的代码不会执行，但是上面的转账sql就会扣除，下面的却不会扣除，逻辑错误
            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.executeUpdate(); // 执行第2条sql
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            JDBCUtils.close(null, preparedStatement, connection);
        }
    }

    //事务来解决
    @Test
    public void useTransaction() {

        //操作转账的业务
        //1. 得到连接
        Connection connection = null;
        //2. 组织一个sql
        String sql = "update account set balance = balance - 100 where id = 1";
        String sql2 = "update account set balance = balance + 100 where id = 2";
        PreparedStatement preparedStatement = null;
        //3. 创建PreparedStatement 对象
        try {
            connection = JDBCUtils.getConnection(); // 在默认情况下，connection是默认自动提交
            //将 connection 设置为不自动提交
            connection.setAutoCommit(false); // 相当于开启了事务
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate(); // 执行第1条sql

            int i = 1 / 0; //抛出异常
            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.executeUpdate(); // 执行第3条sql

            //这里提交事务
            connection.commit();

        } catch (SQLException e) {
            //这里我们可以进行回滚，即撤销执行的SQL
            //默认回滚到事务开始的状态.
            System.out.println("执行发生了异常，撤销执行的sql");
            try {
                connection.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            //关闭资源
            JDBCUtils.close(null, preparedStatement, connection);
        }
    }
}
