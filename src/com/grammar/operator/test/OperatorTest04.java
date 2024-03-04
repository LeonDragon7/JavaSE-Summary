package com.grammar.operator.test;

public class OperatorTest04 {
    public static void main(String[] args) {
        //练习1
        int x1 = 5;
        int y1 = 5;
        if(x1++ == 6 & ++y1 == 6){
            x1 = 11;
        }
        System.out.println("x1 = " + x1 +",y1 = " + y1);//x1 = 6,y1 = 6

        //练习2
        int x2 = 5;
        int y2 = 5;
        if(x2++ == 6 && ++y2 == 6){
            x2 = 11;
        }
        System.out.println("x2 = " + x2 +",y2 = " + y2);//x2 = 6,y2 = 5

        //练习3
        int x3 = 5;
        int y3 = 5;
        if(x3++ == 5 | ++y3 == 5){
            x3 = 11;
        }
        System.out.println("x3 = " + x3 +",y3 = " + y3);//x3 = 11,y3 = 6

        //练习4
        int x4 = 5;
        int y4 = 5;
        if(x4++ == 5 || ++y4 == 5){
            x4 = 11;
        }
        System.out.println("x4 = " + x4 +",y4 = " + y4);//x4 = 11,y4 = 5

        //程序输出
        boolean x = true;
        boolean y = false;
        short z = 40;
        if((z++ == 40) && (y = true))
            z++;
        if((x = false) || (++z == 43))
            z++;
        System.out.println("z = " + z);//44
    }
}
