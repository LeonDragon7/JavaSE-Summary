package com.file.stream.reader_.node;
/*
    处理流的功能主要体现在以下两个方面
    1、性能的提高:主要以增加缓冲的方式来提高输入输出的效率。
    2、操作的便捷:处理流可能提供了一系列便捷的方法来一次输入输出大批量的数据,使用更加灵活方便。
 */
/**
 * 做成处理流/包装流
 */
public class BufferedReader_ extends Reader_ {
    private Reader_ reader_; //属性是 Reader_类型

    //接收Reader_ 子类对象
    public BufferedReader_(Reader_ reader_) {
        this.reader_ = reader_;
    }

    public void readFile() { //封装一层
        reader_.readFile();
    }

    //让方法更加灵活， 多次读取文件, 或者加缓冲byte[] ....
    public void readFiles(int num) {
        for(int i = 0; i < num; i++) {
            reader_.readFile();
        }
    }

    //扩展 readString, 批量处理字符串数据
    public void readStrings(int num) {
        for(int i = 0; i <num; i++) {
            reader_.readString();
        }
    }
}
class Test{
    public static void main(String[] args) {
        BufferedReader_ bufferedReader_ = new BufferedReader_(new FileReader_());
        bufferedReader_.readFiles(10);
        //bufferedReader_.readFile();
        //Serializable
        //Externalizable
        //ObjectInputStream
        //ObjectOutputStream
        //这次希望通过 BufferedReader_ 多次读取字符串
        BufferedReader_ bufferedReader_2 = new BufferedReader_(new StringReader_());
        bufferedReader_2.readStrings(5);
    }
}
