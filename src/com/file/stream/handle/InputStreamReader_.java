package com.file.stream.handle;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 转换流InputStreamReader
 * 文件乱码问题，引出学习转换流必要性。
 * 可以这么理解：相当于把InputStream转为Reader
 *
 * 1、InputStreamReader:Reader的子类，可以将InputStream(字节流)包装成(转换)Reader(字符流)
 * 2、当处理纯文本数据时，如果使用字符流效率更高，并且可以有效解决中文 问题,所以建议将字节流转换成字符流。
 * 3、可以在使用时指定编码格式(比如utf-8, gbk , gb2312,ISO8859-1等)
 */
public class InputStreamReader_ {
    /*
    应用案例
    1.编程将字节流FileInputStream包装成(转换成)字符流InputStreamReader,对 文件进行读取(按照utf-8/gbk格式),
    进而包装成 BufferedReader
     */
    public static void main(String[] args) throws IOException {

        String filePath = "e:\\a.txt";
        //解读
        //1. 把 FileInputStream 转成 InputStreamReader
        //2. 指定编码 gbk
        //InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath), "gbk");
        //3. 把 InputStreamReader 传入 BufferedReader
        //BufferedReader br = new BufferedReader(isr);

        //将2 和 3 合在一起
        BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(filePath), "gbk"));

        //4. 读取
        String s = br.readLine();
        System.out.println("读取内容=" + s);
        //5. 关闭外层流
        br.close();
    }
}
