package com.qq.qqclient.view;

import com.qq.qqclient.service.FileClientService;
import com.qq.qqclient.service.MessageClientService;
import com.qq.qqclient.service.UserClientService;
import com.qq.utils.Utility;

/**
 * 客户端的菜单界面
 */
public class QQView {
    private boolean loop = true;//控制是否显示菜单
    private String key = "";//接收用户的键盘输入
    //实现系统功能对象
    private UserClientService uc = new UserClientService();//对象是用于登录服务/注册用户
    private MessageClientService ms = new MessageClientService();//对象用户私聊/群聊
    private FileClientService fc = new FileClientService();//用户发送文件

    public static void main(String[] args) {
        new QQView().mainMenu();
        System.out.println("客户端退出系统......");
    }

    //显示主菜单
    private void mainMenu(){

        while (loop){
            System.out.println("============欢迎登录网络通讯系统============");
            System.out.println("\t\t 1 登录系统");
            System.out.println("\t\t 9 退出系统");
            System.out.print("请输入你的选择：");
            key = Utility.readString(1);

            //根据用户的输入，来处理不同的逻辑
            switch (key){
                case "1":
                    System.out.print("请输入用户号：");
                    String userId = Utility.readString(50);
                    System.out.print("请输入密码：");
                    String pwd = Utility.readString(50);
                    //需要到服务端去验证用户是否合法，编写一个UserClientService[用户登录/注册]
                    if(uc.checkUser(userId,pwd)){
                        System.out.println("============ 欢迎 (用户 " + userId + " 登录成功) ============");
                        //进入到二级菜单
                        while (loop){
                            System.out.println("============网络通信系统二级菜单(用户 " + userId + " )============");
                            System.out.println("\t\t 1 显示在线用户列表");
                            System.out.println("\t\t 2 群发消息");
                            System.out.println("\t\t 3 私聊消息");
                            System.out.println("\t\t 4 发送文件");
                            System.out.println("\t\t 9 退出系统");
                            System.out.print("请输入你的选择：");
                            key = Utility.readString(1);
                            switch (key){
                                case "1":
                                    uc.onlineFriendList();
                                    break;
                                case "2":
                                    System.out.print("请输入想对大家说的话：");
                                    String contentAll = Utility.readString(100);
                                    ms.sendMessageToAll(contentAll,userId);
                                    break;
                                case "3":
                                    System.out.print("请输入想聊天的用户号(在线)：");
                                    String getterId = Utility.readString(50);
                                    System.out.print("请输入想说的话：");
                                    String content = Utility.readString(100);
                                    ms.sendMessageToOne(content,userId,getterId);
                                    break;
                                case "4":
                                    System.out.print("请输入你想把文件发送给的用户(在线)：");
                                    String getFileId = Utility.readString(50);
                                    System.out.print("请输入发送文件的路径(形式 d:\\xx.jbg)");
                                    String src = Utility.readString(100);
                                    System.out.print("请输入把文件发送到对方的路径(形式 d:\\yy.jbg)");
                                    String dest = Utility.readString(100);
                                    fc.sendFileToOne(src,dest,userId,getFileId);
                                    break;
                                case "9":
                                    uc.logout();
                                    loop = false;
                                    break;
                            }
                        }
                    }else { //登录服务器失败
                        System.out.println("=====登录失败=====");
                    }
                    break;
                case "9":
                    uc.logout();
                    loop = false;
                    break;
            }
        }
    }
}
