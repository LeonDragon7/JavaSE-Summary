package com.oop.centre.modifier;

public class B {
    public void say(){
        A a = new A();
        //在同一个包，可以访问public，protected和默认修饰属性或方法，不能访问private
        System.out.println("n1 = " + a.n1 + " n2 = " + a.n2 + " n3 = " + a.n3 + " n4不能访问(私有属性)");
    }
}
