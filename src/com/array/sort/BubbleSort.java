package com.array.sort;
/*
    冒泡排序法
    冒泡排序(Bubble Sorting)的基本思想是：通过对待排序序列从后向前(从下标
    较大的元素开始)，依次比较相邻元素的值，若发现逆序则交换，使值较大的元素逐渐
    从前移向后部，就像水底下的气泡一样逐渐向上冒。
 */
public class BubbleSort {
    public static void main(String[] args) {
        /*
            将五个无序:24,69,80,57,13使用冒泡排序法将其排成
            一个从小到大的有序数列。
         */
        int arr[] = {24,69,80,57,13};
        int temp = 0;
        for(int i = 0;i < arr.length - 1;i++){//轮数-确定最大数
            for (int j = 0; j < arr.length - 1 - i; j++) {//交换次数
                if(arr[j + 1] < arr[j]){
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        for(int i = 0;i < arr.length;i++){
            System.out.print(arr[i] + "\t");
        }
    }
}
