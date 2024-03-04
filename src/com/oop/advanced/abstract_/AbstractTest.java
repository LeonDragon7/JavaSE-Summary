package com.oop.advanced.abstract_;

public class AbstractTest {
    public static void main(String[] args) {
        /*
            编写一个Employee类，声明为抽象类，包含如下三个属性：name、id、salary。
            提供必要的构造器和抽象方法：work()。对于Manager类来说，他既是员工，还
            具有奖金(bonus)的属性。请使用继承的思想，设计CommonEmployee类和Manager
            类，要求类中提供必要的方法进行属性访问，实现work(),提示 "经理/普通
            员工 名字 工作中..."
         */
        Manager jack = new Manager("jack", 999, 5000);
        jack.setBonus(8000);
        jack.work();

        CommonEmployee tom = new CommonEmployee("tom", 888, 20000);
        tom.work();
    }
}
abstract class Employee{
    private String name;
    private int id;
    private double salary;

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public abstract void work();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

class Manager extends Employee{
    private double bonus;

    public Manager(String name, int id, double salary) {
        super(name, id, salary);
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public void work() {
        System.out.println("经理 " + getName() + " 工作中...");
    }
}

class CommonEmployee extends Employee{
    public CommonEmployee(String name, int id, double salary) {
        super(name, id, salary);
    }

    @Override
    public void work() {
        System.out.println("普通员工 " + getName() + " 工作中...");
    }
}
