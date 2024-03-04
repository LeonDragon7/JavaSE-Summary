package com.qq.qqcommon;

import java.io.Serializable;

/**
 *  客户端和服务端共有的类
 *  表示一个用户/客户信息
 */
public class User implements Serializable {
    //对象流读写通过网络传输需要序列化(Serializable)，保证它的兼容性
    private static final long serialVersionUID = 1L;
    private String userId;//用户ID / 用户名
    private String passwd;//用户密码

    public User() {
    }

    public User(String userId, String passwd) {
        this.userId = userId;
        this.passwd = passwd;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
