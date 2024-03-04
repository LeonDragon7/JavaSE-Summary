package com.common.string_;

public class FoundString {
    /*
        创建String对象的两种方式
        1、方式一: 直接赋值String s = "hspedu";
        2、方式二: 调用构造器 String s = new String("hspedu");

        两种创建String对象的区别
        1、方式一:先从常量池查看是否有"hsp”数据空间,如果有，直接指向;
        如果没有则重新创建,然后指向。s最终指向的是常量池的空间地址。
        2、方式二:先在堆中创建空间，里面维护了value属性，指向常量池的hsp空间。
        如果常量池没有"hsp"，重新创建，如果有，直接通过value指向。最终指向的是
        堆中的空间地址
     */
}
