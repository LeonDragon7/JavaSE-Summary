package com.oop.up.test;

public class ObjectOriTest08 { //公有类
    //8.给定一个Java程序的代码如下所示，则编译运行后，输出结果是()
    int count = 9;//属性
    public void count1(){// ObjectOriTest08类的成员方法
        count = 10;
        System.out.println("count1 = " + count);
    }
    public void count2(){
        System.out.println("count1 = " + count++);
    }
    //任何一个类，都可有一个main方法
    public static void main(String[] args) {
        //new ObjectOriTest08()：是匿名对象，也在堆里面，栈没有引用，没有返回，只能使用一次，使用后就不能使用了
        new ObjectOriTest08().count1();//10
        ObjectOriTest08 test08 = new ObjectOriTest08();
        test08.count2();//9
        test08.count2();//10
    }
}
