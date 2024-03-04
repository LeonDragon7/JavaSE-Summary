package com.oop.up.test;

public class ConstructorTest01 {
    public static void main(String[] args) {
        //定义Person02类中添加两个构造器
        Person02 p1 = new Person02();
        System.out.println("第一个无参构造器：" + p1.name + "," + p1.age);
        Person02 p2 = new Person02("smith", 54);
        System.out.println("第二个无参构造器：" + p2.name + "," + p2.age);
    }
}
class Person02{
    String name;// 默认值 null
    int age;// 默认值 0
    //1、第一个无参构造器：利用构造器设置所有人的age属性初始值都为18
    public Person02(){
        age = 18;
    }
    /*
    2、第二个带pName和pAge两个参数的构造器：使得每次创建Person对
    象的同时初始化对象的age属性值和name属性值。分别使用不同的构造器，
    创建对象。
     */
    public Person02(String pName,int pAge){
        name = pName;
        age = pAge;
    }
}
