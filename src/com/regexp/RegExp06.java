package com.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 元字符-定位符
 * 定位符, 规定要匹配的字符串出现的位置，比如在字符串的开始还是在结束的位置，这个也是相当有用的，必须掌握。
 */
public class RegExp06 {
    public static void main(String[] args) {

        String content = "hanshunping sphan nnhan";
        //String content = "123-abc";
        //以至少1个数字开头，后接任意个小写字母的字符串
        //String regStr = "^[0-9]+[a-z]*";
        //以至少1个数字开头, 必须以至少一个小写字母结束
        //String regStr = "^[0-9]+\\-[a-z]+$";

        //表示匹配边界的han[这里的边界是指：被匹配的字符串最后,
        // 也可以是空格的子字符串的后面]
        //String regStr = "han\\b";

        //和\\b的含义刚刚相反
        String regStr = "han\\B";

        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()) {
            System.out.println("找到=" + matcher.group(0));
        }
    }
}
