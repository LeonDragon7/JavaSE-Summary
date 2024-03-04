package com.oop.centre.test;

public class EqualsTest01 {
    public static void main(String[] args) {
        /*
        应用实例：判断两个Person对象的内容是否相等，如果两个Person对象的各个属性值都一
        样，则返回true，反之false
         */
        Person01 p1 = new Person01("张三", 18, '男');
        Person01 p2 = new Person01("smith", 18, '男');
        System.out.println(p1.equals(p2));
    }

}
class Person01{
    private String name;
    private int age;
    private char gender;

    //重写Object的equals方法
    public boolean equals(Object obj){
        //先判断如果比较的两个对象是同一个对象，则直接返回true
        if(this == obj){
            return true;
        }
        //类型判断
        if(obj instanceof Person01){//类型是Person01才比较
            //进行向下转型 为了获取传入的obj的各个属性
           Person01 p = (Person01)obj;
           return this.name.equals(p.name) && this.age == p.age && this.gender == p.gender;
        }
        //如果不是Person01，则直接返回false
        return false;
    }
    public Person01(String name, int age, char gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
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

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

}