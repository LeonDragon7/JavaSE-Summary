package com.oop.up.test;

public class OverLoadTest02 {
    public static void main(String[] args) {
        /*
        1、编写程序，类Methods中定义三个重载方法并调用。方法名为m。三个方法分
        别接收一个int参数、两个int参数、一个字符串参数。分别执行平方运算并输出
        结果，相乘并输出结果，输出字符串信息。在主类的main()方法中分别用参数区
        别调用三个方法。
         */
        Methods02 methods02 = new Methods02();
        methods02.m(5);
        methods02.m(5,4);
        methods02.m("张三");
    }
}
class Methods02{
    //平方运算
    public void m(int a){
        System.out.println("平方：" + (a * a));
    }
    //乘法运算
    public void m(int a,int b){
        System.out.println("相乘：" + (a * b));
    }
    //输出字符串
    public void m(String a){
        System.out.println("字符串：" + a);
    }
}