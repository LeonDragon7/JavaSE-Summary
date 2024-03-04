package com.collection.map_;
/*
    Map 接口实现类-HashMap
    HashMap 小结
    1、Map接口的常用实现类:HashMap、Hashtable和Properties。
    2、HashMap是 Map 接口使用频率最高的实现类。
    3、HashMap 是以key-val对的方式来存储数据(HashMap$Node类型)[案例Entry ]
    4、key不能重复，但是值可以重复,允许使用null键和null值。
    5、如果添加相同的key，则会覆盖原来的key-val ,等同于修改.(key不会替换，val会替换)
    6、与HashSet一样，不保证映射的顺序，因为底层是以hash表的方式来存储的. (jdk8的hashMap底层数组+链表+红黑树)
    7、HashMap没有实现同步，因此是线程不安全的,方法没有做同步互斥的操作,没有synchronized
 */
public class HashMap_ {

}
