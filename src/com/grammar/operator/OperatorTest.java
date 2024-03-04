package com.grammar.operator;

public class OperatorTest {
    public static void main(String[] args) {
        //程序输出
        boolean x = true;
        boolean y = false;
        short z = 40;
        if((z++ == 40) && (y = true))
            z++;
        if((x = false) || (++z == 43))
            z++;
        System.out.println("z = " + z);//44

        //三元运算符求三个数最大值
        int a = 13,b = 4,c = 5,tmp,max;
        tmp = a > b ? a : b;
        max = tmp > c ? tmp : c;
        System.out.println("max =" + max);
    }
}
