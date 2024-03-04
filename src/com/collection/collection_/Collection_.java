package com.collection.collection_;

import java.util.ArrayList;
import java.util.HashMap;

/*
    集合的理解和好处
    前面我们保存多个数据使用的是数组，那么数组有不足的地方，我们分析一下
    数组
    1)长度开始时必须指定，而且一旦指定，不能更改
    2)保存的必须为同一类型的元素
    3)使用数组进行增加/删除元素比较麻烦
    eg: 写出Person数组扩容示意代码:
    Person[] pers = new Person[1]; //大小是1
    per[0] = new Person();
    //增加新的Person对象?
    Person[] pers2 = new Person[pers.length+1];//新创建数组
    for(){} //拷贝pers数组的元素到per2
    pers2[pers2.length-1] = new Person()://添加新的对象

    集合
    1)可以动态保存任意多个对象，使用比较方便
    2)提供了一系列方便的操作对象的方法: add、remove、set、get 等
    3)使用集合添加/删除新元素简洁了

    集合的框架体系
    1、集合主要是两组(单列集合, 双列集合)
    2、Collection 接口有两个重要的子接口List Set , 他们的实现子类都是单列集合 （单列数据）
    3、Map 接口的实现子类是双列集合，存放的K-V （双列数据）
 */
public class Collection_ {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        //Collection
        //Map
        ArrayList arrayList = new ArrayList();
        arrayList.add("jack");
        arrayList.add("tom");

        HashMap hashMap = new HashMap();
        hashMap.put("NO1", "北京");
        hashMap.put("NO2", "上海");
    }
}
