package com.network.udp;

public class Netstat {
    /*
        netstat 指令
        1.netstat -an 可以查看当前主机网络情况，包括端口监听情况和网络连接情况
        2.netstat -an | more 可以分页显示
        3.netstat -anb （在管理员状态下运行）可以查看是哪些应用监听该端口。
        4.外部地址就是 连接 该本地地址和端口号的客户端的IP和端口号。

        说明:
        (1) Listening表示某个端口在监听 Established 表示连接已经建立
        (2)如果有一个外部程序(客户端)连接到该端口，就会显示一条连接信息

        TCP 网络通讯
        1.当客户端连接到服务端后，实际上客户端也是通过一个端口和服务端进行通讯的，这个端口是TCP/IP来分配的，是不确定的，是随机的。（客户端的端口）
        2.程序验证+netstat -an | more
     */
}
