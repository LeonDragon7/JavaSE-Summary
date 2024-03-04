package com.oop.centre;
/*
    面向对象编程三大特征之一：封装
    封装介绍
    封装(encapsulation)就是把抽象出的数据[属性]和对数据的操作[方法]封装在一起，数
    据被保护在内部，程序的其它部分只有通过被授权的操作[方法]，才能对数据进行操作。

    封装的理解和好处
    1、隐藏实现细节:调用(传入参数...) -> 方法(连接数据库)
    2、可以对数据进行验证，保证安全合理

    封装的实现步骤
    1、将属性进行私有化private [不能直接修改属性]
    2、提供一个公共的(public)set方法，用于对属性判断并赋值
    public void setXxx(类型 参数名){//Xxx 表示某个属性
        //加入数据验证的业务逻辑
        属性 = 参数名;
    }
    3、提供一个公共的(public)get方法，用于获取属性的值
    public 数据类型 getXxx(){//权限判断 Xxx 表示某个属性
        return xx;
    }
 */
public class Encapsulation {
    public static void main(String[] args) {
        /*
        设计一个小程序，不能随便查看人的年龄，工资等隐私，
        并对设置的年龄进行合理的验证。年龄合理就设置，否则就默认
        年龄必须在1-120，年龄、工资不能直接查看，name的长度在2-6字符之间
         */
        Person01 person = new Person01();
        person.setName("jack");
        person.setAge(30);
        person.setSalary(30000);
        System.out.println(person.info());

        //如果我们直接使用构造器指定属性
        Person01 smith = new Person01("smith", 2000, 50000);
        System.out.println("==================smith的信息====================");
        System.out.println(smith.info());
    }
}
class Person01{
    public String name;
    private int age;
    private double salary;

    //构造器

    public Person01() {
    }

    public Person01(String name, int age, double salary) {
        /*
        this.name = name;
        this.age = age;
        this.salary = salary;
         */
        //将set方法写在构造器中，才能进行业务逻辑校验，否则无法校验
        setName(name);//等价于 this.setName(name);
        setAge(age);
        setSalary(salary);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.length() >= 2 && name.length() <= 6){
            this.name = name;
        }else {
            System.out.println("名字的长度不对，需要(2-6)个字符，默认名字");
            this.name = "无名人";
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age >= 1 && age <= 120){
            this.age = age;
        }else{
            System.out.println("你设置的年龄不对，需要在1-120之间，提供默认值");
            this.age = 18;//默认年龄
        }
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    //返回属性信息
    public String info(){
        return "信息为 name = " + name + " age = " + age + " salary = " + salary;
    }
}
