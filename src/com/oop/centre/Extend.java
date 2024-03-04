package com.oop.centre;

import com.oop.centre.extend.Graduate;
import com.oop.centre.extend.Pupil;

/*
    面向对象编程三大特征之一：继承
    为什么需要继承？
    代码复用问题。
    如果我们编写两个类，一个是Pupil类（小学生），一个是Graduate（研究生）
    问题：两个类的属性和方法有很多是相同的，怎么办？
    ==> 继承，解决代码复用性

    继承基本介绍和示意图
    继承可以解决代码复用，让我们的编程更加靠近人类思维，当多个类存在相同的属性（变量）
    和方法时，可以从这些类中抽象出父类，在父类中定义这些相同的属性和方法，所有的子类不
    需要重新定义这些属性和方法，只需要通过extends来声明继承父类即可。

    继承的基本语法
    class 子类 extends 父类{}
    1、子类就会自动拥有父类定义的属性和方法
    2、父类又叫超类，基类
    3、子类又叫派生类

    转到package com.objectoriented.centre.extend;Pupil Graduate
    package com.objectoriented.centre.extend.improve_; Student Graduate Pupil ExtendTest
 */
public class Extend {
    public static void main(String[] args) {
        Pupil pupil = new Pupil();
        pupil.name = "小明";
        pupil.age = 10;
        pupil.testing();
        pupil.setScore(60);
        pupil.showInfo();

        System.out.println("=================");

        Graduate graduate = new Graduate();
        graduate.name = "金角大王";
        graduate.age = 22;
        graduate.testing();
        graduate.setScore(100);
        graduate.showInfo();
    }
}
