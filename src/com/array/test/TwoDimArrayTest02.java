package com.array.test;

public class TwoDimArrayTest02 {
    public static void main(String[] args) {
        /*
            声明：int[] x,y[];以下选项允许通过编译的是(b,e):
            a) x[0] = y;//错误 int[][] -> int
            b) y[0] = x;//正确 int[] -> int[]
            c) y[0][0] = x;//错误 int[] -> int
            d) x[0][0] = y;//错误 x[0][0]：错误写法
            e) y[0][0] = x[0];//正确 int -> int
            f) x = y;//错误 int[][] -> int[]

            思路分析：
            x是int类型一维数组，y是int类型的二维数组
         */
    }
}
