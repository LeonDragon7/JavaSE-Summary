package com.exception_;
/*
    异常Exception
    基本概念
    Java语言中，将程序执行中发生的不正常情况称为“异常”。(开发过程中的语法错误和逻辑错误不是异常)
    执行过程中所发生的异常事件可分为两大类：
    1.Error(错误):Java虚拟机无法解决的严重问题。如:JVM系统内部错误、资源耗尽等严重情况。
    比如: StackOverflowError[栈溢出] 和 OOM(out of memory).
        Error是严重错误,程序会崩溃。
    2.Exception:其它因编程错误或偶然的外在因素导致的一般性问题，可以使用针对性的代码进行处理。
    例如空指针访问，试图读取不存在的文件，网络连接中断等等，Exception分为两大类:
        · 运行时异常[程序运行时，发生的异常]
        · 编译时异常[编程时,编译器检查出的异常]
 */
public class Exception01 {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 0;//Scanner();
        //2. 当执行到 num1 / num2 因为 num2 = 0, 程序就会出现(抛出)异常 ArithmeticException
        //3. 当抛出异常后，程序就退出，崩溃了, 下面的代码就不再执行
        //4. 不应该出现了一个不算致命的问题就导致整个系统崩溃
        //5. java 设计者，提供了一个叫异常处理机制来解决该问题
        //如果程序员，认为一段代码可能出现异常/问题，可以使用try-catch异常处理机制来解决，从而保证程序的健壮性
        //将该代码块->选中->快捷键 ctrl + alt + t -> 选中 try-catch
        //6. 如果进行异常处理，那么即使出现了异常，程序可以继续执行
        try {
            int res = num1 / num2;
        }catch (Exception e){
            //e.printStackTrace();
            System.out.println("出现异常的原因=" + e.getMessage());//输出异常信息
        }
        System.out.println("程序继续运行....");
    }
}
