package com.grammar.flow.test;

import java.util.Scanner;

public class DoWhileLoopTest01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //1.打印1-100
        int i = 1;
        do{
            System.out.println("i = " + i);
            i++;
        }while(i <= 100);

        //2.计算1-100的和
        int start = 1;
        int end = 100;
        int sum = 0;
        do{
            sum += start;
            start++;
        }while(start <= end);
        System.out.println("1-100之间的和为：" + sum);

        //3.统计1-200之间能被5整除但不能被3整除的个数
        int s = 1;
        int e = 200;
        int count = 0;
        do{
            if(s % 5 == 0 && s % 3 != 0){
                count++;
            }
            s++;
        }while(s <= e);
        System.out.println("1-200之间能被5整除但不能被3整除的个数为：" + count);

		/*
		4.如果李三不还钱，则老张将一直使出五连鞭，直到李三说还钱为止
		[System.out.println("老张问：还钱吗？y/n")]
		*/
        int a = 0;
        do{
            System.out.println("老张问：还钱吗？y/n");
            char answer = scanner.next().charAt(0);
            if(answer == 'y'){
                System.out.println("我还钱！");
                a = -1;
            }else if(answer == 'n'){
                System.out.println("老张使出五连鞭！");
                a++;
            }else{
                System.out.println("你输入的格式不对!");
                a++;
            }
        }while(a > 0);
        //或
        char answer = ' ';
        do{
            System.out.println("老张使出五连鞭~");
            System.out.println("老张问：还钱吗？y/n");
            answer = scanner.next().charAt(0);
            System.out.println("他的回答是：" + answer);
        }while(answer != 'y');
        System.out.println("李三还钱了!");
    }
}
