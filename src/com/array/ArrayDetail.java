package com.array;
/*
    数组的使用注意事项和细节
    1.数组是多个相同类型数据的组合，实现对这些数据的统一管理。
    2.数组中的元素可以是任何数据类型，包括基本类型和引用类型，但是不能混用。
    3.数组创建后，如果没有赋值，有默认值
      int 0,short 0,byte 0,long 0,float 0.0,double 0.0,
      char \u0000,boolean false,String null
    4.使用数组的步骤：
        1) 声明数组并开辟空间
        2) 给数组各个元素赋值
        3) 使用数组
    5.数组的下标是从0开始的。
    6.数组下标必须在指定范围内使用，
      否则报：java.lang.ArrayIndexOutOfBoundsException（下标越界异常）,
      比如：int[] arr = new int[5];则有效下标为0-4。
    7.数组属于引用类型，数组型数据是对象(object)。
 */
public class ArrayDetail {
    public static void main(String[] args) {

    }
}