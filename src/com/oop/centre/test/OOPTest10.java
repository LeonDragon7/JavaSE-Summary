package com.oop.centre.test;

public class OOPTest10 {
    public static void main(String[] args) {
        /*
        10、编写Doctor类{name,age,job,gender,sal}
        相应的getter()和setter()方法,5个参数的构造器，重写父类的equals()方法:public
        boolean equals(Object obj)，并判断测试类中创建的两个对象是否相等。相等就是判断
        属性是否相同
         */
        Doctor doctor1 = new Doctor("kitty", 18, "农民", "男", 8000);
        Doctor doctor2 = new Doctor("smith", 18, "农民", "男", 8000);
        System.out.println(doctor1.equals(doctor2));
    }
}
class Doctor{
    private String name;
    private int age;
    private String job;
    private String gender;
    private double sal;

    public Doctor(String name, int age, String job, String gender, double sal) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.gender = gender;
        this.sal = sal;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj instanceof Doctor){
            Doctor doctor = (Doctor)obj;
            return this.name.equals(doctor.name) && this.age == doctor.age && this.job.equals(doctor.job)
                    && this.gender.equals(gender) && this.sal == doctor.sal;
        }
        return false;
    }
}
