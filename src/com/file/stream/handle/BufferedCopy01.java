package com.file.stream.handle;

import java.io.*;
/*
    BufferedReader 和 BufferedWriter属于字符流，是按照字符来读取数据的
    关闭时处理流，只需要关闭外层流即可（因为真正工作的是内层流，关闭时只需要关闭外层处理流，会自动关闭内层流）【源码】
 */
public class BufferedCopy01 {
    /**
     * 综合使用BufferedReader和 BufferedWriter完成文本文件拷贝，注意文件编码。
     * @param args
     */
    public static void main(String[] args) {
        //1. BufferedReader 和 BufferedWriter 是按照字符操作
        //2. 不要去操作 二进制文件[声音，视频，doc, pdf ], 可能造成文件损坏
        //BufferedInputStream
        //BufferedOutputStream
        String srcFilePath = "e:\\a.java";
        String destFilePath = "e:\\a2.java";
//        String srcFilePath = "e:\\0245_零基础学Java_引出this.avi";
//        String destFilePath = "e:\\a2.avi";
        BufferedReader br = null;
        BufferedWriter bw = null;
        String line;
        try {
            br = new BufferedReader(new FileReader(srcFilePath));
            bw = new BufferedWriter(new FileWriter(destFilePath));

            //说明: readLine 读取一行内容，但是没有换行
            while ((line = br.readLine()) != null) {
                //每读取一行，就写入
                bw.write(line);
                //插入一个换行
                bw.newLine();
            }
            System.out.println("拷贝完毕...");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流
            try {
                if(br != null) {
                    br.close();
                }
                if(bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
