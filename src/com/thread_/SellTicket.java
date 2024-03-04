package com.thread_;
/*
    继承Thread vs 实现Runnable 的区别
    1、从java的设计来看，通过继承Thread或者实现Runnable接口来创建线程本质上没有区别,从jdk帮助文档我们可以看到Thread类本身就实现了 Runnable接口。
    2、实现Runnable接口方式更加适合多个线程共享一个资源的情况，并且避免了单继承的限制,建议使用Runnable。
    3、[售票系统]，编程模拟三个售票窗口售票100,分别使用继承 Thread和实现 Runnable方式,并分析有什么问题? 均会出现超卖的问题。
 */
public class SellTicket {
    public static void main(String[] args) {

        //测试
//        SellTicket01 sellTicket01 = new SellTicket01();
//        SellTicket01 sellTicket02 = new SellTicket01();
//        SellTicket01 sellTicket03 = new SellTicket01();
//
//        //这里我们会出现超卖..
//        sellTicket01.start();//启动售票线程
//        sellTicket02.start();//启动售票线程
//        sellTicket03.start();//启动售票线程


        System.out.println("===使用实现接口方式来售票=====");
        SellTicket02 sellTicket02 = new SellTicket02();

        new Thread(sellTicket02).start();//第1个线程-窗口
        new Thread(sellTicket02).start();//第2个线程-窗口
        new Thread(sellTicket02).start();//第3个线程-窗口


    }
}

//使用Thread方式

class SellTicket01 extends Thread {

    private static int ticketNum = 100;//让多个线程共享 ticketNum

    @Override
    public void run() {
        while (true) {

            if (ticketNum <= 0) {
                System.out.println("售票结束...");
                break;
            }

            //休眠50毫秒, 模拟
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("窗口 " + Thread.currentThread().getName() + " 售出一张票"
                    + " 剩余票数=" + (--ticketNum));

        }
    }
}



//实现接口方式
class SellTicket02 implements Runnable {
    private int ticketNum = 100;//让多个线程共享 ticketNum

    @Override
    public void run() {
        while (true) {

            if (ticketNum <= 0) {
                System.out.println("售票结束...");
                break;
            }

            //休眠50毫秒, 模拟
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("窗口 " + Thread.currentThread().getName() + " 售出一张票"
                    + " 剩余票数=" + (--ticketNum));//1 - 0 - -1  - -2

        }
    }
}