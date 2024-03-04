package com.oop.up.test;

public class ObjectOriTest05 {
    public static void main(String[] args) {
        /*
        5.定义一个圆类Circle,定义属性：半径，提供显示圆周长功能的方法，提供显示圆
        面积的方法。
         */
        Circle circle = new Circle(3);
        System.out.println("周长 = " + circle.perimeter() + ",面积 = " + circle.area());
    }
}
class Circle{
    double radius;
    public Circle(double radius){
        this.radius = radius;
    }
    public double perimeter(){
        return  2 * Math.PI * radius;
    }
    public double area(){
        return Math.PI * radius * radius;
    }
}