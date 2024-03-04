package com.oop.centre.test;

public class OOPTest03 {
    public static void main(String[] args) {
        /*
        3、编写老师类
        （1）要求属性 “姓名name”，“年龄age”，“职称post”，“基本工资salary”
        （2）编写业务方法，introduce()，实现输出一个教师的信息。
        （3）编写教师类的三个子类：教授类、副教授类、讲师类。工资级别分别为：教授1.3、副
        教授为1.2、讲师类1.1.在三个子类里面都重写父类的introduce()方法。
        （4）定义并初始化一个老师对象，调用业务方法，实现对象基本信息的后台打印。
         */
        Teacher teacher = new Professor("张三",56,"教授",25000,1.3);
        System.out.println(teacher.introduce());
    }
}
class Teacher{
    private String name;
    private int age;
    private String post;
    private double salary;

    private double rank;

    public Teacher(String name, int age, String post, double salary, double rank) {
        this.name = name;
        this.age = age;
        this.post = post;
        this.salary = salary;
        this.rank = rank;
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

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getRank() {
        return rank;
    }

    public void setRank(double rank) {
        this.rank = rank;
    }

    public String introduce(){
        return "姓名 = " + name + ",年龄 = "+ age + ",职教 = " + post + ",基本工资 = " + salary + ",rank = " + rank;
    }
}
class Professor extends Teacher{
    public Professor(String name, int age, String post, double salary, double rank) {
        super(name, age, post, salary, rank);
    }

    @Override
    public String introduce() {
        System.out.println("这是教授的信息：");
        return super.introduce();
    }
}

class AssProfessor extends Teacher{

    public AssProfessor(String name, int age, String post, double salary, double rank) {
        super(name, age, post, salary, rank);
    }

    @Override
    public String introduce() {
        System.out.println("这是副教授的信息：");
        return super.introduce();
    }

}

class Lecturer extends Teacher{
    public Lecturer(String name, int age, String post, double salary, double rank) {
        super(name, age, post, salary, rank);
    }

    @Override
    public String introduce() {
        System.out.println("这是讲师的信息：");
        return super.introduce();
    }
}