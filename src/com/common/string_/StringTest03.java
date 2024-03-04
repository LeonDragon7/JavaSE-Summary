package com.common.string_;

public class StringTest03 {
    public static void main(String[] args) {

    }
}

/**
 * 数组默认情况下是在堆中的，每次调方法都会产生对应的新栈
 */
class Test1 {
    String str = new String("hsp");
    final char[] ch = {'j', 'a', 'v', 'a'};

    public void change(String str, char ch[]) {
        str = "java";
        ch[0] = 'h';
    }

    public static void main(String[] args) {
        Test1 ex = new Test1();
        ex.change(ex.str, ex.ch);
        System.out.print(ex.str + " and ");
        System.out.println(ex.ch);
    }
}


