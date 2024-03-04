package com.oop.up;
/*
    可变参数
    注意事项和使用细节
    1) 可变参数的实参可以为0个或任意多个。
    2) 可变参数的实参可以为数组。
    3) 可变参数的本质就是数组
    4) 可变参数可以和普通类型的参数一起放在形参列表，但必须保证可变参数在最后
    5) 一个形参列表中只能出现一个可变参数
 */
public class VariableParameterDetail {
    public static void main(String[] args) {
        T t = new T();
        //可变参数的实参可以为数组。
        int[] arr = {1,2,3};
        t.f1(arr);
    }
}
class T{
    public void f1(int... nums){
        System.out.println("长度:" + nums.length);
    }
    //可变参数可以和普通类型的参数一起放在形参列表，但必须保证可变参数在最后
    //double... nums必须放在String str之后.
    public void f2(String str,double... nums){

    }
}