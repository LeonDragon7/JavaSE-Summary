package com.oop.up.recursion.test;

public class RecursionTest01 {
    public static void main(String[] args) {
        /*
        1、请使用递归的方式求出斐波那契数1,1,2,3,5,8,13...给你一个整数n，
        求出它的值是多少？
         */
        Test01 t1 = new Test01();
        int res = t1.fibonacci(5);
        if(res != -1){
            System.out.println("res = " + res);
        }
    }
}
class Test01{
    /*
    思路分析：
    1、当n == 1 和 n == 2时，斐波那契数为1
    2、当n >= 3,斐波那契数为前两个数的和
    3、这里就是一个递归思想
     */
    public int fibonacci(int n){
        if(n >= 1){
            if(n <= 2){
                return 1;
            }else{
                return fibonacci(n - 1) + fibonacci(n - 2);
            }
        }else{
            System.out.println("要求输入的n >= 1的整数");
            return -1;
        }
    }
}