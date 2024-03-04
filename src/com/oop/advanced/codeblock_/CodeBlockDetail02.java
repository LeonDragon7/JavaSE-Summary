package com.oop.advanced.codeblock_;

/*
        代码块使用注意事项和细节讨论
        6、我们看一下创建一个子类对象时(继承关系)，他们的调用顺序如下:
        1、父类的静态代码块和静态属性(优先级一样,按定义顺序执行)（类加载）
        2、子类的静态代码块和静态属性(优先级一样,按定义顺序执行)（类加载）
        3、父类的普通代码块和普通属性初始化(优先级一样，按定义顺序执行)
        4、父类的构造方法
        5、子类的普通代码块和普通属性初始化(优先级一样，按定义顺序执行)
        6、子类的构造方法
        7、静态代码块（本质上是静态方法）只能直接调用静态成员(静态属性和静态方法)，
        普通代码块（本质上是普通方法）可以调用任意成员。

        注意：static修饰是跟着类走的，而不是跟随对象。
        当 new A() 时类的静态代码块和静态属性(优先级一样,按定义顺序执行)
        但是当A.getVal01() 时动用了类中的任意东西，那么静态代码块会马上执行，
        （静态代码块是这个类最先执行的代码）
     */
public class CodeBlockDetail02 {
    public static void main(String[] args) {
        //(1) 进行类的加载
        //1.1 先加载 父类 A 1.2 再加载 B
        //(2) 创建对象
        //2.1 从子类的构造器开始
        //new B();//对象

        new C();
    }
}
class A { //父类
    private static int n1 = getVal01();
    static {
        System.out.println("A02的一个静态代码块..");//(2)
    }
    {
        System.out.println("A02的第一个普通代码块..");//(5)
    }
    public int n3 = getVal02();//普通属性的初始化
    public static int getVal01() {
        System.out.println("getVal01");//(1)
        return 10;
    }

    public int getVal02() {
        System.out.println("getVal02");//(6)
        return 10;
    }

    public A() {//构造器
        //隐藏
        //super()
        //普通代码和普通属性的初始化......
        System.out.println("A02的构造器");//(7)
    }

}

class C {
    private int n1 = 100;
    private static  int n2 = 200;

    private void m1() {

    }
    private static void m2() {

    }

    static {
        //静态代码块，只能调用静态成员
        //System.out.println(n1);错误
        System.out.println(n2);//ok
        //m1();//错误
        m2();
    }
    {
        //普通代码块，可以使用任意成员
        System.out.println(n1);
        System.out.println(n2);//ok
        m1();
        m2();
    }
}

class B extends A {

    private static int n3 = getVal03();

    static {
        System.out.println("B02的一个静态代码块..");//(4)
    }
    public int n5 = getVal04();
    {
        System.out.println("B02的第一个普通代码块..");//(9)
    }

    public static int getVal03() {
        System.out.println("getVal03");//(3)
        return 10;
    }

    public int getVal04() {
        System.out.println("getVal04");//(8)
        return 10;
    }
    //一定要慢慢的去品..
    public B() {//构造器
        //隐藏了
        //super()
        //普通代码块和普通属性的初始化...
        System.out.println("B02的构造器");//(10)
        // TODO Auto-generated constructor stub
    }
}
