package com.array.test;

public class ArrayTest05 {
    public static void main(String[] args) {
        //2.写出结果
        String foo = "blue";
        //bar[0]和bar[1]都为false - 布尔类型默认(没有赋值)为false
        boolean[] bar = new boolean[2];
        if (bar[0]) {
            foo = "green";
        }
        System.out.println(foo);//blue
    }
}
