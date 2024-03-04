package com.oop.centre.test;

public class OOPTest04 {
    public static void main(String[] args) {
        /*
        4、通过继承实现员工工资核算打印功能
        父类：员工类
        子类：部门经理类、普通员工类
        （1）部门经理工资 = 1000 + 单日工资 * 天数 * 等级（1.2）
        （2）普通员工工资 = 单日工资 * 天数 * 等级（1.0）
        （3）员工属性：姓名，单日工资，工作天数
        （4）员工方法
        （5）普通员工及部门经理都是员工子类，需要重写打印工资方法。
        （6）定义并初始化普通员工对象，调用打印工资方法输入工资，定义并初始化
        部门经理对象，调用打印工资方法输入工资。
         */
        Manager manager = new Manager("smith",300,26,1.2);
        manager.setBonus(3000);
        System.out.println(manager.info());
        OrdStaff ordStaff = new OrdStaff("kitty",220,30,1.0);
        System.out.println(ordStaff.info());
    }
}
class Employee{
    private String name;
    private double salary;
    private int days;
    private double rank;

    public Employee(String name, double salary, int days, double rank) {
        this.name = name;
        this.salary = salary;
        this.days = days;
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public double getRank() {
        return rank;
    }

    public void setRank(double rank) {
        this.rank = rank;
    }

    public String info() {
        return "name = " + name + ",salary = " + salary * days * rank;
    }
}

class Manager extends Employee{
    private double bonus;
    /*
    创建Manager对象时，奖金是多少并不是确定的，所以在构造器中，不给bonus
    可以通过setBonus来设置
     */
    public Manager(String name, double salary, int days, double rank) {
        super(name, salary, days, rank);
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public String info() {
        return "name = " + getName() + ",salary = " + (bonus + getSalary() * getDays() * getRank());
    }
}
class OrdStaff extends Employee{
    public OrdStaff(String name, double salary, int days, double rank) {
        super(name, salary, days, rank);
    }

    public String info() {
        return super.info();
    }
}
