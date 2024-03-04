package com.oop.centre.test;

public class ExtendTest02 {
    public static void main(String[] args) {
        CC cc = new CC();//输出什么内容？
        //我是A类
        //hahah我是B类的有参构造器
        //我是C类的有参构造器
        //我是C类的无参构造器
    }
}
class AA{
    public AA(){
        System.out.println("我是A类");
    }
}
class BB extends AA{
    public BB(){
        System.out.println("我是B类的无参构造器");
    }
    public BB(String name){
        System.out.println(name + "我是B类的有参构造器");
    }
}
class CC extends BB{
    public CC(){
        this("hello");
        System.out.println("我是C类的无参构造器");
    }
    public CC(String name){
        super("hahah");
        System.out.println("我是C类的有参构造器");
    }
}