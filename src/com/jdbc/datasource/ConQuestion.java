package com.jdbc.datasource;
/*
    数据库连接池
    5k 次连接数据库问题
 */
import com.jdbc.utils.JDBCUtils;
import org.junit.Test;


import java.sql.Connection;

public class ConQuestion {

    //代码 连接mysql 5000次
    @Test
    public void testCon() {

        //看看连接-关闭 connection 会耗用多久
        long start = System.currentTimeMillis();
        System.out.println("开始连接.....");
        for (int i = 0; i < 5000; i++) {
            //使用传统的jdbc方式，得到连接
            Connection connection = JDBCUtils.getConnection();
            //做一些工作，比如得到PreparedStatement ，发送sql
            //..........
            //关闭
            JDBCUtils.close(null, null, connection);

        }
        long end = System.currentTimeMillis();
        System.out.println("传统方式5000次 耗时=" + (end - start));//传统方式5000次 耗时=7099
        /*
            传统获取Connection 问题分析
            1.传统的JDBC数据库连接使用 DriverManager 来获取，每次向数据库建立连接的时候都要将 Connection 加载到内存中，再验证IP地址，用户名和密码(0.05s~1s时间)。需要数据库连接的时候,就向数据库要求一个,频繁的进行数据库连接操作将占用很多的系统资源，容易造成服务器崩溃。
            2.每一次数据库连接，使用完后都得断开,如果程序出现异常而未能关闭，将导致数据库内存泄漏，最终将导致重启数据库。
            3.传统获取连接的方式,不能控制创建的连接数量，如连接过多，也可能导致内存泄漏，MySQL崩溃。
            4.解决传统开发中的数据库连接问题,可以采用数据库连接池技术 (connection pool)。

           数据库连接池
           基本介绍
           1.预先早缓冲池中放入一定数量的连接，当需要建立数据库连接时，只需从“缓冲池”中取出一个，使用完毕之后再放回去
           2.数据库连接池负责分配、管理和释放数据库连接，它允许应用程序重复使用一个现有的数据库连接，而不是重新建立一个
           3.当应用程序向连接池请求的连接数超过最大连接数量时，这些请求将被加入到等待队列。

            数据库连接池种类
            1.JDBC 的数据库连接池使用javax.sqI.DataSource来表示，DataSource 只是一个接口,该接口通常由第三方提供实现[提供.jar]
            2.C3P0数据库连接池,速度相对较慢，稳定性不错(hibernate, spring)
            3.DBCP数据库连接池,速度相对c3p0较快,但不稳定
            4.Proxool数据库连接池，有监控连接池状态的功能，稳定性较c3p0差一点
            5.BoneCP数据库连接池,速度快
            6.**Druid(德鲁伊)**是阿里提供的数据库连接池，集DBCP、C3P0、Proxool优点于一身的数据库连接池
         */
    }
}
