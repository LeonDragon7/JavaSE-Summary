package com.reflection.classload_;
/*
    连接阶段-解析
    虚拟机将常量池内的符号引用替换为直接引用（地址引用）的过程。这个过程是由jvm机自动完成的。

    Initialization初始化
    1.到初始化阶段，才真正开始执行类中定义的Java程序代码，此阶段是执行<clinit>()方法的过程。
    2.<clinit>()方法是由编译器按语句在源文件中出现的顺序，依次自动收集类中的所有静态变量的赋值动作和静态代码块中的语句,并进行合并。
    3.虚拟机会保证一个类的<clinit>()方法在多线程环境中被正确地加锁、同步，如果多个线程同时去初始化一个类，那么只会有一个线程去执行这个类的<clinit>()方法，
    其他线程都需要阻塞等待，直到活动线程执行<clinit>()方法完毕

    正因为有这个机制，才能保证某个类在内存中, 只有一份Class对象。
 */
public class ClassLoad03 {
    public static void main(String[] args) throws ClassNotFoundException {
        //1. 加载B类，并生成 B的class对象
        //2. 链接 num = 0 (连接阶段-准备)
        //3. 初始化阶段
        //    依次自动收集类中的所有静态变量的赋值动作和静态代码块中的语句,并合并
        /*
                clinit() {
                // 按照顺序合并
                    System.out.println("B 静态代码块被执行");
                    //num = 300;
                    num = 100;
                }
                合并: num = 100

         */

        //new B();//类加载
        //System.out.println(B.num);//100, 如果直接使用类的静态属性，也会导致类的加载

        //看看加载类的时候，是有同步机制控制
        /*
        protected Class<?> loadClass(String name, boolean resolve)
        throws ClassNotFoundException
        {
            //为啥对于某个类的Class类对象，在内存中只有一份，因为类只加载一次？
            //正因为有这个机制，才能保证某个类在内存中, 只有一份Class对象
            synchronized (getClassLoadingLock(name)) {
            //....
            }
            }
         */
        B b = new B();
    }
}
class B {
    static {
        System.out.println("B 静态代码块被执行");
        num = 300;
    }

    static int num = 100;

    //如果直接调用类的静态变量(会导致类的加载)而没有new对象，则构造器不会被执行
    //但是new对象也会导致类的加载
    public B() {//构造器
        System.out.println("B() 构造器被执行");
    }
}