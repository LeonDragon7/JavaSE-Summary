package com.grammar.operator.test;

public class OperatorTest06 {
    public static void main(String[] args) {
        /*
        算术运算符 练习：
        随意给出一个整数，打印显示它的个位数，十位数，百位数的值。
        例如：数字153的情况如下：
        个位数：3
        十位数：5
        百位数：1

        思路：整数被除10就去掉小数点后面的一位：例如：201除10 20.1 返回整型为20，
        取余10得出每位数从个位开始

         */
        int num = 435;
        System.out.println("个位数：" + num % 10);
        System.out.println("十位数：" + num / 10 % 10);
        System.out.println("百位数：" + num / 10 / 10 % 10);

        //练习:交换两个变量的值
        //自编1：
        int temp;
        int num1 = 10;
        int num2 = 20;
        //定义临时变量(推荐)
        temp = num1;
        num1 = num2;
        num2 = temp;
        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);

        //自编2：使用位运算符 - 与运算和或运算
        int num3 = 10;
        int num4 = 20;
        System.out.println("num3 = " + ((num3 | num4) & num4));
        System.out.println("num4 = " + ((num3 | num4) & num3));

        //正解1：
        /*
            好处：不用定义临时变量
            弊端：①相加操作可能超出存储范围。②有局限性：只能适用于数值类型。
         */
        int num5 = 10;
        int num6 = 20;
        num5 = num5 + num6;
        num6 = num5 - num6;
        num5 = num5 - num6;
        System.out.println("num5 = " + num5);
        System.out.println("num6 = " + num6);

        //正解2：使用位运算符 - 异或运算
        int num7 = 10;
        int num8 = 20;
        System.out.println("num7 = " + ((num7 ^ num8) ^ num7));
        System.out.println("num8 = " + ((num7 ^ num8) ^ num8));
    }
}
