package com.oop.up.test;

public class ObjectOriTest06 {
    public static void main(String[] args) {
        /*
        6.编程创建一个Cale计算类，在其中定义2个变量表示两个操作数，定义四个方法实
        现求和、差、乘、商(要求除数为0的话，要提示)并创建两个对象，分别测试
         */
        Cale cale01 = new Cale(2,4);
        System.out.println("和 = " + cale01.sum());
        System.out.println("差 = " + cale01.minus());
        System.out.println("乘 = " + cale01.mul());
        Double divRes = cale01.div();
        if(divRes != null){
            System.out.println("除 = " + divRes);
        }
    }
}
class Cale{
    double num1;
    double num2;
    public Cale(double num1,int num2){
        this.num1 = num1;
        this.num2 = num2;
    }
    public double sum(){
        return num1 + num2;
    }
    public double minus(){
        return num1 - num2;
    }
    public double mul(){
        return num1 * num2;
    }
    public Double div(){
        if(num2 == 0){
            System.out.println("num2不能为0");
            return null;
        }else{
            return num1 / num2;
        }
    }
}
