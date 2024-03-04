package com.grammar.flow.test;

import java.util.Scanner;
public class BranchTest03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*
        1、编写程序，声明2个int型变量并赋值。判断两数之和，
        如果大于等于50，打印“hello world！”
         */
        int i = 18;
        int j = 98;
        if(i + j > 50)
            System.out.println("hello world!");

        /*
        2、编写程序，声明2个double型变量并赋值。判断第一个数
        大于10.0且第2个数小于20.0，打印两数之和。否则，打印两数的乘积。
         */
        double v = 29.5;
        double z = 2.5;
        if(v > 10 && z < 20)
            System.out.println("两数之和:" + (v + z));
        else
            System.out.println("两数之积:" + (v * z));

        /*
        3、我家的狗5岁了，5岁的狗相当于人类多大呢？其实，狗的前两年每
        一年相当于人类的10.5岁，之后每增加一年就增加四岁。那么5岁的狗
        相当于人类多少年龄呢？应该是：10.5 + 10.5 + 4 + 4 + 4 = 33岁。

        编写一个程序，获取用户输入狗的年龄，通过程序显示其相当于人类的年龄。
        如果用户输入负数，请显示一个提示信息。
         */
        System.out.println("请输入狗狗的年龄：");
        double v1 = 10.5;
        int age = scanner.nextInt();
        if(age > 0)
            if(age > 2)
                System.out.println(age + "岁的狗相当于人类" + (2 * v1 + (age - 2) * 4) + "岁年龄");
            else
                System.out.println(age + "岁的狗相当于人类" + v1 * age + "岁年龄");
         else
            System.out.println("狗狗还没出生呢!");
    }
}
