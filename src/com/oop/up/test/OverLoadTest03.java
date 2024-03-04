package com.oop.up.test;

public class OverLoadTest03 {
    public static void main(String[] args) {
        /*
        2、在Methods类，定义三个重载方法max(),第一个方法，返回两个int值中的最
        大值，第二个方法，返回两个double值中的最大值，第三个方法，返回三个double
        值中的最大值，并分别调用三个方法。
         */
        Methods03 methods03 = new Methods03();
        System.out.println("两个int最大值:" + methods03.max(5,4));
        System.out.println("两个double最大值:" + methods03.max(5.4,9.4));
        System.out.println("三个double最大值:" + methods03.max(15.4,9.4,1.4));
    }
}
class Methods03{
    //比较两个int最大值
    public int max(int a,int b){
        return a > b ? a : b;
    }
    //比较两个double最大值
    public double max(double a,double b){
        return a > b ? a : b;
    }
    //比较三个double最大值
    public double max(double a,double b,double c){
        double max = a;
        if(max < b){
            max = b;
            return max;
        }
        if(max < c){
            max = c;
            return max;
        }
        return max;
        /*
        //或者
        double max = a > b ? a : b;
        return max > c ? max : c;
         */
    }
    public double max(double a,double b,int c){
        double max = a;
        if(max < b){
            max = b;
            return max;
        }
        if(max < c){
            max = c;
            return max;
        }
        return max;
        /*
        //或者
        double max = a > b ? a : b;
        return max > c ? max : c;
         */
    }
}