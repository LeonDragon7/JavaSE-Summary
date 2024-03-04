package com.oop.up;
/*
    可变参数
    基本概念
    java允许将同一个类中多个同名同功能但参数个数不同的方法，封装成一个方法，
    就可以通过可变参数实现。
    基本语法
    访问修饰符 返回类型 方法名(数据类型...形参名){}
 */
public class VariableParameter {
    public static void main(String[] args) {
        HspMethod hspMethod = new HspMethod();
        System.out.println(hspMethod.sum(1,5,10));
    }
}
class HspMethod{
    //方法sum，可以计算2个数的和，3个数的和，4,5.....
    //可以使用方法重载，但是比较麻烦，代码累赘
    public int sum(int a,int b){
        return a + b;
    }
    public int sum(int a,int b,int c){
        return a + b + c;
    }
    public int sum(int a,int b,int c,int d){
        return a + b + c + d;
    }
    //...
    //上面的是三个方法名称相同，功能相同，参数个数不同-> 使用可变参数优化
    //1.int...：表示接受的是可变参数，类型是int，既可以接收多个int(0-多)
    //2.使用可变参数时，可以当做数组来使用，即nums可以当做数组
    //3.遍历nums求和即可
    public int sum(int... nums){
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += nums[i];
        }
        return res;
    }
}
