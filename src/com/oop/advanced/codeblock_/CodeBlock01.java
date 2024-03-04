package com.oop.advanced.codeblock_;
/*
    代码块
    基本介绍
    代码化块又称为初始化块,属于类中的成员[即是类的一部分]，类似于方法，将逻辑语句
    封装在方法体中，通过包围起来。
    但和方法不同，没有方法名，没有返回，没有参数，只有方法体，而且不用通过对象或类
    显式调用，而是加载类时，或创建对象时隐式调用。

    基本语法
    [修饰符]{
        代码
    };
    注意：
    1、修饰符可选,要写的话,也只能写static
    2、代码块分为两类，使用static修饰的叫静态代码块，
    没有static修饰的，叫普通代码块/非静态代码块。
    3、逻辑语句可以为任何逻辑语句(输入、输出、方法调用、循环、判断等)
    4、;号可以写上,也可以省略。

    代码块的好处和案例演示
    相当于另外一种形式的构造器(对构造器的补充机制)，可以做初始化的操作
    场景:如果多个构造器中都有重复的语句，可以抽取到初始化块中，提高代码的重用性

    这样当我们不管调用哪个构造器，创建对象，都会先调用代码块的内容，代码块调用的
    顺序优先于构造器。
 */
public class CodeBlock01 {
    public static void main(String[] args) {
        Movie movie = new Movie("你好，李焕英");
        System.out.println("===============");
        Movie movie2 = new Movie("唐探3", 100, "陈思诚");
    }
}
class Movie {
    private String name;
    private double price;
    private String director;

    // 3个构造器-》重载
    //(1) 下面三个构造器都有相同的语句
    //(2) 这样代码看起来比较冗余
    //(3) 这时我们可以把相同的语句，放入到一个代码块中，即可
    //(4) 这样当我们不管调用哪个构造器，创建对象，都会先调用代码块的内容
    //(5) 代码块的调用的顺序优先于构造器
    {
        System.out.println("电影屏幕打开...");
        System.out.println("广告开始...");
        System.out.println("电影正是开始...");
    };

    public Movie(String name) {
//        System.out.println("电影屏幕打开...");
//        System.out.println("广告开始...");
//        System.out.println("电影正是开始...");
        System.out.println("Movie(String name) 被调用...");
        this.name = name;
    }

    public Movie(String name, double price) {
//        System.out.println("电影屏幕打开...");
//        System.out.println("广告开始...");
//        System.out.println("电影正是开始...");
        this.name = name;
        this.price = price;
    }

    public Movie(String name, double price, String director) {
//        System.out.println("电影屏幕打开...");
//        System.out.println("广告开始...");
//        System.out.println("电影正是开始...");
        System.out.println("Movie(String name, double price, String director) 被调用...");
        this.name = name;
        this.price = price;
        this.director = director;
    }
}
