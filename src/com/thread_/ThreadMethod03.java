package com.thread_;
/*
    用户线程和守护线程
    1、用户线程: 也叫工作线程，当线程的任务执行完或通知方式结束。
    2、守护线程: 一般是为工作线程服务的，当所有的用户线程结束，守护线程自动结束。
    3、常见的守护线程: 垃圾回收机制。

    应用案例
    下面我们测试如何将一个线程设置成守护线程。
    只需要将 myDaemonThread.setDaemon(true); 设置为 true 即可。
 */
public class ThreadMethod03 {
    public static void main(String[] args) throws InterruptedException {
        MyDaemonThread myDaemonThread = new MyDaemonThread();
        //如果我们希望当main线程结束后，子线程自动结束，只需将子线程设为守护线程即可
        myDaemonThread.setDaemon(true);
        myDaemonThread.start();

        for( int i = 1; i <= 10; i++) {//main线程
            System.out.println("工作...");
            Thread.sleep(1000);
        }
    }
}

class MyDaemonThread extends Thread {
    public void run() {
        for (; ; ) {//无限循环
            try {
                Thread.sleep(1000);//休眠1000毫秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("聊天");
        }
    }
}