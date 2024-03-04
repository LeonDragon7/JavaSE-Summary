package com.grammar.flow;

import java.util.Scanner;

/*
3、
    Scanner类使用
        - 具体实现步骤：
            1、导包：import java.util.Scanner
            2、Scanner的实例化
            3、调用Scanner类的相关方法，来获取指定类型的变量

            注意：
                需要根据相应的方法，来输入指定类型的值，如果输入的数据类型与要求的类型不匹配时，会报异常：Exception in thread "main" java.util.InputMismatchException。

 */
public class ScannerClass {
    public static void main(String[] args) {
        //Scanner的实例化
        Scanner scanner = new Scanner(System.in);

        //调用Scanner类的相关方法
        System.out.println("请输入你的姓名:");
        String name = scanner.next();
        System.out.println(name);

        System.out.println("请输入你的芳龄:");
        int age = scanner.nextInt();
        System.out.println(age);

        System.out.println("请输入你的体重:");
        double weight = scanner.nextDouble();
        System.out.println(weight);

        System.out.println("你是否相中我了呢?(true/false)");
        boolean isLove = scanner.nextBoolean();
        System.out.println(isLove);

        //对于char型的获取，Scanner没有提供相关方法，只能获取一个字符串
        System.out.println("请输入你的性别:(男/女)");
        String gender = scanner.next();
        char genderChar = gender.charAt(0);//charAt(0):获取索引为0位置上的字符
        System.out.println(genderChar);


    }
}
