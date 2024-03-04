package com.oop.centre;

import com.oop.centre.extend.Sub;

/*
    面向对象编程三大特征之一：继承
    继承给编程带来的便利
    1、代码的复用性提高了
    2、代码的扩展性和维护性提高了 例：父类增加了新属性或方法会发现所有子类也将可以使用（扩展性）

    继承的细节：
    1、子类继承了所有的属性和方法，非私有的属性和方法可以在子类直接访问，但是私有属性不能再子类直接访问，要通过父类提供的公共的方法去访问
    转到package com.objectoriented.centre.extend;Base Sub
 */
public class ExtendDetail01 {
    public static void main(String[] args) {
        //测试细节1
        Sub sub = new Sub();
        sub.sayOk();
    }
}
