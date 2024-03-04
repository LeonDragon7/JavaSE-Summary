package com.qq.qqclient.service;

import com.qq.qqcommon.Message;
import com.qq.qqcommon.MessageType;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * 该类/对象,提供和消息相关的服务方法
 */
public class MessageClientService {

    /**
     * 私聊
     * @param content 消息内容
     * @param senderId 发送用户ID
     * @param getterId 接收用户ID
     */
    public void sendMessageToOne(String content,String senderId,String getterId){
        //构建message
        Message message = new Message();
        message.setContent(content);
        message.setSender(senderId);
        message.setGetter(getterId);
        message.setMesType(MessageType.MESSAGE_COMM_MES);
        message.setSendTime(new Date().toString());
        System.out.println(senderId + " 对 " + getterId + " 说 " + content);

        //发送服务端
        try {
            ObjectOutputStream obj = new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectServerThread(senderId)
                    .getSocket().getOutputStream());
            obj.writeObject(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *
     * @param content 消息内容
     * @param senderId 发送用户ID
     */
    public void sendMessageToAll(String content,String senderId){
        //构建message
        Message message = new Message();
        message.setContent(content);
        message.setSender(senderId);
        message.setMesType(MessageType.MESSAGE_COMM_MES_ALL);
        message.setSendTime(new Date().toString());
        System.out.println(senderId + " 对大家说 " + content);

        //发送服务端
        try {
            ObjectOutputStream obj = new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectServerThread(senderId)
                    .getSocket().getOutputStream());
            obj.writeObject(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
