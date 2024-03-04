package com.generic;

import java.util.ArrayList;
/*
    泛型的好处
    1)编译时，检查添加元素的类型,提高了安全性
    2)减少了类型转换的次数,提高效率。
    不使用泛型
    · Dog -加入-> Object -取出-> Dog //放入到ArrayList 会先转成Object,在取出时，还需要转换
    使用泛型
    · Dog -> Dog -> Dog // 放入时，和取出时，不需要类型转换，提高效率
    3)不再提示编译警告
 */
public class Generic02 {
    public static void main(String[] args) {

        // 使用传统的方法来解决===> 使用泛型
        // 1. 当我们 ArrayList<Dog> 表示存放到 ArrayList 集合中的元素是Dog类型
        // 2. 如果编译器发现添加的类型，不满足要求，就会报错
        // 3. 在遍历的时候，可以直接取出 Dog 类型而不是 Object
        // 4. public class ArrayList<E> {} E称为泛型,那么 Dog->E
        ArrayList<Dog> arrayList = new ArrayList<Dog>();
        arrayList.add(new Dog("旺财", 10));
        arrayList.add(new Dog("发财", 1));
        arrayList.add(new Dog("小黄", 5));
        // 假如我们的程序员，不小心，添加了一只猫
        // arrayList.add(new Cat("招财猫", 8));
        System.out.println("==== 使用泛型 ====");
        for (Dog dog : arrayList) {
            System.out.println(dog.getName() + "-" + dog.getAge());
        }
    }
}
