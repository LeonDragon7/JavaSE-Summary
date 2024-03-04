package com.generic;
/*
    泛型介绍
    泛(广泛)型(类型)=> Integer,String,Dog
    1、泛型又称参数化类型，是Jdk5.0出现的新特性,解决数据类型的安全性问题
    2、在类声明或实例化时只要指定好需要的具体的类型即可。
    3、Java泛型可以保证如果程序在编译时没有发出警告，运行时就不会产生ClassCastException异常。同时，代码更加简洁、健壮。
    4、泛型的作用是:可以在类声明时通过一个标识表示类中某个属性的类型，或者法的返回值的类型，或者是参数类型。

    泛型的语法
    泛型的声明
    interface 接口<T>{} 和 class 类 <K,V>{}
    //比如:List , ArrayList

    说明:
    1、其中，T,K,V不代表值,而是表示类型。
    2、任意字母都可以。常用T表示，是Type的缩写

    泛型的实例化
    要在类名后面指定类型参数的值(类型)。
    List<String> strList = new ArrayList<String>();
    Iterator<Customer> iterator = customers.iterator();
 */
public class Generic03 {
    public static void main(String[] args) {

        //注意，特别强调： E具体的数据类型在定义Person对象的时候指定,即在编译期间，就确定E是什么类型
        Person<String> person = new Person<String>("timerring");
        person.show(); //String

        /*
            你可以这样理解，上面的Person类
            class Person {
                String s ;//E表示 s的数据类型, 该数据类型在定义Person对象的时候指定,即在编译期间，就确定E是什么类型

                public Person(String s) {//E也可以是参数类型
                    this.s = s;
                }

                public String f() {//返回类型使用E
                    return s;
                }
            }
         */

        Person<Integer> person2 = new Person<Integer>(100);
        person2.show();//Integer

        /*
            class Person {
                Integer s ;//E表示 s的数据类型, 该数据类型在定义Person对象的时候指定,即在编译期间，就确定E是什么类型

                public Person(Integer s) {//E也可以是参数类型
                    this.s = s;
                }

                public Integer f() {//返回类型使用E
                    return s;
                }
            }
         */
    }
}
//泛型的作用是：可以在类声明时通过一个标识表示类中某个属性的类型，
// 或者是某个方法的返回值的类型，或者是参数类型
class Person<E> {
    E s ;//E表示 s的数据类型, 该数据类型在定义Person对象的时候指定,即在编译期间，就确定E是什么类型

    public Person(E s) {//E也可以是参数类型
        this.s = s;
    }

    public E f() {//返回类型使用E
        return s;
    }

    public void show() {
        System.out.println(s.getClass());//显示s的运行类型
    }
}