package com.oop.advanced.single_;
/*
    懒汉式
    懒汉式，只有當用戶使用getInstance時，才返回cat對象, 後面再次調用時，會返回上次創建的cat對象。
    懒汉式可能会存在线程安全的问题。
 */
    /**
     * 演示懒汉式的单例模式
     */
public class SingleTon02 {
    public static void main(String[] args) {
        //new Cat("大黃");
        //System.out.println(Cat.n1);
        Cat instance = Cat.getInstance();
        System.out.println(instance);


        //再次调用getInstance
        Cat instance2 = Cat.getInstance();
        System.out.println(instance2);

        System.out.println(instance == instance2);//T
    }
}
//希望在程序允许过程中，只能创建一个Cat对象
//使用单例模式
class Cat {
    private String name;
    public static  int n1 = 999;
    private static Cat cat ; //默认是null

    //步驟
    //1.仍然构造器私有化
    //2.定义一个static静态属性对象
    //3.提供一个public的static方法，可以返回一个Cat对象
    //4.懒汉式，只有当用户使用getInstance时，才返回cat对象, 后面再次调用时，会返回上次创建的cat对象
    //  从而保证了单例
    private Cat(String name) {
        System.out.println("构造器调用...");
        this.name = name;
    }
    public static Cat getInstance() {

        if(cat == null) {//如果还没有创建cat對象
            cat = new Cat("小可爱");
        }
        return cat;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
}
/*
        比较
        1、二者最主要的区别在于创建对象的时机不同:饿汉式是在类加载就创建了对象实例,而懒汉式是在使用时才创建。
        2、饿汉式不存在线程安全问题，懒汉式存在线程安全问题。(后面学习线程后，会完善一把)。
        3、饿汉式存在浪费资源的可能。因为如果程序员一个对象实例都没有使用，那么饿汉式创建的对象就浪费了，
        懒汉式是使用时才创建，就不存在这个问题。
        4、在我们javaSE标准类中，java.lang.Runtime就是经典的单例模式.
 */

