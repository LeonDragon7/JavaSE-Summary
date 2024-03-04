package com.common.string_;
/*
    String类的常见方法
    说明
    String类是保存字符串常量的。每次更新都需要重新开辟空间，效率较低,因此java设计者还提供了StringBuilder
    和StringBuffer来增强String的功能,并提高效率。
    String类的常见方法一览
    1、equals //区分大小写，判断内容是否相等
    2、equalsIgnoreCase //忽略大小写的判断内容是否相等length/获取字符的个数,字符串的长度
    3、length 获取字符的个数，字符串的长度
    4、indexOf //获取字符在字符串中第1次出现的索引索引从0开始,如果找不到,返回-1
    5、lastIndexOf //获取字符在字符串中最后1次出现的索引,索引从0开始,如找不到,返回-1
    6、substring //截取指定范围的子串
    7、trim //去前后空格
    8、charAt // 获取某索引处的字符, 注意不能使用Str[index]这种方式.
 */
public class StringMethod01 {
    public static void main(String[] args) {
        // 1. equals 前面已经讲过了. 比较内容是否相同，区分大小写
        String str1 = "hello";
        String str2 = "Hello";
        System.out.println(str1.equals(str2));

        // 2.equalsIgnoreCase 忽略大小写的判断内容是否相等
        String username = "johN";
        if ("john".equalsIgnoreCase(username)) {
            System.out.println("Success!");
        } else {
            System.out.println("Failure!");
        }
        // 3.length 获取字符的个数，字符串的长度
        System.out.println("韩顺平".length());
        // 4.indexOf 获取字符在字符串对象中第一次出现的索引，索引从0开始，如果找不到，返回-1
        String s1 = "wer@terwe@g";
        int index = s1.indexOf('@');
        System.out.println(index);// 3
        System.out.println("weIndex=" + s1.indexOf("we"));//0
        // 5.lastIndexOf 获取字符在字符串中最后一次出现的索引，索引从0开始，如果找不到，返回-1
        s1 = "wer@terwe@g@";
        index = s1.lastIndexOf('@');
        System.out.println(index);//11
        System.out.println("ter的位置=" + s1.lastIndexOf("ter"));//4
        // 6.substring 截取指定范围的子串
        String name = "hello,张三";
        // 下面name.substring(6) 从索引6开始截取后面所有的内容
        System.out.println(name.substring(6));//截取后面的字符
        // name.substring(0,5)表示从索引0开始截取，截取到索引5 - 1 = 4位置
        System.out.println(name.substring(2,5));//llo
    }
}
