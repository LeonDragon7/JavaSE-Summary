package com.array.test;

public class ArrayTest02 {
    public static void main(String[] args) {
        //2.请求出一个数组int[]的最大值{4,-1,9,10,23},并得到对应的下标。
        int max = 0;
        int maxIndex = 0;
        int arr[] = {4,-1,9,10,23};
        for(int i = 0;i < arr.length;i++){
            max = arr[0];
            if(arr[i] > max){
                max = arr[i];
                maxIndex = i;
            }
        }
        System.out.println("最大值为：" + max + ",下标为：" + maxIndex);
    }
}
