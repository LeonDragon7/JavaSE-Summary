package com.common.wrapper;
/*
    包装类和基本数据的转换
    1、jdk5前的手动装箱和拆箱方式，装箱：基本类型->包装类型。反之拆箱。
    2、jdk5以后(含jdk5)的自动装箱和拆箱方式。
    3、自动装箱底层调用的是valueOf方法，比如Integer.valueOf()其它
    包装类的用法类似,不一一举例
 */
public class Integer_ {
    public static void main(String[] args) {
        //演示int <--> Integer 的装箱和拆箱
        //jdk5前是手动装箱和拆箱
        //手动装箱 int->Integer
        int n1 = 100;
        Integer integer = new Integer(n1);
        //或者
        Integer integer1 = Integer.valueOf(n1);

        //手动拆箱
        //Integer -> int
        int i = integer.intValue();

        //jdk5后，就可以自动装箱和自动拆箱
        int n2 = 200;
        //自动装箱 int->Integer
        Integer integer2 = n2; //底层使用的是 Integer.valueOf(n2)
        //自动拆箱 Integer->int
        int n3 = integer2; //底层仍然使用的是 intValue()方法
    }
}
