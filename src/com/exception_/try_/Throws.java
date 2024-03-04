package com.exception_.try_;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
/*
    throws 异常处理
    基本介绍
    1、如果一个方法(中的语句执行时)可能生成某种异常，但是并不能确定如何处理这种异常，则此方法应显示地
    声明抛出异常，表明该方法将不对这些异常进行处理，而由该方法的调用者负责处理。
    2、在方法声明中用throws语句可以声明抛出异常的列表,throws后面的异常类型可以是方法中产生的异常类型,
    也可以是它的父类。
 */
public class Throws {
    public static void main(String[] args) {
    }

    public void f2() throws FileNotFoundException,NullPointerException,ArithmeticException {
        //创建了一个文件流对象
        //1. 这里的异常是一个FileNotFoundException 编译异常
        //2. 使用前面讲过的 try-catch-finally
        //3. 使用throws ,抛出异常, 让调用f2方法的调用者(方法)处理
        //4. throws后面的异常类型可以是方法中产生的异常类型，也可以是它的父类(例如 Exception)
        //5. throws 关键字后也可以是 异常列表, 即可以抛出多个异常
        FileInputStream fis = new FileInputStream("d://aa.txt");

    }
}
