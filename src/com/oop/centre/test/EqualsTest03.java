package com.oop.centre.test;

public class EqualsTest03 {
    public static void main(String[] args) {
        int it = 65;
        float fl = 65.0f;
        System.out.println("65和65.0f是否相等？" + (it == fl));//true
        char ch1 = 'A';
        char ch2 = 12;
        System.out.println("65和'A'是否相等？" + (it == ch1));//true
        System.out.println("65和'A'是否相等？" + (12 == ch2));//true

        String str1 = new String("hello");
        String str2 = new String("hello");
        System.out.println("str1和str2是否相等？" + (str1 == str2));//false
        System.out.println("str1是否equals str2？" + (str1.equals(str2)));//true
        //System.out.println("hello" == new java.sql.Date());编译错误
    }
}
