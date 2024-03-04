package com.array.test;

public class ArrayTest08 {
    public static void main(String[] args) {
        /*
        5.随机生成10个整数(1_100的范围)保存到数组，并倒序打印以及求平均值，求最大
        值和最大值的下标、并查找里面是否有8
         */
        int arr[] = new int[10];
        double avg = 0;
        int maxIndex = 0;
        double sum = arr[0];
        int max = arr[0];
        for(int i = 0;i < arr.length;i++){
            arr[i] = (int)(Math.random() * 100) + 1;
        }
        for(int i = arr.length-1;i >= 0;i--){//倒序打印
            System.out.print(arr[i] + "\t");

        }
        System.out.println();
        for(int i = 1;i < arr.length;i++){
            sum += arr[i];
            if(max < arr[i]){
                max = arr[i];
                maxIndex = i;
            }
        }
        System.out.println("max = " +  max + ",下标为：" + maxIndex);
        avg = sum / arr.length;//平均值
        System.out.println("avg = " + avg);
        int findNum = 8;
        int index = -1;//如果有多个8，可以将这行定义为数组
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == findNum){
                System.out.println("找到数：" + findNum + "下标：" + i);
                index = 1;
                break;
            }
        }
        if(index == -1){
            System.out.println("没有找到数：" + findNum);
        }
    }
}
