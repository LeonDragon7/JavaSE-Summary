package com.grammar.flow.test;

import java.util.Scanner;

public class BranchTest05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*
        大家都知道，男大当婚，女大当嫁。那么女方家长要嫁女儿，当然要提出
        一定的条件：高：180以上；富：财富1千万以上；帅：是。
        如果这三个条件同时满足，则：“我一定要嫁给他！！！”
        如果三个条件有为真的情况，则：”嫁吧，必上不足，比下有余。“
        如果三个条件都不满足，则：“不嫁！”
         */
        System.out.println("身高：");
        int height = scanner.nextInt();
        System.out.println("财富：");
        double value = scanner.nextDouble();
        System.out.println("帅否：（true/false）");
        boolean face = scanner.nextBoolean();
        if(height >= 180 && value >= 10000000.0 && face)
            System.out.println("我一定要嫁给他！！！");
        else if(height >= 180 || value >= 10000000.0 || face)
            System.out.println("嫁吧，必上不足，比下有余。");
        else
            System.out.println("不嫁！");

//        System.out.println("请输入你是否帅");
//        String isHandsome = scanner.next();
//
//        if(height >= 180 && value >= 10000000.0 && isHandsome.equals("是"))
//            System.out.println("我一定要嫁给他！！！");
//        else if(height >= 180 || value >= 10000000.0 || isHandsome.equals("是"))
//            System.out.println("嫁吧，必上不足，比下有余。");
//        else
//            System.out.println("不嫁！");
/*
			参加歌手比赛，如果初赛成绩大于8.0进入决赛，否则提示淘汰。并且根据性别提示
			进入男子组或女子组。输入成绩和性别，进行判断和输出信息。
			提示：double score;char gender;
			接受字符：char gender = scanner.next().charAt(0);
        */
        System.out.println("你的初赛成绩是：");
        double score = scanner.nextDouble();
        System.out.println("性别：");
        char gender = scanner.next().charAt(0);
        if(score > 8.0){
            if(gender == '男'){
                System.out.println("恭喜你，你已经进入决赛男子组！");
            }else if(gender == '女'){
                System.out.println("恭喜你，你已经进入决赛女子组！");
            }else{
                System.out.println("你输入的性别有误！");
            }
        }else{
            System.out.println("不好意思，你已经被淘汰了");
        }

        /*
		出售系统：根据淡旺季的月份和年龄，打印票价
			4_10旺季：
				成人（18-60）：60
				儿童（18）：半价
				老人（>60）:1/3
			淡季：
				成人：40
				其他：20
        */
        System.out.println("请输入当前的月份：");
        int month = scanner.nextInt();
        System.out.println("请输入你的年龄：");
        int age = scanner.nextInt();
        if(month > 1 && month < 12){
            if(month > 4 && month < 10){
                if(age > 18 && age < 60){
                    System.out.println("你在当前月份为旺季，你的售票价为：60");
                }else if(age == 18){
                    System.out.println("你在当前月份为旺季，你的售票价格为：半价");
                }else if(age > 60){
                    System.out.println("你在当前月份为旺季，你的售票价为：1/3");
                }
            }else{
                if(age > 0){
                    if(age >= 18){
                        System.out.println("你在当前月份为淡季，你的售票价为：40");
                    }else{
                        System.out.println("你在当前月份为淡季，你的售票价为：20");
                    }
                }
            }
        }
    }
}
