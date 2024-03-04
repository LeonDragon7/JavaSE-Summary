package com.oop.centre;

import com.oop.centre.override.Dog;

/*
    方法重写/覆盖(override)
    基本介绍
    方法覆盖（重写）就是子类有一个方法，和父类的某个方法
    的名称、返回类型、参数一样，那么我们就说子类的这个方
    法覆盖了父类的方法
    转到package com.objectoriented.centre.override;
 */
public class Override {
    public static void main(String[] args) {
        //演示方法重写的情况
        Dog dog = new Dog();
        dog.cry();//ctrl + b
    }
}
