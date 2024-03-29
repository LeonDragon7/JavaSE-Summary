package com.oop.up;
/*
    构造方法/构造器
    注意事项和使用细节
    1、一个类可以定义多个不同的构造器，即构造器重载
        比如：我们可以再给Person类定义一个构造器，用来创建对象的时候，只指定人名，
        不需要指定年龄
    2、构造器名和类名要相同
    3、构造器没有返回值
    4、构造器是完成对象的初始化，并不是创建对象
    5、在创建对象时，系统自动的调用该类的构造方法
    6、如果没有定义构造方法，系统会自动给类生成一个默认无参构造
    方法(也叫默认构造方法)，比如Person(){}，使用javap指令反编译看看
    7、一旦定义了自己的构造器，默认的构造器就覆盖了，就不能再使用默认的无
    参构造器，除非显示的定义一下，即：Person(){}

    javap的使用
    1、javap是JDK提供的一个命令行工具，javap能对给定的class文件提供的字节
    代码进行反编译
    2、通过它，可以对照源代码和字节码，从而了解很多编译器内部的工作，对更深入
    地理解如何提高程序执行的效率等问题有极大的帮助。
    3、使用格式
    javap <options><classes>
    常用：javap -c -v 类名
 */
public class ConstructorDetail01 {
    public static void main(String[] args) {

    }
}
