package com.oop.centre.test;

public class OOPTest07 {
}
//7、写成程序结果
class Test{
    String name = "Rose";
    Test(){
        System.out.println("Test");
    }
    Test(String name){
        this.name = name;
    }
}
class Demo extends Test{
    String name = "Jack";
    Demo(){
        super();
        System.out.println("Demo");
    }
    Demo(String s){
        super(s);
    }
    public void test(){
        System.out.println(super.name);
        System.out.println(this.name);
    }

    public static void main(String[] args) {
        new Demo().test();//匿名对象
        new Demo("john").test();//匿名对象
        /*
        Test
        Demo
        Rose
        Jack
        john
        Jack
         */
    }
}
