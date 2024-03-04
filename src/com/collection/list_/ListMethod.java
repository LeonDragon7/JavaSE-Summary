package com.collection.list_;

import java.util.ArrayList;
import java.util.List;

/*
    List 接口和常用方法
    List 接口基本介绍
    List 接口是 Collection接口的子接口
    1、List集合类中元素有序(即添加顺序和取出顺序一致)、且可重复
    2、List集合中的每个元素都有其对应的顺序索引，即支持索引。
    3、List容器中的元素都对应一个整数型的序号记载其在容器中的位置，可以根据序号存取容器中的元素。
    4、JDK API中List接口的实现类有很多：
    AbstractList、AbstractSequentialList、ArrayList...

    List 接口的常用方法
    这部分方法是List独有的，set用不了。
    1、void add(int index, Object ele):在index位置插入ele元素
    2、boolean addAll(int index, Collection eles):从index位置开始将eles中的所有元素添加进来
    3、Object get(int index):获取指定index位置的元素
    4、int indexOf(Object obj):返回obj在集合中首次出现的位置
    5、int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置
    6、Object remove(int index):移除指定index位置的元素，并返回此元素
    7、Object set(int index, Object ele):设置指定index位置的元素为ele , 相当于是替换.
    8、List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex位置的子集合。（fromIndex <= subList < toIndex）
 */
public class ListMethod {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("张三丰");
        list.add("贾宝玉");
//        void add(int index, Object ele):在index位置插入ele元素
        //在index = 1的位置插入一个对象（index 从0开始）
        list.add(1, "韩顺平");
        System.out.println("list=" + list);
//        boolean addAll(int index, Collection eles):从index位置开始将eles中的所有元素添加进来
        List list2 = new ArrayList();
        list2.add("jack");
        list2.add("tom");
        list.addAll(1, list2);
        System.out.println("list=" + list);
//        Object get(int index):获取指定index位置的元素
        //说过
//        int indexOf(Object obj):返回obj在集合中首次出现的位置
        System.out.println(list.indexOf("tom"));//2
//        int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置
        list.add("韩顺平");
        System.out.println("list=" + list);
        System.out.println(list.lastIndexOf("韩顺平"));
//        Object remove(int index):移除指定index位置的元素，并返回此元素
        list.remove(0);
        System.out.println("list=" + list);
//        Object set(int index, Object ele):设置指定index位置的元素为ele , 相当于是替换.
        list.set(1, "玛丽");
        System.out.println("list=" + list);
//        List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex位置的子集合
        // 注意返回的子集合 fromIndex <= subList < toIndex
        List returnlist = list.subList(0, 2);
        System.out.println("returnlist=" + returnlist);
    }
}
