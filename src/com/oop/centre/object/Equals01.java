package com.oop.centre.object;
/*
    Object类详解
    equals方法
    == 和 equals的对比

    1、== 是一个比较运算符
    1）==：既可以判断基本类型，又可以判断引用类型
    2）==：如果判断基本类型，判断的是值是否相等。实例：int i = 10；double d = 10.0;
    3）==：如果判断引用类型，判断的是地址是否相等，即判断是不是同一个对象

    2、equals方法
    1）equals：是Object类中的方法，只能判断引用类型。
    2）默认判断的是地址是否相等，子类中往往重写该方法，用于判断内容是否相等。
 */
public class Equals01 {
    public static void main(String[] args) {
        //1、==
        A a = new A();
        A b = a;
        A c = b;
        System.out.println(a == c);//true
        B bObj = a;
        System.out.println(bObj == c);//true

        //2、equals方法
        "hello".equals("abc");


        /*
        equalsJDK源码 String类的equals方法
        把Object的equals方法重写了，变成了比较两个字符串的值是否相同
        public boolean equals(Object anObject) {
        if (this == anObject) {//如果是同一个对象
            return true;
        }
        if (anObject instanceof String) {//判断类型
            String anotherString = (String)anObject;//向下转型
            int n = value.length;
            if (n == anotherString.value.length) {//如果长度相同
                char v1[] = value;
                char v2[] = anotherString.value;
                int i = 0;
                while (n-- != 0) {//然后一个一个的比较字符
                    if (v1[i] != v2[i])
                        return false;
                    i++;
                }
                return true;//如果两个字符串的所有字符都相等，则返回true
            }
        }
        return false;//如果比较的不是字符串，则直接返回false
    }
         */
    }
}
class B{}
class A extends B{}
