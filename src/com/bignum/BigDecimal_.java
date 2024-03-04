package com.bignum;

import java.math.BigDecimal;

/**
 * BigDecimal类
 * 介绍
 * 应用场景:
 * BigDecimal 适合保存精度更高的浮点型(小数)
 * 常见方法：
 * 1、add 加
 * 2、subtract 减
 * 3、multiply 乘
 * 4、divide 除
 */
public class BigDecimal_ {
    public static void main(String[] args) {
        // 当我们需要保存一个精度很高的数时，double 不够用
        // 可以是 BigDecimal
        // double d = 1999.11111111111999999999999977788d;
        // System.out.println(d);
        BigDecimal bigDecimal = new BigDecimal("1999.11");
        BigDecimal bigDecimal2 = new BigDecimal("3");
        System.out.println(bigDecimal);

        // 1. 如果对 BigDecimal进行运算，比如加减乘除，需要使用对应的方法
        // 2. 创建一个需要操作的 BigDecimal 然后调用相应的方法即可
        System.out.println(bigDecimal.add(bigDecimal2));
        System.out.println(bigDecimal.subtract(bigDecimal2));
        System.out.println(bigDecimal.multiply(bigDecimal2));
        // System.out.println(bigDecimal.divide(bigDecimal2));//可能抛出异常ArithmeticException 因为除不尽
        // 在调用 divide 方法时，指定精度即可. 加上BigDecimal.ROUND_CEILING
        // 如果有无限循环小数，就会保留 分子 的精度
        System.out.println(bigDecimal.divide(bigDecimal2, BigDecimal.ROUND_CEILING));
    }
}
