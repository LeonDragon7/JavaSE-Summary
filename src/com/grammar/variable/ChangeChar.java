package com.grammar.variable;

public class ChangeChar {
    public static void main(String[] args) {
        // \t:一个制表位，实现对齐的功能
        System.out.println("北京\t天津\t上海");

        // \n:换行符
        System.out.println("jack\nsmitch\nmary");

        // \\:一个\ \\\\:两个\\

        System.out.println("D:\\BackEnd\\Java\\JavaSE\\\\Item");

        // \":一个"
        System.out.println("\"java是世界上最好的语言\"");

        // \':一个'
        System.out.println("\'java是世界上最好的语言\'");

        // \r:一个回车
        System.out.println("xxxx是我\r帅哥");//帅哥是我上
    }
}
