package com.array.test;

public class ArrayReverse02 {
    public static void main(String[] args) {
        /*
			把数组的元素内容反转。
			arr{11,22,33,44,55,66} ->  {66,55,44,33,22,11}
		*/
		/*
			1、创建新的数组
			2、逆序遍历arr，将每个元素拷贝到新数组的元素中
			3、增加循环变量 j -> 0 - > 5
			4、for循环结束，得到逆序数组arr1
			5、让arr指向arr1的数据空间，此时arr原来的数据空间就没有变量引用，会被当做垃圾销毁(JVM)
		*/
        int arr[] = {11,22,33,44,55,66};
        int arr1[] = new int[arr.length];
        for (int i = arr.length - 1,j = 0; i >= 0; i--,j++) {
            arr1[j] = arr[i];
        }
        arr = arr1;
        //输出
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }
}
