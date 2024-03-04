package com.oop.centre.tempmodifier;

import com.oop.centre.modifier.A;

public class Test {
    public static void main(String[] args) {
        A a = new A();
        //在不同包下，只能访问公开(public)修饰的属性或方法。
        System.out.println("n1 = " + a.n1 + " n2不能访问(受保护)" + " n3不能访问(默认) " + " n4不能访问(私有)");
    }
}
