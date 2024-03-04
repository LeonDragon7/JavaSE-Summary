package com.thread_;
/*
    1、主线程每隔1s，输出hi,一共10次
    2、当输出到hi5时，启动一个子线程(要求实现Runnable)，每隔1s输出hello,等该线程输出10次 hello后，退出
    3、主线程继续输出hi，直到主线程退出.
    4、完成代码其实线程插队
 */
public class ThreadMethodTest {
    public static void main(String[] args) throws InterruptedException {
        Thread t5 = new Thread(new T5());//创建子线程
        for (int i = 1; i <= 10; i++) {
            System.out.println("hi " + i);
            if(i == 5) {//说明主线程输出了5次 hi
                t5.start();//启动子线程 输出 hello...
                t5.join();//立即将t5子线程，插入到main线程，让t5先执行
            }
            Thread.sleep(1000);//输出一次 hi, 让main线程也休眠1s
        }
    }
}
class T5 implements Runnable {
    private int count = 0;

    @Override
    public void run() {
        while (true) {
            System.out.println("hello " + (++count));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count == 10) {
                break;
            }
        }
    }
}