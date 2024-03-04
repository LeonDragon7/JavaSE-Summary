package com.oop.up;
/*
    方法重载
    基本介绍
    java中允许同一个类中，多个同名方法存在，但要求形参列表不一致！
    比如：System.out.println(); out是PrintStream类型

    重载的好处
    1、减轻了起名的麻烦
    2、减轻了记名的麻烦
 */
public class OverLoad {
    public static void main(String[] args) {
        MyCalculator myCalculator = new MyCalculator();
        System.out.println(myCalculator.calculate(1, 2));//两个int的和
        System.out.println(myCalculator.calculate(1, 2.2));//一个int，一个double的和
        System.out.println(myCalculator.calculate(1.1, 2));//一个double，一个int和
        System.out.println(myCalculator.calculate(1, 2,3));//三个int的和
    }
}
class MyCalculator{
    //calculate方法构成了重载
    //两个int的和
    public int calculate(int n1,int n2){
        return n1 + n2;
    }
    //一个int，一个double的和
    public double calculate(int n1,double n2){
        return n1 + n2;
    }
    //一个double，一个int和
    public double calculate(double n1,int n2){
        return n1 + n2;
    }
    //三个int的和
    public int calculate(int n1,int n2,int n3){
        return n1 + n2 + n3;
    }
}