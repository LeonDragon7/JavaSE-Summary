package com.oop.up;
/*
    成员方法
    注意事项和使用细节
    访问修饰符：[public、private、protected、默认](作用是控制方法使用范围)

    返回数据类型
    1、一个方法最多有一个返回值
    2、返回类型可以为任意类型，包含基本类型或引用类型(数组，对象)
    3、如果方法要求有返回数据类型，则方法体中最后的执行语句必须为return 值;而
    且要求返回值类型必须和return的值类型一致或兼容(类型转换)
    4、如果方法是void，则方法体中可以没有return语句，或者只写return;
 */
public class MethodDetail01 {
    public static void main(String[] args) {
        //1、一个方法最多有一个返回值 如何返回多个数组？返回数组
        Test test = new Test();
        int[] arr =  test.getSumAndSub(1,4);
        System.out.println("和 = " + arr[0] + ",差 = " + arr[1]);
    }
}
class Test{
    public int[] getSumAndSub(int n1,int n2){
        int[] resArr = new int[2];
        resArr[0] = n1 + n2;
        resArr[1] = n1 - n2;
        return resArr;
    }
}