package com.common.string_;

public class StringTest02 {
    public static void main(String[] args) {
        String a = "hsp"; //a 指向 常量池的 “hsp”
        String b =new String("hsp");//b 指向堆中对象
        System.out.println(a.equals(b)); //T
        System.out.println(a==b); //F
        //b.intern() 方法返回常量池地址
        System.out.println(a==b.intern()); //T intern方法查看API
        System.out.println(b==b.intern()); //F
        // b 指向的是堆地址，b.intern 返回的是常量池地址
        /*
        当调用intern方法时，如果池已经包含一个等于此 String对象的字符串(用equals(Object)方法确定)，
        则返回池中的字符串。否则，将此String 对象添加到池中，并返回此 String对象的引用
         */
    }
}
