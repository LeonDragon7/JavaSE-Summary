package com.grammar.flow.test;

import java.util.Scanner;

public class ForLoopTest02 {
    public static void main(String[] args){
        /*
        一个数如果恰好等于它的因子之和，这个数就称为"完数"。 例如，6的因子为1、2、3，而6=1+2+3，因此6是"完数"。 编程序找出30之内的所有完数。
         */
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int last = -1; // 用于跟踪最后一个完美数
        for(int i = 1;i <= n;i++){
            int temp = 0;
            //i / 2:避免取本身值，优化代码
            for (int j = 1; j <= i / 2; j++) {
                if(i % j == 0){//判断是否为因子
                    temp += j;
                }
            }
            if(temp == i){
                last = i;// 更新最后一个完美数
            }
        }

        for(int i = 1;i <= n;i++){
            int temp = 0;
            //i / 2:避免取本身值，优化代码
            for (int j = 1; j <= i / 2; j++) {
                if(i % j == 0){//判断是否为因子
                    temp += j;
                }
            }
            if(last == i){//输出最后一个完美数
                System.out.print(i);
            } else if (temp == i) {//输出其他完美数
                System.out.print(i + ",");
            }
        }
        /*
        int n = 30;
        String ans = "";
        for(int i = 1;i <= n;i++){
            int temp = 0;
            //i / 2:避免取本身值，优化代码
            for (int j = 1; j <= i / 2; j++) {
                if(i % j == 0){//判断是否为因子
                    temp += j;
                }
            }
            //字符串解决输出问题
            if(temp == i){
                if(ans.equals("")){
                    ans += i + "";
                }else{
                    ans += "," + i;
                }
            }
        }
        System.out.println(ans);
         */
    }
}
