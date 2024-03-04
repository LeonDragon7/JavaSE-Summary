package com.oop.advanced.static_;

public class StaticTest02 {
    public static void main(String[] args) {
        Person01.setTotalPerson(3); //调用静态方法 这里没有调用构造器
        new Person01(); // 因为构造器是在创建对象时完成对对象的初始化。 new了之后调用构造器，total++
        Person01.m();// 最后 total的值就是4
    }
}
class Person01 {
    private int id;
    private static int total = 0;
    public static void setTotalPerson(int total){
        // this.total = total;//错误，因为在static方法中，不可以使用this 关键字

        Person01.total = total;
    }
    public Person01() {//构造器
        total++;
        id = total;
    }
    //编写一个方法，输出total的值
    public static void m() {
        System.out.println("total的值=" + total);
    }
}