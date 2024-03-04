package com.oop.up.test;

public class ThisTest {
    public static void main(String[] args) {
        /*
        定义Person03类，里面有name、age属性，并提供compareTo比较方法，用于判断
        是否和另一个人相等，提供测试类TestPerson用于测试，名字和年龄完全一样，就
        返回true，否则返回false
         */
        Person03 p1 = new Person03("mary",20);
        Person03 p2 = new Person03("smith",30);
        System.out.println("p1和p2比较的结果：" + p1.compareTo(p2));
    }
}
class Person03{
    String name;
    int age;
    //构造器 初始化每个对象下的属性
    public Person03(String name,int age){
        this.name = name;
        this.age = age;
    }
    //compareTo比较方法
    public boolean compareTo(Person03 p){
        //名字和年龄完成一样
        /*
        if(this.name.equals(p.name) && this.age == p.age){
            return true;
        }else {
            return false;
        }
         */
        //this.name.equals(p.name):当前对象p1的名字是否等于p2的名字(传参进入)
        return this.name.equals(p.name) && this.age == p.age;
    }
}
