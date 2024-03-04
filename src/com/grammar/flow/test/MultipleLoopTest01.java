package com.grammar.flow.test;

import java.util.Scanner;

public class MultipleLoopTest01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
		/*
			1.统计3个班成绩情况，每个班有5名同学，求出各个班的平均分和所有班级
			的平均分[学生的成绩从键盘输入]。
			2.统计三个班及格人数，每个班有5名同学。
		*/
		/*
			思路分析:
			1、化繁为简
			（1）先计算一个班，5个学生的成绩和平均分,使用for
				1.1 创建Scanner对象，然后接收用户输入
				1.2 得到该班级的平均分
			（2）统计3个班的（每个班5个学生）平均分
			（3）所有班级的平均分
				3.1 定义一个变量，double totalScore 累计所有学生的成绩
				3.2 当多重循环结束后，totalScore / (i * j)
			（4）统计三个班的及格人数
				4.1 定义变量 int passNum = 0;
				4.2 当有一个学生成绩>=60,passNum++
			2、先死后活：
			（1）将固定的值换成变量，优化[效率，可读性和结构]
		*/
        System.out.println("请输入有多少个班级：");
        int classNum = scanner.nextInt();
        System.out.println("请输入每个班有多少同学：");
        int classMates = scanner.nextInt();
        double avg = 0;
        double score = 0;
        double totalScore = 0;
        double totalAvg = 0;
        int passNum = 0;
        for(int i = 1;i <= classNum;i++){
            double sum = 0;
            for(int j = 1;j <= classMates;j++){
                System.out.println(i + "班,请输入第" + j + "个学生的成绩");
                do{
                    score = scanner.nextDouble();
                    if(score >= 0 && score <= 100){
                        sum += score;
                        if(score >= 60){
                            passNum++;
                        }
                    }else{
                        System.out.println("你输入的成绩有误，请重新输入！");
                    }
                }while(score < 0 || score > 100);
            }
            avg = sum / classMates;
            System.out.println(i + "班的平均成绩是：" + avg);
            totalScore += sum;
        }
        totalAvg = totalScore / (classNum * classMates);
        System.out.println("所有班级的平均分是：" + totalAvg);
        System.out.println("三个班的及格人数为：" + passNum);
    }
}
