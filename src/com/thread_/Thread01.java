package com.thread_;
/*
    线程基本使用
    创建线程的两种方式
    在java中线程来使用有两种方法。
    1.继承Thread类，重写run方法
    2.实现Runnable接口,重写run方法

    线程应用案例1-继承Thread 类
    运行程序时就相当启动了一个进程，进入main时就开启了一个main线程。
    主线程挂了但是子线程还在继续执行，这并不会导致应用程序的结束。说明: 当main线程启动一个子线程 Thread-0, 主线程不会阻塞,
    会继续执行（不会等执行完毕后再往下执行），这时 主线程和子线程是交替执行。

    主线程（子线程）结束不代表进程结束，因为子线程（或主线程）还在运行进程就还在。
 */

/**
 * 演示通过继承 Thread 类创建线程
 */
public class Thread01 {
    public static void main(String[] args) throws InterruptedException {

        //创建Cat对象，可以当做线程使用
        Cat cat = new Cat();

        // 读源码
        /*
            (1)
            public synchronized void start() {
                start0();
            }
            (2)
            //start0() 是本地方法，是JVM调用, 底层是c/c++实现
            //真正实现多线程的效果， 是start0(), 而不是 run
            private native void start0();

         */

        cat.start();// 启动线程-> 最终会执行cat的run方法
        //cat.run();run方法就是一个普通的方法, 没有真正的启动一个线程，就会把run方法执行完毕，才向下执行，因此要真正实现多线程，还是应该使用start方法。

        //说明: 当main线程启动一个子线程 Thread-0, 主线程不会阻塞, 会继续执行后面的代码（不会等执行完毕后再往下执行），这时 主线程和子线程是交替执行。
        System.out.println("主线程继续执行" + Thread.currentThread().getName());//名字main
        for(int i = 0; i < 60; i++) {
            System.out.println("主线程 i=" + i);
            //让主线程休眠
            Thread.sleep(1000);
        }
    }
}



/*
1)请编写程序,开启一个线程，该线程每隔1秒。在控制台输出“哺瞄。我是小猫咪
2)对上题改进:当输出80次啪瞄,我是小猫咪,结束该线程
3)使用JConsole 监控线程执行情况,并画出程序示意图!
在进程运行时直接在控制台输入JConsole即可。
 */
// 说明
//1. 当一个类继承了 Thread 类， 该类就可以当做线程使用
//2. 我们会重写 run方法，写上自己的业务代码
//3. run Thread 类 实现了 Runnable 接口的run方法，如下

/*
    @Override
    public void run() {
        if (target != null) {
            target.run();
        }
    }
 */
class Cat extends Thread {

    int times = 0;
    @Override
    public void run() {//重写run方法，写上自己的业务逻辑

        while (true) {
            //该线程每隔1秒。在控制台输出 “喵喵, 我是小猫咪”
            System.out.println("喵喵, 我是小猫咪" + (++times) + " 线程名=" + Thread.currentThread().getName());
            //让该线程休眠1秒 ctrl+alt+t
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(times == 80) {
                break;//当times 到80, 退出while, 这时线程也就退出..
            }
        }
    }
}