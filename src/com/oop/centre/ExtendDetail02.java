package com.oop.centre;

import com.oop.centre.extend.Sub;

/*
    面向对象编程三大特征之一：继承
    继承的细节：
    2、子类必须调用父类的构造器，完成父类的初始化
    3、当创建子类对象时，不管使用子类的哪个构造器，默认情况下总会去调用父类的无
    参构造器，如果父类没有提供无参构造器，则必须在子类的构造器中用super去指定
    使用父类的哪个构造器完成对父类的初始化工作，否则，编译不会通过
    转到package com.objectoriented.centre.extend;Base Sub
 */
public class ExtendDetail02 {
    public static void main(String[] args) {
        //测试细节2
        //当我们创建一个子类对象的时候，会发现先调用父类的构造器接着调用子类构造器
        //这是因为在子类的无参构造器里面隐藏了super();
        //super();默认调用父类的无参构造器
        Sub sub1 = new Sub();

        System.out.println("==============================");

        //测试细节3
        //当创建子类对象时，不管使用子类的哪个构造器，默认情况下总会去调用父类的无参构造器
        //接着在调用你创建对象的子类有参构造器
        Sub sub2 = new Sub("jack");
    }
}
