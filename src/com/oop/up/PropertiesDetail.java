package com.oop.up;
/*
    注意事项和细节说明
    1) 属性的定义语法同变量，示例：访问修饰符 属性类型 属性名;
    2) 属性的定义类型可以为任意类型，包含基本类型或引用类型
    3) 属性如果不赋值，有默认值，规则和数组一致，具体说明：int 0，short 0，
    byte 0，long 0，float 0.0，double 0.0，char \u0000，boolean false
    String null。

    访问修饰符：控制属性的访问范围
    有四种访问修饰符：public protected 默认 private
 */
public class PropertiesDetail {
    public static void main(String[] args) {
        //创建Person对象
        //person:对象引用/对象名
        //new Person():创建的对象空间(数据)才是真正的对象
        Person01 person = new Person01();

        //对象的属性默认值，遵守数组的规则
        System.out.println("\n当前这个人的信息");
        System.out.println("age = " + person.age + ",name = " +
                person.name + ",sal=" + person.sal +",isPass=" + person.isPass);
    }
}
class Person01{
    int age;
    String name;
    double sal;
    boolean isPass;
}
