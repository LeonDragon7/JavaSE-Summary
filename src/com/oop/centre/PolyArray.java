package com.oop.centre;

import com.oop.centre.polyarr.Person;
import com.oop.centre.polyarr.Student;
import com.oop.centre.polyarr.Teacher;

/*
    面向对象编程-多态
    多态的应用
    1）多态数组
    数组的定义类型为父类类型，里面保存的实际元素类型为子类类型

 */
public class PolyArray {
    public static void main(String[] args) {
        /*
        应用实例：现有一个继承结构如下：要求创建一个Person对象[name:String,age int]、
        2个Student[score]对象和2个Teacher[salary]对象，统一放在数组中，并调用
        每个对象的say方法。

        应用实例升级：如何调用子类特有的方法，比如Teacher有一个teach，Student有一个
        study怎么调用？
        转到package com.objectoriented.centre.polyarr;
         */
        Person[] persons = new Person[5];
        persons[0] = new Person("jack",20);
        persons[1] = new Student("mary",18,100);
        persons[2] = new Student("smith",19,30.1);
        persons[3] = new Teacher("scott",30,20000);
        persons[4] = new Teacher("king",50,25000);

        //循环遍历多态数组，调用say
        for (int i = 0; i < persons.length; i++) {
            System.out.println(persons[i].say());//动态绑定机制

            //如何调用Student和Teacher特有方法?
            //使用类型判断 + 向下转型
            if(persons[i] instanceof Student){
                Student student = (Student) persons[i];//向下转型
                student.study();
            } else if (persons[i] instanceof Teacher){
                ((Teacher)persons[i]).teach();
            }else if(persons[i] instanceof Person){
                continue;
            }else {
                System.out.println("你的类型有误，请自行检查...");
            }
        }
    }
}
