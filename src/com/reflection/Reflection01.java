package com.reflection;

import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

/*
    反射机制
    Java Reflection
    1.反射机制允许程序在执行期借助于 Reflection API 取得任何类的内部信息(比如成员变量，构造器，成员方法等等)，并能操作对象的属性及方法。
    反射在设计模式和框架底层都会用到。
    2.加载完类之后，在堆中就产生了一个Class类型的对象( 一个类只有一个Class对象)，这个对象包含了类的完整结构信息。通过这个对象得到类的结构。
    这个Class对象就像一面镜子,透过这个镜子看到类的结构,所以,形象的称之为：反射。

    类比：
    p对象 ---> 类型Person类
    Class对象cls ---> 类型Class类

    Java 反射机制可以完成
    1.在运行时判断任意一个对象所属的类
    2.在运行时构造任意一个类的对象
    3.在运行时得到任意一个类所具有的成员变量和方法
    4.在运行时调用任意一个对象的成员变量和方法
    5.生成动态代理

    反射相关的主要类
    1.java.lang.Class:代表一个类，Class对象表示某个类加载后在堆中的对象
    2.java.lang.reflect.Method:代表类的方法, Method对象表示某个类的方法
    3.java.lang.reflect.Field:代表类的成员变量,Field对象表示某个类的成员变量
    4.java.lang.reflect.Constructor:代表类的构造方法,Constructor对象表示 构造器
    这些类在java.lang.reflection
 */
@SuppressWarnings({"all"})
public class Reflection01 {
    public static void main(String[] args) throws Exception {

        //1. 使用Properties 类, 可以读写配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\re.properties"));
        String classfullpath = properties.get("classfullpath").toString();//"com.hspedu.Cat"
        String methodName = properties.get("method").toString();//"hi"

        //2. 使用反射机制解决
        //(1) 加载类, 返回Class类型的对象cls
        Class cls = Class.forName(classfullpath);
        //(2) 通过 cls 得到你加载的类 com.reflection.Cat 的对象实例
        Object o = cls.newInstance();
        System.out.println("o的运行类型=" + o.getClass()); //运行类型
        //(3) 通过 cls 得到你加载的类 com.reflection.Cat 的 methodName"hi"  的方法对象
        //    即：在反射中，可以把方法视为对象（万物皆对象）
        Method method1 = cls.getMethod(methodName);
        //(4) 通过method1 调用方法: 即通过方法对象来实现调用方法
        System.out.println("=============================");
        method1.invoke(o); //传统方法 对象.方法() , 反射机制 方法.invoke(对象)

        // java.lang.reflect.Field: 代表类的成员变量, Field对象表示某个类的成员变量
        // getField不能得到私有的属性
        Field nameField = cls.getField("age");
        System.out.println(nameField.get(o)); // 传统写法 对象.成员变量 , 反射: 成员变量对象.get(对象)

        //java.lang.reflect.Constructor: 代表类的构造方法, Constructor对象表示构造器
        //()中可以指定构造器参数类型, 返回无参构造器
        Constructor constructor = cls.getConstructor();
        System.out.println(constructor);//Cat()


        Constructor constructor2 = cls.getConstructor(String.class); //这里老师传入的 String.class 就是String类的Class对象
        System.out.println(constructor2);//Cat(String name)
    }
}
