package com.collection.collection_;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CollectionTest {
    public static void main(String[] args) {
        /*
        1、编写3个Dog{name,age}对象，放入到Arraylist中，赋给List引用
        2、用迭代器和增强for循环两种方式来遍历
        3、重写Dog的toString方法，输出name和age
         */
        List list = new ArrayList();
        list.add(new Dog("小黑",30));
        list.add(new Dog("大黄",100));
        list.add(new Dog("大壮",8));

        //for增强
        for (Object dog : list) {
            System.out.println("dog = " + dog);
        }

        //迭代器
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object dog =  iterator.next();
            System.out.println("dog = " + dog);
        }
    }
}
class Dog{
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

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
