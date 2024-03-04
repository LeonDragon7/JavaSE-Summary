package com.qq.qqserver.service;

import com.qq.qqcommon.Message;
import com.qq.qqcommon.MessageType;
import com.qq.qqcommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 服务器，监听端口9999，等待客户端的连接，并保持通信
 */
public class QQServer {
    private ServerSocket serverSocket = null;
    //创建一个集合（虚拟数据库），存放多个用户，如果是这些用户登录，就认为是合法的
    //这里我们可以使用ConcurrentHashMap,可以处理并发的集合，线程安全，即线程同步，效率高
    //HashMap没有处理线程安全，因此在多线程情况下是不安全的
    private static ConcurrentHashMap<String,User> users = new ConcurrentHashMap<>();
    static {//静态代码块，在创建QQServer的时候，只会初始化users一次
        users.put("100",new User("100","123456"));
        users.put("200",new User("200","123"));
        users.put("300",new User("300","abc"));
        users.put("至尊宝",new User("至尊宝","abc"));
        users.put("紫霞仙子",new User("紫霞仙子","abc"));
        users.put("菩提老祖",new User("菩提老祖","abc"));
    }

    //验证用户是否有效的方法
    private boolean checkUser(String userId,String pwd){
        User user = users.get(userId);
        if(user == null) return false;//说明userId没有存在users的key中
        if(!user.getPasswd().equals(pwd)) return false;//userId正确，但是密码错误
        return true;
    }
    public QQServer(){
        try {
            System.out.println("服务端在9999端口监听...");
            //启动推送新闻的线程
            new Thread(new SendNewsToAllService()).start();
            serverSocket = new ServerSocket(9999);//端口可以写在配置文件中
            //服务端的Socket，监听端口9999 循环监听，因为客户端不止一个socket
            while (true){
                Socket socket = serverSocket.accept();//如果没有客户端连接，就会阻塞在这里
                //得到socket关联的对象输入流,读取客户端发送的User对象
                ObjectInputStream obj1 = new ObjectInputStream(socket.getInputStream());
                User user = (User)obj1.readObject();

                //创建一个Message对象，发送客户端
                Message message = new Message();
                //得到socket关联的对象输出流
                ObjectOutputStream obj2 = new ObjectOutputStream(socket.getOutputStream());
                //验证 模拟服务端的数据库 hashmap
                if(checkUser(user.getUserId(), user.getPasswd())){//登录成功
                    message.setMesType(MessageType.MESSAGE_LOGIN_SUCCEED);
                    //将message对象回复客户端
                    obj2.writeObject(message);
                    //创建一个线程和客户端保持通信，该线程需要持有socket对象
                    ServerConnectClientThread scc = new ServerConnectClientThread(socket, user.getUserId());
                    //启动线程
                    scc.start();
                    //把该对象，放入到一个集合中，进行管理。
                    ManageServerConnectClientThread.addServerConnectClientThread(user.getUserId(), scc);
                }else {//登录失败
                    System.out.println("用户:" + user.getUserId() + ",登录失败！");
                    message.setMesType(MessageType.MESSAGE_LOGIN_FAIL);
                    obj2.writeObject(message);
                    //关闭stock
                    socket.close();
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            //如果服务端退出了while循环，说明服务器不在监听，因此关闭ServerSocket
            try {
                serverSocket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
