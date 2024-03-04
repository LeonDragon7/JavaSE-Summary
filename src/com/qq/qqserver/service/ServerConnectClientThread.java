package com.qq.qqserver.service;

import com.qq.qqclient.service.ManageClientConnectServerThread;
import com.qq.qqcommon.Message;
import com.qq.qqcommon.MessageType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;

/**
 * 该类的一个对象和某个客户端保持通信
 */
public class ServerConnectClientThread extends Thread{
    private Socket socket;
    private String userId;//连接到服务端的用户Id

    public ServerConnectClientThread(Socket socket, String userId) {
        this.socket = socket;
        this.userId = userId;
    }

    public Socket getSocket() {
        return socket;
    }

    //发送/接收消息
    @Override
    public void run() {
        while (true){
            try {
                System.out.println("服务端和客户端的用户Id - " + userId + "，保持通信，读取数据...");
                ObjectInputStream obj1 = new ObjectInputStream(socket.getInputStream());
                Message message = (Message)obj1.readObject();
                //根据message的类型，做相应的业务处理
                if(message.getMesType().equals(MessageType.MESSAGE_GET_ONLINE_FRIEND)){
                    //客户端要在线用户列表
                    System.out.println(message.getSender() + " 展示在线用户列表");
                    String list = ManageServerConnectClientThread.getOnlineUser();
                    //构建一个Message对象，返回给客户端
                    Message newMes = new Message();
                    newMes.setMesType(MessageType.MESSAGE_RET_ONLINE_FRIEND);
                    newMes.setContent(list);
                    newMes.setGetter(message.getSender());//设置服务端newMes返回客户端的发送对象的sender(100)，客户端需getter（100）
                    //返回给客户端
                    ObjectOutputStream obj2 = new ObjectOutputStream(socket.getOutputStream());
                    obj2.writeObject(newMes);
                    
                } else if (message.getMesType().equals(MessageType.MESSAGE_COMM_MES)) {
                    //服务端根据message获取getterId，然后得到对应相应的线程
                    ServerConnectClientThread serverConnectClientThread = ManageServerConnectClientThread.
                            getServerConnectClientThread(message.getGetter());
                    //得到对应socket的对象输出流，将message对象转发给指定的客户端
                    ObjectOutputStream oos = new ObjectOutputStream(serverConnectClientThread.getSocket().getOutputStream());
                    oos.writeObject(message);//转发，提示如果客户不在线，可以保存到数据库，就可以实现离线留言
                } else if (message.getMesType().equals(MessageType.MESSAGE_COMM_MES_ALL)) {
                    //需要遍历，服务器管理线程的集合，把所有的线程的socket得到，然后把message进行转发即可
                    HashMap<String, ServerConnectClientThread> hm = ManageServerConnectClientThread.getHm();
                    Iterator<String> iterator = hm.keySet().iterator();
                    while (iterator.hasNext()) {
                        //取出在线用户的id
                        String onLineUserId = iterator.next();
                        //排除群发消息本身的用户
                        if(!onLineUserId.equals(message.getSender())){
                            //进行转发message
                            ObjectOutputStream oos = new ObjectOutputStream(hm.get(onLineUserId).getSocket().getOutputStream());
                            oos.writeObject(message);
                        }
                    }
                } else if (message.getMesType().equals(MessageType.MESSAGE_CLIENT_EXIT)) {
                    System.out.println(message.getSender() + " 退出");
                    //将这个客户端对应线程，从集合中删除
                    ManageServerConnectClientThread.removeServerConnectClientThread(userId);
                    socket.close();//关闭连接
                    //退出while和线程
                    break;
                } else if (message.getMesType().equals(MessageType.MESSAGE_FILE_MES)) {
                    //根据getterId 获取到对应的线程，将message对象转发
                    ObjectOutputStream oos = new ObjectOutputStream(ManageServerConnectClientThread.getServerConnectClientThread(message.getGetter())
                            .getSocket().getOutputStream());
                    oos.writeObject(message);
                } else {
                    System.out.println("其他类型的message，暂时不处理");
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
