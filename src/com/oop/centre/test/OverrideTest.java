package com.oop.centre.test;

public class OverrideTest {
    public static void main(String[] args) {
        /*
        1、编写一个Person类，包括属性/private（name、age），构造器、方法say(返
        回自我介绍的字符串)。
        2、编写一个Student类，继承Person类，增加id、score属性/private，以及构造
        器，定义say方法（返回自我介绍的信息）。
        3、在main中，分别创建Person和Student对象，调用say方法输出自我介绍
         */
        Person person = new Person("Ben",18);
        System.out.println(person.say());
        Student student = new Student("smith",20,2032,68.9);
        System.out.println(student.say());
    }
}
class Person{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String say(){
        return "name = " + name + " age = " + age;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
class Student extends Person{
    private int id;
    private double score;

    public Student(String name, int age, int id, double score) {
        super(name, age);
        this.id = id;
        this.score = score;
    }

    public String say(){
        return super.say() + " id = " + id + " score = " + score;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}