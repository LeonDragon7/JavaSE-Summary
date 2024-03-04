package com.collection.set_;

import java.util.LinkedHashSet;
import java.util.Set;

/*
    Set 接口实现类-LinkedHashSet
    LinkedHashSet 的全面说明
    1、LinkedHashSet 是 HashSet的子类
    2、LinkedHashSet 底层是一个 LinkedHashMap，底层维护了一个数组+双向链表
    3、LinkedHashSet根据元素的hashCode值来决定元素的存储位置,同时使 用链表维
    护元素的次序(图),这使得元素看起来是以插入顺序保存的。
    4、LinkedHashSet不允许添重复元素

    说明
    1、在LinkedHastSet中维护了一个hash表和双向链表( LinkedHashSet有 head和tail)
    2、每一个节点有before和after属性,这样可以形成双向链表
    3、在添加一个元素时，先求hash值，在求索引,确定该元素在table 的位置,然后将添加的元素
    加入到双向链表(如果已经存在，不添加[原则和hashset一样])
    tail.next = newElement //示意代码
    newElement.pre = tail
    tail = newEelment;
    4、这样的话，我们遍历LinkedHashSet 也能确保插入顺序和遍历顺序一致
 */
@SuppressWarnings({"all"})
public class LinkedHashSetSource {
    public static void main(String[] args) {
        //分析一下LinkedHashSet的底层机制
        Set set = new LinkedHashSet();
        set.add(new String("AA"));
        set.add(456);
        set.add(456);
        set.add(new Customer("刘", 1001));
        set.add(123);
        set.add("HSP");

        System.out.println("set=" + set);
        //1. LinkedHashSet 加入顺序和取出元素/数据的顺序一致
        //2. LinkedHashSet 底层维护的是一个LinkedHashMap(是HashMap的子类)
        //3. LinkedHashSet 底层结构 (数组table+双向链表)
        //4. 添加第一次时，直接将 数组table 扩容到 16 ,存放的结点类型是 LinkedHashMap$Entry
        //5. 数组是 HashMap$Node[] 存放的元素/数据是 LinkedHashMap$Entry类型
        /*
                //继承关系是在内部类完成.
                static class Entry<K,V> extends HashMap.Node<K,V> {
                    Entry<K,V> before, after;
                    Entry(int hash, K key, V value, Node<K,V> next) {
                        super(hash, key, value, next);
                    }
                }

         */
    }
}
class Customer {
    private String name;
    private int no;

    public Customer(String name, int no) {
        this.name = name;
        this.no = no;
    }
}
