package com.oop.centre.extend;

public class Sub extends Base{//子类
    public Sub() {//构造器
        //super()->默认存在;默认调用父类的无参构造器
        /*
        如果父类没有提供无参构造器，则必须在子类的构造器中用super去指定
        使用父类的哪个构造器完成对父类的初始化工作，否则，编译不会通过
         */
        super("smith",10);
        System.out.println("子类Sub()构造器...");
    }

    //当创建子类对象时，不管使用子类的哪个构造器，默认情况下总会去调用父类的无参构造器
    public Sub(String name){
        super("tom",30);
        System.out.println("子类Sub(String name)构造器...");
    }
    //测试细节4
    public Sub(String name, int age) {
        //调用父类的无参构造器 如下或者 什么都不写，默认就是调用super()
        //super();

        //调用父类的Base(String name)构造器
        super("hsp");

        System.out.println("子类Sub(String name, int age)构造器...");
    }

    public void sayOk(){
        //非私有的属性和方法可以在子类直接访问
        System.out.println(n1 + " " + n2 + " " + n3);
        test100();
        test200();
        test300();
        //但是私有属性和方法不能再子类直接访问 例：n4 test400

        //要通过父类提供的公共的方法去访问
        System.out.println("n4 = " + getN4());
        callTest400();
    }
}
