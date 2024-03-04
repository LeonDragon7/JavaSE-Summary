package com.mysql.basics.type.numerical;

public class Decimal {
    /*
        数值型(小数)的基本使用
        1.FLOAT/DOUBLE [UNSIGNED]
        Float单精度精度，Double双精度.
        2.DECIMAL[M,D] [UNSIGNED]
        · 可以支持更加精确的小数位。M是小数位数(精度)的总数，D是小数点(标度)后面的位数。
        · 如果D是0，则值没有小数点或分数部分。M最大65。D最大是30。如果D被省略,默认是0。如果M被省略,默认是10。
        · 建议:如果希望小数的精度高，推荐使用decimal

        #演示decimal类型、float、double使用
        #创建表
        CREATE TABLE t06 (
            num1 FLOAT,
            num2 DOUBLE,
            num3 DECIMAL(30,20));
        #添加数据
        INSERT INTO t06 VALUES(88.12345678912345, 88.12345678912345,88.12345678912345);
        SELECT * FROM t06;

        #decimal可以存放很大的数
        CREATE TABLE t07 (
            num DECIMAL(65));
        INSERT INTO t07 VALUES(8999999933338388388383838838383009338388383838383838383);

        SELECT * FROM t07;
        CREATE TABLE t08(
            num BIGINT UNSIGNED)
        INSERT INTO t08 VALUES(8999999933338388388383838838383009338388383838383838383);
        SELECT * FROM t08;
     */
}
