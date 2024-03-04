package com.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
    正则表达式语法
    基本介绍
    如果要想灵活的运用正则表达式,必须了解其中各种元字符的功能，元字符从功能上大致分为:
    1.限定
    2.选择匹配符
    3.分组组合和反向引用符
    4.特殊字符
    5.字符匹配符
    6.定位符

    元字符(Metacharacter)-转义号\\
    符号说明：在我们使用正则表达式去检索某些特殊字符的时候，需要用到转义符号，否则检索不到结果，甚至会报错的。
    再次提示: 在Java的正则表达式中，两个\\代表其他语言中的一个\
 */
public class RegExp02 {
    public static void main(String[] args) {
        /**
         * 演示转义字符的使用
         * 需要用到转义符号的字符有以下:.*+()$/?[] ^{
         */
        String content = "abc$(a.bc(123( )";
        //匹配( => \\(
        //匹配. => \\.
        //String regStr = "\\.";
        //String regStr = "\\d\\d\\d";
        String regStr = "\\d{3}";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()) {
            System.out.println("找到 " + matcher.group(0));
        }
    }
}
