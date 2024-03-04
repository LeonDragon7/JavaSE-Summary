package com.oop.advanced.final_;

public class FinalTest01 {
    public static void main(String[] args) {
        /*
        请编写一个程序，能够计算圆形的面积。要求圆周率为3.14.赋值的位置3个
        方式都写一下
         */
        Circle circle = new Circle(5.0);
        System.out.println("面积 = " + circle.calArea());
    }
}
class Circle{
    private double radius;
    private final double PI;//PI = 3.14

    public Circle(double radius) {
        this.radius = radius;
        //PI = 3.14;
    }
    {
        PI = 3.14;
    }

    public double calArea(){
        return PI * radius * radius;
    }
}
