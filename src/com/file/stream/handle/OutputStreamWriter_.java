package com.file.stream.handle;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * 转换流OutputStreamWriter
 * 文件乱码问题，引出学习转换流必要性。
 * 可以这么理解：相当于把OutputStream转为Writer
 *
 * 1、OutputStreamWriter:Writer的子类，实现将OutputStream(字节流) 包装成Writer(字符流)
 * 2、当处理纯文本数据时，如果使用字符流效率更高，并且可以有效解决中文 问题,所以建议将字节流转换成字符流。
 * 3、可以在使用时指定编码格式(比如utf-8, gbk , gb2312,ISO8859-1等)
 */
public class OutputStreamWriter_ {
    /*
        2、编程将字节流 FileOutputStream包装成(转换成)字符流OutputStreamWriter,对文件进行写入
        (按照gbk格式,可以指定其他，比如utf-8)
     */
    public static void main(String[] args) throws IOException {
        String filePath = "e:\\hsp.txt";
        String charSet = "utf-8";
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(filePath), charSet);
        osw.write("hi, 教育");
        osw.close();
        System.out.println("按照 " + charSet + " 保存文件成功~");
    }
}
