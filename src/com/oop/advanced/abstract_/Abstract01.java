package com.oop.advanced.abstract_;
public class Abstract01 {
    /*
    抽象类
    引出：当父类的某些方法，需要声明，但是又不确定如何实现时，可以将其声明为抽象方法,
    那么这个类就是抽象类

    所谓抽象方法就是没有实现的方法，所谓没有实现就是指，没有方法体。

    当一个类中存在抽象方法时，需要将该类声明为abstract 类，一般来说，抽象类会被继承，
    由其子类来实现抽象方法。

    abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }
    public abstract void eat()  ;
}

    抽象类的介绍
    1)用abstract关键字来修饰一个类时,这个类就叫抽象类访问修饰符
    2)用abstract关键字来修饰一个方法时,这个方法就是抽象方法
        访问修饰符 abstract 返回类型 方法名(参数列表);//没有方法体
    3)抽象类的价值更多作用是在于设计,是设计者设计好后，让子类继承并实现抽象类。
    4)抽象类是考官比较爱问的知识点，在框架和设计模式使用较多。
 */
}
