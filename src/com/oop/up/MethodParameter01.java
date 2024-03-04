package com.oop.up;
/*
    成员方法的传参机制
    基本数据类型的传参机制
    基本数据类型，传递的是值(值拷贝)，形参的任何改变不影响实参！
 */
public class MethodParameter01 {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        AA aa = new AA();
        aa.swap(a,b);
        System.out.println("\nmain方法\na = " + a + "\tb = " + b);//10 20
    }
}
class AA{
    public void swap(int a,int b){
        System.out.println("\na和b交换前的值\na = " + a + "\tb = " + b);//10 20
        //完成了a和b的交换
        int tmp = a;
        a = b;
        b = tmp;
        System.out.println("\na和b交换后的值\na = " + a + "\tb = " + b);//20 10
    }
}
//结论：main栈和swap栈是两块独立的空间，当swap栈交换的值不能影响main找的值。