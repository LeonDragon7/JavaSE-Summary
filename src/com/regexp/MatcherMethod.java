package com.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Matcher类 Matcher对象是对输入字符串进行解释和匹配的引擎。与Pattern类一样，Matcher 也没有公共构造方法。你需要调用Pattern对象的matcher方法来获得一个Matcher对象
 * Matcher 类的常用方法
 */
public class MatcherMethod {
    public static void main(String[] args) {
        String content = "hello edu jack hspedutom hello smith hello hspedu hspedu";
        String regStr = "hello";

        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println("=================");
            System.out.println(matcher.start());
            System.out.println(matcher.end());
            System.out.println("找到: " + content.substring(matcher.start(), matcher.end()));
        }

        //整体匹配方法，常用于，去校验某个字符串是否满足某个规则
        System.out.println("整体匹配=" + matcher.matches());

        //完成如果content 有 hspedu 替换成 碳膜闰教育
        regStr = "hspedu";
        pattern = Pattern.compile(regStr);
        matcher = pattern.matcher(content);
        //注意：返回的字符串才是替换后的字符串 原来的 content 不变化
        String newContent = matcher.replaceAll("碳膜闰教育");
        System.out.println("newContent=" + newContent);
        System.out.println("content=" + content);
    }
}
