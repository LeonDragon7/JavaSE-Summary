package com.grammar.flow.test;

import java.util.Scanner;

/*
    水仙花数是指一个N位正整数（7≥N≥3），它的每个位上的数字的N次幂之和等于它本身。例如：153=13+53+33。 要求编写程序，计算所有N位水仙花数。
 */
public class ForLoopTest03 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int a[] = new int[N];
        int num = (int) Math.pow(10,N-1);
        while(num < Math.pow(10,N)){//100 - 1000
            int l = num;
            int sum = 0;
            //计算每个位上的数字的N次幂之和
            for(int j = 0;j < N;j++){
                int c = 1;
                for(int k = 0;k < N;k++){
                    c = c*(l % 10);//c->记录每一位数的幂之和
                    //1 * (153 % 10) -> 3 ^ 3
                    //1 * (15 % 10) -> 5 ^ 3
                    //1 * (1 % 10) -> 1 ^ 3
                }
                sum += c;
                l /= 10;//153 - > 15 - > 1
            }
            if(sum == num){
                System.out.println(num);
            }
            num++;
        }
    }
}
