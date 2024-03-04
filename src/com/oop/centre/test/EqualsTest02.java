package com.oop.centre.test;

public class EqualsTest02 {
    public static void main(String[] args) {
        Person02 p1 = new Person02();
        p1.name = "hspedu";

        Person02 p2 = new Person02();
        p2.name = "hspedu";

        System.out.println(p1 == p2);//false
        System.out.println(p1.name.equals(p2.name));//true
        System.out.println(p1.equals(p2));//false

        String s1 = new String("asdf");

        String s2 = new String("asdf");
        System.out.println(s1.equals(s2));//true
        System.out.println(s1 == s2);//false
    }
}
class Person02{
    public String name;
}