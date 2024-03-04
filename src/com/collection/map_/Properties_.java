package com.collection.map_;

import java.util.Properties;

/*
    Map 接口实现类-Properties
    基本介绍
    1、Properties类继承自 Hashtable 类并且实现了Map接口，也是使用一种键值对的形式来保存数据。
    2、他的使用特点和Hashtable类似。
    3、Properties还可以用于从xxx.properties文件中，加载数据到Properties类对象, 并进行读取和修改。
    4、说明:工作后 xxx.properties文件通常作为配置文件，这个知识点在IO流举例,有兴趣可先看文章。
    cnblogs.com/xudong-bupt/p/3758136.html
 */
@SuppressWarnings({"all"})
public class Properties_ {
    public static void main(String[] args) {

        //1. Properties 继承  Hashtable
        //2. 可以通过 k-v 存放数据，当然key 和 value 不能为 null
        //增加
        Properties properties = new Properties();
        //properties.put(null, "abc");//抛出 空指针异常
        //properties.put("abc", null); //抛出 空指针异常
        properties.put("john", 100);//k-v
        properties.put("lucy", 100);
        properties.put("lic", 100);
        properties.put("lic", 88);//如果有相同的key ， value被替换

        System.out.println("properties=" + properties);

        //通过k 获取对应值
        System.out.println(properties.get("lic"));//88
        System.out.println(properties.getProperty("lic"));

        //删除
        properties.remove("lic");
        System.out.println("properties=" + properties);

        //修改
        properties.put("john", "约翰");
        System.out.println("properties=" + properties);
    }
}
