package com.oop.up;
/*
    成员方法
    注意事项和使用细节

    方法细节调用说明
    1、同一个类中的方法调用：直接调用即可。比如print(参数);
    2、跨类中的方法A类调用B类方法：需要通过对象名调用。比如：对象名.方法名(参数);
    3、跨类的方法调用和方法的访问修饰符相关。
 */
public class MethodDetail03 {
    public static void main(String[] args) {
        A a = new A();
        a.sayOk();
        a.m1();
    }
}
class A{
    public void print(int n){
        System.out.println("print()方法被调用,n = " + n);
    }
    //1、同一个类中的方法调用：直接调用即可。比如print(参数);
    public void sayOk(){
        print(10);
        System.out.println("继续执行sayOK()~~");
    }

     //2、跨类中的方法A类调用B类方法：需要通过对象名调用。比如：对象名.方法名(参数);
    public void m1(){
        //先创建B对象，然后再调用方法即可。
        System.out.println("m1() 方法被调用");
        B b = new B();
        b.sayHello();
        System.out.println("m1() 继续执行");
    }
}
class B{
    public void sayHello(){
        System.out.println("B类中的方法sayHello()被执行");
    }
}
