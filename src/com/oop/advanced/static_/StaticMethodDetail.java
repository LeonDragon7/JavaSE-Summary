package com.oop.advanced.static_;
/*
    类方法经典的使用场景
    当方法中不涉及到任何和对象相关的成员，则可以将方法设计成静态方法, 提高开发效率。
    比如:工具类中的方法utils。Math类、Arrays类、Collections集合类看下源码可以发
    现都是static方法。

    类方法使用注意事项和细节讨论
    1、类方法和普通方法都是随着类的加载而加载，将结构信息存储在方法区∶类方法中无this
    的参数。普通方法中隐含着this的参数。
    2、类方法可以通过类名调用，也可以通过对象名调用。普通方法和对象有关，需要通过对象名
    调用，比如对象名.方法名(参数)，不能通过类名调用。
    3、类方法中不允许使用和对象有关的关键字，比如this和super。普通方法(成员方法)可以。
    4、类方法(静态方法)中只能访问静态变量或静态方法。普通成员方法,既可以访问非静态成员,
    也可以访问静态成员!!
 */
public class StaticMethodDetail {
    public static void main(String[] args) {
        D.hi();//ok
        //非静态方法，不能通过类名调用
        //D.say();, 错误，需要先创建对象，再调用
        new D().say();//可以
    }
}
class D {

    private int n1 = 100;
    private static  int n2 = 200;
    public void say() {//非静态方法,普通方法

    }

    public static  void hi() {//静态方法,类方法
        //类方法中不允许使用和对象有关的关键字，
        //比如this和super。普通方法(成员方法)可以。
        //System.out.println(this.n1);
    }

    //类方法(静态方法)中 只能访问 静态变量 或静态方法
    //口诀:静态方法只能访问静态成员.
    public static void hello() {
        System.out.println(n2);
        System.out.println(D.n2);
        //System.out.println(this.n2);不能使用
        hi();//OK
        //say();//错误
    }
    //普通成员方法，既可以访问  非静态成员，也可以访问静态成员
    //小结: 非静态方法可以访问 静态成员和非静态成员
    public void ok() {
        //非静态成员
        System.out.println(n1);
        say();
        //静态成员
        System.out.println(n2);
        hello();

    }
}
