package com.oop.centre.test;
/*
13、案例题目描述：
（1）做一个Student02类，Student02类有名称（name），性别（sex），年龄（age），
学号（stu_id），做合理封装，通过构造器在创建对象时将4个属性赋值。
（2）写一个Teacher01类，Teacher01类有名称（name），性别（sex），年龄（age），
工龄（work_age），做合理封装，通过构造器在创建对象时将4个属性赋值。
（3）抽取一个父类Person05类，将共同属性和方法放到Person05类
（4）学生需要有学习的方法（study），在方法里写上“我承诺，我会好好学习。”。
（5）教师需要有教学的方法（teach），在方法里写上“我承诺，我会认真教学。”。
（6）学生和教师都会有玩的方法（play），学会玩的是足球，老师玩的是象棋。此方法
是返回字符串的，分别返回“xx爱玩足球”和“xx爱玩象棋”（其中分别代表学生和老师的姓名）。
因为玩的方法名称都一样，所以要求此方法定义在父类中，子类实现重写。
（7）定义多态数组，里面保存2个学生和2个老师，要求按年龄从高到低排序
（8）定义方法，形参为Person05类型，功能：调用学生的study或教师的teach方法

打印效果如下：
老师的信息：
姓名：王飞
年龄：30
性别：男
工龄：5
我承诺，我会认真教课。
王飞爱玩象棋。
-------------------------
学生的信息：
姓名：小明
年龄：15
性别：男
学号：00023102
我承诺，我会好好学习。
小明爱玩足球。
 */
public class OOPTest13 {
    public static void main(String[] args) {
        OOPTest13 oopTest13 = new OOPTest13();
        Teacher01 teacher01 = new Teacher01("王飞", "男", 30, 5);
        teacher01.printInfo();
        oopTest13.infoMethod(teacher01);
        Student02 student02 = new Student02("小明", "男", 15,"00023102" );
        System.out.println("-------------------------------");
        student02.printInfo();
        oopTest13.infoMethod(student02);


        System.out.println("排序：");
        Person05[] p = new Person05[4];
        p[0] = new Teacher01("smith","男",45,25);
        p[1] = new Teacher01("bott","男",50,30);
        p[2] = new Student02("ben","男",18,"20210202");
        p[3] = new Student02("kimi","女",17,"20210204");

        Person05 temp = null;
        for (int i = 0; i < p.length; i++) {
            for (int j = 0; j < p.length - i - 1; j++) {
                if(p[j + 1].getAge() > p[j].getAge()){
                    temp = p[j + 1];
                    p[j + 1] = p[j];
                    p[j] = temp;
                }
            }
        }
        for (int i = 0; i < p.length; i++) {
            if(p[i] instanceof Student02){
                Student02 s = (Student02) p[i];
                System.out.println("name = " + s.getName() + ",sex = " + s.getSex() + ",age = " + s.getAge() + ",stu_id = " + s.getStu_id());
            } else if (p[i] instanceof Teacher01) {
                Teacher01 t = (Teacher01) p[i];
                System.out.println("name = " + t.getName() + ",sex = " + t.getSex() + ",age = " + t.getAge() + ",work_age = " + t.getWork_age());
            }else{
                System.out.println("预处理");
            }
        }
        //或者在Student02和Teacher01写toString方法
        System.out.println("-------------------------");
        for (int i = 0; i < p.length; i++) {
            System.out.println(p[i]);
        }
    }
    public void infoMethod(Person05 p){
        if(p instanceof Student02){
            ((Student02) p).study();
        } else if (p instanceof Teacher01) {
            ((Teacher01) p).teach();
        }else {
            System.out.println("预处理");
        }
    }
}
class Person05{
    private String name;
    private String sex;
    private int age;

    public Person05(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public String play(){
        return name + "爱玩";
    }

    public String basicInfo(){
        return "姓名：" + name + "\n年龄：" + age + "\n性别：" + sex;
    }

    @Override
    public String toString() {
        return "Person05{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }


}
class Student02 extends Person05{
    private String stu_id;

    public Student02(String name, String sex, int age, String stu_id) {
        super(name, sex, age);
        this.stu_id = stu_id;
    }

    public String getStu_id() {
        return stu_id;
    }

    public void setStu_id(String stu_id) {
        this.stu_id = stu_id;
    }
    public void study(){
        System.out.println("我承诺，我会好好学习");
    }

    @Override
    public String play() {
        return super.play() + "足球";
    }

    @Override
    public String toString() {
        return "Student02{" +
                "stu_id='" + stu_id + '\'' +
                '}' + super.toString();
    }

    public void printInfo() {
        System.out.println("学生的信息：");
        System.out.println(super.basicInfo());
        System.out.println("学号：" + stu_id);
        study();
        System.out.println(play());
    }
}
class Teacher01 extends Person05{
    private int work_age;

    public Teacher01(String name, String sex, int age, int work_age) {
        super(name, sex, age);
        this.work_age = work_age;
    }

    public int getWork_age() {
        return work_age;
    }

    public void setWork_age(int work_age) {
        this.work_age = work_age;
    }

    public void teach(){
        System.out.println("我承诺，我会认真教学");
    }

    public String play() {
        return super.play() + "象棋";
    }

    @Override
    public String toString() {
        return "Teacher01{" +
                "work_age=" + work_age +
                '}' + super.toString();
    }

    public void printInfo(){
        System.out.println("老师的信息：");
        System.out.println(super.basicInfo());
        System.out.println("工龄：" + work_age);
        teach();
        System.out.println(play());
    }
}


