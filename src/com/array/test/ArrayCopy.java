package com.array.test;

public class ArrayCopy {
    public static void main(String[] args) {
        /*
        编写代码实现数组拷贝
        将 int[] arr1 = {10,20,30};拷贝到arr2数组，要求两个数组空间是独立的。
         */
        int arr1[] = {10,20,30};
        int arr2[] = new int[arr1.length];// new 开辟新的数据空间，不会导致arr2和arr1存储同一地址
        for(int i = 0;i < arr1.length;i++){
            arr2[i] = arr1[i];
            System.out.println(arr2[i]);
        }
    }
}
