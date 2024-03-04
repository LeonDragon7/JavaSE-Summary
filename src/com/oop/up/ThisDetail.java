package com.oop.up;
/*
    this关键字
    this的注意事项和使用细节
    1、this关键字可以用来访问本类的属性、方法、构造器
    2、this用来区分当前类的属性和局部变量
    3、访问成员方法的语法：this.方法名(参数列表);
    4、访问构造器语法：this(参数列表);注意只能在构造器中使用
    （即只能在构造器中访问另外一个构造器，必须放在第一个语句）
    5、this不能在类定义的外部使用，只能在类定义的方法中使用。
 */
public class ThisDetail {
    public static void main(String[] args) {
        T3 t1 = new T3();
        t1.f2();
    }
}
class T3{
    //3、访问成员方法的语法：this.方法名(参数列表);
    public void f1(){
        System.out.println("f1() 方法...");
    }
    public void f2(){
        System.out.println("f2() 方法...");
        //调用本类的f1
        f1();//方法一;
        this.f1();//方法二;
    }
    /*
     4、访问构造器语法：this(参数列表);注意只能在构造器中使用
     （即只能在构造器中访问另外一个构造器）

     注意：访问构造器语法：this(参数列表);必须放置第一行语句
     */
    public T3(){
        //这里访问 T3(String name,int age)
        this("jack",100);
        System.out.println("T() 构造器");
    }
    public T3(String name,int age){
        System.out.println("T3(String name,int age) 构造器");
    }
}