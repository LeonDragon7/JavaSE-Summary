package com.qq.qqclient.service;

import com.qq.qqcommon.Message;
import com.qq.qqcommon.MessageType;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

//为啥需要线程？
//主要原因是：（非阻塞 或 异步操作）
// 1.避免阻塞主线程。Socket通信通常设计网络连接，而网络连接操作可能会导致阻塞，即程序
// 等待某些操作完成而无法继续执行其他任务。
// 2.通过使用线程，可以在等待Socket连接的同时继续执行其他任务，保持应用程序的响应性。
// 3.为了让客户端多个用户能同时和服务器进行通信，也就是并发 方便管理
// 后面可以使用高级的异步编程模型，如Java NIO（New I/O）或异步框架，来实现非阻塞的网络通信，
// 而无需直接使用线程。这些方法可以更有效地处理大量并发连接，提高性能。
public class ClientConnectServerThread extends Thread{
    //该线程需要持有Socket
    private Socket socket;

    //构造器可以接受一个Socket对象
    public ClientConnectServerThread(Socket socket){
        this.socket = socket;
    }

    //因为Thread需要再后台和服务器通信，因此我们while循环
    @Override
    public void run() {
        while (true){
            try {
                System.out.println("客户端线程，等待读取从服务器发送的消息");
                ObjectInputStream obj = new ObjectInputStream(socket.getInputStream());
                //如果服务器没有发送Message对象，线程会阻塞在这里
                Message ms = (Message) obj.readObject();
                //判断message类型，然后做相应的业务处理
                //如果是读取到的是服务端返回的在线用户列表
                if(ms.getMesType().equals(MessageType.MESSAGE_RET_ONLINE_FRIEND)){
                    //取出在线列表信息，并显示
                    String[] list = ms.getContent().split(" ");
                    System.out.println("======当前在线用户列表======");
                    for (int i = 0; i < list.length; i++) {
                        System.out.println("用户:" + list[i]);
                    }
                } else if (ms.getMesType().equals(MessageType.MESSAGE_COMM_MES)) {
                    //把从服务器转发的消息(私聊)，显示到控制台即可
                    System.out.println("\n" + ms.getSender() + " 对 " + ms.getGetter() + " 说 " + ms.getContent());
                } else if (ms.getMesType().equals(MessageType.MESSAGE_COMM_MES_ALL)) {
                    //把从服务器转发的消息(裙聊)，显示到控制台即可
                    System.out.println("\n" + ms.getSender() + " 对大家说 " + ms.getContent());
                } else if (ms.getMesType().equals(MessageType.MESSAGE_FILE_MES)) {
                    System.out.println("\n" + ms.getSender() + " 给 " + ms.getGetter()
                            + " 发文件 " + ms.getSrc() + " 到我的电脑的目录 " + ms.getDest());
                    //取出message的文件字节数组，通过文件输出流写出到磁盘
                    FileOutputStream fileOutputStream = new FileOutputStream(ms.getDest());
                    fileOutputStream.write(ms.getFileBytes());
                    fileOutputStream.close();
                    System.out.println("\n 保存文件成功！");
                } else {
                    System.out.println("其他类型的Message，暂时不处理...");
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Socket getSocket() {
        return socket;
    }

}
