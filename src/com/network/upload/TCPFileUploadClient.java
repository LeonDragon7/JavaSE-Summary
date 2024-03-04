package com.network.upload;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;

/*
    应用案例4
    1.编写一个文件上传服务端(TCPFileUploadServer),和一个文件上传客户端(TCPFileUploadClient)
    2.服务器端在8888端口监听
    3.客户端连接到服务端,发送一张图片e://qie.png
    4.服务器端接收到客户端发送的图片，保存到src下,发送“收到图片"再退出
    5.客户端接收到服务端发送的“收到图片”，再退出
    6.该程序要求使用StreamUtils.java, 我们直接使用其中封装好的方法。
 */
public class TCPFileUploadClient {
    public static void main(String[] args) throws Exception {

        //客户端连接服务端 8888，得到Socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
        //创建读取磁盘文件的输入流
        //String filePath = "e:\\qie.png";
        String filePath = "e:\\abc.mp4";
        BufferedInputStream bis  = new BufferedInputStream(new FileInputStream(filePath));

        // 把文件读到字符数组中!!!!!
        // bytes 就是filePath对应的字节数组
        byte[] bytes = StreamUtils.streamToByteArray(bis);

        //通过socket获取到输出流, 将bytes数据发送给服务端
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        bos.write(bytes); //将文件对应的字节数组的内容，写入到数据通道
        bis.close();
        socket.shutdownOutput(); //设置写入数据的结束标记

        //=====接收从服务端回复的消息=====

        InputStream inputStream = socket.getInputStream();
        //使用StreamUtils 的方法，直接将 inputStream 读取到的内容 转成字符串
        String s = StreamUtils.streamToString(inputStream);
        System.out.println(s);


        //关闭相关的流
        inputStream.close();
        bos.close();
        socket.close();

    }
}
