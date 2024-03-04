package com.oop.centre.test;

public class OOPTest11 {
    public static void main(String[] args) {
        /*
        11、现有Person04类，里面有方法run、eat，Student01类继承了Person04类，并重写了run方
        法，自定义了study方法，试写出对象向上转型和向下转型的代码，并写出各自都可以调用
        哪些方法，并写出输出什么？
         */
        //向上转型
        Person04 p1 = new Student01();
        p1.run();//student run
        p1.eat();//person eat
        //向下转型
        Student01 s1 = (Student01)p1;
        s1.run();//student run
        s1.study();//student study..
        s1.eat();//person eat
    }
}
class Person04{
    public void run(){
        System.out.println("person run");
    }
    public void eat(){
        System.out.println("person eat");
    }
}
class Student01 extends Person04{
    public void run(){
        System.out.println("student run");
    }
    public void study(){
        System.out.println("student study..");
    }
}
