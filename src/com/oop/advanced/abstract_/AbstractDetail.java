package com.oop.advanced.abstract_;

public class AbstractDetail {
    /*
         抽象类使用的注意事项和细节讨论
         1)抽象类不能被实例化
         2)抽象类不一定要包含abstract方法。也就是说, 抽象类可以没有abstract方法。
         3)一旦类包含了abstract方法,则这个类必须声明为abstract。
         4)abstract只能修饰类和方法，不能修饰属性和其它的。
         5)抽象类可以有任意成员【抽象类本质还是类】，比如: 非抽象方法、构造器、静态属性等等。
         6)抽象方法不能有主体，即不能实现。
         7)如果一个类继承了抽象类，则它必须实现抽象类的所有抽象方法，除非它自己也声明为abstract类。
         8)抽象方法不能使用private、final和 static来修饰，因为这些关键字都是和重写相违背的。
     */
}
