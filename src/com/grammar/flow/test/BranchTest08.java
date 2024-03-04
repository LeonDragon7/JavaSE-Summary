package com.grammar.flow.test;

import java.util.Scanner;

public class BranchTest08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*
        编写程序：从键盘上读入一个学生成绩，存放在变量score中，根据score的
        值输出其对应的成绩等级：
        score>=90   等级：A
        70<=score<90    等级：B
        60<=score<70    等级：C
        score<60    等级：D
         */
        double score = scanner.nextDouble();
        //if-else结构
        if(score >= 90)
            System.out.println("A");
        else if(score >= 70 && score < 90)
            System.out.println("B");
        else if(score >= 60 && score < 70)
            System.out.println("C");
        else
            System.out.println("D");
        //switch-case
        int swiScore =  (int)score / 10;
        switch (swiScore){
            case 10:
            case 9:
                System.out.println("A");
                break;
            case 8:
            case 7:
                System.out.println("B");
                break;
            case 6:
                System.out.println("C");
                break;
            case 5:
            case 4:
            case 3:
            case 2:
            case 1:
            case 0:
                System.out.println("D");
        }
    }
}
