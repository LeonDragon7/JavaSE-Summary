package com.oop.up.test;

public class ObjectMechanismTest {
    public static void main(String[] args) {
        //下面一段代码，输出的结果？
        Person a = new Person();
        a.age = 10;
        a.name = "小明";
        Person b;
        b = a;
        System.out.println(b.name);//小明
        b.age = 200;
        b = null;//会使得指向和a一样的地址，变成null
        System.out.println(a.age);//200
        System.out.println(b.age);//报空值错误，java.lang.NullPointerException
    }
}
class Person{
    int age;
    String name;
}
