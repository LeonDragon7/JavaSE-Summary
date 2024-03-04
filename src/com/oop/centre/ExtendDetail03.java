package com.oop.centre;

import com.oop.centre.extend.Sub;

/*
    面向对象编程三大特征之一：继承
    继承的细节：
    4、如果希望指定去调用父类的某个构造器，则显示的调用一下：super(参数列表)
    5、super在使用时，需要放在构造器第一行(super只能在构造器中使用)
    6、super()和this()都只能放在构造器第一行，因此这两个方法不能共存在一个构造器
    转到package com.objectoriented.centre.extend;Base Sub
 */
public class ExtendDetail03 {
    public static void main(String[] args) {
        //测试细节4
        //如果希望指定去调用父类的某个构造器，则显示的调用一下：super(参数列表)
        Sub sub01 = new Sub("king", 10);
    }
}
