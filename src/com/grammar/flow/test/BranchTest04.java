package com.grammar.flow.test;

import java.util.Scanner;

//公式：[a,b]:(int)(Math.random() * (b - a + 1) + a)
public class BranchTest04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*
        判断一个年份是否是闰年。
        注：判断一年是否是闰年的标准：
        1）可以被4整除，但不可被100整除
                或
        2）可以被400整除
        */
        System.out.println("请输入年份");
        int year = scanner.nextInt();
        if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
        {
            System.out.println(year + "是闰年！");
        }else{
            System.out.println(year + "不是闰年！");
        }
        /*
        假设你想开发一个玩彩票的游戏，程序随机地产生一个两位数的彩票，x

        提示用户输入一个两位数，然后按照下面的规则判定用户是否能赢。
        1）如果用户输入的数匹配彩票的实际顺序，奖金10000美元。
        2）如果用户输入的所有数字匹配彩票的所有数字，但顺序不一致，奖金3000美元。
        3）如果用户输入的一个数字仅满足顺序情况下匹配彩票的一个数字，奖金1000美元。
        4）如果用户输入的一个数字仅满足非顺序情况下匹配彩票的一个数字，奖金500美元。
        5）如果用户输入的数字没有匹配任何一个数字，则彩票作废。

        提示：使用(int)(Math.random() * 90 + 10)产生随机数。
        Math.random() : [0,1) * 90 ->[0,90) + 10 ->[10,100]->[10,99]
         */
        int ran = (int) (Math.random() * 90 + 10);
        System.out.println("请输入一个两位数:");
        System.out.println(ran);
        int i = scanner.nextInt();
        if(ran == i)
            System.out.println("奖金10000美元");
        else if(i / 10 == ran % 10 && i % 10 == ran / 10)
            System.out.println("奖金3000美元");
        else if(i / 10 == ran / 10 || i % 10 == ran % 10)
            System.out.println("奖金1000美元");
        else if(i / 10 == ran % 10 || i % 10 == ran / 10)
            System.out.println("奖金500美元");
        else
            System.out.println("彩票作废");
    }
}
