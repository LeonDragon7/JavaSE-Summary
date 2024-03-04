package com.oop.up.test;

public class ObjectOriTest13 {
    public static void main(String[] args) {
        /*
        13.将对象作为参数传递给方法。
        题目要求：
        （1）定义一个Circle01类，包含一个double型的radius属性代表圆的半径，——findArea()
        方法返回圆的面积。
        （2）定义一个类PassObject,在类中定义一个方法printArea(),该方法的定义如下：
        public void printAreas(Circle c,int times)
        （3）在printAreas方法中打印输出1到times之间的每个整数半径值，以及对应的面积。
        例如，times为5，则输出半径1,2,3,4,5，以及对应的圆面积。
        （4）在main方法中调用printAreas()方法，调用完毕后输出当前半径值。
         */
        Circle01 c1 = new Circle01();
        PassObject passObject = new PassObject();
        passObject.printAreas(c1,5);
        System.out.println("当前的半径 = " + c1.radius);
    }
}
class Circle01{
    double radius;
    public double findArea(){
        return Math.PI * radius * radius;
    }
    //添加方法setRadius，修改当前对象的半径值
    public void setRadius(double radius){
        this.radius = radius;
    }
}
class PassObject{
    public void printAreas(Circle01 c,int times){
        System.out.println("Radius\t\t\tArea");
        for (int i = 1; i <= times; i++) {
            //修改c对象的半径值
            c.setRadius(i);
            //或者c.radius = i;
            System.out.println(c.radius + "\t\t\t\t" + c.findArea());
        }
    }
}