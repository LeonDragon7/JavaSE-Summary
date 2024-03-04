package com.oop.up;
/*
    成员方法传参机制
    引用数据类型的传参机制
    引用类型传递的是地址（传递是值，但是值是地址），可以通过形参影响实参。
 */
public class MethodParameter02 {
    public static void main(String[] args) {
        /*
        1、B类中编写一个方法test100，可以接收一个数组，在方法中修改该数组，看看原
        来的数组是否变化？
        2、B类中编写一个方法test200，可以接收一个Person03(age,sal)对象，在方法中
        修改该对象属性，看看原来的对象是否变化？
         */
        BB bb = new BB();
        //1、
        int[] arr = {1,2,3};
        bb.test100(arr);
        System.out.println("main的arr数组");
        //遍历数组
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");//200	2	3
        }
        System.out.println();
        //2、
        Person p = new Person();
        p.name = "jack";
        p.age = 10;
        bb.test200(p);
        System.out.println("main的age" + p.age);//10000
    }
}
class Person03{
    String name;
    int age;
}
class BB{
    public void test100(int[] arr){
        arr[0] = 200;
        System.out.println("test100的arr数组");
        //遍历数组
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");//200	2	3
        }
        System.out.println();
    }
    public void test200(Person p){
        p.age = 10000;//修改对象属性
        /*
        思考1：
        p = null
        main方法会输出什么？
        会输出10，因为main栈和test200栈是块独立的空间，
        相当于把test200栈里面的p指向null，并不影响main栈的指向

        思考2：
        p = new Person();
        p.name = "tom";
        p.age = 99;
        main方法会输出什么？
        会输出jack,10,因为p = new Person();会在堆里面产生一个新的对象，
        相当于把test200栈里面的p指向新的对象(地址)，并不影响main栈的指向
        p = new Person();会被当做垃圾销毁
         */
    }
}
