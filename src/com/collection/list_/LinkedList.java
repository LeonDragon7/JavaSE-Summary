package com.collection.list_;
/*
    LinkedList 底层结构
    LinkedList 的全面说明
    1、LinkedList底层实现了双向链表和双端队列特点
    2、可以添加任意元素(元素可以重复),包括null
    3、线程不安全，没有实现同步

    LinkedList 的底层操作机制
    1、LinkedList底层维护了一个双向链表.
    2、LinkedList中维护了两个属性first和last分别指向首节点和尾节点
    3、每个节点(Node对象)，里面又维护了prev、next、item三个属性，其中通过 prev指向前一个，通过next指向后一个节点。最终实现双向链表.
    4、所以LinkedList的元素的添加和删除，不是通过数组完成的，相对来说效率较高。
    5、模拟一个简单的双向链表

    ArrayList 和LinkedList 比较
    如何选择ArrayList和LinkedList:
    1、如果我们改查的操作多，选择ArrayList
    2、如果我们增删的操作多，选择LinkedList
    3、一般来说，在程序中，80%-90%都是查询，因此大部分情况下会选择ArrayList
    4、在一个项目中，根据业务灵活选择，也可能这样，一个模块使用的是ArrayList,
    另外一个模块是LinkedList,也就是说,要根据业务来进行选择。
 */
public class LinkedList {
    public static void main(String[] args) {
        //模拟一个简单的双向链表

        Node jack = new Node("jack");
        Node tom = new Node("tom");
        Node hsp = new Node("老韩");

        //连接三个结点，形成双向链表
        //jack -> tom -> hsp
        jack.next = tom;
        tom.next = hsp;
        //hsp -> tom -> jack
        hsp.pre = tom;
        tom.pre = jack;

        Node first = jack;//让first引用指向jack,就是双向链表的头结点
        Node last = hsp; //让last引用指向hsp,就是双向链表的尾结点


        //演示，从头到尾进行遍历
        System.out.println("===从头到尾进行遍历===");
        while (true) {
            if(first == null) {
                break;
            }
            //输出first 信息
            System.out.println(first);
            first = first.next;
        }

        //演示，从尾到头的遍历
        System.out.println("====从尾到头的遍历====");
        while (true) {
            if(last == null) {
                break;
            }
            //输出last 信息
            System.out.println(last);
            last = last.pre;
        }

        //演示链表的添加对象/数据，是多么的方便
        //要求，是在 tom --------- 插入一个对象 smith

        //1. 先创建一个 Node 结点，name 就是 smith
        Node smith = new Node("smith");
        //下面就把 smith 加入到双向链表了
        smith.next = hsp;
        smith.pre = tom;
        hsp.pre = smith;
        tom.next = smith;

        //让first 再次指向jack 因为上面已经到最后了
        first = jack;//让first引用指向jack,就是双向链表的头结点

        System.out.println("===从头到尾进行遍历===");
        while (true) {
            if(first == null) {
                break;
            }
            //输出first 信息
            System.out.println(first);
            first = first.next;
        }

        last = hsp; //让last 重新指向最后一个结点
        //演示，从尾到头的遍历
        System.out.println("====从尾到头的遍历====");
        while (true) {
            if(last == null) {
                break;
            }
            //输出last 信息
            System.out.println(last);
            last = last.pre;
        }
    }
}
//定义一个Node 类，Node 对象 表示双向链表的一个结点
class Node {
    public Object item; //真正存放数据
    public Node next; //指向后一个结点
    public Node pre; //指向前一个结点
    public Node(Object name) {
        this.item = name;
    }
    public String toString() {
        return "Node name=" + item;
    }
}
