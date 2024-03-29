package com.collection.map_;

import java.util.Hashtable;

/*
    Map 接口实现类-Hashtable
    HashTable 的基本介绍
    1、存放的元素是键值对:即K-V
    2、hashtable的键和值都不能为null，否则会抛出NullPointerException
    3、hashTable使用方法基本上和HashMap一样
    4、hashTable是线程安全的(synchronized), hashMap是线程不安全的
 */
@SuppressWarnings({"all"})
public class HashTable_ {
    public static void main(String[] args) {
        Hashtable table = new Hashtable();//ok
        table.put("john", 100); //ok
        //table.put(null, 100); //异常 NullPointerException
        //table.put("john", null);//异常 NullPointerException
        table.put("lucy", 100);//ok
        table.put("lic", 100);//ok
        table.put("lic", 88);//替换
        table.put("hello1", 1);
        table.put("hello2", 1);
        table.put("hello3", 1);
        table.put("hello4", 1);
        table.put("hello5", 1);
        table.put("hello6", 1);
        System.out.println(table);

        //简单说明一下Hashtable的底层
        //1. 底层有数组 Hashtable$Entry[] 初始化大小为 11
        //2. 临界值 threshold 8 = 11 * 0.75
        //3. 扩容:
        //4. 执行 方法 addEntry(hash, key, value, index); 添加K-V 封装到Entry
        //5. 当 if (count >= threshold) 满足时，就进行扩容
        //5. 按照 int newCapacity = (oldCapacity << 1) + 1; 的大小扩容. 两倍加一
    }
}
