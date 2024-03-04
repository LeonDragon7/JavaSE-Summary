package com.grammar.operator.test;

public class OperatorTest01 {
    public static void main(String[] args) {
        //面试题1
		/*
		为什么为1？
		因为在 i = i++;会规则使用临时变量：
		(1)temp = i;
		(2)i = i + 1;
		(3)i = temp;
		*/
        int i = 1;
        i = i++;
        System.out.println(i);//1

        //面试题2
		/*
		为什么为2？
		因为在 i = ++i;会规则使用临时变量：
		(1)i = i + 1;
		(2)temp = i;
		(3)i = temp;
		*/
        int j = 1;
        j = ++j;
        System.out.println(j);//2


        int i1 = 10;
        int i2 = 20;
        int k = i1++;
        System.out.print("k = " + k);//10
        System.out.println("i2 = " + i2);//20
        k = --i2;
        System.out.print("k = " + k);//19
        System.out.println("i2 = " + i2);//19
    }
}
