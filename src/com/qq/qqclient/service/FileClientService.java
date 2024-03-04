package com.qq.qqclient.service;

import com.qq.qqcommon.Message;
import com.qq.qqcommon.MessageType;

import java.io.*;

/**
 * 该类/对象 完成文件传输服务
 */
public class FileClientService {
    /**
     *
     * @param src 原文件路径
     * @param dest 目标文件路径
     * @param senderId 发送者
     * @param getterId 接收者
     */
    public void sendFileToOne(String src,String dest,String senderId,String getterId){
        //读取src文件 --> message
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_FILE_MES);
        message.setSender(senderId);
        message.setGetter(getterId);
        message.setSrc(src);
        message.setDest(dest);

        //需要将文件读取
        FileInputStream fileInputStream = null;
        byte[] fileBytes = new byte[(int)new File(src).length()];

        try {
            fileInputStream = new FileInputStream(src);
            fileInputStream.read(fileBytes);//将src文件读入到程序的字节数组
            //将文件对应的字节数组设置到message中
            message.setFileBytes(fileBytes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            //关闭流
            if(fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        //提示信息
        System.out.println("\n" + senderId + " 给 " + getterId + " 发送文件 "
                + src + " 对方的电脑的目录 " + dest);

        //发送到服务端
        try {
            ObjectOutputStream oos = new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectServerThread(senderId)
                    .getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
