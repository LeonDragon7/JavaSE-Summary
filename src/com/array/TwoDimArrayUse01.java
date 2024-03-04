package com.array;

/*
    二维数组的使用
    使用方式1：动态初始化
    1) 语法：类型[][] 数组名 = new 类型[大小][大小];
    2) 比如：int a[][] = new int[2][3];
 */
public class TwoDimArrayUse01 {
    public static void main(String[] args) {
        int[][] arr = new int[2][3];
        arr[1][1] = 8;
        for(int i = 0;i < arr.length;i++){
            for(int j = 0;j < arr[i].length;j++){
                System.out.println(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
