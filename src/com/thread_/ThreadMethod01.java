package com.thread_;
/*
    线程常用方法
    常用方法第一组
setName A //设置线程名称，使之与参数name相同

getName //返回该线程的名称

startM //使该线程开始执行;Java虚拟机底层调用该线程的start0方

run //调用线程对象 run方法;

setPriority //更改线程的优先级

getPriority //获取线程的优先级

sleep //在指定的毫秒数内让当前正在执行的线程休眠(暂停执行)

interrupt //中断线程

    注意事项和细节
    1、start底层会创建新的线程，调用run, run 就是一个简单的方法调用，不会启动新线程。
    2、线程优先级的范围。MAX_PRIORITY 10  MIN_PRIORITY 1  NORM_PRIORITY 5
    3、interrupt，中断线程，但并没有真正的结束线程。所以一般用于中断正在休眠线程。
    4、sleep:线程的静态方法，使当前线程休眠。
 */
public class ThreadMethod01 {
    public static void main(String[] args) throws InterruptedException {
        //测试相关的方法
        T3 t = new T3();
        t.setName("timerring");
        t.setPriority(Thread.MIN_PRIORITY);//1
        t.start();//启动子线程


        //主线程打印5 hi ,然后我就中断 子线程的休眠
        for(int i = 0; i < 5; i++) {
            Thread.sleep(1000);
            System.out.println("hi " + i);
        }

        System.out.println(t.getName() + " 线程的优先级 =" + t.getPriority());//1
        t.interrupt();//当执行到这里，就会中断 t线程的休眠.
    }
}

class T3 extends Thread { // 自定义的线程类
    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < 100; i++) {
                // Thread.currentThread().getName() 获取当前线程的名称
                System.out.println(Thread.currentThread().getName() + "  吃包子~~~~" + i);
            }
            try {
                System.out.println(Thread.currentThread().getName() + " 休眠中~~~");
                Thread.sleep(20000);//20秒
            } catch (InterruptedException e) {
                // 当该线程执行到一个interrupt 方法时，就会catch 一个 异常, 可以加入自己的业务代码
                // InterruptedException 是捕获到一个中断异常.
                System.out.println(Thread.currentThread().getName() + "被 interrupt了");
            }
        }
    }
}
