package com.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 元字符-选择匹配符
 * 在匹配某个字符串的时候是选择性的，即:既可以匹配这个，又可以匹配那个，这时你需要用到选择匹配符号|
 */
public class RegExp04 {
    public static void main(String[] args) {

        String content = "hanshunping 韩 寒冷";
        String regStr = "han|韩|寒";

        Pattern pattern = Pattern.compile(regStr/*, Pattern.CASE_INSENSITIVE*/);
        Matcher matcher = pattern.matcher(content);


        while (matcher.find()) {
            System.out.println("找到 " + matcher.group(0));
        }
    }
}
