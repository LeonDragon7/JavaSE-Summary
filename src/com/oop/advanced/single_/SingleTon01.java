package com.oop.advanced.single_;
/*
    单例设计模式
    什么是设计模式
    1、静态方法和属性的经典使用
    2、设计模式是在大量的实践中总结和理论化之后优选的代码结构、编程风格、以及解决问题的思考方式。
    设计模式就像是经典的棋谱,不同的棋局,我们用不同的棋谱，免去我们自己再思考和摸索。

    什么是单例模式
    1、所谓类的单例设计模式，就是采取一定的方法保证在整个的软件系统中，对某个类只能存在一个对象实例，
    并且该类只提供一个取得其对象实例的方法。
    2、单例模式有两种方式:1) 饿汉式 2) 懒汉式

    饿汉式
    步骤如下:
    1、构造器私有化 =》防止直接new
    2、类的内部创建对象
    3、向外暴露一个静态的公共方法。getInstance

    饿汉式：有可能还没有用到这个对象，但是由于类的机制已经将对象创建好了。在线程还没出现之前就已经实例化了,
    因此饿汉式线程一定是安全的。
 */
public class SingleTon01 {
    public static void main(String[] args) {
        //GirlFriend xh = new GirlFriend("小红");
        //GirlFriend xb = new GirlFriend("小白");

        //通过方法可以获取对象
        GirlFriend instance = GirlFriend.getInstance();
        System.out.println(instance);
        // 都是同一个对象
        GirlFriend instance2 = GirlFriend.getInstance();
        System.out.println(instance2);

        System.out.println(instance == instance2);// T 同一个对象
        //System.out.println(GirlFriend.n1);
    }
}
// 有一个类， GirlFriend
// 只能有一个女朋友
class GirlFriend {

    private String name;
    // public static  int n1 = 100;
    // 为了能够在静态方法中，返回 gf对象，需要将其修饰为static
    // 對象，通常是重量級的對象, 餓漢式可能造成創建了對象，但是沒有使用.
    // 只要类加载了，就一定创建了gf对象
    private static GirlFriend gf = new GirlFriend("小红红");

    // 如何保障我们只能创建一个 GirlFriend 对象
    // 步骤[单例模式-饿汉式]
    // 1. 将构造器私有化
    // 2. 在类的内部直接创建对象(该对象是static)
    // 3. 提供一个公共的static方法，返回 gf 对象
    private GirlFriend(String name) {
        System.out.println("構造器被調用.");
        this.name = name;
    }

    // 用static的目的就是在不创建对象的前提下直接调用
    public static GirlFriend getInstance() {
        return gf;
    }

    @Override
    public String toString() {
        return "GirlFriend{" +
                "name='" + name + '\'' +
                '}';
    }
}

