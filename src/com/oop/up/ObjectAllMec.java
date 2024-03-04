package com.oop.up;
/*
    类与对象
    类和对象的内存分配机制
    Java内存结构分析
    1、栈：一般存放基本数据类型(局部变量)
    2、堆：存放对象(Cat cat，数组等)
    3、方法区：常量池(常量，比如字符串)，类加载信息
 */
public class ObjectAllMec {
    public static void main(String[] args) {
        Person02 p1 = new Person02();
        p1.age = 10;
        p1.name = "小明";
        Person02 p2 = p1;//p1赋给p2/让p2指向p1
        /*
        1、先再方法区加载Person02类信息(属性和方法信息，只会加载一次)
        2、在堆中分配空间，进行默认初始化(看规则),把堆中地址赋给p1
        3、p1就指向堆中的对象
        4、进行指定初始化，p1.name = "小明";p1.age = 10;
         */
        System.out.println(p2.age);
    }
}
class Person02{
    int age;
    String name;
}
