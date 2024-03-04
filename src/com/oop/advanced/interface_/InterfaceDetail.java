package com.oop.advanced.interface_;

public class InterfaceDetail {
    /*
        注意事项和细节
        1、接口不能被实例化（new）
        2、接口中所有的方法是public方法，接口中抽象方法，可以不用abstract修饰。
        void aaa(); 实际上是abstract void aa();（同理，不写public也是默认public方法，因此实现时该方法不写public不会报错。）
        3、一个普通类实现接口,就必须将该接口的所有方法都实现。
        4、抽象类实现接口，可以不用实现接口的方法。
        5、一个类同时可以实现多个接口。
        class Timer implements IA, IB{ }
        6、接口中的属性，只能是final的，而且是 public static final修饰符。
        比如:int a=1;实际上是public static final int a=1; (必须初始化)
        7、接口中属性的访问形式:接口名.属性名
        8、接口不能继承其它的类,但是可以继承多个别的接口。（接口无法实现接口）
        interface A extends B,C{}
        9、接口的修饰符只能是public和默认，这点和类的修饰符是一样的。

        实现接口VS继承类
        当子类继承了父类，就自动的拥有父类的功能，如果子类需要扩展功能，可以通过实现接口的方式扩展。
        可以理解 实现接口 是对 java 单继承机制的一种补充。
            1、接口和继承解决的问题不同
            继承的价值主要在于:解决代码的复用性和可维护性。
            2、接口的价值主要在于:设计，设计好各种规范(方法)，让其它类去实现这些方法。即更加的灵活
        接口比继承更加灵活：继承是满足is - a的关系，而接口只需满足 like - a的关系。
        接口在一定程度上实现代码解耦[即:接口规范性+动态绑定机制]
     */
}
