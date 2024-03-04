package com.array;

/*
    多维数组-二维数组
    原来的一维数组的每个元素是一维数组，就构成二维数组。
 */
public class TwoDimArray {
    public static void main(String[] args) {
        /*
        请用二维数组输出如下图形
        0 0 0 0 0 0
        0 0 1 0 0 0
        0 2 0 3 0 0
        0 0 0 0 0 0
         */
        /*
        概念：
        (1) 二维数组的元素个数为 arr.length
        (2) 二维数组的每个元素使一维数组，所以如果需要得到每一个一维数组的值还需要我们遍历。
        (3) 如果我们要访问第(i + 1)个一维数组的第(j + 1)个值 arr[i][j];(下标是从0开始的)
            举例：访问第 3个一维数组的第4个值 arr[2][3]; -> 3
         */
        int[][] arr = {{0,0,0,0,0,0},{0,0,1,0,0,0},{0,2,0,3,0,0},{0,0,0,0,0,0}};
        System.out.println(arr.length);
        for (int i = 0; i < arr.length; i++) {//遍历二维数组的每个元素
            //arr[i]表示二维数组的第i+1个元素 比如arr[0]:二维数组的第一个元素
            //arr[i].length;：得到对应的每个一维数组的长度
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
