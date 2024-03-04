package com.oop.advanced.innerclass;
/*
    使用注意事项和细节讨论:
    2.匿名内部类的语法比较奇特，因为匿名内部类既是一个类的定义.同时它本身也是一个对象，因此从语法上看，
    它既有定义类的特征，也有创建对象的特征，对前面代码分析可以看出这个特点，因此可以调用匿名内部类方法。
    3．可以直接访问外部类的所有成员，包含私有的。
    4.不能添加访问修饰符,因为它的地位就是一个局部变量。
    5.作用域:仅仅在定义它的方法或代码块中。
    6.匿名内部类---访问---->外部类成员[访问方式:直接访问]
    7.外部其他类---不能访问----->匿名内部类(因为匿名内部类地位是一个局部变量)
    8.如果外部类和匿名内部类的成员重名时，匿名内部类访问的话，默认遵循就近原则,如果想访问外部类的成员，
    则可以使用(外部类名.this.成员)去访问
 */
public class AnonymousInnerClassDetail {
    public static void main(String[] args) {
        Outer05 outer05 = new Outer05();
        outer05.f1();
        //外部其他类---不能访问----->匿名内部类
        System.out.println("main outer05 hashcode=" + outer05);
    }
}
class Outer05 {
    private int n1 = 99;

    public void f1() {
        //创建一个基于类的匿名内部类
        //不能添加访问修饰符,因为它的地位就是一个局部变量
        //作用域 : 仅仅在定义它的方法或代码块中
        Person p = new Person(){
            private int n1 = 88;
            @Override
            public void hi() {
                // 可以直接访问外部类的所有成员，包含私有的
                // 如果外部类和匿名内部类的成员重名时，匿名内部类访问的话，
                // 默认遵循就近原则，如果想访问外部类的成员，则可以使用 （外部类名.this.成员）去访问
                System.out.println("匿名内部类重写了 hi方法 n1=" + n1 +
                        " 外部类的n1=" + Outer05.this.n1 );
                // Outer05.this 就是调用 f1的 对象
                System.out.println("Outer05.this hashcode=" + Outer05.this);
            }
        };
        p.hi();//动态绑定, 运行类型是 Outer05$1

        //也可以直接调用, 匿名内部类本身也是返回对象
        // class 匿名内部类 extends Person {}
//        new Person(){
//            @Override
//            public void hi() {
//                System.out.println("匿名内部类重写了 hi方法,哈哈...");
//            }
//            @Override
//            public void ok(String str) {
//                super.ok(str);
//            }
//        }.ok("jack");


    }
}

class Person {//类
    public void hi() {
        System.out.println("Person hi()");
    }
    public void ok(String str) {
        System.out.println("Person ok() " + str);
    }
}
//抽象类/接口...
