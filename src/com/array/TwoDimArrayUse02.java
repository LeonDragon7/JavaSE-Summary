package com.array;
/*
    二维数组的使用
    使用方式2：动态初始化
    1) 先声明：类型[][] 数组名;
    2) 再定义(开辟空间) 数组名 = new 类型[大小][大小];
    3) 赋值(有默认值，比如int 类型的就是0)
 */
public class TwoDimArrayUse02 {
    public static void main(String[] args) {
        int[][] arr;//声明二维数组
        arr = new int[2][3];//开辟空间
        for(int i = 0;i < arr.length;i++){
            for(int j = 0;j < arr[i].length;j++){
                System.out.println(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
