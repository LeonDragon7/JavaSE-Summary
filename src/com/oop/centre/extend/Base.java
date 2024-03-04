package com.oop.centre.extend;

public class Base { //父类
    //4个属性
    public int n1 = 100;
    protected int n2 = 200;
    int n3 = 300;
    private int n4 = 400;

    /*
    public Base() {//无参构造器
        System.out.println("父类Base()构造器...");
    }
    如果父类没有提供无参构造器，则必须在子类的构造器中用super去指定
    使用父类的哪个构造器完成对父类的初始化工作，否则，编译不会通过
    会在Sub(子类)中的所有构造器报错误：There is no default constructor available in 'com.objectoriented.centre.extend.Base'
    解决方案：在子类中用super()指定父类现有的构造器
     */
    //测试细节4
    public Base() {
        System.out.println("父类Base()构造器...");
    }

    public Base(String name, int age){//有参构造器
        System.out.println("父类Base(String name,int age)构造器...");
    }

    public Base(String name){//有参构造器
        System.out.println("父类Base(String name)构造器...");
    }
    //父类提供一个public的方法，返回n4
    public int getN4(){
        return n4;
    }
    public void test100(){
        System.out.println("test100");
    }

    protected void test200(){
        System.out.println("test200");
    }

    void test300(){
        System.out.println("test300");
    }

    private void test400(){
        System.out.println("test400");
    }
    //父类提供一个public的方法，解决test400的私有修饰符问题
    public void callTest400(){
        test400();
    }
}
