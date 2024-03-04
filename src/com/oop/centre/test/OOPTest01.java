package com.oop.centre.test;

public class OOPTest01 {
    public static void main(String[] args) {
        /*
        1、定义一个Person03类{name，age，job}，初始化Person对象数组，有3个Person对象，并
        按照age从大到小进行排序，提示：使用冒泡排序
         */
        Person03[] arr = new Person03[3];
        arr[0] = new Person03("张三", 23, "搬砖");;
        arr[1] = new Person03("李四", 18, "打螺丝");;
        arr[2] = new Person03("王五", 30, "送外卖");;
        Person03 temp = null;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j + 1].getAge() > arr[j].getAge()){
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i].toString());
        }
    }
}
class Person03{
    private String name;
    private int age;
    private String job;

    public Person03(String name, int age, String job) {
        this.name = name;
        this.age = age;
        this.job = job;
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

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Person03{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                '}';
    }
}
