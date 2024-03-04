package com.exception_;

/**
 * NullPointerException 空指针异常
 * 当应用程序试图在需要对象的地方使用null 时，抛出该异常。
 */
public class NullPointerException_ {
    public static void main(String[] args) {
        String name = null; // 空指针出现异常
        System.out.println(name.length());
    }
}
