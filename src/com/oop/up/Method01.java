package com.oop.up;
/*
    成员方法
    基本介绍
    在某些情况下，我们需要定义成员方法(简称方法)。比如人类：除了有一些属性外(年龄，
    姓名...),我们人类还有一些行为比如：可以说话、跑步..，通过学习，还可以做算术题。
    这时就要用成员方法才能完成。现在要求对Person类完善。
 */
public class Method01 {
    public static void main(String[] args) {
    /*
    成员方法快速入门
    1) 添加speak成员方法，输出我是一个好人
    2) 添加cal01成员方法，可以计算从1+..+1000的结果
    3) 添加cal02成员方法，该方法可以接收一个数n，计算从1 + .. + n的结果
    4) 添加getSum成员方法，可以计算两个数的和
     */
    /*
    方法的使用：
    1、方法写好后，如果不去调用，不会输出
    2、先创建一个对象，然后调用方法即可
     */
    Person p1 = new Person();
    p1.speak();//调用方法
    p1.cal01();
    p1.cal02(5);
    int returnSum = p1.getSum(10,20);//方法getSum返回的值，赋给变量returnSum
    System.out.println("getSum方法返回的值 = " + returnSum);
    }
}
class Person{
    String name;
    int age;

    //1) 添加speak成员方法，输出我是一个好人
    //public:表示方法是公开的
    //void:表述方法没有返回值
    //speak():speak是方法名，():形参列表
    //{}:方法的内容
    public void speak(){
        System.out.println("我是一个好人！");
    }

    //2) 添加cal01成员方法，可以计算从1+..+1000的结果
    public void cal01(){
        int sum = 0;
        for(int i = 1;i <= 1000;i++){
            sum += i;
        }
        System.out.println("cal01方法，计算结果 = " + sum);
    }

    //3) 添加cal02成员方法，该方法可以接收一个数n，计算从1 + .. + n的结果
    public void cal02(int n){//表示当前有一个形参，可以接收用户输入
        int sum = 0;
        for(int i = 1;i <= n;i++){
            sum += i;
        }
        System.out.println("cal02方法，计算结果 = " + sum);
    }

    //4) 添加getSum成员方法，可以计算两个数的和
    //int：表示方法执行后，返回一个int值
    //return sum;表示把sum的值，返回
    public int getSum(int num1,int num2){
        int sum = num1 + num2;
        return sum;
    }
}