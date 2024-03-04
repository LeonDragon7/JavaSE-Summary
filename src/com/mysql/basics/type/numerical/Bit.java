package com.mysql.basics.type.numerical;

public class Bit {
    /*
        数值型(bit)的使用
        1.基本使用
        mysql > create table t05 (num bit(8));
        mysql > insert into t05 (1, 3);
        mysql > insert into t05 values(2, 65);

        2.细节说明bit.sql
        · bit字段显示时，按照位的方式显示.
        · 查询的时候仍然可以用使用添加的数值
        · 如果一个值只有0，1可以考虑使用bit(1), 可以节约空间
        · 位类型。M指定位数，默认值1，范围1-64

        #演示bit类型使用
        #说明
        #1. bit(m) m 在 1-64
        #2. 添加数据 范围 按照你给的位数来确定，比如 m = 8 表示一个字节 0~255
        #3. 显示按照bit
        #4. 查询时，仍然可以按照数来查询
        CREATE TABLE t05 (num BIT(8));
        INSERT INTO t05 VALUES(255); # 按位显示 255 就是全1 （b'11111111'）
        SELECT * FROM t05;
        SELECT * FROM t05 WHERE num = 1;
     */
}
