package com.exception_;
/*
    自定义异常
    基本概念
    当程序中出现了某些“错误”，但该错误信息并没有在 Throwable 子类中描述处理，
    这个时候可以自己设计异常类,用于描述该错误信息。

    自定义异常的步骤
    1、定义类:自定义异常类名(程序员自己写)继承Exception或RuntimeException
        · 如果继承Exception，属于编译异常
        · 如果继承RuntimeException，属于运行异常(一般来说,继承RuntimeException)
 */
public class CustomException_ {
    // 方法声明处，throws 异常
    public static void main(String[] args) /*throws AgeException*/ {
        /**
         * 当我们接收Person对象年龄时，要求范围在18-120之间,否则抛出一个自定义异常
         * (要求继承RuntimeException)，并给出提示信息。
         */
        int age = 180;
        //要求范围在 18 – 120 之间，否则抛出一个自定义异常
        if(!(age >= 18 && age <= 120)) {
            //这里我们可以通过构造器，设置信息
            // 在方法体中，这里 throw 对象
            throw new AgeException("年龄需要在 18~120之间");
        }
        System.out.println("你的年龄范围正确.");
    }
}
// 自定义一个异常
// 1. 一般情况下，我们自定义异常是继承 RuntimeException
// 2. 即把自定义异常做成 运行时异常，好处是我们可以使用默认的处理机制，即自动向上throws异常，否则main中也得加throws。
class AgeException extends RuntimeException {
    public AgeException(String message) {//构造器
        super(message); // 调用父构造器，可以进入源码逐级查看。
    }
}
