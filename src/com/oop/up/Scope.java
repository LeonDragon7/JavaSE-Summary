package com.oop.up;
/*
    作用域
    基本使用
    1、在java编程中，主要的变量就是属性（成员变量）和局部变量
    2、局部变量一般是指在成员方法中定义的变量
    3、java中作用域的分类：
        全局变量：也就是属性，作用域为整个类体 Cat类：cry eat等方法使用属性
        局部变量：也就是除了属性之外的其他变量。作用域为定义它的代码块中
    4、全局变量可以不赋值，直接使用，因为有默认值，局部变量必须赋值后，才能使用，
    因为没有默认值。
 */
public class Scope {
    public static void main(String[] args) {
        Cats cats = new Cats();
        cats.cry();
        cats.eat();
    }
}
class Cats{
    //全局变量
    //属性在定义时，可以直接赋值
    int age = 10;
    public void cry(){
        //n、name为局部变量，作用域在cry,eat不能用
        int n = 10;
        String name = "jack";
        System.out.println("在cry中使用属性age：" + age);
    }
    public void eat(){
        System.out.println("在eat中使用属性age：" + age);
    }
}
