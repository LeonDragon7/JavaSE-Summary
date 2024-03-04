package com.common.string_;

public class StringTest01 {
    public static void main(String[] args) {
        String a = "abc";
        String b ="abc";
        // equals在string中被重写，逐个比较，相同
        System.out.println(a.equals(b));//T
        System.out.println(a==b); //T
        // 这里指向的是同一个常量池地址，故 == 也相同
    }
}
