package com.oop.up;
/*
    类与对象
    一个程序就是一个世界，有很多事物(对象[属性，行为])

    类和对象的区别和联系
    1) 类是抽象的，概念的，代表一类事物，比如人类，猫类..,即它是数据类型
    2) 对象是具体的，实际的，代表一个具体事物，即是实例
    3) 类是对象的模版，对象是类的一个个体，对应一个实例
 */
public class ClassesAndObjects {
    public static void main(String[] args) {
        /*
        张老太养了两只猫猫：一只名字叫小白，今年3岁，白色。还有一只叫小花，今年100岁，花色。
        请编写一个程序，当用户输入小猫的名字时，就显示该猫的名字，年龄，颜色。如果用户输入的
        小猫名错误，则显示张老太没有这只猫猫。
         */
        /*
        类与对象之前的技术解决-变量。
        缺点：在增减变量属性时，不利于数据管理，效率低
         */
        //第一只猫的信息
        String catName1 = "小白";
        int catAge1 = 3;
        String  carColor1 = "白色";
        //第二只猫的信息
        String catName2 = "小花";
        int catAge2 = 100;
        String  carColor2 = "花色";

        /*
        类与对象之前的技术解决-数组(优于变量方法)。
        缺点：
        1、体现不出数据类型，例，年龄体重是int和double类型
        2、只能通过[下标]获取信息，造成变量名和内容的对应关系不明确
        3、不能体现猫的行为(*)
        4、不利于数据管理，效率低
         */
        String[] cat01 = {"小白","3","白色"};
        String[] cat02 = {"小花","100","花色"};

        //使用oop
        //实例化一只猫[创建一只猫]
        /*
        1、new Cat()：创建第一只猫
        2、Cat cat1 = new Cat();：把创建的猫赋给cat1
        3、cat1就是一个对象
         */
        Cat cat1 = new Cat();
        cat1.name = "小白";
        cat1.age = 3;
        cat1.color = "白色";
        cat1.weight = 10;
        /*
        1、new Cat()：创建第二只猫
        2、Cat cat2 = new Cat();：把创建的猫赋给cat2
        3、cat2就是一个对象
         */
        Cat cat2 = new Cat();
        cat2.name = "小花";
        cat2.age = 100;
        cat2.color = "花色";
        cat2.weight = 20;

        //如何访问对象的属性
        System.out.println("第一只猫的信息：" +
                cat1.name + " " +
                cat1.age + " " +
                cat1.color + " " +
                cat1.weight);

        System.out.println("第二只猫的信息：" +
                cat2.name + " " +
                cat2.age + " " +
                cat2.color + " " +
                cat2.weight);
    }
}
//面向对象的方式
//定义一个猫类 Cat -> 自定义的数据类型
class Cat{
    //属性/成员变量/field字段
    protected String name;//名字
    int age;//年龄
    String color;//颜色
    double weight;//体重
}
