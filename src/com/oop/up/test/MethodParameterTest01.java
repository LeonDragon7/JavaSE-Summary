package com.oop.up.test;


public class MethodParameterTest01 {
    public static void main(String[] args) {
        /*
        1)编写一个方法copyPerson，可以复制一个Person对象，返回复制的对象。克隆对象，
        注意要求得到新对象和原来的对象是两个独立的对象，只是他们的属性相同。
         */
        Person01 p1 = new Person01();
        p1.name = "milan";
        p1.age = 18;
        System.out.println("age = " + p1.age + ",name = " + p1.name);
        CC cc = new CC();
        Person01 p2 = cc.copyPerson(p1);
        System.out.println("age = " + p2.age + ",name = " + p2.name);

        //可以通过输出对象比较(boolean值)看看对象是否是一致
        System.out.println(p1 == p2);//false
    }
}
class Person01{
    String name;
    int age;
}
class CC{
    public Person01 copyPerson(Person01 p){
        Person01 p2 = new Person01();
        p2.name = p.name;//把原来对象的名字赋给p2.name
        p2.age = p.age;//把原来对象的年龄赋给p2.age
        return p2;
    }
}
