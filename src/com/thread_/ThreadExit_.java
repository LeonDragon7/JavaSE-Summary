package com.thread_;
/*
    线程终止
    基本说明
    1、当线程完成任务后，会自动退出。
    2、还可以通过使用变量来控制run方法退出的方式停止线程，即通知方式。

    应用案例
    需求:启动一个线程t，要求在main线程中去停止线程t,请编程实现。
 */
public class ThreadExit_ {
    public static void main(String[] args) throws InterruptedException {
        T t1 = new T();
        t1.start();

        // 如果希望 main 线程去控制 t1 线程的终止, 必须可以修改 loop
        // 让 t1 退出 run 方法，从而终止 t1 线程 -> 通知方式
        // 让主线程休眠 10 秒，再通知 t1 线程退出
        System.out.println("main线程休眠10s...");
        Thread.sleep(10 * 1000);
        t1.setLoop(false);
    }
}

class T extends Thread {
    private int count = 0;
    // 设置一个控制变量
    private boolean loop = true;
    @Override
    public void run() {
        while (loop) {

            try {
                Thread.sleep(50);// 让当前线程休眠50ms
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("T 运行中...." + (++count));
        }
    }
    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}