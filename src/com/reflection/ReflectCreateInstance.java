package com.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
/*
    通过反射创建对象
    1.方式一:调用类中的public修饰的无参构造器
    2.方式二:调用类中的指定构造器
    3.Class类相关方法
        · newInstance:调用类中的无参构造器,获取对应类的对象
        · getConstructor(Class..clazz):根据参数列表，获取对应的public构造器对象
        · getDecalaredConstructor(Class..clazz):根据参数列表，获取对应的所有构造器对象
    4.Constructor类相关方法
    · setAccessible:暴破 （使用反射可以访问private构造器/方法/属性, 反射面前，都是纸老虎）
    constructor1.setAccessible(true);
    · newInstance(Object...obj):调用构造器
 */
/**
 * 演示通过反射机制创建实例
 * 测试1：通过反射创建某类的对象，要求该类中必须有public 的无参构造
 * 测试2：通过调用某个特定构造器的方式，实现创建某类的对象
 */
public class ReflectCreateInstance {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        //1. 先获取到User类的Class对象
        Class<?> userClass = Class.forName("com.reflection.User");
        //2. 通过public的无参构造器创建实例
        Object o = userClass.newInstance();
        System.out.println(o);
        //3. 通过public的有参构造器创建实例
        /*
            constructor 对象就是
            public User(String name) {//public的有参构造器
                this.name = name;
            }
         */
        //3.1 先得到对应public构造器
        Constructor<?> constructor = userClass.getConstructor(String.class);
        //3.2 创建实例，并传入实参
        Object com = constructor.newInstance("com");
        System.out.println("com=" + com);

        //4. 通过非public的有参构造器创建实例
        //4.1 得到private的构造器对象
        Constructor<?> constructor1 = userClass.getDeclaredConstructor(int.class, String.class);
        //4.2 创建实例
        //暴破【暴力破解】 , 使用反射可以访问private构造器/方法/属性, 反射面前，都是纸老虎
        constructor1.setAccessible(true);

        Object user2 = constructor1.newInstance(100, "张三丰");
        System.out.println("user2=" + user2);
    }
}
class User { //User类
    private int age = 10;
    private String name = "教育";

    public User() {//无参 public
    }

    public User(String name) {//public的有参构造器
        this.name = name;
    }

    private User(int age, String name) {//private 有参构造器
        this.age = age;
        this.name = name;
    }

    public String toString() {
        return "User [age=" + age + ", name=" + name + "]";
    }
}