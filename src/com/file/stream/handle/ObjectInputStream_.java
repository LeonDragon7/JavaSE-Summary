package com.file.stream.handle;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
/*
    看一个需求：不仅需要保存值，还需要保存数据类型。
    1、将int num = 100这个 int数据保存到文件中,注意不是100 数字，而是int 100，并且，能够从文件中直接恢复int 100
    2、将Dog dog = new Dog(“小黄”，3)这个 dog对象保存到文件中，并且能够从文件恢复.
    3、上面的要求，就是能够将基本数据类型或者对象进行序列化和反序列化操作

    序列化和反序列化
    1、序列化就是在保存数据时，保存数据的值和数据类型
    2、反序列化就是在恢复数据时，恢复数据的值和数据类型
    3、需要让某个对象支持序列化机制，则必须让其类是可序列化的，为了让某个类是可序列化的，该类必须实现如下两个接口之一:
        Serializable //这是一个标记接口,没有方法
        Externalizable //该接口有方法需要实现，因此我们一般实现上面的接口
 */

/**
 * 对象流
 * 使用ObjectInputStream 读取data.dat 并反序列化恢复数据
 * ObjectInputStream 提供反序列化功能
 */
public class ObjectInputStream_ {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        //指定反序列化的文件
        String filePath = "e:\\data.dat";

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath));

        //读取
        //1. 读取(反序列化)的顺序需要和你保存数据(序列化)的顺序一致，因为保存按顺序保存什么样的类型，读取的时候也就要按照相应的类型。
        //2. 否则会出现异常

        System.out.println(ois.readInt());
        System.out.println(ois.readBoolean());

        System.out.println(ois.readChar());
        System.out.println(ois.readDouble());
        System.out.println(ois.readUTF());


        //dog 的编译类型是 Object , dog 的运行类型是 Dog
        Object dog = ois.readObject();
        System.out.println("运行类型=" + dog.getClass());
        System.out.println("dog信息=" + dog);//底层 Object -> Dog

        //这里是特别重要的细节:

        //1. 如果我们希望调用Dog的方法, 需要向下转型
        //2. 需要我们将Dog类的定义，放在到可以引用的位置（在本类下或者同一个包下）
        Dog dog2 = (Dog)dog;
        System.out.println(dog2.getName()); //旺财..

        //关闭流, 关闭外层流即可，底层会关闭 FileInputStream 流
        ois.close();
    }
}
