package com.jdbc;
/*
    Statement
    基本介绍
    1.Statement对象用于执行静态SQL语句并返回其生成的结果的对象
    2.在连接建立后,需要对数据库进行访问，执行命名或是SQL语句，可以通过
    · Statement[存在SQL注入]
    · PreparedStatement[预处理]
    · CallableStatement[存储过程]
    3.Statement对象执行SQL语句,存在SQL注入风险
    4.SQL注入是利用某些系统没有对用户输入的数据进行充分的检查，而在用户输入数据中注入非法的SQL语句段或命令,恶意攻击数据库。
    5.要防范SQL注入，只要用 PreparedStatement(从Statement扩展而来)取代Statement就可以了。
 */

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

/**
 * 演示statement 的注入问题
 */
@SuppressWarnings({"all"})
public class Statement_ {public static void main(String[] args) throws Exception {

    Scanner scanner = new Scanner(System.in);

    //让用户输入管理员名和密码
    System.out.print("请输入管理员的名字: ");  //next(): 当接收到 空格或者 '就是表示结束
    String admin_name = scanner.nextLine(); // 说明:如果希望看到SQL注入，这里需要用nextLine 直到回车才结束
    System.out.print("请输入管理员的密码: ");
    String admin_pwd = scanner.nextLine();

    //通过Properties对象获取配置文件的信息


    Properties properties = new Properties();
    properties.load(new FileInputStream("src\\mysql.properties"));
    //获取相关的值
    String user = properties.getProperty("user");
    String password = properties.getProperty("password");
    String driver = properties.getProperty("driver");
    String url = properties.getProperty("url");

    //1. 注册驱动
    Class.forName(driver);//建议写上

    //2. 得到连接
    Connection connection = DriverManager.getConnection(url, user, password);

    //3. 得到Statement
    Statement statement = connection.createStatement();
    //4. 组织SqL
    String sql = "select name , pwd  from admin where name ='"
            + admin_name + "' and pwd = '" + admin_pwd + "'";
    ResultSet resultSet = statement.executeQuery(sql);
    if (resultSet.next()) { //如果查询到一条记录，则说明该管理存在
        System.out.println("恭喜， 登录成功");
    } else {
        System.out.println("对不起，登录失败");
    }

    //关闭连接
    resultSet.close();
    statement.close();
    connection.close();
}
}
