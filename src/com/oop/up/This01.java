package com.oop.up;
/*
    this关键字
    什么是this
    java虚拟机会给每个对象分配this，代表当前对象。
    简单来说：哪个对象调用，this就代表哪个对象
 */
public class This01 {
    public static void main(String[] args) {
        Dog dog1 = new Dog("Tom", 3);
        System.out.println("dog1的hashcode = " + dog1.hashCode());
        dog1.info();
        System.out.println("===============================");
        Dog dog2 = new Dog("大黄", 2);
        dog2.info();
        System.out.println("dog2的hashcode = " + dog2.hashCode());
    }
}
class Dog{
    public String name;
    public int age;
    /*
    public Dog(String dName,int dAge){//构造器
        name = dName;
        age = dAge;
    }
    如果我们构造器的形参，能够直接写成属性名，就更加好了，
    但是不能直接写成和属性相同的名称，因为根据变量的作用
    域原则，构造器的name和age是局部变量，而不是属性，
    不会改变值，所以会输出为默认值。
    public Dog(String name,int age){//构造器
        name = name;
        age = age;
    }
    --> 引出this
     */
    public Dog(String name,int age){
        //this.name：就是当前对象(new出来的)的属性name
        this.name = name;
        //this.age：就是当前对象(new出来的)的属性age
        this.age = age;
        System.out.println("this.hashCode = " + this.hashCode());
    }
    public void info(){
        //hashCode():将该对象的内部地址转化成一个整数来实现的。
        System.out.println(this.name + "\t" + this.age + "\t"
                + "当前对象的hashCode是：" + this.hashCode());
    }
}
