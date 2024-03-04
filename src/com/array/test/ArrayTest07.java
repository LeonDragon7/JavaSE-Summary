package com.array.test;

public class ArrayTest07 {
    public static void main(String[] args) {
        /*
        4.已知有一个升序的数组，要求插入一个元素，该数组顺序依然是升序，比如：
        [10,12,45,90],添加23后，数组为[10,12,23,45,90]

        思路分析：数组扩容 + 定位
        1、我们先确定 添加数据应该插入到哪个索引
        2、然后扩容
         */
        //定位
        //先定义数组
        int arr[] = {10,12,45,90};
        int insertNum = 23;
        int index = -1;//index就是要插入的位置
        //遍历arr数组，如果发现 insertNum <= arr[i],说明i就是要插入的位置
        //使用index 保留 index = i;
        //如果遍历完后，insertNum <= arr[i]不成立，说明index = arr.length(arr的最后)
        for (int i = 0; i < arr.length; i++) {
            if(insertNum <= arr[i]){
                index = i;
                break;//找到位置退出
            }
        }
        //判断index的值是否为-1
        if(index == -1){
            index = arr.length;
        }
        //扩容
        //创建一个新的数组
        int arrNew[] = new int[arr.length +  1];
        //将arr的元素拷贝到arrNew，并且要跳过index位置
        //i-控制arrNew的下标，j用来控制arr下标
        for (int i = 0,j = 0; i < arrNew.length; i++) {//定义两个变量，自增位置不同进行错位
            if(i != index){
                arrNew[i] = arr[j];
                j++;
            }else {
                arrNew[i] = insertNum;
            }
        }
        //让arr指向arrNew ，原来的数组被销毁
        arr = arrNew;
        for(int i = 0;i < arr.length;i++){
            System.out.print(arr[i] + "\t");
        }
        /*
        或
        int temp = 0;
        int arr[] = {10,12,45,90};
        int arrNew[] = new int[arr.length +  1];
        for(int i = 0;i < arr.length;i++){
            arrNew[i] = arr[i];
        }
        arrNew[arrNew.length - 1] = 23;
        arr = arrNew;
        for(int i = 0;i < arr.length - 1;i++){
            for(int j = 0;j < arr.length - i - 1;j++){
                if(arr[j + 1] < arr[j]){
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for(int i = 0;i < arr.length;i++){
            System.out.print(arr[i] + "\t");
        }
         */
    }
}
