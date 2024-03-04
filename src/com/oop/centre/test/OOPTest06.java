package com.oop.centre.test;

public class OOPTest06 {}
/*
        6、在父类和子类中通过this和super都可以调用哪些属性和方法，假定Grand、
        Father和Son在同一个包
         */
class Grand{
    String name = "AA";
    private int age = 100;
    public void g1(){}
}
class Father extends Grand{
    String id = "001";
    private double score;
    public void f1(){
        //super可以访问哪些成员(属性和方法)？
        super.g1();
        System.out.println(super.name);
        //this可以访问哪些成员？
        System.out.println(this.name);
        System.out.println(this.id);
        System.out.println(this.score);
        this.g1();
        this.f1();
    }
}
class Son extends Father{
    String name = "BB";
    public void g1(){}
    private void show(){
        //super可以访问哪些成员(属性和方法)？
        System.out.println(super.id);
        System.out.println(super.name);
        super.g1();
        super.f1();
        //this可以访问哪些成员？
        System.out.println(this.name);
        System.out.println(this.id);
        this.g1();
        this.f1();
        this.show();
    }
}
