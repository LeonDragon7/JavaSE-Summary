package com.oop.centre.object;
/*
    Object类详解
    finalize方法
    1、当对象被回收是，系统自动调用该对象的finalize方法。子类可以重写该方法，
    做一些释放资源的操作。
    2、什么时候被回收：当某个对象没有任何引用时，则jvm就认为这个对象是一个垃圾
    对象，就会使用垃圾回收机制来销毁该对象，在销毁该对象前，会先调用finalize
    方法。
    3、垃圾回收机制的调用，是由系统来决定(GC算法)，也可以通过System.gc()主动触发垃圾
    回收机制。
 */
public class Finalize {
    public static void main(String[] args) {
        Car bmw = new Car("宝马");
        //car对象变成一个垃圾。垃圾回收器就会回收(销毁)对象，在销毁对象前，会调用该对象的finalize方法
        //在重写finalize中，可以编写业务逻辑(比如释放资源：数据库连接，或者打开文件...)
        bmw = null;
        System.gc();
        System.out.println("程序退出了...");
    }
}
class Car{
    private String name;

    public Car(String name) {
        this.name = name;
    }

    //重写finalize方法

    @Override
    protected void finalize() throws Throwable {
        System.out.println("我们销毁汽车" + name);
        System.out.println("释放了某些资源");
    }
}