package com.file.stream.handle;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
/**
 * 对象流
 * 使用ObjectOutputStream序列化基本数据类型和一个Dog对象(name, age),并 保存到data.dat文件中。
 * ObjectOutputStream 提供序列化功能
 */
public class ObjectOutStream_ {
    public static void main(String[] args) throws Exception {
        //序列化后，保存的文件格式，不是存文本，而是按照他的格式来保存
        String filePath = "e:\\data.dat";

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));

        //序列化数据到 e:\data.dat
        oos.writeInt(100);// int -> Integer (Integer 实现了 Serializable)
        oos.writeBoolean(true);// boolean -> Boolean (实现了 Serializable)
        oos.writeChar('a');// char -> Character (实现了 Serializable)
        oos.writeDouble(9.5);// double -> Double (实现了 Serializable)
        oos.writeUTF("教育");//String
        //保存一个dog对象 因为Dog没有实现Serializable 所以要手动实现
        oos.writeObject(new Dog("旺财", 10, "日本", "白色"));
        oos.close();
        System.out.println("数据保存完毕(序列化形式)");
    }
}
/*
    注意事项和细节说明
    1、读写顺序要一致。
    2、要求序列化或反序列化对象，需要实现Serializable。
    3、序列化的类中建议添加SerialVersionUID，为了提高版本的兼容性。当加入新属性时，序列化和反序列化会认为是原来的修改版，而不会认为是一个全新的类。
        private static final long serialVersionUID = 1L;
    4、序列化对象时，默认将里面所有属性都进行序列化，但除了static或transient修饰的成员。也就是序列化并不保存static或transient修饰的信息。
    5、序列化对象时，要求里面属性的类型也需要实现序列化接口。
    6、序列化具备可继承性，也就是如果某类已经实现了序列化，则它的所有子类也已经默认实现了序列化。
 */