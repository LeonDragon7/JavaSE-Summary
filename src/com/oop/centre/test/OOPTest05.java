package com.oop.centre.test;

public class OOPTest05 {
    public static void main(String[] args) {
        /*
        5、设计父类-员工类。子类：工人类，农民类，教师类，科学家类，服务生类。
        （1）其中工人，农民，服务生只有基本工资
        （2）教师除基本工资外，还有课酬（元/天）
        （3）科学家除基本工资外，还有年终奖
        （4）编写一个测试类，将各种类型的员工的全年工资打印出来
         */
        Worker jack = new Worker("jack",10000);
        jack.printSal();
        Peasant smith = new Peasant("smith", 20000);
        smith.printSal();
        Educator shu = new Educator("shu", 2000);
        shu.setClassDays(360);
        shu.setClassSal(1000);
        shu.printSal();

        Scientist scientist = new Scientist("钟南山", 20000);
        scientist.setBonus(2000000);
        scientist.printSal();

        Waiter moni = new Waiter("moni", 5000);
        moni.printSal();
    }
}
class Staff{
    private String name;
    private double salary;
    private int salMonth = 12;//带薪的月份，默认为12，可以通过set修改

    public Staff(String name, double salary) {
        this.name = name;
        this.salary = salary;
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

    public int getSalMonth() {
        return salMonth;
    }

    public void setSalMonth(int salMonth) {
        this.salMonth = salMonth;
    }
    //打印全年工资
    public void printSal(){
        System.out.println(name + " 年工资是：" + (salary * salMonth));
    }
}
class Worker extends Staff{
    public Worker(String name, double salary) {
        super(name, salary);
    }

    @Override
    public void printSal() {
        super.printSal();
    }
}
class Peasant extends Staff{
    public Peasant(String name, double salary) {
        super(name, salary);
    }

    @Override
    public void printSal() {
        super.printSal();
    }
}
class Educator extends Staff{
    private int classDays;//一年上课次数 通过set设置不同的值
    private double classSal;//课时费  通过set设置不同的值

    public Educator(String name, double salary) {
        super(name, salary);
    }

    public int getClassDays() {
        return classDays;
    }

    public void setClassDays(int classDays) {
        this.classDays = classDays;
    }

    public double getClassSal() {
        return classSal;
    }

    public void setClassSal(double classSal) {
        this.classSal = classSal;
    }

    @Override
    public void printSal() {
        System.out.println(getName() + " 年工资是：" + (getSalary() * getSalMonth() + classDays * classSal));
    }
}
class Scientist extends Staff{
    private double bonus;

    public Scientist(String name, double salary) {
        super(name, salary);
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public void printSal() {
        System.out.println(getName() + " 年工资是：" + getSalary() * getSalMonth() + bonus);
    }
}
class Waiter extends Staff{

    public Waiter(String name, double salary) {
        super(name, salary);
    }

    @Override
    public void printSal() {
        super.printSal();
    }

}


