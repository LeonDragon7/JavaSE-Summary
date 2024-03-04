package com.jdbc.utils;
/*
    封装JDBCUtils
    说明
    在jdbc操作中，获取连接和释放资源是经常使用到,可以将其封装DBC连接的工真类JDBCUtils。
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * 这是一个工具类，完成 mysql的连接和关闭资源
 */
public class JDBCUtils {
    //定义相关的属性(4个), 因为只需要一份，因此，我们做成static
    private static String user; //用户名
    private static String password; //密码
    private static String url; //url
    private static String driver; //驱动名

    //在static代码块去初始化
    static {

        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("src\\mysql.properties"));
            //读取相关的属性值
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            url = properties.getProperty("url");
            driver = properties.getProperty("driver");
        } catch (IOException e) {
            //在实际开发中，我们可以这样处理
            //1. 将编译异常转成 运行异常 不转允许异常报错之后程序会异常中断
            //2. 调用者，可以选择捕获该异常，也可以选择默认处理该异常，比较方便.
            //这是因为使用JDBCUtils时被调用者 如果在这里输出编译异常信息[e.printStackTrace();]，那么
            //调用者获得的异常信息就少了 如果用运行异常，调用者想看就捕获这个异常，不想看就抛出（就是异常信息的决定权交给了调用者）
            throw new RuntimeException(e);
        }

    }

    //连接数据库, 返回Connection
    public static Connection getConnection() {

        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            //1. 将编译异常转成 运行异常
            //2. 调用者，可以选择捕获该异常，也可以选择默认处理该异常，比较方便.
            throw new RuntimeException(e);
        }
    }

    //关闭相关资源
    /*
        1. ResultSet 结果集
        2. Statement 或者 PreparedStatement
        3. Connection
        4. 如果需要关闭资源，就传入对象，否则传入 null
     */
    public static void close(ResultSet set, Statement statement, Connection connection) {

        //判断是否为null
        try {
            if (set != null) {
                set.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            //将编译异常转成运行异常抛出
            throw new RuntimeException(e);
        }
    }
}
