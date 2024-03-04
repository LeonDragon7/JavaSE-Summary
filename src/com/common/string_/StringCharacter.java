package com.common.string_;

public class StringCharacter {
    /*
        字符串的特性
        说明
        1、String是一个final类，代表不可变的字符序列
        2、字符串是不可变的。一个字符串对象一旦被分配，其内容是不可变的.

        例：以下语句创建了几个对象?
        String s1 = "hello";
        s1 = "haha"; //创建了2个对象，从指向hello变为了指向haha（而不是修改hello为haha）

        面试题
        1)题1
        String a ="hello" +"abc";
        创建了几个对象?只有1个对象 String a = "hello"+"abc"; ==> 优化等价 String a = "helloabc";
        分析：编译器不傻，做一个优化，判断创建的常量池对象，是否有引用指向。

        2)题2
        String a ="hello";//创建a对象 常量池
        String b ="abc";//创建b对象 常量池
        String c = a + b;堆->常量池 "helloabc"
        创建了几个对象?一共有3对象
        底层是:
        1、StringBuilder sb = new StringBuilder();
        2、执行sb.append(a);
        3、执行sb.append(b);
        sb是在堆中，并且append是在原来字符串的基础上追加的。
        4、String c = sb.toString();
        最后其实是c指向堆中的对象(String) value[] -> 池中 "helloabc"
        重要规则：String c1 = "ab" + "cd";常量相加，看的是池。String c1 = a+b;变量相加,是在堆中
     */
}
