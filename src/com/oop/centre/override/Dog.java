package com.oop.centre.override;

public class Dog extends Animal{
    /*
    1、因为Dog是Animal子类
    2、Dog的cry方法和Animal的cry定义形式一样（名称、返回类型、参数）
    3、Dog的cry方法，重写了Animal的cry方法
     */
    public void cry(){
        System.out.println("小狗汪汪叫。");
    }
}
