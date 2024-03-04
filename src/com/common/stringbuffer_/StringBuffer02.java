package com.common.stringbuffer_;
/*
    构造方法概要
    1、StringBuffer()
        构造一个没有字符的字符串缓冲区，初始容量为16个字符。
    2、StringBuffer(CharSequence seq)
        构造一个包含与指定的相同字符的字符串缓冲区 CharSequence 。
    3、StringBuffer(int capacity)
        构造一个没有字符的字符串缓冲区和指定的初始容量。
    4、StringBuffer(String str)
        构造一个初始化为指定字符串内容的字符串缓冲区。
 */
public class StringBuffer02 {
    public static void main(String[] args) {
        //构造器的使用
        //1. 创建一个 大小为 16的 char[] ,用于存放字符内容
        StringBuffer stringBuffer = new StringBuffer();

        //2 通过构造器指定 char[] 大小
        StringBuffer stringBuffer1 = new StringBuffer(100);
        //3. 通过 给一个String 创建 StringBuffer, char[] 大小就是 str.length() + 16

        StringBuffer hello = new StringBuffer("hello");
    }
}
