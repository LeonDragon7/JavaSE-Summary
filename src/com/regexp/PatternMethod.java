package com.regexp;

import java.util.regex.Pattern;

/**
 *  Pattern类 pattern对象是一个正则表达式对象。Pattern类没有公共构造方法。要创建一个 Pattern对象，调用其公共静态方法，它返回一个 Pattern对象。该方法接受一个正则表达式作为它的第一个参数,比如:Pattern r= Pattern.compile(pattern);
 *  演示matches方法，用于整体匹配, 在验证输入的字符串是否满足条件使用
 *  matches由于是整体匹配，所以甚至可以不用定位符^和$。默认就是整体匹配。
 */
public class PatternMethod {
    public static void main(String[] args) {
        String content = "hello abc hello, 教育";
        //String regStr = "hello";
        String regStr = "hello.*";

        boolean matches = Pattern.matches(regStr, content);
        System.out.println("整体匹配= " + matches);
    }
}
