package com.oop.centre.test;
/*
14、在main方法中执行：C c = new C();输出什么内容？
 */
public class OOPTest14 {
    public static void main(String[] args) {
        C c = new C();
        /*
        我是AAA类
        hahah我是BBB类的有参构造器
        hello我是C类的有参构造器
        我是C类的无参构造器
         */
    }
}
class AAA{
    public AAA(){
        System.out.println("我是AAA类");
    }
}
class BBB extends AAA{
    public BBB(){
        System.out.println("我是BBB类的无参构造器");
    }
    public BBB(String name){
        System.out.println(name + "我是BBB类的有参构造器");
    }
}
class C extends BBB{
    public C(){
        this("hello");
        System.out.println("我是C类的无参构造器");
    }
    public C(String name){
        super("hahah");
        System.out.println(name + "我是C类的有参构造器");
    }
}
