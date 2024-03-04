package com.thread_;
/*
    线程应用案例2-实现Runnable 接口
    1、java是单继承的，在某些情况下一个类可能已经继承了某个父类,这时在用继承Thread类方法来创建线程显然不可能了。
    2、java设计者们提供了另外一个方式创建线程，就是通过实现Runnable接口来创建线程

    应用案例
    请编写程序,该程序可以每隔1秒。在控制台输出“hi!”,当输出10次后，自动退出。请使用实现Runnable接口的方式实现。
    这里底层使用了设计模式[代理模式]=>代码模拟实现Runnable接口开发线程的机制
 */
public class Thread02 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        //dog.start(); 这里不能调用start
        //创建了Thread对象，把 dog对象(实现Runnable),放入Thread
        Thread thread = new Thread(dog);
        thread.start();

//        Tiger tiger = new Tiger();//实现了 Runnable
        // 1.
//        ThreadProxy threadProxy = new ThreadProxy(tiger);
        // 2.
//        threadProxy.start();
    }
}

class Animal {
}

class Tiger extends Animal implements Runnable {
    // 6.
    @Override
    public void run() {
        System.out.println("老虎嗷嗷叫....");
    }
}

//线程代理类 , 模拟了一个极简的Thread类
class ThreadProxy implements Runnable {//你可以把Proxy类当做 ThreadProxy

    private Runnable target = null;//属性，类型是 Runnable
    // 5.
    @Override
    public void run() {
        if (target != null) {
            target.run();//动态绑定（运行类型Tiger）
        }
    }

    public ThreadProxy(Runnable target) {
        this.target = target;
    }
    // 3.
    public void start() {
        start0();//这个方法时真正实现多线程方法
    }
    // 4.
    public void start0() {
        run();
    }
}


class Dog implements Runnable { //通过实现Runnable接口，开发线程

    int count = 0;

    @Override
    public void run() { //普通方法
        while (true) {
            System.out.println("小狗汪汪叫..hi" + (++count) + Thread.currentThread().getName());

            //休眠1秒
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
