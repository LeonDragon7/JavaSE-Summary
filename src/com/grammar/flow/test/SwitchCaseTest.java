package com.grammar.flow.test;

import java.util.Scanner;

public class SwitchCaseTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*
			请编写一个程序，该程序可以接受一个字符，比如：a，b，c，d，e,f,g.
			a表示星期一，b表示星期二...
			根据用户的输入显示相应的信息，要求使用switch语句完成
        */
        System.out.println("请输入对应的字符（a-g）：");
        char week = scanner.next().charAt(0);
        switch(week){
            case 'a':
                System.out.println("星期一");
                break;
            case 'b':
                System.out.println("星期二");
                break;
            case 'c':
                System.out.println("星期三");
                break;
            case 'd':
                System.out.println("星期四");
                break;
            case 'e':
                System.out.println("星期五");
                break;
            case 'f':
                System.out.println("星期六");
                break;
            case 'g':
                System.out.println("星期天");
                break;
            default:
                System.out.println("你输入的字符有误！");
                break;
        }
        //1、使用switch把小写类型的char型转为大写。只转化a，b，c，d，e，其他的输出"other"
        String word = scanner.next();
        char c = word.charAt(0);
        switch (c){
            case 'a':
                System.out.println("A");
                break;
            case 'b':
                System.out.println("B");
                break;
            case 'c':
                System.out.println("C");
                break;
            case 'd':
                System.out.println("D");
                break;
            case 'e':
                System.out.println("E");
                break;
            default:
                System.out.println("other");
        }

        //2、对学生成绩大于60分的，输出合格。低于60分的，输出“不合格”。
        double score = scanner.nextDouble();
        if(score >= 60)
            score = 0;
        switch ((int)score){
            case 0:
                System.out.println("合格");
                break;
            default:
                System.out.println("不合格");
        }
        /*
        switch (score / 10){
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                System.out.println("不合格");
                break;
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                System.out.println("合格");
        }
         */
        /*
        switch(score / 60){
        case 0:
            System.out.println("不合格");
            break;
        case 1:
            System.out.println("合格");
        }
         */
        //根据指定月份，打印该月份所属的季节。
        int month = scanner.nextInt();
        switch (month){
            case 3:
            case 4:
            case 5:
                System.out.println("春季");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("夏季");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("秋季");
                break;
            case 12:
            case 1:
            case 2:
                System.out.println("冬季");
                break;
            default:
                System.out.println("你输入的月份有误！");

        /*
        编写程序：从键盘上输入2019年“month”和“day”，要求通过程序输出
        输入的日期为2019年的第几天。
         */

                System.out.println("请输入2019年的month:");
                int mon = scanner.nextInt();
                System.out.println("请输入2019年的day:");
                int day = scanner.nextInt();
                int sumDays = 0;//保存总天数
                /*if-else结构(冗余)
                if(mon == 1)
                    sumDays = day;
                else if(mon == 2)
                    sumDays = day + 31;
                else if(mon == 3)
                    sumDays = day + 31 + 28;
                else if(mon == 4)
                    sumDays = day + 31 + 28 + 31;
                //......
                else {//mon == 12
                }
                */

                /*switch-case结构(冗余)
                switch (mon){
                    case 1:
                        sumDays = day;
                        break;
                    case 2:
                        sumDays = day + 31;
                        //......

                 */
                //switch-case结构
                switch (mon){
                    case 12:
                        sumDays += 30;//+上一个月的总天数
                    case 11:
                        sumDays += 31;
                    case 10:
                        sumDays += 30;
                    case 9:
                        sumDays += 31;
                    case 8:
                        sumDays += 31;
                    case 7:
                        sumDays += 30;
                    case 6:
                        sumDays += 31;
                    case 5:
                        sumDays += 30;
                    case 4:
                        sumDays += 31;
                    case 3:
                        sumDays += 28;
                    case 2:
                        sumDays += 31;
                    case 1:
                        sumDays += day;
                }
                System.out.println("2019年" + mon + "月" + day + "日是当年的第" + sumDays + "天");
        }
    }
}
