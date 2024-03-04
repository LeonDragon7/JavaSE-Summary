package com.file.stream.node;



import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

/**
 *  InputStream（超类） 常用的子类-FileInputStream（文件输入流）
 */
public class FileInputStream_ {
    /*
    FileInputStream 应用实例
    请使用FileInputStream 读取hello.txt 文件，并将文件内容显示到控制台.
    当然，注意一个汉字通常是由3个bytes构成的，而read只会读取一个byte的数据，因此如果用read则会乱码，建议文本文件用字符流处理。
 */
    /**
     * 演示读取文件...
     * 单个字节的读取，效率比较低
     * -> 使用 read(byte[] b)
     */
    @Test
    public void readFile01() {
        String filePath = "e:\\hello.txt";
        int readData = 0;
        FileInputStream fileInputStream = null;
        try {
            //创建 FileInputStream 对象，用于读取 文件
            fileInputStream = new FileInputStream(filePath);
            //从该输入流读取一个字节的数据。 如果没有输入可用，此方法将阻止。
            //如果返回-1 , 表示读取完毕
            while ((readData = fileInputStream.read()) != -1) {
                System.out.print((char)readData);//转成char显示
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭文件流，释放资源.
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 使用 read(byte[] b) 读取文件，提高效率
     */
    @Test
    public void readFile02() {
        String filePath = "e:\\hello.txt";
        //字节数组
        byte[] buf = new byte[8]; //一次读取8个字节.
        int readLen = 0;
        FileInputStream fileInputStream = null;
        try {
            //创建 FileInputStream 对象，用于读取 文件
            fileInputStream = new FileInputStream(filePath);
            //从该输入流读取最多b.length字节的数据到字节数组。 此方法将阻塞，直到某些输入可用。
            //如果返回-1 , 表示读取完毕
            //如果读取正常, 返回实际读取的字节数
            //new String(buf, 0, readLen):将字节数组内容转换成字符串 字符数组也可以用
            while ((readLen = fileInputStream.read(buf)) != -1) {
                System.out.print(new String(buf, 0, readLen));//显示
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭文件流，释放资源.
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
