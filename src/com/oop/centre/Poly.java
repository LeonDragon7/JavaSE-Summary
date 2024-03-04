package com.oop.centre;

import com.oop.centre.poly.*;

/*
    面向对象编程-多态
    案例：
    请编写一个程序，Master类中有一个feed（喂食）方法，可以完成主人给动物（Animal类）喂
    食物（Food类）的信息
    转到package com.objectoriented.centre.poly;

 */
public class Poly {
    public static void main(String[] args) {
        Master tom = new Master("汤姆");
        Dog dog = new Dog("大黄");
        Bone bone = new Bone("大棒骨");
        tom.feed(dog,bone);

        Cat cat = new Cat("小花猫");
        Fish fish = new Fish("黄花鱼");
        tom.feed(cat,fish);

        Pig pig = new Pig("小花猪");
        Rice rice = new Rice("米饭");
        tom.feed(pig,rice);
    }
}
