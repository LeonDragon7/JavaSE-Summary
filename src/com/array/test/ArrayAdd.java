package com.array.test;

import java.util.Scanner;

public class ArrayAdd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*
            实现动态的给数组添加元素效果，实现对数组扩容。
            1) 原始数组使用静态分配 int[] arr = {1,2,3};
            2) 增加的元素4，直接放在数组的最后 arr = {1,2,3,4}
                arrNew = {1,2,3,4}
            3) 用户可以通过如下方法来决定是否继续添加，添加成功，是否继续? y/n

            思路分析：
            1、定义初始数组 int arr[] = {1,2,3};
            2、定义一个新的数组 int arrNew[] = new int[arr.length+1];
            3、遍历arr数组，依次将arr的元素拷贝到arrNew数组
            4、将4赋值给 arrNew[arrNew.length - 1] = 4;
            5、让arr指向arrNew;
            6、创建一个Scanner对象接受用户输入
            7、因为用户什么时候退出，不确定，使用do-while + break来控制

            注意：数组的扩容效率低，每次扩容都需要开辟空间（int arrNew[] = new int[arr.length + 1];）
            和拷贝数组。(规划空间/推荐链表的方式)
         */
        int arr[] = {1,2,3};
        do {
            int arrNew[] = new int[arr.length + 1];
            for(int i = 0;i < arr.length;i++){
                arrNew[i] = arr[i];
            }
            System.out.println("请输入你需要添加的数:");
            int addNum = scanner.nextInt();
            arrNew[arrNew.length - 1] = addNum;
            arr = arrNew;
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + "\t");
            }

            System.out.println("\n添加成功，是否继续? y/n");
            char key = scanner.next().charAt(0);
            if(key == 'n'){
                break;
            }
        }while (true);
        System.out.println("退出成功！");
    }
}
