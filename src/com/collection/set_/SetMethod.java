package com.collection.set_;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
    Set 接口和常用方法
    Set 接口基本介绍
    1、无序（添加和取出的顺序不一致)，没有索引
    2、不允许重复元素,所以最多包含一个null
    3、JDK API中Set接口的实现类有:
    AbstractSet、ConcurrentHashMap.KeySetView....

    Set 接口的常用方法
    和List 接口一样, Set 接口也是Collection 的子接口，因此，常用方法和Collection 接口一样.

    Set 接口的遍历方式
    同Collection的遍历方式一样，因为Set接口是Collection接口的子接口。
    1、可以使用迭代器
    2、增强for
    3、不能使用索引的方式来获取
 */
@SuppressWarnings({"all"})
public class SetMethod {
    public static void main(String[] args) {
        //1. 以Set 接口的实现类 HashSet 来讲解Set 接口的方法
        //2. set 接口的实现类的对象(Set接口对象), 不能存放重复的元素, 可以添加一个null
        //3. set 接口对象存放数据是无序(即添加的顺序和取出的顺序不一致)
        //4. 注意：取出的顺序的顺序虽然不是添加的顺序，但是他的固定.
        Set set = new HashSet();
        set.add("john");
        set.add("lucy");
        set.add("john");//重复
        set.add("jack");
        set.add("hsp");
        set.add("mary");
        set.add(null);//
        set.add(null);//再次添加null
        for(int i = 0; i <10;i ++) {
            System.out.println("set=" + set);
        }

        //遍历
        //方式1： 使用迭代器
        System.out.println("=====使用迭代器====");
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object obj =  iterator.next();
            System.out.println("obj=" + obj);

        }

        set.remove(null);

        //方式2: 增强for
        System.out.println("=====增强for====");
        for (Object o : set) {
            System.out.println("o=" + o);
        }

        //set 接口对象，不能通过索引来获取
    }
}
