package com.jdbc.datasource;
/*
    基本介绍
    1.commons-dbutils是 Apache组织提供的一个开源JDBC工具类库，它是对JDBC的封装，使用dbutils能极大简化jdbc编码的工作量。
    · DbUtils类：
    1.QueryRunner类:该类封装了SQL的执行，是线程安全的。可以实现增、删、改、查、批处理。
    2.使用QueryRunner类实现查询。
    3.ResultSetHandler接口：该接口用于处理java.sql.ResultSet，将数据按要求转换为另一种形式。
    · ArrayHandler:把结果集中的第一行数据转成对象数组。
    · ArrayListHandler:把结果集中的每一行数据都转成一个数组，再存放到List中。
    · BeanHandler:将结果集中的第一行数据封装到一个对应的JavaBean实例中。
    · BeanListHandler: 将结果集中的每一行数据都封装到一个对应的JavaBean实例中，存放到List里。
    · ColumnListHandler:将结果集中某一列的数据存放到List中。
    · KeyedHandler(name):将结果集中的每行数据都封装到Map里，再把这些map再存到一个map里，其key为指定的key。
    · MapHandler: 将结果集中的第一行数据封装到一个Map里，key是列名,value就是对应的值。
    · MapListHandler:将结果集中的每一行数据都封装到一个Map里，然后再存放到List。
 */
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"all"})
public class DBUtils_USE {

    // 使用apache-DBUtils 工具类 + druid 完成对表的crud操作
    @Test
    public void testQueryMany() throws SQLException { //返回结果是多行的情况

        //1. 得到 连接 (druid)
        Connection connection = JDBCUtilsByDruid.getConnection();
        //2. 使用 DBUtils 类和接口 , 先引入DBUtils 相关的jar , 加入到本Project
        //3. 创建 QueryRunner
        QueryRunner queryRunner = new QueryRunner();
        //4. 就可以执行相关的方法，返回ArrayList 结果集
        //String sql = "select * from actor where id >= ?";
        //   注意: sql 语句也可以查询部分列
        String sql = "select id, name from actor where id >= ?";
        //(1) query 方法就是执行sql 语句，得到resultset ---封装到 --> ArrayList 集合中
        //(2) 返回集合
        //(3) connection: 连接
        //(4) sql : 执行的sql语句
        //(5) new BeanListHandler<>(Actor.class): 在将resultset -> Actor 对象 -> 封装到 ArrayList
        //    底层使用反射机制 去获取Actor 类的属性，然后进行封装
        //(6) 1 就是给 sql 语句中的? 赋值，可以有多个值，因为是可变参数Object... params
        //(7) 底层得到的resultset ,会在query 关闭, 并且关闭PreparedStatment，所以只需要传入connection就可以。
        /**
         * 分析 queryRunner.query方法:
         * public <T> T query(Connection conn, String sql, ResultSetHandler<T> rsh, Object... params) throws SQLException {
         *         PreparedStatement stmt = null;//定义PreparedStatement
         *         ResultSet rs = null;//接收返回的 ResultSet
         *         Object result = null;//返回ArrayList
         *
         *         try {
         *             stmt = this.prepareStatement(conn, sql);//创建PreparedStatement
         *             this.fillStatement(stmt, params);//对sql 进行 ? 赋值
         *             rs = this.wrap(stmt.executeQuery());//执行sql,返回resultset
         *             result = rsh.handle(rs);//返回的resultset --> arrayList[result] [使用到反射，对传入class对象处理]
         *         } catch (SQLException var33) {
         *             this.rethrow(var33, sql, params);
         *         } finally {
         *             try {
         *                 this.close(rs);//关闭resultset
         *             } finally {
         *                 this.close((Statement)stmt);//关闭preparedstatement对象
         *             }
         *         }
         *
         *         return result;
         *     }
         */
        List<Actor> list =
                queryRunner.query(connection, sql, new BeanListHandler<>(Actor.class), 1);
        System.out.println("输出集合的信息");
        for (Actor actor : list) {
            System.out.print(actor);
        }


        //释放资源
        JDBCUtilsByDruid.close(null, null, connection);

    }

    //演示 apache-dbutils + druid 完成 返回的结果是单行记录(单个对象)
    @Test
    public void testQuerySingle() throws SQLException {

        //1. 得到 连接 (druid)
        Connection connection = JDBCUtilsByDruid.getConnection();
        //2. 使用 DBUtils 类和接口 , 先引入DBUtils 相关的jar , 加入到本Project
        //3. 创建 QueryRunner
        QueryRunner queryRunner = new QueryRunner();
        //4. 就可以执行相关的方法，返回单个对象
        String sql = "select * from actor where id = ?";
        // 因为我们返回的单行记录<--->单个对象 , 使用的Hander 是 BeanHandler
        Actor actor = queryRunner.query(connection, sql, new BeanHandler<>(Actor.class), 10);
        System.out.println(actor);

        // 释放资源
        JDBCUtilsByDruid.close(null, null, connection);

    }

    //演示apache-dbutils + druid 完成查询结果是单行单列-返回的就是object
    @Test
    public void testScalar() throws SQLException {

        //1. 得到 连接 (druid)
        Connection connection = JDBCUtilsByDruid.getConnection();
        //2. 使用 DBUtils 类和接口 , 先引入DBUtils 相关的jar , 加入到本Project
        //3. 创建 QueryRunner
        QueryRunner queryRunner = new QueryRunner();

        //4. 就可以执行相关的方法，返回单行单列 , 返回的就是Object
        String sql = "select name from actor where id = ?";
        //解读： 因为返回的是一个对象, 使用的handler 就是 ScalarHandler
        Object obj = queryRunner.query(connection, sql, new ScalarHandler(), 4);
        System.out.println(obj);

        // 释放资源
        JDBCUtilsByDruid.close(null, null, connection);
    }

    //演示apache-dbutils + druid 完成 dml (update, insert ,delete)
    @Test
    public void testDML() throws SQLException {

        //1. 得到 连接 (druid)
        Connection connection = JDBCUtilsByDruid.getConnection();
        //2. 使用 DBUtils 类和接口 , 先引入DBUtils 相关的jar , 加入到本Project
        //3. 创建 QueryRunner
        QueryRunner queryRunner = new QueryRunner();

        //4. 这里组织sql 完成 update, insert delete
        //String sql = "update actor set name = ? where id = ?";
        //String sql = "insert into actor values(null, ?, ?, ?, ?)";//因为id是自增，所以传入null值
        String sql = "delete from actor where id = ?";

        //(1) 执行dml 操作是 queryRunner.update()
        //(2) 返回的值是受影响的行数 (affected: 受影响) 成功返回1，没有影响到表返回0
        //int affectedRow = queryRunner.update(connection, sql, "林青霞", "女", "1966-10-10", "116");
        int affectedRow = queryRunner.update(connection, sql, 1000 );
        System.out.println(affectedRow > 0 ? "执行成功" : "执行没有影响到表");

        // 释放资源
        JDBCUtilsByDruid.close(null, null, connection);

    }
}