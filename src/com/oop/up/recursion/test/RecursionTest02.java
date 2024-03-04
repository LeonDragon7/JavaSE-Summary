package com.oop.up.recursion.test;

public class RecursionTest02 {
    public static void main(String[] args) {
        /*
        2、猴子吃桃子问题：有一堆桃子，猴子第一天吃了其中的一半，并再多吃了一个！以后
        每天猴子都吃其中的一半，然后再多吃一个。当到第10天时，想再多吃(即还没吃)，发
        现只有1个桃子了。问题：最初共多少个桃子？
         */
        int days = 1;
        Test02 t2 = new Test02();
        int res01 = t2.peaches01(days);
        if(res01 != -1){
            System.out.println("第" + days + "天共" + res01 + "个桃子");
        }
    }
}
class Test02{
    /*
    思路分析：逆推
    1、day = 10时,有1个桃子
    2、day = 9时，有 (day(10) + 1) * 2 = 4个桃子
    3、day = 8时，有(day(8) + 1) * 2 = 10个桃子
    4、规律就是：前一天的桃子 = (后一天的桃子 + 1) * 2
    5、递归
     */
    public int peaches01(int days){
        if(days == 10){
            return 1;
        }else if(days >= 1 && days <= 9){
            return (peaches01(days + 1) + 1) * 2;
        }else{
            System.out.println("days在1-10");
            return -1;
        }
    }
    public int peaches02(int days){
        if(days == 1){
            return 1;
        }else{
            return peaches02(days - 1) * 2 + 2;
        }
    }
    public int peaches03(int n,int days){
        if(days == 1){
            return n;
        }
        return peaches03((n + 1) * 2,days - 1);
    }
}