package com.oop.up.test;

public class ObjectOriTest01 {
    public static void main(String[] args) {
        //1.编写类A01,定义方法max，实现求某个double数组的最大值，并返回
        double[] arr = {78.5,96.6,04.5,40.3,39.12};
        A01 a01 = new A01();
        Double max = a01.max(arr);
        if(max != null){
            System.out.println("该数组最大值为：" + max);
        }else {
            System.out.println("arr的输入有误{}或者不能为null");
        }
    }
}
class A01{
    //Double:包装类，使得返回值可以为空，double基本类型，不能返回为空,（防止数组的长度为0或者为空）
    public Double max(double[] arr){
        //考虑代码的健壮性，先判断arr是否为空，需要保证arr至少有一个元素
        if(arr != null && arr.length > 0) {
            double max = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                }
            }
        return max;
        }else {
            return null;
        }
    }
}