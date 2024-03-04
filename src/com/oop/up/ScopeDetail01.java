package com.oop.up;
/*
    作用域
    注意事项和细节使用
    1、属性和局部变量可以重名，访问是遵循就近原则。
    2、在同一个作用域中，比如在同一个成员方法中，两个局部变量，不能重名。
    3、（全局变量）属性生命周期较长，伴随着对象的创建而创建，伴随着对象的销毁而销毁。局部变
    量，生命周期较短，伴随着它的代码块的执行而创建，伴随着代码块的结束而销毁。
    即在一次方法调用过程中。
    4、作用域不同
    全局变量：可以被本类使用，或其他类使用(通过对象调用)
    局部变量：只能在本类中对应的方法中使用
    5、修饰符不同
    全局变量/属性可以加修饰符
    局部变量不可以加修饰符
 */
public class ScopeDetail01 {
    public static void main(String[] args) {
        T2 t2 = new T2();
        T1 t1 = new T1();
        t2.test1();
        t2.test2(t1);
    }
}
class T2{
    //全局变量：可以被本类使用，或其他类使用(通过对象调用)

    //方式一：第一种跨类访问对象属性的方式
    public void test1(){
        T1 t1 = new T1();
        System.out.println(t1.name);
    }
    //方式二：第二种跨类访问对象属性的方式
    public void test2(T1 t1){
        System.out.println(t1.name);
    }
}
class T1{
    //全局变量/属性可以加修饰符
    private int age = 20;
    String name = "jack";
    public void test(){
        //局部变量不可以加修饰符
        //private int age = 0;
        //会报错误：java: 非法的表达式开始
    }
}