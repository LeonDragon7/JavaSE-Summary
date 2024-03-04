package com.file.stream.reader_;

import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;

/*
    FileReader 相关方法
    1、new FileReader(File/String)
    2、read: 每次读取单个字符，返回该字符，如果到文件末尾返回-1
    3、read(char[]): 批量读取多个字符到数组，返回读取到的字符数，如果到文件未尾返回-1

    相关API:
    1、new String(char[]):将char[]转换成String
    2、new String(char[],off,len):将char[]的指定部分转换成String
 */
public class FileReader_{
    /**
     * 使用FileReader 从story.txt 读取内容，并显示
     * 单个字符读取文件
     */
    @Test
    public void readFile01() {
        String filePath = "e:\\story.txt";
        FileReader fileReader = null;
        int data = 0;
        //1. 创建FileReader对象
        try {
            fileReader = new FileReader(filePath);
            //循环读取 使用read, 单个字符读取
            while ((data = fileReader.read()) != -1) {
                System.out.print((char) data);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 使用FileReader 从story.txt 读取内容，并显示
     * 字符数组读取文件 效率高
     */
    @Test
    public void readFile02() {
        System.out.println("~~~readFile02 ~~~");
        String filePath = "e:\\story.txt";
        FileReader fileReader = null;

        int readLen = 0;
        char[] buf = new char[8];
        //1. 创建FileReader对象
        try {
            fileReader = new FileReader(filePath);
            //循环读取 使用read(buf), 返回的是实际读取到的字符数
            //如果返回-1, 说明到文件结束
            while ((readLen = fileReader.read(buf)) != -1) {
                System.out.print(new String(buf, 0, readLen));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
