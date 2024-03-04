package com.oop.up.test;

public class ObjectOriTest07 {
    public static void main(String[] args) {
        /*
        7.设计一个Dog类，有名字、颜色和年龄属性，定义输出方法show()显示其信息。
        并创建对象，进行测试
         */
        Dog dog = new Dog();
        dog.show();
    }
}
class Dog{
    String name;
    String color;
    double age;
    public Dog(){
        this.name = "花花";
        this.color = "黑色";
        this.age = 3.8;
    }
    public void show(){
        System.out.println("姓名：" + name + ",颜色：" + color + ",年龄：" + age);
    }
}