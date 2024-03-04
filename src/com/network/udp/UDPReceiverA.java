package com.network.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
/*
    UDP 网络通信编程
    基本介绍
    1.类 DatagramSocket 和 DatagramPacket[数据包/数据报]实现了基于UDP 协议网络程序。
    2.UDP数据报通过数据报套接字DatagramSocket 发送和接收，系统不保证UDP数据报一定能够安全送到目的地，也不能确定什么时候可以抵达。
    3.DatagramPacket 对象封装了UDP数据报，在数据报中包含了发送端的IP地址和 端口号以及接收端的IP地址和端口号。
    4.UDP协议中每个数据报都给出了完整的地址信息，因此无须建立发送方和接收方 的连接

    基本流程
    1.核心的两个类/对象 DatagramSocket与DatagramPacket
    2.建立发送端，接收端(没有服务端和客户端概念)
    3.发送数据前,建立数据包/报 DatagramPacket对象
    4.调用DatagramSocket的发送、接收方法
    5.关闭DatagramSocket
 */

/**
 * 应用案例
 * 1.编写一个接收端A,和一个发送端B
 * 2.接收端 A在 9999端口等待接收数据(receive)
 * 3.发送端B向接收端A发送数据“hello，明天吃火锅~"
 * 4.接收端A接收到发送端B发送的数据，回复"好的,明天见"再退出
 * 5.发送端接收回复的数据,再退出
 */
public class UDPReceiverA {
    public static void main(String[] args) throws IOException {
        //1. 创建一个 DatagramSocket 对象，准备在9999接收数据
        DatagramSocket socket = new DatagramSocket(9999);
        //2. 构建一个 DatagramPacket 对象，准备接收数据
        //   在前面讲解UDP 协议时，老师说过一个数据包最大 64k
        byte[] buf = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        //3. 调用 接收方法, 将通过网络传输的 DatagramPacket 对象
        //   填充到 packet对象
        //提示: 当有数据包发送到 本机的9999端口时，就会接收到数据
        //   如果没有数据包发送到 本机的9999端口, 就会阻塞等待.
        System.out.println("接收端A 等待接收数据..");
        socket.receive(packet);

        //4. 可以把packet 进行拆包，取出数据，并显示.
        int length = packet.getLength();//实际接收到的数据字节长度
        byte[] data = packet.getData();//接收到数据
        String s = new String(data, 0, length);
        System.out.println(s);


        //===回复信息给B端
        //将需要发送的数据，封装到 DatagramPacket对象
        data = "好的, 明天见".getBytes();
        //说明: 封装的 DatagramPacket对象 data 内容字节数组 , data.length , B主机(IP) , B端口
        packet =
                new DatagramPacket(data, data.length, InetAddress.getByName("192.168.12.1"), 9998);

        socket.send(packet);//发送

        //5. 关闭资源
        socket.close();
        System.out.println("A端退出...");

    }
}
