package com.oop.advanced.codeblock_;

public class CodeBlockTest01 {
}
class Sample
{
    Sample(String s)
    {
        System.out.println(s);
    }
    Sample()
    {
        System.out.println("Sample默认构造函数被调用");
    }
}
class Test{
    Sample sam1=new Sample("sam1成员初始化");//3
    static Sample sam=new Sample("静态成员sam初始化 ");//1
    static{
        System.out.println("static块执行");//2
        if(sam==null)System.out.println("sam is null");
    }
    Test()//构造器
    {
        System.out.println("Test默认构造函数被调用");//4
    }
    //主方法
    public static void  main(String  str[])
    {
        Test a=new Test();//无参构造器
    }
}
/*
1. 静态成员sam 初始化
2. static 块执行
3. sam1 成员初始化
4. Test 默认构造函数被调用
 */