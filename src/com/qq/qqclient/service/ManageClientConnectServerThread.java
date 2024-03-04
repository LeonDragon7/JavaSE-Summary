package com.qq.qqclient.service;

import java.util.HashMap;

/**
 * 该类管理客户端连接到服务端的线程
 */
public class ManageClientConnectServerThread {
    //我们把多个线程放入一个HashMap集合，key就是用户id，value就是线程
    private static HashMap<String,ClientConnectServerThread> hm = new HashMap<>();

    //将某个线程加入到集合
    public static void addClientConnectServerThread(String useId,ClientConnectServerThread c){
        hm.put(useId, c);
    }

    //通过userId 可以得到对应的线程
    public static ClientConnectServerThread getClientConnectServerThread(String userId){
        return hm.get(userId);
    }

}
