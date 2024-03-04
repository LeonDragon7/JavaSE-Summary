package com.qq.qqserver.service;

import java.util.HashMap;
import java.util.Iterator;

/**
 * 管理和客户端通信的线程
 */
public class ManageServerConnectClientThread {
    private static HashMap<String,ServerConnectClientThread> hm = new HashMap<>();

    public static HashMap<String, ServerConnectClientThread> getHm() {
        return hm;
    }

    //添加线程对象到hm集合
    public static void addServerConnectClientThread(String userId,ServerConnectClientThread sc){
        hm.put(userId,sc);
    }

    //根据userId返回ServerConnectClientThread线程
    public static ServerConnectClientThread getServerConnectClientThread(String userId){
        return hm.get(userId);
    }

    //返回在线用户列表
    public static String getOnlineUser(){
        //遍历集合
        Iterator<String> iterator = hm.keySet().iterator();
        String list = "";
        while (iterator.hasNext()) {
            list += iterator.next().toString() + " ";//因为格式是空格分隔
        }
        return list;
    }

    //从集合中，移除某个线程对象
    public static void removeServerConnectClientThread(String userId){
        hm.remove(userId);
    }
}
