package com.oop.advanced.static_;
/*
    类变量和类方法
    类变量内存布局
    https://blog.csdn.net/x_iya/article/details/81260154/
    https://www.zhihu.com/question/59174759/answer/163207831

    有些书说在方法区... jdk 版本有关系,记住两点：
    (1) static变量是同一个类所有对象共享
    (2) static类变量，在类加载的时候就生成了.静态变量是类加载的时候，就创建了,
    所以不用创建对象实例也能直接通过 类名.类变量名 访问。
 */
public class ChildGame {
    public static void main(String[] args) {
        /*
        在main方法中定义一个变量count，当一个小孩加入游戏后count++，
        最后个count 就记录有多少小孩玩游戏 。
        问题分析:
        count是一个独立于对象,很尴尬，以后我们访问count很麻烦,没有使用
        到OOP。因此,我们引出类变量/静态变量。
         */
        //定义一个变量 count, 统计有多少小孩加入了游戏
        int count = 0;

        Child child1 = new Child("白骨精");
        child1.join();
        //count++;
        child1.count++;

        Child child2 = new Child("狐狸精");
        child2.join();
        //count++;
        child2.count++;

        Child child3 = new Child("老鼠精");
        child3.join();
        //count++;
        child3.count++;

        //===========
        // 类变量，可以通过类名来访问
        System.out.println("共有" + Child.count  + " 小孩加入了游戏...");
        // 下面的代码输出什么?
        System.out.println("child1.count=" + child1.count);//3
        System.out.println("child2.count=" + child2.count);//3
        System.out.println("child3.count=" + child3.count);//3
    }
}
class Child { //类
    private String name;
    // 定义一个变量 count ,是一个类变量(静态变量) static 静态!!!
    // 该变量最大的特点就是会被 Child 类的所有的对象实例共享!!!
    public static int count = 0;
    public Child(String name) {
        this.name = name;
    }
    public void join() {
        System.out.println(name + " 加入了游戏..");
    }
}
