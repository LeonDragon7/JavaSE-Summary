package com.grammar.flow.test;

public class WhileLoopTest01 {
    public static void main(String[] args) {
        //1.打印1-100之间所有能被3整除的数
        int i = 1;
        int end = 100;
        int multiple = 3;
        System.out.println("1-100能被3整除的数有：");
        while(i <= end){
            if(i % multiple == 0){
                System.out.println(i);
            }
            i++;
        }

        //2.打印40-200之间所有的偶数
        int j = 40;
        int endNum = 200;
        int num = 2;
        System.out.println("40-200之间所有的偶数：");
        while(j <= endNum){
            if(j % num == 0){
                System.out.println(j);
            }
            j++;
        }
    }
}
