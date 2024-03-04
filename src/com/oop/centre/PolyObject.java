package com.oop.centre;

import com.oop.centre.poly.objectpoly.Animal;
import com.oop.centre.poly.objectpoly.Cat;
import com.oop.centre.poly.objectpoly.Dog;

/*
    面向对象编程-多态
    多态的具体表现
    2、对象的多态（核心）
    （1）一个对象的编译类型和运行类型可以不一致
    （2）编译类型在定义对象时，就确定了，不能改变
    （3）运行类型是可以变化的
    （4）编译类型看定义时 = 号的左边，运行类型看 = 号的右边

    Animal animal = new Dog();animal 编译类型是Animal，运行类型是Dog
    animal = new Cat();animal 编译类型仍然是Animal，运行类型是Cat
    转到package com.objectoriented.centre.poly.objectpoly;
 */
public class PolyObject {
    public static void main(String[] args) {
        //对象多态

        Animal animal = new Dog();
        //因为运行时，这时就执行到该行时，animal运行类型是Dog，所以cry就是Dog的cry
        animal.cry();//小狗汪汪叫

        animal = new Cat();
        animal.cry();//小猫喵喵叫
    }
}
