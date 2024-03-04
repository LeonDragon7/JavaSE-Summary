package com.file.stream.handle;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 演示PrintWriter （字符打印流/输出流）
 * 没有输入流
 */
public class PrintWriter_ {
    public static void main(String[] args) throws IOException {

        //PrintWriter printWriter = new PrintWriter(System.out); // 输出到显示器
        PrintWriter printWriter = new PrintWriter(new FileWriter("e:\\f2.txt"));
        printWriter.print("hi, 北京你好~~~~");
        printWriter.close();//flush + 关闭流, 才会将数据写入到文件..

    }
}
