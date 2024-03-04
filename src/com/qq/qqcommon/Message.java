package com.qq.qqcommon;

import java.io.Serializable;

/**
 * 客户端和服务端共有的类
 * 通讯时的消息对象
 */
public class Message implements Serializable {
    //对象流读写通过网络传输需要序列化(Serializable)，保证它的兼容性
    private static final long serialVersionUID = 1L;
    private String sender;//发送者
    private String getter;//接受者
    private String content;//消息的内容
    private String sendTime;//发送时间
    //因为发送的Message可能是文件、图片和文字等.
    private String mesType;//消息类型[可以在接口中定义消息类型]

    //进行扩展 和文件相关的成员
    private byte[] fileBytes;
    private int fileLen = 0;
    private String src;//原文件路径
    private String dest;//将文件传输到哪里

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getGetter() {
        return getter;
    }

    public void setGetter(String getter) {
        this.getter = getter;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getMesType() {
        return mesType;
    }

    public void setMesType(String mesType) {
        this.mesType = mesType;
    }

    public byte[] getFileBytes() {
        return fileBytes;
    }

    public void setFileBytes(byte[] fileBytes) {
        this.fileBytes = fileBytes;
    }

    public int getFileLen() {
        return fileLen;
    }

    public void setFileLen(int fileLen) {
        this.fileLen = fileLen;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }
}
