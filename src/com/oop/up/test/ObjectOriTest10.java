package com.oop.up.test;

public class ObjectOriTest10 {
    public static void main(String[] args) {
        //10.试写出以下代码的运行结果
        Demo d1 = new Demo();
        Demo d2 = d1;
        d2.m();
        /*
        i = 101
        j = 100
         */
        System.out .println(d1.i);//101
        System.out.println(d2.i);//101
    }
}
class Demo{
    int i = 100;
    public void m(){
        int j = i++;
        System.out.println("i = " + i);//101
        System.out.println("j = " + j);//100
    }
}
