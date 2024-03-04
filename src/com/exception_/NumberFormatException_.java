package com.exception_;

/**
 * NumberFormatException 数字格式不正确异常
 * 当应用程序试图将字符串转换成一种数值类型，但该字符串不能转换为适当格式时，
 * 抛出该异常=> 使用异常我们，可以确保输入是满足条件数字.
 */
public class NumberFormatException_ {
    public static void main(String[] args) {
        String name = "timerring";
        //将String 转成 int
        int num = Integer.parseInt(name); // 抛出NumberFormatException
        System.out.println(num);
    }
}
