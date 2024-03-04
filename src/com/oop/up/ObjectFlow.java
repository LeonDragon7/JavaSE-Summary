package com.oop.up;
/*
    对象创建的流程分析
    看一个案例
    class Person{//类Person
        int age = 90;
        String name;
        Person(String n,int a){//构造器
            name = n;//属性赋值
            age = a;
        }
    }
    Person p = new Person("小青",20);

    流程分析：
    1、加载Person类型信息(Person.class)，只会加载一次 (方法区)
    2、在堆中分配空间(地址)
    3、完成对象初始化
    1) 默认初始化 age = 0,name = null
    2) 显示初始化 age = 90,name = null
    3) 构造器的初始化 age = 20,name = 小青（说明：name = 小青 堆中的null赋值一个地址在常量池引用地址）
    4、在对象在堆中的地址，返回(栈)给p(p是对象名，也可以理解成是对象的引用)
 */
public class ObjectFlow {
    public static void main(String[] args) {

    }
}