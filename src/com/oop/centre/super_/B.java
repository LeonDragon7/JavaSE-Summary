package com.oop.centre.super_;

public class B extends A{
    /*
    1、访问父类的属性，但不能访问父类的private属性
        super.属性名;
     */
    public void hi(){
        System.out.println(super.n1 + " " + super.n2 + " " + super.n3);
    }
    /*
    2、访问父类的方法，不能访问父类的private方法
        super.方法名(参数列表);
     */
    public void ok(){
        super.test100();
        super.test200();
        super.test300();
    }

    /*
    3、访问父类的构造器
    super(参数列表);只能放在构造器的第一句，只能出现一句！
     */
    public B(){
        //super();
        //super("jack");
        //super("jack",10);
    }

    /*
    2、当子类中有和父类中的成员（属性和方法）重名时，为了访问父类的成员，必须通过super
    。如果没有重名，使用super、this、直接访问是一样的效果！
     */
    public void sum(){
        System.out.println("B类的sum方法");
        //调用父类A的cal方法
        //方法1：
        //先找本类，如果有，则调用，如果没有，则找父类(如果有，并可以调用，则调用),直到找到Object类
        cal();
        //方法2：
        this.cal();//等价于cal();
        //方法3：
        super.cal();//直接查找父类
        //属性和方法相同
    }
}
