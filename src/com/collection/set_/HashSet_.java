package com.collection.set_;

import java.util.HashSet;
import java.util.Set;

/*
    Set 接口实现类-HashSet
    HashSet 的全面说明
    1、HashSet实现了Set接口
    2、HashSet实际上是HashMap,看下源码
    public Hashset() {
	    map = new HashMap<>();
    }
    3、可以存放null值，但是只能有一个null
    4、HashSet不保证元素是有序的,取决于hash后，再确定索引的结果。
    (即，不保证存放元素的顺序和取出顺序一致)
    5、不能有重复元素/对象，在前面Set 接口使用已经讲过。
 */
@SuppressWarnings({"all"})
public class HashSet_ {
    public static void main(String[] args) {
        //1. 构造器走的源码
        /*
            public HashSet() {
                map = new HashMap<>();
            }
         2. HashSet 可以存放null ,但是只能有一个null,即元素不能重复
         */
        Set hashSet = new HashSet();
        hashSet.add(null);
        hashSet.add(null);
        System.out.println("hashSet=" + hashSet);
    }
}
