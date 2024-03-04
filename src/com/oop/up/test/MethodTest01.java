package com.oop.up.test;

public class MethodTest01 {
    public static void main(String[] args) {
        //1、编写类AA新方法：判断一个数是奇数odd还是偶数even，返回boolean
        AA aa = new AA();
        if (aa.isOdd(1)){
            System.out.println("奇数");
        }else {
            System.out.println("偶数");
        }
    }
}
class AA{
    public boolean isOdd(int num){
        /*
        if(num % 2 != 0){
            return true;
        }else{
            return false;
        }
         */

        //return num % 2 != 0 ? true:false;

        return num % 2 != 0;
    }
}
