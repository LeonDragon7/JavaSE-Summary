package com.oop.centre;
/*
    面向对象编程-多态（多种状态）
    多态基本介绍
    方法或对象具有多种形态。是面向对象的第三大特征，多态是建议在封装和继承基础
    之上的。

    多态的具体体现
    1、方法的多态
    重写和重载就体现多态
 */
public class PolyMethod {
    public static void main(String[] args) {
        //方法重载体现多态
        A a = new A();
        //我们通过不同的参数个数去调用sum方法，就会调用不同的方法，
        //因此对sum 方法来说，就是多种状态的体现。
        System.out.println(a.sum(10, 20));
        System.out.println(a.sum(10, 20, 30));

        //方法的重新体现多态
        B b = new B();
        a.say();
        b.say();
    }
}
class B{
    public void say(){
        System.out.println("B say() 方法被调用.....");
    }
}
class A extends B{
    public int sum(int n1,int n2){
        return n1 + n2;
    }
    public int sum(int n1,int n2,int n3){
        return n1 + n2 + n3;
    }
    public void say(){
        System.out.println("A say() 方法被调用.....");
    }
}