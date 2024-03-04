package com.grammar.operator.test;

public class OperatorTest05 {
    public static void main(String[] args) {
        //三元运算符求三个数最大值
        int a = 13,b = 4,c = 5,tmp,max;
        tmp = a > b ? a : b;
        max = tmp > c ? tmp : c;
        System.out.println("max =" + max);

        /*使用一条语句（不太推荐）
        int max = (a > b ? a : b) > c ? (a > b ? a : b) : c;
        System.out.println("max =" + max);
         */
    }
}
