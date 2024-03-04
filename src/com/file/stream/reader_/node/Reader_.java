package com.file.stream.reader_.node;
//节点流可以从一个特定的数据源读写数据，如FileReader、FileWriter
//处理流(也叫包装流)是“连接”在已存在的流（节点流或处理流)之上，为程序提供更为强大的读写功能，也更加灵活,如BufferedReader、BufferedWriter

public abstract class Reader_ {//抽象类
    public void readFile() {
    }
    public void readString() {
    }

    //在Reader_ 抽象类，使用read方法统一管理.
    //后面在调用时，利于对象动态绑定机制， 绑定到对应的实现子类即可.
    //public abstract void read();

    /*
    节点流和处理流的区别和联系
    1、节点流是底层流/低级流,直接跟数据源相接。
    2、处理流(包装流)包装节点流，既可以消除不同节点流的实现差异，也可以提供更方 便的方法来完成输入输出。
    3、处理流(也叫包装流)对节点流进行包装，使用了修饰器设计模式，不会直接与数据 源相连[模拟修饰器设计模式]
 */
}
