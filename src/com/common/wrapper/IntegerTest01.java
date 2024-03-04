package com.common.wrapper;

public class IntegerTest01 {
    public static void main(String[] args) {
        /**
         *  三元运算符
         *  看作一个整体
         *  输出 1.0(因为后面是Double包装类的拆箱，既是不允许也是一个整体)
         *  如果是if-else就不能看作一个整体 分别计算 输出 1
         */
        Object obj = true ? new Integer(1) : new Double(2.0);
        System.out.println(obj);
    }
}


