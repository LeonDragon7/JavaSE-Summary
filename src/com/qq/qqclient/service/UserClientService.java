package com.qq.qqclient.service;

import com.qq.qqcommon.Message;
import com.qq.qqcommon.MessageType;
import com.qq.qqcommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 该类完成用户登录验证和用户注册功能
 */
public class UserClientService {
    //为啥要设计User对象属性？
    //因为其他地方也可能需要使用到User的信息，可以通过set和get方法来获取
    private User user = new User();
    //因为其他地方也可能需要使用到Socket的信息，因此也做成属性
    private Socket socket;

    //根据userId 和 pwd到服务器验证该用户是否合法
    public boolean checkUser(String userId,String pwd){
        boolean loop = false;
        //创建User对象
        user.setUserId(userId);
        user.setPasswd(pwd);

        try {
            //连接到服务端，发送user对象
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 9999);
            //得到ObjectOutputStream对象,发送User对象
            ObjectOutputStream obj1 = new ObjectOutputStream(socket.getOutputStream());
            obj1.writeObject(user);

            //读取从服务器回复的Message对象
            ObjectInputStream obj2 = new ObjectInputStream(socket.getInputStream());
            Message ms = (Message) obj2.readObject();

            //判断登录成功或者失败
            if(ms.getMesType().equals(MessageType.MESSAGE_LOGIN_SUCCEED)){ //登录成功
                //创建一个和服务端保持通信的线程 -> 创建一个类 ClientConnectServerThread
                ClientConnectServerThread cst = new ClientConnectServerThread(socket);
                //启动客户端的线程
                cst.start();
                //客户端可能不止一个，所以为了扩展，我们将线程放入到集合管理
                ManageClientConnectServerThread.addClientConnectServerThread(userId,cst);
                loop = true;
            }else{
                //登录失败，我们就不能启动和服务器通信的线程，关闭起初创建的线程
                socket.close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return loop;
    }

    //向服务端请求在线用户列表
    public void onlineFriendList(){
        //创建Message对象
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_GET_ONLINE_FRIEND);
        message.setSender(user.getUserId());

        //发送一个Message，类型MESSAGE_GET_ONLINE_FRIEND
        try {
            //从管理线程集合中，通过userId,获取当前线程关联的Socket的ObjectOutputStream对象
            ObjectOutputStream obj1 = new ObjectOutputStream
                    (ManageClientConnectServerThread.getClientConnectServerThread(user.getUserId()).getSocket().getOutputStream());
            obj1.writeObject(message);//发送一个Message对象，向服务器要求在线用户列表
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //退出客户端，并给服务端发送一个退出系统的message对象
    public void logout(){
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_CLIENT_EXIT);
        message.setSender(user.getUserId());//指定服务端关联的某个客户端

        //发送message
        try {
            ObjectOutputStream obj = new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectServerThread(user.getUserId())
                    .getSocket().getOutputStream());
            obj.writeObject(message);
            System.out.println(user.getUserId() + " 退出系统 ");
            System.exit(0);//结束进程
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
