package com.grammar.flow.test;

import java.util.Scanner;

public class BranchTest01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //if-else求三个数最大值
        int a = 3,b = 41,c = 51,max;
        max = a;
        if(b > max)
            max = b;
        if(c > max)
            max = c;
        System.out.println("max = " + max);
        /*
            编写程序，声明2个double型变量并赋值。判断第一个数大于10.0,且第2
            个数小于20.0，打印两数之和。否则，打印两数的乘积。
         */

        double x = 29.0,y = 39.0;
        if(x > 10.0 && y < 20.0)
            System.out.println("两数之和:" + (x + y));
        else
            System.out.println("两数的乘积:" + (x * y));

        /*
            成绩为100分时，奖励一辆BMW;
            成绩为(80,99]时，奖励一台iphone xs max;
            当成绩为[60,80]时，奖励一个iPad;
            其它时，什么奖励也没有。
            请从键盘输入期末成绩，并加以判断
         */
        /*
        1.else结构是可选的
        2.针对于条件表达式：
            > 如果多个条件表达式之间是“互斥”关系（或没有交集的关系），哪个判断和执行语句声明在上面还是下面，无所谓。
            > 如果多个条件表达式之间是“交集”关系，需要根据实际情况，考虑清楚应该将哪个结构声明在上面。
            > 如果多个条件表达式之间是“包含”关系，通常情况下，需要将范围小的声明在范围大的上面。否则，范围小的就没机会执行。
         */
        System.out.println("请输入你的期末成绩<0 - 100>:");
        int score = scanner.nextInt();
        if(score == 100)
            System.out.println("奖励一台BMW");
        else if(score > 80 && score <= 99)
            System.out.println("奖励一台iphone xs max");
        else if(score >= 60 && score <= 80)
            System.out.println("奖励一个iPad");
        else
            System.out.println("没有奖励");
        //由键盘输入三个整数分别存入三个整型变量，对它们进行排序,并且从小到大输入
        /*
        1.if-else结构可以相互嵌套
        2.如果if-else结构中的执行语句只有一行时，对应的一对{}可以省略。但是，不建议省略。(防止报错或者加代码)
         */
        System.out.println("请输入三个整数:");
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int num3 = scanner.nextInt();
        int temp;
        //方法1
        if(num1 > num2)
        {
            temp = num1;
            num1 = num2;
            num2 = temp;
        }
        if(num1 > num3){
            temp = num1;
            num1 = num3;
            num3 = temp;
        }
        if(num2 > num3){
            temp = num2;
            num2 = num3;
            num3 = temp;
        }
        System.out.println("min -> max:" + num1 + "," + num2 + "," + num3);
        //方法二
        if(num1 >= num2){
            if(num3 > num1)
                System.out.println("min -> max:" + num2 + "," + num1 + "," + num3);
            else if(num3 <= num2)
                System.out.println("min -> max:" + num3 + "," + num2 + "," + num1);
            else
                System.out.println("min -> max:" + num2 + "," + num3 + "," + num1);

        }else{
            if(num3 >= num2)
                System.out.println("min -> max:" + num1 + "," + num2 + "," + num3);
            else if(num3 <= num1)
                System.out.println("min -> max:" + num3 + "," + num1 + "," + num2);
            else
                System.out.println("min -> max:" + num1 + "," + num3 + "," + num2);
            }
    }
}
