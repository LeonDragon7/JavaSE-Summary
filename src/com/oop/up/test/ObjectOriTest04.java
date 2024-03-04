package com.oop.up.test;

public class ObjectOriTest04 {
    public static void main(String[] args) {
        /*
        4.编写类A03,实现数组的复制功能copyArr,输入旧数组，返回一个新数组，元素和
        旧数组一样
         */
        int[] oldArr = {12,45,67,54,32};
        A03 a03 = new A03();
        int[] newArr = a03.copyArr(oldArr);
        System.out.print("复制后的数组为：");
        for (int i = 0; i < oldArr.length; i++) {
            System.out.print(newArr[i] + "\t");
        }
        System.out.println();
    }
}
class A03{
    public int[] copyArr(int[] oldArr){
        int[] newArr = new int[oldArr.length];
        for (int i = 0; i < oldArr.length; i++) {
            newArr[i] = oldArr[i];
        }
        return newArr;
    }
}
