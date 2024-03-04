package com.oop.centre.test;

public class ExtendTest01 {
    public static void main(String[] args) {
        B b = new B();//会输出什么？
        //a
        //b name
        //b
    }
}
class A{
    A(){
        System.out.println("a");
    }
    A(String name){
        System.out.println("a name");
    }
}
class B extends A{
    B(){
        this("abc");
        System.out.println("b");
    }
    B(String name){
        //super();默认调用父类的无参构造器
        System.out.println("b name");
    }
}
