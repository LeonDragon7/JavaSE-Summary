package com.network.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
/*
    Socket
    基本介绍
    1.套接字(Socket)开发网络应用程序被广泛采用，以至于成为事实上的标准。
    2.通信的两端都要有Socket，是两台机器间通信的端点。
    3.网络通信其实就是Socket间的通信。
    4.Socket允许程序把网络连接当成一个流，数据在两个Socket间通过IO传输。
    5.一般主动发起通信的应用程序属客户端,等待通信请求的为服务端。

    TCP 网络通信编程
    基本介绍
    1.基于客户端—服务端的网络通信
    2.底层使用的是TCP/IP协议
    3.应用场景举例: 客户端发送数据，服务端接受并显示控制台
    4.基于Socket的TCP编程
    最后需要关闭socket，不然链接太多会出现问题。
 */

/**
 * 应用案例1(使用字节流)
 * 1.编写一个服务器端(SocketTCP01Server),和一个客户端(SocketTCP01Client)
 * 2.服务器端在9999端口监听
 * 3.客户端连接到服务器端,发送"hello, server"，然后退出
 * 4.服务器端接收到客户端发送的信息，输出，并退出
 * ServerSocket 可以通过 accept() 返回多个Socket[多个客户端连接服务器的并发]
 */
public class SocketTCP01Client {
    public static void main(String[] args) throws IOException {
        //思路
        //1. 连接服务端 (ip , 端口）
        //解读: 连接InetAddress.getLocalHost();(本机)的 9999端口, 如果连接成功，返回Socket对象
        // 如果链接网络，第一个参数可以改为IP
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端 socket返回=" + socket.getClass());
        //2. 连接上后，生成Socket, 通过socket.getOutputStream()
        //   得到 和 socket对象关联的输出流对象
        OutputStream outputStream = socket.getOutputStream();
        //3. 通过输出流，写入数据到 数据通道
        outputStream.write("hello, server".getBytes());//字符串转换为字符数组
        //4. 关闭流对象和socket, 必须关闭
        outputStream.close();
        socket.close();
        System.out.println("客户端退出.....");
    }
}
