package com.oop.up;
/*
    构造方法
    基本介绍
    构造方法又叫构造器(constructor),是类的一种特殊的方法，它的作用是
    完成对新对象的初始化。
    基本语法：
    [修饰符] 方法名(形参列表){
        方法体;
    }
    特点：
    1) 构造器的修饰符可以默认
    2) 构造器没有返回值
    3) 方法名和类名必须一样
    4) 参数列表和成员方法一样的规则
    5) 构造器的调用由系统完成
 */
public class Constructor01 {
    public static void main(String[] args) {
        //当我们new一个对象时，直接通过构造器指定名字和年龄
        Person04 person04 = new Person04("smith",80);
        System.out.println("person04的信息如下");
        System.out.println("person04对象name = " + person04.name);
        System.out.println("person04对象age = " + person04.age);
    }
}
//在创建人类的对象时，就直接指定这个对象的年龄和姓名
class Person04{
    String name;
    int age;
    //构造器
    //1.构造器没有返回值,也不能写void
    //2.构造器的名称和类Person04一样
    //3.(String pName,int pAge) 是构造器形参列表，规则和成员方法一样
    public Person04(String pName,int pAge){
        System.out.println("构造器被调用，完成对象的属性初始化");
        name = pName;
        age = pAge;
    }
}