package com.oop.centre.super_;

public class A {
    public int n1 = 100;
    protected int n2 = 200;
    int n3 = 300;
    private int n4 = 400;
    public void test100(){}
    protected void test200(){}
    void test300(){}
    private void test400(){}

    public A(){}
    public A(String name){}
    public A(String name,int age){}

    /*
    2、当子类中有和父类中的成员（属性和方法）重名时，为了访问父类的成员，必须通过super
    。如果没有重名，使用super、this、直接访问是一样的效果！
     */
    public void cal(){
        System.out.println("A类的cal() 方法...");
    }
}
