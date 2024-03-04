package com.oop.up.test;

public class ObjectOriTest12 {
    public static void main(String[] args) {
        /*
        12.创建一个Employee类，属性有(名字，性别，年龄，职位，薪水)，提供3个构造
        方法，可以初始化
        （1）（名字，性别，年龄，职位，薪水）
        （2）（名字，性别，年龄）
        （3）（职位，薪水），要求充分复用构造器
         */
    }
}
class Employee{
    String name;
    char gender;
    int age;
    String job;
    double sal;
    //因为要求可以复用构造器，因此需要先写属性少的构造器
    public Employee(String job,double sal){
        this.job = job;
        this.sal = sal;
    }
    public Employee(String name,char gender,int age){
        this.name = name;
        this.gender = gender;
        this.age = age;
    }
    public Employee(String name,char gender,int age,String job,double sal){
        //复用
        this(name,gender,age);
        this.job = job;
        this.sal = sal;
        //为啥不能写this(job,sal);,因为在构造器中调用构造器只能写在第一行的语句
    }

}
