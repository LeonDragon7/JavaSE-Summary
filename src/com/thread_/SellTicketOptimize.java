package com.thread_;

public class SellTicketOptimize {
    public static void main(String[] args) {

        //测试
//        SellTicket04 sellTicket04 = new SellTicket04();
//        SellTicket05 sellTicket05 = new SellTicket05();
//        SellTicket06 sellTicket06 = new SellTicket06();
//
//        //这里我们会出现超卖..
//        sellTicket04.start();//启动售票线程
//        sellTicket05.start();//启动售票线程
//        sellTicket06.start();//启动售票线程

/*
        System.out.println("===使用实现接口方式来售票=====");
        SellTicket05 sellTicket05 = new SellTicket05();

        new Thread(sellTicket05).start();//第1个线程-窗口
        new Thread(sellTicket05).start();//第2个线程-窗口
        new Thread(sellTicket05).start();//第3个线程-窗口

 */
        SellTicket06 sellTicket06 = new SellTicket06();
        new Thread(sellTicket06).start();//第1个线程-窗口
        new Thread(sellTicket06).start();//第2个线程-窗口
        new Thread(sellTicket06).start();//第3个线程-窗口

    }
}
//实现接口方式, 使用synchronized实现线程同步
class SellTicket06 implements Runnable {
    private int ticketNum = 100;//让多个线程共享 ticketNum
    private boolean loop = true;//控制run方法变量
    Object object = new Object();


    //同步方法（静态的）的锁为当前类本身
    //1. public synchronized static void m1() {} 锁是加在 SellTicket06.class上
    //2. 如果在静态方法中，实现一个同步代码块.
    /*
        synchronized (SellTicket03.class) {
            System.out.println("m2");
        }
     */
    public synchronized static void m1() {

    }
    public static  void m2() {
        synchronized (SellTicket06.class) {
            System.out.println("m2");
        }
    }

    //1. public synchronized void sell() {} 就是一个同步方法
    //2. 这时锁在 this对象
    //3. 也可以在代码块上写 synchronize ,同步代码块, 互斥锁还是在this对象
    //4. 线程是3个，对象是同一个，this就代表三个线程中会调用的同一个对象
    public /*synchronized*/ void sell() { //同步方法, 在同一时刻， 只能有一个线程来执行sell方法

        synchronized (/*this*/ object) {
            if (ticketNum <= 0) {
                System.out.println("售票结束...");
                loop = false;
                return;
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

    @Override
    public void run() {
        while (loop) {
            sell();//sell方法是一共同步方法
        }
    }
}

//使用Thread方式
// new SellTicket01().start()
// new SellTicket01().start(); 对象不是同一个，锁不住m1()

class SellTicket04 extends Thread {

    private static int ticketNum = 100;//让多个线程共享 ticketNum

    // 以下写法没用，因为每次对象都不是同一个，锁不住
//    public void m1() {
//        synchronized (this) {
//            System.out.println("hello");
//        }
//    }

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
class SellTicket05 implements Runnable {
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