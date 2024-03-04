package com.reflection.class_;
/*
    Class 类
    基本介绍
    1.Class也是类，因此也继承Object类[类图]
    2.Class类对象不是new出来的，而是系统创建的[演示]
    3.对于某个类的Class类对象,在内存中只有一份，因为类只加载一次[演示]
    4.每个类的实例都会记得自己是由哪个Class 实例所生成
    5.通过Class对象可以完整地得到一个类的完整结构,通过一系列API
    6.Class对象是存放在堆的
    7.类的字节码二进制数据，是放在方法区的，有的地方称为类的元数据(包括方法代码, 变量名，方法名，访问权限等等)
     https://www.zhihu.com/question/38496907【示意图】
 */
/**
 * 对Class类特点的梳理
 */
public class Class01 {
    public static void main(String[] args) throws ClassNotFoundException {
        //看看Class类图
        //1. Class也是类，因此也继承Object类
        //Class
        //2. Class类对象不是new出来的，而是系统创建的
        //(1) 传统new对象
        /*  ClassLoader类
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                return loadClass(name, false);
            }
         */
        //Cat cat = new Cat();
        //(2) 反射方式, 刚才没有debug到 ClassLoader类的 loadClass, 原因是，我没有注销Cat cat = new Cat(); 而类只会加载一次，刚刚加载过下面就不会再次加载
        /*
            ClassLoader类, 仍然是通过 ClassLoader类加载Cat类的 Class对象
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                return loadClass(name, false);
            }
         */
        Class cls1 = Class.forName("com.reflection.Cat");

        //3. 对于某个类的Class类对象，在内存中只有一份，因为类只加载一次!!!!!!!!!!
        Class cls2 = Class.forName("com.reflection.Cat");
        System.out.println(cls1.hashCode());
        System.out.println(cls2.hashCode()); // 相等
        Class cls3 = Class.forName("com.reflection.Dog");
        System.out.println(cls3.hashCode());//不相等
    }
}
