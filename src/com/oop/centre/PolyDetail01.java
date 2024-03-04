package com.oop.centre;

import com.oop.centre.poly.detail.Animal;
import com.oop.centre.poly.detail.Cat;

/*
    面向对象编程-多态
    多态注意事项和细节讨论

    多态的前提是：两个对象（类）存在继承关系
    多态的向上转型
    1）本质：父类的引用指向了子类的对象 例：Animal animal = new Dog();
    2）语法：父类类型   引用名 = new 子类类型
    3）特点：编译类型看左边，运行类型看右边。
        可以调用父类中的所有成员（需遵守访问权限），
        不能调用子类中特有成员；
        最终运行效果看子类的具体实现！
    转到package com.objectoriented.centre.poly.detail;

    多态的向下转型
    1）语法：子类类型   引用名 = (子类类型) 父类引用
    2）只能强转父类的引用，不能强转父类的对象
    3）要求父类的引用必须指向的是当前目标类型的对象
    4）当向下转型后，可以调用子类类型中所有的成员
 */
public class PolyDetail01 {
    public static void main(String[] args) {
        //向上转型：父类的引用指向了子类的对象
        Animal animal = new Cat();
        //或者Object object = new Cat();

        //可以调用父类中的所有成员（需遵守访问权限）
        //但是不能调用子类中特有成员
        //因为在编译阶段，能调用哪些成员，是由编译类型来决定的
        //animal.catchMouse();错误 解决：向下转型

        //最终运行效果看子类的具体实现，即调用方法时，按照从运行类型开始查找方法
        animal.eat();//猫吃鱼
        animal.run();//跑
        animal.show();//hello，你好
        animal.sleep();//睡

        //多态的向下转型
        //语法：子类类型 引用名 = (子类类型) 父类引用
        //cat编译类型和运行类型都是Cat
        Cat cat = (Cat) animal;
        cat.catchMouse();//猫抓老鼠
        //要求父类的引用必须指向的是当前目标类型的对象
        //Dog dog = (Dog) animal; 不可以 ，animal已经指向cat对象(向上转型)，会报错误：类异常
    }
}
