package com.array.test;

public class YanghuiTriangle {
    public static void main(String[] args) {
        /*
            1、使用二维数组打印一个10行杨辉三角
            1
            1 1
            1 2 1
            1 3 3 1
            1 4 6 4 1
            1 5 10 10 5 1
            ...
            草稿：
                 0          00
            1    1 1    10 11
            2    1 2 1  20 21 22 arr[2][1] = arr[1][0] + arr[1][1];
            3    1 3 3 1 30 31 32 33 arr[3][1] = arr[2][0] + arr[2][1]; arr[3][2] = arr[2][1] + arr[2][2]
            4    1 4 6 4 1 40 41 42 43 44
            5    1 5 10 10 5 1
            6    1 6 15 15 15 6 1
                ...

            思路分析：
            1、第一行有1个元素，第n行有n个元素
            2、每一行的第一个元素和最后一个元素都是1
            3、从第三行开始，对于非第一个元素和最后一个元素的元素的值，arr[i][j]
            arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];

         */
        int arr[][] = new int[10][];
        for(int i = 0;i < arr.length;i++){
            arr[i] = new int[i + 1];
            for(int j = 0;j < arr[i].length;j++){
                if(j == 0 || i == j){
                    arr[i][j] = 1;
                }else if(i >= 2){
                    arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
                }
                /*
                或者
                if(j == 0 || j == arr[i].length - 1){
                    arr[i][j] = 1;
                }else{
                    arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
                }
                 */
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
