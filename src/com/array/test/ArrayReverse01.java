package com.array.test;

public class ArrayReverse01 {
    public static void main(String[] args) {
        /*
			把数组的元素内容反转。
			arr{11,22,33,44,55,66} ->  {66,55,44,33,22,11}
		*/
		/*
			arr[0] == arr[5]
			arr[1] == arr[4]
			...
			arr[i] == arr[arr.length - 1 - i]
		*/
        int arr[] = {11,22,33,44,55,66};
        int temp = 0;
        int len = arr.length;
        for(int i = 0;i < Math.sqrt(len);i++){//arr.length / 2
            temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
        for (int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + "\t");
        }
    }
}
