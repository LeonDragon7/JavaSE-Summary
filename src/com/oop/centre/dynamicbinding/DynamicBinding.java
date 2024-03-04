package com.oop.centre.dynamicbinding;
/*
    面向对象编程-多态
    java的动态绑定机制
    Java重要特性：动态绑定机制
    1、当调用对象方法的时候，该方法会和该对象的内存地址/运行类型绑定
    2、当调用对象属性时，没有动态绑定机制，哪里声明，那里使用
 */
public class DynamicBinding{
    public static void main(String[] args) {
        A a = new B();//向上转型
        System.out.println(a.sum());//40
        System.out.println(a.sum1());//30

        //如果注销子类的sum方法，会找到父类的sum方法，
        // sum()方法里面有getI()方法，根据动态绑定机制，会去找运行类型的getI()方法
        System.out.println(a.sum());//30

        //如果注销子类的sum1方法,属性没有动态绑定机制，哪里声明，那里使用
        System.out.println(a.sum1());//20
    }
}
class A{
    public int i = 10;
    public int sum(){
        return getI() + 10;
    }
    public int sum1(){
        return i + 10;
    }
    public int getI(){
        return i;
    }
}
class B extends A{
    public int i = 20;

    public int sum(){
        return i + 20;
    }

    public int getI(){
        return i;
    }

    public int sum1(){
        return i + 10;
    }
}