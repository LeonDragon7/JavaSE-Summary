package com.oop.centre;
/*
    面向对象编程-多态
    多态注意事项和细节讨论
    属性没有重写之说！属性的值看编译类型
    instanceof比较操作符，用于判断对象的运行类型是否为XX类型或XX类型的子类型
 */
public class PolyDetail02 {
    public static void main(String[] args) {
        //属性没有重写之说！属性的值看编译类型
        Base base = new Sub();//向上转型
        System.out.println(base.count);//10

        //instanceOf比较操作符，用于判断对象的运行类型是否为XX类型或XX类型的子类型
        BB bb = new BB();
        System.out.println(bb instanceof BB);//true
        System.out.println(bb instanceof AA);//true

        AA aa = new BB();
        System.out.println(aa instanceof AA);//true
        System.out.println(aa instanceof BB);//true

        Object obj = new Object();
        System.out.println(obj instanceof AA);//false
        String str = "hello";
        System.out.println(str instanceof Object);//true
    }
}
class Base{
    int count = 10;
}
class Sub extends Base{
    int count = 20;
}

class AA{}
class BB extends AA{}