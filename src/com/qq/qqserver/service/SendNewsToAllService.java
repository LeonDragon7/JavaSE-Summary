package com.qq.qqserver.service;

import com.qq.qqcommon.Message;
import com.qq.qqcommon.MessageType;
import com.qq.utils.Utility;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

public class SendNewsToAllService implements Runnable{
    @Override
    public void run() {
        while (true){//为了可以多次推送新闻
            System.out.println("请输入服务器要推送的新闻/信息[输入exit表示退出推送服务]");
            String news = Utility.readString(1000);
            if("exit".equals(news)){
                break;
            }
            //构建一个消息，群发消息
            Message message = new Message();
            message.setMesType(MessageType.MESSAGE_COMM_MES_ALL);
            message.setSender("服务器");
            message.setContent(news);
            message.setSendTime(new Date().toString());
            System.out.println("服务器推送消息给所有人 说：" + news);

            //遍历当前所有的通信线程，得到socket，并发送message
            HashMap<String, ServerConnectClientThread> hm = ManageServerConnectClientThread.getHm();
            Iterator<String> iterator = hm.keySet().iterator();
            while (iterator.hasNext()) {
                String onLineUserId = iterator.next();
                try {
                    ObjectOutputStream oos = new ObjectOutputStream(hm.get(onLineUserId).getSocket().getOutputStream());
                    oos.writeObject(message);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
