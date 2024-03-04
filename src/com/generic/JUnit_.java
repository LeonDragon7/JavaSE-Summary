package com.generic;

import org.junit.Test;

/*
    JUnit
    1、一个类有很多功能代码需要测试，为了测试，就需要写入到main方法中
    2、如果有多个功能代码测试，就需要来回注销,切换很麻烦
    3、如果可以直接运行一个方法，就方便很多，并且可以给出相关信息，就好了，可以用 JUnit 测试框架

    JUnit是一个Java语言的单元测试框架
    多数Java的开发环境都已经集成了JUnit作为单元测试的工具，不用直接在main中实例对象再调用方法了，可以直接单独执行方法。
    使用方法：先写 @Test ，然后 Alt + Enter 从Maven 添加 Junit 即可。
 */
public class JUnit_ {
    public static void main(String[] args) {
        //传统方式
        //new JUnit_().m1();
        //new JUnit_().m2();
    }
    @Test
    public void m1() {
        System.out.println("m1方法被调用");
    }

    @Test
    public void m2() {
        System.out.println("m2方法被调用");
    }

    @Test
    public void m3() {
        System.out.println("m3方法被调用");
    }
}
