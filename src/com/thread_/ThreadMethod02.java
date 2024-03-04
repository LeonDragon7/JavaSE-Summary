package com.thread_;
/*
    常用方法第二组
    1、yield：线程的礼让。让出cpu,让其他线程执行，但礼让的时间不确定，所以也不一定礼让成功
    2、join：线程的插队。插队的线程一旦插队成功，则肯定先执行完插入的线程所有的任务。
    3、案例:main线程创建一个子线程，每隔1s输出hello,输出20次,主线程每隔1秒, 输出hi，输出20次。
    要求:两个线程同时执行，当主线程输出5次后，就让子线程运行完毕，主线程再继续。
 */
public class ThreadMethod02 {
    public static void main(String[] args) throws InterruptedException {

        T4 t2 = new T4();
        t2.start();

        for(int i = 1; i <= 20; i++) {
            Thread.sleep(1000);
            System.out.println("主线程(小弟) 吃了 " + i  + " 包子");
            if(i == 5) {
                System.out.println("主线程(小弟) 让 子线程(老大) 先吃");
                //join, 线程插队
                //t2.join();// 这里相当于让t2 线程先执行完毕
                Thread.yield();//礼让，不一定成功.
                System.out.println("线程(老大) 吃完了 主线程(小弟) 接着吃..");
            }
        }
    }
}

class T4 extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {
            try {
                Thread.sleep(1000);//休眠1秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("子线程(老大) 吃了 " + i +  " 包子");
        }
    }
}