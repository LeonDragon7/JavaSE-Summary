package com.collection.collection_;

import java.util.ArrayList;
import java.util.List;

/*
    Collection 接口和常用方法
    Collection 接口实现类的特点:
    public interface Collection <E> extends Iterable <E>
    1、collection实现子类可以存放多个元素，每个元素可以是Object
    2、有些Collection的实现类,可以存放重复的元素,有些不可以
    3、有些Collection的实现类，有些是有序的(List)，有些不是有序(Set)
    4、Collection接口没有直接的实现子类，是通过它的子接口 Set 和 List 来实现的

 */
public class CollectionMethod {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        List list = new ArrayList();
//        add:添加单个元素
        list.add("jack");
        list.add(10);//list.add(new Integer(10)) 本质是对象
        list.add(true);
        System.out.println("list=" + list);
//        remove:删除指定元素
        list.remove(0);//删除第一个元素 返回boolen
        list.remove(true);//指定删除某个元素 返回该obj
        System.out.println("list=" + list);
//        contains:查找元素是否存在
        System.out.println(list.contains("jack"));//T
//        size:获取元素个数
        System.out.println(list.size());//2
//        isEmpty:判断是否为空
        System.out.println(list.isEmpty());//F
//        clear:清空
        list.clear();
        System.out.println("list=" + list);
//        addAll:添加多个元素
        ArrayList list2 = new ArrayList();
        list2.add("红楼梦");
        list2.add("三国演义");
        list.addAll(list2);
        System.out.println("list=" + list);
//        containsAll:查找多个元素是否都存在
        System.out.println(list.containsAll(list2));//T
//        removeAll：删除多个元素
        list.add("聊斋");
        list2.add("时间是金");
        list.removeAll(list2);
        System.out.println("list=" + list);//[聊斋]
//        说明：以ArrayList实现类来演示.
    }
}
