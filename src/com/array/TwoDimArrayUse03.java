package com.array;
/*
    二维数组的使用
    使用方式3：动态初始化-列数不确定
 */
public class TwoDimArrayUse03 {
    public static void main(String[] args) {
        /*
            1)看一个需求：动态创建下面二维数组，并输出。
                    j = 0       j = 1       j = 2
           i = 0      1
           i = 1      2           2
           i = 2      3           3           3
           注意：一共有三个一维数组，每个一维数组的元素个数是不一样的。
         */
        int[][] arr = new int[3][];//创建二维数组，但是只是确定一维数组的个/行数(列数不确定)，每个一维数组还没有开辟空间。
        for (int i = 0; i < arr.length; i++) {//遍历每arr个一维数组
            //给每个一维数组开空间(如果没有开辟会报错 arr[i]就是null 空值- java.lang.NullPointerException)
            arr[i] = new int[i + 1];//arr[0] = new int[0 + 1];
            //遍历一维数组，并给一维数组的每个元素赋值
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = i + 1;//赋值
            }
        }
        //遍历输出
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
