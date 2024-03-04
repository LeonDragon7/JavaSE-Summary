package com.oop.up.test;


public class ObjectOriTest11 {
    double a;
    double b;

    public double method(double a,double b){
        return a + b;
    }
    public static double method(double method,int c){
        return method + c;
    }
    public static void main(String[] args) {
        /*
        11.在测试方法中，调用method方法，代码如下，编译正确，试写出，method方法的
        定义形式，调用语句为：System.out.println(method(10.0,20.0),100));
         */
        System.out.println(method(method(10,20),100));
    }
}
