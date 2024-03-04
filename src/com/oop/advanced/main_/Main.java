package com.oop.advanced.main_;
/*
    深入理解main方法
    解释main方法的形式: public static void main(String[] args){}
    1.main方法时虚拟机调用
    2.java虚拟机需要调用类的main()方法，所以该方法的访问权限必须是public
    3.java虚拟机在执行main()方法时不必创建对象，所以该方法必须是static
    4.该方法接收String类型的数组参数，该数组中保存执行java命令时传递给所运行的类的参数,案例演示，接收参数.
    5.java执行的程序 参数1 参数2 参数3。
    点击Main - > Edit Configurations.. -> 在Program arguments 中传入参数即可。

    特别提示
    在main()方法中，我们可以直接调用main 方法所在类的静态方法或静态属性。但是，不能直接访问该类中的非静态成员，
    必须创建该类的一个实例对象后，才能通过这个对象去访问类中的非静态成员。
 */
public class Main {
}
