package com.qq.qqframe;

import com.qq.qqserver.service.QQServer;

/**
 * 该类创建QQServer对象，启动后台服务
 */
public class QQFrame {
    public static void main(String[] args) {
        new QQServer();
    }
}
