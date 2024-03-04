package com.oop.centre;

import com.oop.centre.super_.B;

/*
    super关键字
    super给编程带来的便利/细节
    1、调用父类的构造器的好处（分工明确，父类属性由父类初始化，子类的属性由子类初始化）
    2、当子类中有和父类中的成员（属性和方法）重名时，为了访问父类的成员，必须通过super
    。如果没有重名，使用super、this、直接访问是一样的效果！
    转到package com.objectoriented.centre.super_;
    3、super的访问不限于直接父类，如果爷爷类和本类中有同名的成员，也可以使用
    super去访问爷爷类的成员；如果多个基类中都有同名的成员，使用super访问遵循
    就近原则。A->B->C

 */
public class SuperDetail {
    public static void main(String[] args) {
        B b = new B();
        b.sum();
    }
}
