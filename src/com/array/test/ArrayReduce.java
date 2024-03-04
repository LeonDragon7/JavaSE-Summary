package com.array.test;

import java.util.Scanner;

public class ArrayReduce {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*
            有一个数组{1,2,3,4,5}，可以将该数组进行缩减，提示用户是否继续缩
            减，每次缩减最后哪个元素。当只剩下最后一个元素，提示，不在缩减。
         */
        int arr[] = {1,2,3,4,5};
        do{
            int arrNew[] = new int[arr.length - 1];
            for(int i = arrNew.length - 1;i >= 0;i--){
                arrNew[i] = arr[i];
            }
            arr = arrNew;
            for(int i = 0;i < arr.length;i++){
                System.out.print(arr[i] + "\t");
            }
            System.out.println();
            System.out.println("缩减成功，是否继续？y/n");
            char key = scanner.next().charAt(0);
            if(key == 'n'){
                break;
            }
            if(arr.length == 1){
                System.out.print("不能再缩减了,退出！");
                break;
            }
        }while(true);
    }
}
