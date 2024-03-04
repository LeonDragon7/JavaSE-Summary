package com.array.search;

import java.util.Scanner;

//顺序查找
public class SeqSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*
            1、有一个案例：白眉鹰王、金毛狮王、紫衫龙王、青翼蝠王猜数游戏：从键盘
            中任意输入一个名称，判断数列中是否包含名称[顺序查找] 要求：如果找
            到了，就提示找到了，并给出下标值。
         */
        int i = 0;
        String arr[] = {"白眉鹰王","金毛狮王","紫衫龙王","青翼蝠王"};
        System.out.println("请输入你的猜想:");
        String name = scanner.next();
        //int index = -1;
        for(i = 0;i < arr.length;i++){
            if(name.equals(arr[i])){//字符串的比较equals  例： xxx.equals(yyy)
                System.out.println("找到了,下标为：" + i);
                //index = i;
                break;
            }
        }
        if(i >= arr.length){
            System.out.println("没找到:" + name);
        }
//        if (index == -1){
//            System.out.println("没找到:" + name);
//        }
    }
}
