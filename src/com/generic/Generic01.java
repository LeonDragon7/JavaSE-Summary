package com.generic;

import java.util.ArrayList;

/*
    泛型
    泛型的理解和好处
    看一个需求
    请编写程序，在ArrayList 中，添加3个Dog对象
    Dog对象含有name 和 age, 并输出name 和 age (要求使用getXxx())

    使用传统方法的问题分析
    1)不能对加入到集合ArrayList中的数据类型进行约束(不安全)
    2)遍历的时候，需要进行类型转换,如果集合中的数据量较大，对效率有影响
 */
@SuppressWarnings({"all"})
public class Generic01 {
    public static void main(String[] args) {

        //使用传统的方法来解决
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Dog("旺财", 10));
        arrayList.add(new Dog("发财", 1));
        arrayList.add(new Dog("小黄", 5));

        //假如程序员，不小心，添加了一只猫
        arrayList.add(new Cat("招财猫", 8)); // 就会报类型转换的错误

        //遍历
        for (Object o : arrayList) {
            //向下转型Object ->Dog
            Dog dog = (Dog) o;
            System.out.println(dog.getName() + "-" + dog.getAge());
        }
    }
}
class Dog {
    private String name;
    private int age;
    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class Cat { //Cat类
    private String name;
    private int age;
    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
